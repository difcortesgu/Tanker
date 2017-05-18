package Menus;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menu_basico extends JPanel{

    private final GridBagConstraints limites;

    public Menu_basico() {
        super(new GridBagLayout());
        this.limites = new GridBagConstraints();
        this.limites.gridx = 0;
        this.limites.gridy = 0;
        this.initNewPanel();
    }

    
    
    public final void initNewPanel() {
    }

    public void initButton(JButton boton, String nombre,ActionListener a) {
        this.limites.insets = new Insets(10, 10, 10, 10);
        boton = new JButton(nombre);        
        this.add(boton, this.limites);
        boton.addActionListener(a);
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

    
}

