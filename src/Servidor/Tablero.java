package Servidor;

import Usuario.Ventana;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.Timer;
import org.netbeans.lib.awtextra.AbsoluteConstraints;


public class Tablero extends JPanel implements ActionListener{
    
    
    private ArrayList<Elemento> elementos;
    private final Timer timer;
    private Image fondo;
    private final Ventana menu;
    private final JButton atras;
    
    public Tablero(Ventana menu) {
        
        this.menu = menu; 
        atras = new JButton();
        atras.setText("atras");
        atras.addActionListener((ActionEvent evt) -> {
            menu.Cambiar_panel("Jugar");
            setVisible(false);
        });
        add(atras, new AbsoluteConstraints(10, 10, -1, -1));
        
        elementos = new ArrayList();
        elementos.add(new Tanque(770,500,0,0,100,1,1000,this));

        this.addMouseMotionListener((MouseMotionListener) elementos.get(0));
        this.addMouseListener((MouseListener) elementos.get(0));
        timer = new Timer(1,this);
        timer.start();               
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
        //g2.drawImage(this.loadImage("Camuflajes.png"), 0, 0, this.getWidth(), this.getHeight(), 0, 0, 128, 128, this);
        for(Elemento i: elementos){
            if(i instanceof Tanque){
                ((Tanque) i).paintComponent(g2);
            }
            if(i instanceof Obstaculo){
                ((Obstaculo) i).PaintComponent(g2);
            }
        }
    }
        
    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0;i<elementos.size();i++){
            if(elementos.get(i).die()){
                elementos.get(i).finalize();               
                elementos.remove(i);
            }
        }
        this.repaint();
    }
    
    public Image loadImage(String imageName) {
        ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();

        return image;
    }   
    
}
