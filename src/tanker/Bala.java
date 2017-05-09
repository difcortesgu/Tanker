package tanker;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;

public class Bala extends Elemento{

    
    private double daño;

    public Bala(double daño, double x, double y, double vx, double vy, double tamaño, double vida, Tablero tablero) {
        super(x, y, vx, vy, tamaño, vida, tablero);
        this.daño = daño;
    }
      
    public void actualizar(){
        x+=vx;
        y+=vy;
    }
    
    @Override
    public boolean colision(){
        return false;
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
