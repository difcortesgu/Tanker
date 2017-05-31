package Tanker;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;

public class Bala extends Elemento{

    
    private final double daño,dvx,dvy,aceleracion;
    private final Tanque tanque;
    
    public Bala(double daño, double x, double y, double vx, double vy, double tamaño, double vida,Tanque tanque,boolean viento, Tablero tablero) {
        super(x, y, vx, vy, tamaño, vida, tablero);
        this.aceleracion=0;
        dvx=Math.cos(a);
        dvy=Math.sin(a);
        this.daño = daño;
        this.tanque=tanque;
        timer.setDelay(5);     
        timer.start();
    }
    public Bala(double daño, double x, double y, double vx, double vy, double tamaño, double vida,Tanque tanque,double aceleracion, Tablero tablero) {
        super(x, y, vx, vy, tamaño, vida, tablero);
        this.aceleracion=aceleracion;
        dvx=Math.cos(a);
        dvy=Math.sin(a);
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
              
        vx+=dvx/100;
        vy+=dvy/100;
        x+=vx;
        y+=vy;
    }
    
}
