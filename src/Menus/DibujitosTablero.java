/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menus;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author juan sebastian
 */
public class DibujitosTablero extends JPanel implements MouseMotionListener, MouseListener,KeyListener {
    private int x,y,tamaño,tamaño_bala;
    private double a;
    private int mx,my;
    private final int TipoOruga; //para seleccionar qué tipo de oruga tendrá
    private final int TipoArmazon ;     
    private boolean click;
    private Image tanque;
    private int contador=0;

    public DibujitosTablero(int x, int y, double a, int TipoOruga, int TipoArmazon, boolean click) {
        this.x = x;
        this.y = y;
        this.tamaño = 100;
        this.tamaño_bala = 10;
        this.a = a;
        this.mx = mx;
        this.my = my;
        this.TipoOruga = TipoOruga;
        this.TipoArmazon = TipoArmazon;
        this.click = click;
    }
    
    
    
    
    public void pintarTanque(Graphics2D g) {

        tanque = loadImage("Tanque.png");

        a = Math.toDegrees(a);
        
        int i = (int) (Math.floor((a) / 15) % 6);
        if (a<90) {
            i = 6 - i;//invierte rotacion de giro
            g.drawImage(tanque,  x,  (y + tamaño), (x + tamaño),  y, TipoArmazon * 181, i * 181, (TipoArmazon + 1) * 181, (i + 1) * 181, this);            
            g.drawImage(tanque,  (x + tamaño),  y,  x,  (y + tamaño), ((2 * TipoOruga) + contador) * 181, i * 181, ((2 * TipoOruga) + contador + 1) * 181, (i + 1) * 181, this);
        } else if (a < 180) {
            g.drawImage(tanque,  x, y,  (x + tamaño), (y + tamaño), ((2 * TipoOruga) + contador) * 181, i * 181, ((2 * TipoOruga) + contador + 1) * 181, (i + 1) * 181, this);
            g.drawImage(tanque, (x + tamaño), (y + tamaño), x,  y, TipoArmazon * 181, i * 181, (TipoArmazon + 1) * 181, (i + 1) * 181, this);
        } else if (a < 270) {
            i = 6 - i; 
            g.drawImage(tanque,(x + tamaño), y, x, (y + tamaño), ((2 * TipoOruga) + contador) * 181, i * 181, ((2 * TipoOruga) + contador + 1) * 181, (i + 1) * 181, this);
            g.drawImage(tanque, (x + tamaño), y, x, (y + tamaño), TipoArmazon * 181, i * 181, (TipoArmazon + 1) * 181, (i + 1) * 181, this);
        } else {
            g.drawImage(tanque, x, y, (x + tamaño), (y + tamaño), ((2 * TipoOruga) + contador) * 181, i * 181, ((2 * TipoOruga) + contador + 1) * 181, (i + 1) * 181, this);
            g.drawImage(tanque, x, y, (x + tamaño), (y + tamaño), TipoArmazon * 181, i * 181, (TipoArmazon + 1) * 181, (i + 1) * 181, this);
        }
        a = Math.toRadians(a);
    }
    
    public void paintComponent(Graphics2D g){
        g.fillOval(x, y, tamaño_bala, tamaño_bala);
    }
    
    public Image loadImage(String imageName) {
        ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();
        return image;
    }
      
    @Override
    public void mouseDragged(MouseEvent e) {
        mx=e.getX();
        my=e.getY();  
    }

    @Override
    public void mouseMoved(MouseEvent e) {
         mx=e.getX();
        my=e.getY();
    }
    

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        click=true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        click=false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
