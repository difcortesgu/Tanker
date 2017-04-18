package tanker;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class Tablero extends JPanel{
    
    private final int ancho;
    private final int alto;
    private Tanque tanque;

    public Tablero(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;

        
                
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }
            @Override
            public void keyPressed(KeyEvent e) {
                tanque.KeyPressed(e);
            }
            @Override
            public void keyReleased(KeyEvent e) {
                tanque.KeyReleased();
            }
        });
        setFocusable(true);
    }

    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }

    public Tanque getTanque() {
        return tanque;
    }

    public void setTanque(Tanque tanque) {
        this.tanque = tanque;
    }
    
    public void actualizar() {
        tanque.actualizar();
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2= (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        this.tanque.paint(g2);
    }
    
    
    
}
