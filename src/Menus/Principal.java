package Menus;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import tanker.Main;

/**
 *
 * @author Familia
 */
public class Principal extends JFrame {

    public Principal() {
        /*botones:
            opciones 
            jugar
        */
        
        add(new NewPanel());
    }

    public static void main(String[] args) {
        Principal frame = new Principal();
        frame.setTitle("Tanker");
        frame.setSize(600, 450);
        frame.setLocationRelativeTo(null); //Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class NewPanel extends JPanel implements ActionListener{

    //private final Timer timer;
    private int x;

    private JButton JBjugar, JBopciones, JBcrear, JBentrar;
    private JLabel JLtanker;
    
    private final GridBagConstraints limites;

    public NewPanel() {
        super(new GridBagLayout());
        this.limites = new GridBagConstraints();
        this.limites.gridx = 0;
        this.limites.gridy = 0;
        this.initNewPanel();
        //timer = new Timer(25, this);
        //timer.start();
    }

    public final void initNewPanel() {
        this.initLabel(this.JLtanker, "TANKER");
        this.initButton(this.JBjugar, "Jugar");
        this.initButton(this.JBopciones, "Opciones");
        this.initButton(this.JBcrear, "Crear");
        this.initButton(this.JBentrar, "Entrar");
    }

    public void initButton(JButton boton, String nombre) {
        this.limites.insets = new Insets(10, 10, 10, 10);
        boton = new JButton(nombre);        
        this.add(boton, this.limites);
        boton.addActionListener(this);
        boton.setVisible(true);
        this.limites.gridy++;
    }
    
    public void initLabel(JLabel label, String nombre) {
        this.limites.insets = new Insets(20, 20, 20, 20);
        label = new JLabel(nombre);        
        this.add(label, this.limites);
        label.setVisible(true);
        this.limites.gridy++;
    }
    
    public Image loadImage (String imageName) {
        ImageIcon ii = new ImageIcon (imageName);
        Image image = ii.getImage();
        return image;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image Fondo = loadImage ("Menu.png");
        g.drawImage(Fondo, 0, 0, null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Main m= new Main();
    }

}
