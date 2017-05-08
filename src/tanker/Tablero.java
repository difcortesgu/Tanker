package tanker;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class Tablero extends JPanel{
    
    private Tanque tanque;
    private Obstaculo obs;
    
    public Tablero() {
        tanque = new Tanque(100,100,0,0,50,100,this);
        obs = new Obstaculo(300,300,100,0,this); 
        this.addMouseMotionListener(tanque);
        this.addMouseListener(tanque);
    }

    public Tanque getTanque() {
        return tanque;
    }

    public void setTanque(Tanque tanque) {
        this.tanque = tanque;
    }
       
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2= (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        this.tanque.paintComponent(g2);
        this.obs.PaintComponent(g2);
    }
    
}
