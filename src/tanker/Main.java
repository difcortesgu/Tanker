package tanker;

import javax.swing.JFrame;

public class Main extends JFrame{

    public Main() {
        add(new Tablero());
    }
    
    

    public static void main(String[] args) throws InterruptedException {
        Main j = new Main();
        j.setTitle("Tanker");
        j.setSize(500,500);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setLocationRelativeTo(null);
        j.setVisible(true);
        
    }
    
}
