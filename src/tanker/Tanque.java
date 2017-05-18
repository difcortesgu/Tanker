package tanker;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import static java.lang.Math.PI;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Tanque extends Elemento implements MouseMotionListener, MouseListener {

    double dx, dy, mx, my, daño;
    private ArrayList<Bala> balas;
    private Image tanque;
    private int contador = 0;
    private int TipoOruga; //para seleccionar qué tipo de oruga tendrá

    public Tanque(double x, double y, double vx, double vy, double tamaño, int tipo, double vida, Tablero tablero) {
        super(x, y, vx, vy, tamaño, vida, tablero);
        daño = 50;
        balas = new ArrayList();
        this.TipoOruga = tipo;
    }

    @Override
    public boolean die() {
        if (vida == 0) {
            this.finalize();
        }

        return false;
    }

    @Override
    public boolean colision() {
        for (Elemento i : tablero.getElementos()) {
            if (i instanceof Obstaculo) {
                if (this.getBounds().intersects(i.getBounds())) {
                    vx *= -1;
                    vy *= -1;
                    vida--;
                    return true;
                }
            }
        }
        return false;
    }

    public void paintComponent(Graphics2D g) {
        this.pintarTanque(g);
        g.drawRect((int) x, (int) y, (int) tamaño, (int) tamaño);
        g.drawLine((int) (x + tamaño / 2), (int) (y + tamaño / 2), (int) ((x + tamaño / 2) + (100 * Math.cos(a))), (int) ((y + tamaño / 2) + (100 * Math.sin(a))));
        balas.forEach((i) -> {
            i.paintComponent(g);
        });
    
        g.drawString("" + Math.toDegrees(a), 10, 10);
    }

    public void pintarTanque(Graphics2D g) {

        tanque = loadImage("Orugas.png");

        a = Math.toDegrees(a);

        if (Math.abs(dx) > 1 || Math.abs(dy) > 1) {
            if (contador == 1) {
                contador = 0;
            } else {
                contador++;
            }
        }
        
        int i=(int) (Math.floor((a)/15)%6);
        g.drawString(""+i, 200, 200);
        if((a>=90&&a<180) || (a>=270)){
            g.drawImage(tanque, (int)x, (int)y, (int)(x+tamaño), (int)(y+tamaño), ((2*TipoOruga)+contador)*181, i*181,((2*TipoOruga)+contador+1)*181,(i+1)*181, tablero);
        }else{
            i=6-i;
            g.drawImage(tanque,(int) (x + tamaño), (int) y, (int) x, (int) (y + tamaño), ((2*TipoOruga)+contador)*181, i*181,((2*TipoOruga)+contador+1)*181,(i+1)*181, tablero);
        }
        a = Math.toRadians(a);
        g.drawString("vida: " + vida, 100, 100);
    }
    
    //cambie el parametro por un entero para eliminar la bala del arreglo
    public void eliminar_bala(int i) {
        balas.get(i).finalize();
        balas.remove(i);
    }

    public ArrayList<Bala> getBalas() {
        return balas;
    }

    public void setBalas(ArrayList<Bala> balas) {
        this.balas = balas;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        dx = (mx - (x + (tamaño / 2)));
        dy = (my - (y + (tamaño / 2)));
        if (dx > 0) {
            if(dy>0){
                a = Math.atan(dy / dx);
            }else{
                a = Math.atan(dy / dx)+2*PI;
            }
            
        } else {
            a = Math.atan(dy / dx) + PI;
        }
        if (!colision()) {
            vx = Math.cos(a);
            vy = Math.sin(a);
        }
        //se comprueba si la distancia al punto el mouse es menor a 1 
        //para dejar quieto el tanque si este esta muy cerca del punto del mouse pero sin hacer las 
        //velocidades igual a 0
        if (Math.abs(dx) > 1 || Math.abs(dy) > 1) {
            x += vx;
            y += vy;
        }

        //cambie el bucle para poder eliminar las balas
        //y lo coloque en el metodo actionPerformed en vez del metodo PaintComponent 
        for (int i = 0; i < balas.size(); i++) {
            if (balas.get(i).colision()) {
                eliminar_bala(i);
            }
        }
        this.die();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        /*
        mx=e.getX();
        my=e.getY();
        int x1 = (int)((x+tamaño/2)+(100*Math.cos(a)));
        int y1 = (int)((y+tamaño/2)+(100*Math.sin(a)));
        balas.add(new Bala(daño,x1,y1,vx*2,vy*2,10,50,this,tablero));
         */
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mx = e.getX();
        my = e.getY();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (this.getBounds().contains(e.getPoint())) {
            if (this.TipoOruga == 1) {
                this.TipoOruga = 0;
            } else {
                this.TipoOruga++;
            }
        }

        int x1 = (int) ((x + tamaño / 2) + (100 * Math.cos(a)));
        int y1 = (int) ((y + tamaño / 2) + (100 * Math.sin(a)));
        balas.add(new Bala(daño, x1, y1, vx * 2, vy * 2, 10, 50, this, tablero));
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    public Image loadImage(String imageName) {
        ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();

        return image;
    }
}
