package Tanker;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import static java.lang.Math.PI;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import javax.swing.ImageIcon;

public class Tanque extends Elemento implements MouseMotionListener, MouseListener,KeyListener , Runnable{

    private double dx,dy,mx,my,aceleracion;
    private final double daño;
    private ArrayList<Bala> balas;
    private Image oruga,armazon;
    private int contador = 0;
    private int TipoOruga; //para seleccionar qué tipo de oruga tendrá
    private int TipoArmazon;//por ahora es final porque no hay más jejeje
    private final boolean viento;
    private boolean click;
    private String equipo,modo;
    private Random r;
    
    public Tanque(double x, double y,int tipoArmazon,int tipoOruga, int vida ,int daño,boolean viento, Tablero tablero) {
        super(x, y,50, vida, tablero);
        vx=0;
        vy=0;
        mx=x;
        my=y;
        click=false;
        this.viento=viento;
        this.daño = daño;
        balas = new ArrayList();
        this.TipoArmazon=tipoArmazon;
        this.TipoOruga = tipoOruga;
        Thread t = new Thread(this, "tank");
        t.start();
    }

    @Override
    public boolean colision() {
        if(modo.equalsIgnoreCase("ffa")){
            colisionBalaffa();
        }else{
            colisionBalateams();
        }
        for (Elemento i : tablero.getElementos()) {
            if (i instanceof Obstaculo) {
                if (this.getBounds().intersects(i.getBounds())) {
                    vx *= -1;
                    vy *= -1;
                    return true;
                }
            }
            if(i instanceof Tanque){
                if(i!=this){
                    if(this.getBounds().intersects(i.getBounds())){
                        vx *= -1;
                        vy *= -1;
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public void colisionBalaffa(){
        for(int i=0;i<tablero.getTanques().size();i++){
            if (!tablero.getTanque(i).equals(this)){
                for(int j=0;j<tablero.getTanque(i).getBalas().size();j++){
                    if(tablero.getTanque(i).getBalas().get(j).getBounds().intersects(this.getBounds())){
                        this.vida--;
                        tablero.getTanque(i).eliminar_bala(j);
                    }
                }
            }
        }
    }

    public void colisionBalateams(){
        for(int i=0;i<tablero.getTanques().size();i++){
            if (equipo.equalsIgnoreCase("azul")){
                if(i%2==0){
                    for(int j=0;j<tablero.getTanque(i).getBalas().size();j++){
                        if(tablero.getTanque(i).getBalas().get(j).getBounds().intersects(this.getBounds())){
                            this.vida--;
                            tablero.getTanque(i).eliminar_bala(j);
                        }                    
                    }
                }
            }else{
                if(i%2!=0){
                    for(int j=0;j<tablero.getTanque(i).getBalas().size();j++){
                        if(tablero.getTanque(i).getBalas().get(j).getBounds().intersects(this.getBounds())){
                            this.vida--;
                            tablero.getTanque(i).eliminar_bala(j);
                        }                    
                    }
                }                
            }
        }
    }

    
    public void paintComponent(Graphics2D g) {
        this.pintarTanque(g);
        balas.forEach((i) -> {
            i.paintComponent(g);
        });
        g.fillOval((int)mx, (int)my, 2, 2);
    }

    public void pintarTanque(Graphics2D g) {

        oruga = loadImage("Tanque.png");
        if(equipo.equalsIgnoreCase("azul")){
            armazon = loadImage("Azules.png");
        }else{
            armazon = loadImage("Rojos.png");
        }
        
        

        a = Math.toDegrees(a);
        
        int i = (int) (Math.floor((a) / 15) % 6);
        if (a<90) {
            i = 6 - i;//invierte rotacion de giro
            g.drawImage(armazon,  (int) x, (int) (y + tamaño),(int) (x + tamaño), (int) y, TipoArmazon * 181, i * 181, (TipoArmazon + 1) * 181, (i + 1) * 181, tablero);            
            g.drawImage(oruga, (int) (x + tamaño), (int) y, (int) x, (int) (y + tamaño), ((2 * TipoOruga) + contador) * 181, i * 181, ((2 * TipoOruga) + contador + 1) * 181, (i + 1) * 181, tablero);
        } else if (a < 180) {
            g.drawImage(oruga, (int) x, (int) y, (int) (x + tamaño), (int) (y + tamaño), ((2 * TipoOruga) + contador) * 181, i * 181, ((2 * TipoOruga) + contador + 1) * 181, (i + 1) * 181, tablero);
            g.drawImage(armazon,  (int) (x + tamaño), (int) (y + tamaño),(int) x, (int) y, TipoArmazon * 181, i * 181, (TipoArmazon + 1) * 181, (i + 1) * 181, tablero);
        } else if (a < 270) {
            i = 6 - i; 
            g.drawImage(oruga, (int) (x + tamaño), (int) y, (int) x, (int) (y + tamaño), ((2 * TipoOruga) + contador) * 181, i * 181, ((2 * TipoOruga) + contador + 1) * 181, (i + 1) * 181, tablero);
            g.drawImage(armazon, (int) (x + tamaño), (int) y, (int) x, (int) (y + tamaño), TipoArmazon * 181, i * 181, (TipoArmazon + 1) * 181, (i + 1) * 181, tablero);
        } else {
            g.drawImage(oruga, (int) x, (int) y, (int) (x + tamaño), (int) (y + tamaño), ((2 * TipoOruga) + contador) * 181, i * 181, ((2 * TipoOruga) + contador + 1) * 181, (i + 1) * 181, tablero);
            g.drawImage(armazon, (int) x, (int) y, (int) (x + tamaño), (int) (y + tamaño), TipoArmazon * 181, i * 181, (TipoArmazon + 1) * 181, (i + 1) * 181, tablero);
        }
        a = Math.toRadians(a);
        g.drawString("vida = "+(int)this.vida, (int)x, (int)(y));
    }

    public void eliminar_bala(int i) {
        balas.get(i).finalize();
        balas.remove(i);
    }

    public double getAceleracion() {
        return aceleracion;
    }

    public void setAceleracion(double aceleracion) {
        this.aceleracion = aceleracion;
    }

    public ArrayList<Bala> getBalas() {
        return balas;
    }

    public void setBalas(ArrayList<Bala> balas) {
        this.balas = balas;
    }

    public double getMx() {
        return mx;
    }

    public void setMx(double mx) {
        this.mx = mx;
    }

    public double getMy() {
        return my;
    }

    public void setMy(double my) {
        this.my = my;
    }

    public int getTipoOruga() {
        return TipoOruga;
    }

    public void setTipoOruga(int TipoOruga) {
        this.TipoOruga = TipoOruga;
    }

    public int getTipoArmazon() {
        return TipoArmazon;
    }

    public void setTipoArmazon(int TipoArmazon) {
        this.TipoArmazon = TipoArmazon;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(click){
            disparar();
        }
        
        dx = (mx - (x + (tamaño / 2)));
        dy = (my - (y + (tamaño / 2)));
        if (dx > 0) {
            if (dy > 0) {
                a = Math.atan(dy / dx);
            } else {
                a = Math.atan(dy / dx) + 2 * PI;
            }

        } else {
            a = Math.atan(dy / dx) + PI;
        }
        if (!colision()) {
            vx = Math.cos(a);
            vy = Math.sin(a);
        }
        if (Math.abs(dx) > 1 || Math.abs(dy) > 1) {
            x += vx;
            y += vy;
        }

        for (int i = 0; i < balas.size(); i++) {
            if (balas.get(i).colision()) {
                eliminar_bala(i);
            }
        }

        if (Math.abs(dx) > 1 || Math.abs(dy) > 1) {
            if (contador == 1) {
                contador = 0;
            } else {
                contador++;
            }
        }
    }

    public synchronized void disparar(){
        int x1 = (int) ((x + tamaño / 2) + (50 * Math.cos(a)));
        int y1 = (int) ((y + tamaño / 2) + (50 * Math.sin(a)));
        r = new Random(new Date().getTime());
        aceleracion = ((PI+r.nextDouble())-r.nextDouble());
        double a = 2*PI*(r.nextDouble() - r.nextDouble());
        balas.add(new Bala(daño, x1, y1, vx * 2, vy * 2, 10, 50, this,aceleracion, a,tablero));
        click=false;
    }
    
    @Override
    public void mouseDragged(MouseEvent e) {
        mx=e.getX();
        my=e.getY();
    }

    public boolean isClick() {
        return click;
    }

    public void setClick(boolean click) {
        this.click = click;
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
        click=true;
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

    @Override
    public void run() {
        timer.start();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()== KeyEvent.VK_UP){
            my-=60;
        }
        if(e.getKeyCode()== KeyEvent.VK_DOWN){
            my+=60;
        }
        if(e.getKeyCode()== KeyEvent.VK_RIGHT){
            mx+=60;
        }
        if(e.getKeyCode()== KeyEvent.VK_LEFT){
            mx-=60;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getModo() {
        return modo;
    }

    public void setModo(String modo) {
        this.modo = modo;
    }
    
}
