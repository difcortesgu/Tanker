/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario;


import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author juan sebastian
 */
public class CPanel extends JPanel implements MouseMotionListener, MouseListener{
    int x,y,x2,y2;
    int DELAY=1;
    int click;
    final int p1=100,p2=200;
   
    //Tablero tablero;

    public CPanel() {
        //this.tablero= tablero;
        x=0;
        y=0;
        click=0;
       
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
        
        
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawString(this.toString(),p1,p2);
        g.fillRect(x, y, 10, 10);
        
        
       
        //tablero.paintComponent(g);
        
    }

    @Override
    public String toString() {
        return x+" "+y;
        //return "parametros:  x="+x+",  y="+y+",  click="+click;
    }
    
   

 
    @Override
    public void mouseDragged(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        x=e.getXOnScreen();
        y=e.getYOnScreen();
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        click=1;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        click=0;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
       
    }

     public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public int getClick() {
        return click;
    }

    public void setClick(int click) {
        this.click = click;
    }
    

    public int getDELAY() {
        return DELAY;
    }

    public void setDELAY(int DELAY) {
        this.DELAY = DELAY;
    }

   
    
}
