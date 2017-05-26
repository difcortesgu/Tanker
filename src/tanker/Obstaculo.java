package tanker;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;

public class Obstaculo extends Elemento{
    int c=0;
    
    public Obstaculo(double x, double y, double tamaño, double vida, Tablero tablero) {
        super(x, y, tamaño, vida, tablero);
        vx=0;
        vy=0;
        timer.start();
        
    }

    //cambie los 2 ciclos porque con los anteriores no estaba eliminando el objeto
    //y elimine el metodo Colision2 porque se podia simplemente colocar en el actionPerformed
    @Override
    public void actionPerformed(ActionEvent e) {
    
        for (int i=0;i<tablero.getElementos().size();i++) {
            
            if(tablero.getElementos().get(i) instanceof Tanque){
                
                for(int j=0;j<((Tanque)(tablero.getElementos().get(i))).getBalas().size();j++){
                    if(((Tanque)(tablero.getElementos().get(i))).getBalas().get(j).getBounds().intersects(this.getBounds())){
                        ((Tanque)(tablero.getElementos().get(i))).eliminar_bala(j);
                        vida--;
                    }
                }
            }
            
        }   
        if(x>700||x<-100){
            vx*=-1;
        }
        if(y>700||y<-100){
            vy*=-1;
        }
        if( c==50){
            vx=5*(Math.random()-Math.random());
            vy= 5*(Math.random()-Math.random());
            c=0;
        }
        
        
        x+=vx;
        y+=vy;
        c++;
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
