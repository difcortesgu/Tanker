package Tanker;

import Menus.Crear;
import Menus.Ventana;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
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
    private final boolean viento;
    private String datos,modo;
    private int numerotanque;
    
    public Tablero(String fondo,String modo,boolean viento,Ventana menu) {
        this.modo=modo;
        this.menu = menu; 
        this.viento=viento;
        this.fondo=fondo;
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
    
    public ArrayList<Tanque> getTanques(){
        ArrayList<Tanque> t= new ArrayList();
        for(int i=0;i<elementos.size();i++){
            if(elementos.get(i) instanceof Tanque){
                t.add((Tanque) elementos.get(i));
            }
        }
        return t;
    }
    
    public void addTanque(String equipo,int TipoArmazon,int TipoOruga,int vida,int daño,boolean controles,int numerotanque){
        Random r = new Random();
        this.numerotanque=numerotanque;
        elementos.add(new Tanque(r.nextInt(menu.getWidth()), r.nextInt(menu.getHeight()), TipoArmazon, TipoOruga,vida,daño, viento, this));
        int j=0,h=0;
        ((Tanque)elementos.get(elementos.size()-1)).setEquipo(equipo);
        ((Tanque)elementos.get(elementos.size()-1)).setModo(modo);
        if(controles){
            this.addMouseMotionListener(getTanque(numerotanque));
        }else{
            this.addKeyListener(getTanque(numerotanque));
            this.setFocusable(true);
        }
        this.addMouseListener(getTanque(numerotanque));
    }


    public Tanque getTanque(int h){
        int j=0;
        for (Elemento i: elementos) {
            if(i instanceof Tanque){
                if(h==j){
                    return (Tanque) i;
                }
                j++;
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
        g2.drawImage(loadImage(fondo), 0, 0, this.getWidth(), this.getHeight(), 0, 0, 250, 250, this);
        for (Elemento i: elementos){
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
                if(elementos.get(i).equals(getTanque(numerotanque))){
                    //que vamos a hacer cuando se elimine el tanque propio
                }
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

    public boolean isViento() {
        return viento;
    }

    public boolean isControles() {
        return controles;
    }

    public void setControles(boolean controles) {
        this.controles = controles;
    }

    public String getFondo() {
        return fondo;
    }

    public void setFondo(String fondo) {
        this.fondo = fondo;
    }
    
}
