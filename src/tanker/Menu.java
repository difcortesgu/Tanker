/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tanker;

import java.awt.*;
import static java.awt.Color.*;
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

    private final Timer timer;
    private int x;

    private JButton JBjugar, JBopciones, JBcrear, JBentrar;

    public NewPanel() {
        this.initNewPanel();
        timer = new Timer(25, this);
        timer.start();
    }

    public final void initNewPanel() {
        this.addMouseListener(this);
        this.initButton(this.JBjugar, "Jugar", BLACK, 260, 160, 80, 20);
        this.initButton(this.JBopciones, "Opciones", BLUE, 260, 210, 80, 20);
        this.initButton(this.JBcrear, "Crear", GREEN, 260, 260, 80, 20);
        this.initButton(this.JBentrar, "Entrar", RED, 260, 310, 80, 20);
    }

    public void initButton(JButton boton, String nombre, Color color, int x, int y, int width, int height) {
        boton = new JButton(nombre);
        this.add(boton);
        boton.setForeground(color);
        boton.setBounds(x, y, width, height);
        boton.setVisible(true);
        
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawString("TANKER", 280, 50);

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
