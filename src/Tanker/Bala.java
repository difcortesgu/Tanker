package Tanker;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import static java.lang.Math.PI;

public class Bala extends Elemento{

    
    private final double daño,dvx,dvy;
    private final Tanque tanque;
    private final boolean viento;
    
    public Bala(double daño, double x, double y, double vx, double vy, double tamaño, double vida,Tanque tanque,boolean viento, Tablero tablero) {
        super(x, y, vx, vy, tamaño, vida, tablero);
        this.viento=viento;
        this.daño = daño;
        this.tanque=tanque;
        timer.setDelay(5);
        if(this.viento){
            a=(Math.random()-Math.random())%2*PI;
            dvx=Math.cos(a);
            dvy=Math.sin(a);
        }else{
            dvx=0;
            dvy=0;
        }
             
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
              
        vx+=dvx/500;
        vy+=dvy/500;
        x+=vx;
        y+=vy;
    }
    
}
