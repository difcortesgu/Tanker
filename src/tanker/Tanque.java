package tanker;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import static java.lang.Math.PI;
import java.util.ArrayList;

public class Tanque extends Elemento implements MouseMotionListener,MouseListener{

    double dx,dy,mx,my,daño;
    private ArrayList<Bala> balas;

    public Tanque(double x, double y, double vx, double vy, double tamaño, double vida, Tablero tablero) {
        super(x, y, vx, vy, tamaño, vida, tablero);
        daño=50;
        balas= new ArrayList();
    }


    public boolean colision(){
        return y+vy<tablero.getHeight()-tamaño || y+vy<=0 || x+vx<tablero.getWidth()- tamaño || x+vx>0;
    }
    
    public void paintComponent(Graphics2D g){
        g.fillRect((int)x, (int)y, (int)tamaño, (int)tamaño);
        for(Bala i: balas){
            i.paintComponent(g);
        }
        g.drawString(""+balas.size(), 10, 10);
    }

    public ArrayList<Bala> getBalas() {
        return balas;
    }

    public void setBalas(ArrayList<Bala> balas) {
        this.balas = balas;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        dx=(mx-(x+(tamaño/2)));
        dy=(my-(y+(tamaño/2)));
        if(dx>0){
            a = Math.atan(dy/dx); 
        }else{
            a = Math.atan(dy/dx)+PI; 
        }
        vx=Math.cos(a);
        vy=Math.sin(a);
        x+=vx;
        y+=vy;
        tablero.repaint();
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
    }

    @Override
    public void mousePressed(MouseEvent e) {
        balas.add(new Bala(daño,x+(tamaño/2),y+(tamaño/2),vx*2,vy*2,10,50,tablero));
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}
