/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario;
import tanker.Tablero;

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
public class CPanel extends JPanel implements MouseMotionListener, MouseListener, ActionListener{
    int x,y;
    int DELAY=1000/32;
    boolean click;
    final int p1=100,p2=200;
    //Tablero tablero;

    public CPanel() {
        //this.tablero= tablero;
        x=0;
        y=0;
        click=false;
        Timer time= new Timer(DELAY,this);
        time.start();
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
        
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawString(this.toString(),p1,p2);
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
        click=true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        click=false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.repaint();
   
    }

    

   

    public int getDELAY() {
        return DELAY;
    }

    public void setDELAY(int DELAY) {
        this.DELAY = DELAY;
    }

    public boolean isClick() {
        return click;
    }

    public void setClick(boolean click) {
        this.click = click;
    }
    
    
}
