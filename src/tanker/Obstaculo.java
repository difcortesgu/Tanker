package tanker;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Obstaculo extends Elemento{

    
    public Obstaculo(double x, double y, double tamaño, double vida, Tablero tablero) {
        super(x, y, tamaño, vida, tablero);
    }

    public void colision2() throws Throwable {

        for (Elemento i: tablero.getElementos()) {
            
            if(i instanceof Tanque){
                for (Bala j:((Tanque) i).getBalas()) {
                    
                if(j.getBounds().intersects(this.getBounds())){
                    ((Tanque) i).eliminar_bala(j);
                    vida--;
                }
                }
            }
        }
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            colision2();
        } catch (Throwable ex) {
            Logger.getLogger(Obstaculo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void PaintComponent(Graphics2D g){
        g.drawRect((int)x, (int)y, (int)tamaño, (int)tamaño);
        g.drawString(""+vida, (int)(x+(tamaño/2)), (int)(y+(tamaño/2)));
    }

    @Override
    public boolean colision() {
        return false;
    }

}
