package tanker;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;

public class Bala extends Elemento{

    
    private double daño;
    private Tanque tanque;

    public Bala(double daño, double x, double y, double vx, double vy, double tamaño, double vida,Tanque tanque, Tablero tablero) {
        super(x, y, vx, vy, tamaño, vida, tablero);
        this.daño = daño;
        this.tanque=tanque;
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
    
    public void borrar() throws Throwable{
        this.finalize();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        x+=vx;
        y+=vy;
    }
    
}
