package Tanker;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Obstaculo extends Elemento{
 
    private int c=0;
    private String obstaculo;
    
    public Obstaculo(double x, double y, double tamaño, double vida, Tablero tablero) {
        super(x, y, tamaño, vida, tablero);
        vx=0;
        vy=0;       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    
        for (int i=0;i<tablero.getTanques().size();i++) {                      
            for(int j=0;j<tablero.getTanque(i).getBalas().size();j++){
                if(tablero.getTanque(i).getBalas().get(j).getBounds().intersects(this.getBounds())){
                    tablero.getTanque(i).eliminar_bala(j);
                    vida--;
                }
            }
        }   
        /*        if(x>700||x<-100){
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
    c++;*/    
    }
    
    public void PaintComponent(Graphics2D g){
        switch(tablero.getFondo()){
            case "fondo1.png":  obstaculo="obstaculo1.png";break;
            case "fondo2.png":  obstaculo="obstaculo2.png";break;
            case "fondo3.png":  obstaculo="obstaculo3.png";break;
            case "fondo4.png":  obstaculo="obstaculo4.png";break;
        }
        
        g.drawImage(loadImage(obstaculo),(int)x, (int)y, (int)tamaño, (int)tamaño,null);
        g.drawString(""+vida, (int)(x+(tamaño/2)), (int)(y+(tamaño/2)));
    }

    @Override
    public boolean colision() {
        return false;
    }

    public Image loadImage(String imageName) {
        ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();
        return image;
    }

    
}
