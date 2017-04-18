package tanker;

import java.awt.Color;
import java.awt.Graphics2D;

public class Bala {

    
    private int x;
    private int y;
    private int vx;
    private int vy;
    private int radio;
    private Color color;
    private Tablero tablero;

    public Bala(int x, int y, int vx, int vy,Tablero tablero) {
        this.radio=10;
        this.color=Color.RED;
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.tablero=tablero;
    }
    
    public void actualizar(){
        x+=vx;
        y+=vy;
    }
    
    public boolean colision(){
        return y>=tablero.getHeight() || y<=0 || x>=tablero.getWidth() || x<=0;
    }

    public void paint(Graphics2D g){
        g.fillOval(x, y, radio*2, radio*2);
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

    public int getRadio() {
        return radio;
    }

    public void setRadio(int radio) {
        this.radio = radio;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }
    
}
