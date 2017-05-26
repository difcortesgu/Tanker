package Servidor;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import static java.lang.Math.PI;

public class Bala extends Elemento{

    
    private double daño,dvx,dvy;
    private Tanque tanque;
    
    public Bala(double daño, double x, double y, double vx, double vy, double tamaño, double vida,Tanque tanque, Tablero tablero) {
        super(x, y, vx, vy, tamaño, vida, tablero);
        this.daño = daño;
        this.tanque=tanque;
        timer.setDelay(5);
        a=(Math.random()-Math.random())%2*PI;
        dvx=Math.cos(a);
        dvy=Math.sin(a);
        timer.start();
    }

    public double getDaño() {
        return daño;
    }

    public void setDaño(double daño) {
        this.daño = daño;
    }

    public Tanque getTanque() {
        return tanque;
    }

    public void setTanque(Tanque tanque) {
        this.tanque = tanque;
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
