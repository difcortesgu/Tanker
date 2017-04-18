package tanker;

import java.awt.Color;
import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        JFrame j = new JFrame("Rebotes");
        Tablero r = new Tablero(500,500);
        Tanque t = new Tanque(250,250,40,Color.MAGENTA,r);
        r.setTanque(t);

        j.setSize(500,500);
        r.setBounds(0, 0, 250, 250);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setLocationRelativeTo(null);
        j.add(r);
        r.setBackground(Color.ORANGE);
        j.setVisible(true);
        
        while(true){
            r.actualizar();
            r.repaint();
            Thread.sleep(10);
        }
        
    }
    
}
