package tanker;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.Timer;


public class Tablero extends JPanel implements ActionListener{
    
    
    private ArrayList<Elemento> elementos;
    private Timer timer;//Añadi un timer para controlar el metodo repaint desde el tablero
    
    public Tablero() {
        elementos = new ArrayList();
        elementos.add(new Tanque(100,100,0,0,50,100,this));
        elementos.add(new Obstaculo(300,300,100,10,this));
        this.addMouseMotionListener((MouseMotionListener) elementos.get(0));
        this.addMouseListener((MouseListener) elementos.get(0));
        timer = new Timer(1,this);
        timer.start();
    }

    public ArrayList<Elemento> getElementos() {
        return elementos;
    }

    public void setElementos(ArrayList<Elemento> elementos) {
        this.elementos = elementos;
    }

       
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2= (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);

        for(Elemento i: elementos){
            if(i instanceof Tanque){
                ((Tanque) i).paintComponent(g2);
            }
            if(i instanceof Obstaculo){
                ((Obstaculo) i).PaintComponent(g2);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //cambie los bucles que comproueban las colisiones para poder eliminar los objetos
        for(int i=0;i<elementos.size();i++){
            if(elementos.get(i).die()){
                elementos.get(i).finalize();               
                elementos.remove(i);
            }
        }
        this.repaint();
    }
    
    
}
