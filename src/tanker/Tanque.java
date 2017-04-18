package tanker;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Tanque {

    private int x;
    private int y;
    private int vx;
    private int vy;
    private int lado;
    private Color color;
    private ArrayList<Bala> balas;
    private Tablero tablero;

    public Tanque(int x, int y, int lado, Color color,Tablero tablero) {
        this.x = x;
        this.y = y;
        this.vx=0;
        this.vy=0;
        this.lado = lado;
        this.color = color;
        balas= new ArrayList();
        this.tablero=tablero;
    }

    public void disparar(){
        int x1=x,y1=y;
        if(vx>0){
            x1=x+lado;
        }
        if(vy>0){
            y1=y+lado;
        }
        balas.add(new Bala(x1,y1,vx,vy,tablero));
    }
    
    public void actualizar(){
        if(vx==-1 && x>0){      
            x+=vx;
        }
        if(vx==1 && x<tablero.getWidth()-lado){
            x+=vx;
        }
        if(vy==-1 && y>0){
            y+=vy;
        }
        if(vy==1 && y<tablero.getHeight()-lado){
            y+=vy;
        }
        for(Bala i: balas){
            i.actualizar();
        }
    }
    
    public void KeyPressed(KeyEvent e){
        if(e.getKeyCode()==KeyEvent.VK_SPACE){
           disparar();
        }else
        if(e.getKeyCode()== KeyEvent.VK_UP ){
            vy=-1;
        }else
        if(e.getKeyCode()== KeyEvent.VK_DOWN){
            vy=1;
        }else
        if(e.getKeyCode()== KeyEvent.VK_RIGHT){
            vx=1;
        }else
        if(e.getKeyCode()== KeyEvent.VK_LEFT){
            vx=-1;
        }
        
    }
    
    public void KeyReleased(){
        vx=0;
        vy=0;
    }
    

    
    public boolean colision(){
        return y+vy<tablero.getHeight()-lado || y+vy<=0 || x+vx<tablero.getWidth()-lado || x+vx>0;
    }
    
    public void paint(Graphics2D g){
        g.setColor(color);
        g.fillRect(x, y, lado, lado);
        for(Bala i: balas){
            i.paint(g);
        }
    }
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getVx() {
        return vx;
    }

    public void setVx(int vx) {
        this.vx = vx;
    }

    public int getVy() {
        return vy;
    }

    public void setVy(int vy) {
        this.vy = vy;
    }

    public int getLado() {
        return lado;
    }

    public void setLado(int lado) {
        this.lado = lado;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public ArrayList<Bala> getBalas() {
        return balas;
    }

    public void setBalas(ArrayList<Bala> balas) {
        this.balas = balas;
    }
    
}
