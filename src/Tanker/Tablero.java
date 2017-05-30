package Tanker;

import Menus.Ventana;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
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
    private String fondo;
    private final Ventana menu;
    private final JButton atras;
    private boolean controles;//True = mouse / False = teclado 
    private boolean viento;
    private String datos;
    
    public Tablero(String fondo,boolean viento,Ventana menu) {
        
        this.menu = menu; 
        this.controles=controles;
        this.viento=viento;
        atras = new JButton();
        atras.setText("atras");
        atras.addActionListener((ActionEvent evt) -> {
            menu.Cambiar_panel("Jugar","Tablero");
        });
        add(atras, new AbsoluteConstraints(10, 10, -1, -1));
        
        elementos = new ArrayList();
        timer = new Timer(1,this);
        timer.start();               
    }

    public ArrayList<Elemento> getElementos() {
        return elementos;
    }
    
    public void addTanque(int TipoArmazon,int TipoOruga,int vida,int daño,boolean controles,int numerotanque){
        elementos.add(new Tanque(Math.random(), Math.random(), TipoArmazon, TipoOruga,vida,daño, viento, this));
        int j=0;
        for(Elemento i: elementos){
            if(i instanceof Tanque){
                if(j==numerotanque){
                    if(controles){
                        this.addMouseMotionListener((MouseMotionListener) elementos.get(numerotanque));
                    }else{
                        this.addKeyListener((KeyListener)elementos.get(numerotanque));
                        this.setFocusable(true);
                    }
                    this.addMouseListener((MouseListener) elementos.get(numerotanque));
                }
                j++;
            }
        }
    }
    public Tanque getTanque(){
        for (Elemento i: elementos) {
            if(i instanceof Tanque){
             return (Tanque) i;   
            }
            
        }   
        return null;
    }

    public void setElementos(ArrayList<Elemento> elementos) {
        this.elementos = elementos;
    }

    public String getDatos() {
        return datos;
    }

    public void setDatos(String datos) {
        this.datos = datos;
    }
    
    
       
    @Override
    public void paintComponent(Graphics g){
        
        super.paintComponent(g);
        Graphics2D g2= (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        //g2.drawImage(loadImage("fondo"), 0, 0, this.getWidth(), this.getHeight(), 0, 0, 128, 128, this);
        for(Elemento i: elementos){
            if(i instanceof Tanque){
                ((Tanque) i).paintComponent(g2);
                datos+=i.getX()+" ";
                datos+=i.getY()+" ";
                datos+=((Tanque) i).getBalas().size()+" ";
                for (Bala j : ((Tanque) i).getBalas()) {
                    datos+=j.getX()+" ";
                    datos+=j.getY()+" ";
                }
                
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
