package tanker;

import menus.Ventana;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import static java.lang.Math.PI;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.Timer;


public class Tablero extends JPanel implements ActionListener{
    
    
    private ArrayList<Elemento> elementos;
    private final Timer timer;//Añadi un timer para controlar el metodo repaint desde el tablero
    public double a,dvx,dvy;
    private Image fondo;
    private final Ventana menu;
    private JButton atras;
    
    public Tablero(Ventana menu) {
        
        this.menu = menu; 
        atras = new JButton();
        atras.setText("atras");
        atras.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu.Cambiar_panel("Jugar");
                setVisible(false);
            }
        });
        add(atras, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        
        elementos = new ArrayList();
        elementos.add(new Tanque(770,500,0,0,128,1,1000,this));
        /*elementos.add(new Obstaculo(300,300,200,10,this));
        elementos.add(new Obstaculo(700,500,100,10,this));
        elementos.add(new Obstaculo(800,100,50,10,this));*/        
        this.addMouseMotionListener((MouseMotionListener) elementos.get(0));
        this.addMouseListener((MouseListener) elementos.get(0));
        timer = new Timer(1,this);
        timer.start();        
        a=(Math.random()-Math.random())%2*PI;
        dvx=0;
        dvy=0;
        
    }

    public ArrayList<Elemento> getElementos() {
        return elementos;
    }

    public void setElementos(ArrayList<Elemento> elementos) {
        this.elementos = elementos;
    }

       
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2= (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        //this.PaintFondo(g2);
        g2.drawLine(400, 100, 400+(int)(100*Math.cos(a)), 100+(int)(100*Math.sin(a)));
        for(Elemento i: elementos){
            if(i instanceof Tanque){
                ((Tanque) i).paintComponent(g2);
            }
            if(i instanceof Obstaculo){
                ((Obstaculo) i).PaintComponent(g2);
            }
        }
    }
    
    private void PaintFondo(Graphics2D g) {
        fondo = this.loadImage("Camuflajes.png");        
        g.drawImage(fondo, 0, 0, this.getWidth(), this.getHeight(), 0, 0, 128, 128, this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //cambie los bucles que comproueban las colisiones para poder eliminar los objetos
        for(int i=0;i<elementos.size();i++){
            if(elementos.get(i).die()){
                elementos.get(i).finalize();               
                elementos.remove(i);
            }
        }
        a=(Math.random()-Math.random())%2*PI;
        this.repaint();
    }
    
    public Image loadImage(String imageName) {
        ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();

        return image;
    }   
    
}
