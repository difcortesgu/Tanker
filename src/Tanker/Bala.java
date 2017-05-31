package Tanker;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;

public class Bala extends Elemento{

    
    private final double daño,dvx,dvy,aceleracion;
    private final Tanque tanque;
    
    public Bala(double daño, double x, double y, double vx, double vy, double tamaño, double vida,Tanque tanque,double aceleracion, double a,Tablero tablero) {
        super(x, y, vx, vy, tamaño, vida, tablero);
        this.aceleracion=aceleracion;
        this.a = a;
        dvx=Math.cos(this.a);
        dvy=Math.sin(this.a);
        this.daño = daño;
        this.tanque=tanque;
        timer.setDelay(5);     
        timer.start();
    }

    public double getDaño() {
        return daño;
    }

    public Tanque getTanque() {
        return tanque;
    }
    
    @Override
    public boolean colision(){
        return x<0 || x>tablero.getWidth() || y<0 || y>tablero.getHeight();
    }

    public void paintComponent(Graphics2D g){
        g.fillOval((int)x, (int)y, (int)tamaño, (int)tamaño);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
              
        vx+=dvx/400;
        vy+=dvy/400;
        x+=vx;
        y+=vy;
    }
    
}
