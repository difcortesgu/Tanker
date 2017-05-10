package tanker;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablero extends JPanel{
    
    private ArrayList<Elemento> elementos;
    
    
    public Tablero() {
        elementos = new ArrayList();
        elementos.add(new Tanque(100,100,0,0,50,100,this));
        elementos.add(new Obstaculo(300,300,100,10,this));
        this.addMouseMotionListener((MouseMotionListener) elementos.get(0));
        this.addMouseListener((MouseListener) elementos.get(0));
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
        for(Elemento i : elementos){
            if(i.die()){
                try {
                    i= null;
                    elementos.remove(i);
                    System.gc();
                } catch (Throwable ex) {
                    Logger.getLogger(Tablero.class.getName()).log(Level.SEVERE, null, ex);
                }

            }else{
            if(i instanceof Tanque){
                try {
                    ((Tanque) i).paintComponent(g2);
                } catch (Throwable ex) {
                    Logger.getLogger(Tablero.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(i instanceof Obstaculo){
                ((Obstaculo) i).PaintComponent(g2);
            }
            }
        }
    }
    
}
