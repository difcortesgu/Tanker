package tanker;

import java.awt.event.ActionListener;
import javax.swing.Timer;

public abstract class Elemento implements ActionListener{
 
    protected double a,x,y,vx,vy,tamaño,vida;
    protected Tablero tablero;
    protected Timer timer;

    public Elemento(double x, double y, double vx, double vy, double tamaño, double vida, Tablero tablero) {
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.tamaño = tamaño;
        this.vida = vida;
        this.tablero = tablero;
        this.a=0;
        timer= new Timer(10,this);
        timer.start();
    }

    public Elemento(double x, double y, double tamaño, double vida, Tablero tablero) {
        this.x = x;
        this.y = y;
        this.tamaño = tamaño;
        this.vida = vida;
        this.tablero = tablero;
    }
    
    


    
    public abstract boolean colision();

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getTamaño() {
        return tamaño;
    }

    public void setTamaño(double tamaño) {
        this.tamaño = tamaño;
    }

    
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getVx() {
        return vx;
    }

    public void setVx(double vx) {
        this.vx = vx;
    }

    public double getVy() {
        return vy;
    }

    public void setVy(double vy) {
        this.vy = vy;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }
    
    
}
