package tanker;

import javax.swing.JFrame;

public class Main extends JFrame{

    public Main() {
        add(new Tablero());
        setTitle("Tanker");
        setSize(1000,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        
    }
       
}
