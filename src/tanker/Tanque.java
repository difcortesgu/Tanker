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


    @Override
    public boolean colision(){
        return y+vy<tablero.getHeight()-tamaño || y+vy<=0 || x+vx<tablero.getWidth()- tamaño || x+vx>0;
    }
    
    public void paintComponent(Graphics2D g){
        g.drawRect((int)x, (int)y, (int)tamaño, (int)tamaño);
        for(Bala i:balas){
            i.paintComponent(g);
        }
        g.drawString(""+balas.size(), 10, 10);
    }

    //cambie el parametro por un entero para eliminar la bala del arreglo
    public void eliminar_bala(int i){
        balas.get(i).finalize();
        balas.remove(i);   
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
        //se comprueba si la distancia al punto el mouse es menor a 1 
        //para dejar quieto el tanque si este esta muy cerca del punto del mouse pero sin hacer las 
        //velocidades igual a 0
        if(Math.abs(dx)>1 || Math.abs(dy)>1){
            x+=vx;
            y+=vy;
        }
        
        //cambie el bucle para poder eliminar las balas
        //y lo coloque en el metodo actionPerformed en vez del metodo PaintComponent 
        for(int i=0;i<balas.size();i++){
            if(balas.get(i).colision()){
                eliminar_bala(i);
            }
        }
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
        balas.add(new Bala(daño,x+(tamaño/2),y+(tamaño/2),vx*2,vy*2,10,50,this,tablero));
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
