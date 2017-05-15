/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tanker;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Familia
 */
public class Menu extends JFrame {

    public Menu() {
        add(new NewPanel());
    }

    public static void main(String[] args) {
        Menu frame = new Menu();
        frame.setTitle("Tanker");
        frame.setSize(600, 450);
        frame.setLocationRelativeTo(null); //Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class NewPanel extends JPanel implements ActionListener, MouseListener {

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
        this.addMouseListener(this);
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

//        g.drawString("TANKER", 280, 50);

//        g.drawString("Jugar", 285, 175);
//        g.drawString("Opciones", 275, 225);
//
//        g.drawRect(260, 160, 80, 20); //Rectangulo alrededor de "Jugar"
//        g.drawRect(260, 210, 80, 20); //Rectangulo alrededor de "Opciones"
//
//        g.drawString("Crear", 285, 175);
//        g.drawString("Entrar", 285, 225);
//
//        g.drawRect(260, 160, 80, 20); //Rectangulo alrededor de "Crear"
//        g.drawRect(260, 210, 80, 20); //Rectangulo alrededor de "Entrar"
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
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
}
