package Menus;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.*;
import org.netbeans.lib.awtextra.*;

public class Principal extends JPanel {

    private JButton jugar,opciones;
    private JLabel titulo;
    private final Menu_basico menu;

    public Principal(Menu_basico menu) {
        this.initComponents();
        this.menu=menu;
    }
    
    private void initComponents() {

        jugar = new JButton();
        opciones = new JButton();
        titulo = new JLabel();
        
        //Permite configurar el orden de los componentes a partir de coordenadas
        setLayout(new AbsoluteLayout());

        //configuracion del boton jugar
        jugar.setText("JUGAR");
        jugar.addActionListener((java.awt.event.ActionEvent evt) -> {
            //Accion del boton jugar
            menu.Cambiar_panel("Jugar");
            this.setVisible(false);
        });
        add(jugar, new AbsoluteConstraints(245,250,100,-1));
        
        //Configuracion del boton de opciones
        opciones.setText("OPCIONES");
        opciones.addActionListener((java.awt.event.ActionEvent evt) -> {
            //Accion del boton opciones
            menu.Cambiar_panel("Opciones");
            this.setVisible(false);
        });
        add(opciones, new AbsoluteConstraints(235,350,120,-1));
        
        //configuracion del titulo
        titulo.setFont(new java.awt.Font("Ubuntu", 0, 25)); // NOI18N
        titulo.setText("TANKER");
        add(titulo, new AbsoluteConstraints(250,150,100,-1));
            
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

}
