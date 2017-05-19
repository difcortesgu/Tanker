package Menus;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import org.netbeans.lib.awtextra.*;

public class Jugar extends JPanel{
    
    private JButton crear,entrar,atras;
    private final Menu_basico menu;

    public Jugar(Menu_basico menu) {
        this.menu=menu;
        this.initComponents();
    }
    
    private void initComponents() {

        setLayout(new AbsoluteLayout());
        
        crear = new JButton();
        entrar = new JButton();
        atras = new JButton();
   
        //configuracion del boton para volver
        atras.setText("ATRAS");
        atras.addActionListener((java.awt.event.ActionEvent evt) -> {
            //Accion del boton volver
            menu.Cambiar_panel("Principal");
            this.setVisible(false);
        });
        //se añade el boton con las coordenadas y el tamaño
        add(atras,new AbsoluteConstraints(10, 10, -1, -1));

        //configuracion del boton para crear un servidor
        crear.setText("CREAR SERVIDOR");
        crear.addActionListener((java.awt.event.ActionEvent evt) -> {
            //Accion del boton crear
            menu.Cambiar_panel("Crear");
            this.setVisible(false);
        });
        //se añade el boton con las coordenadas y el tamaño
        add(crear,new AbsoluteConstraints(200, 120, 200, -1));
        
        //configuracion del boton para entrar al servidor
        entrar.setText("ENTRAR A SERVIDOR");
        entrar.addActionListener((java.awt.event.ActionEvent evt) -> {
            //Accion del boton entrar
            menu.Cambiar_panel("Entrar");
            this.setVisible(false);
        });
        //se añade el boton con las coordenadas y el tamaño
        add(entrar,new AbsoluteConstraints(200, 300, 200, -1));
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Image fondo = loadImage("fondo_jugar.jpg");
        g.drawImage(fondo, 0, 0, 600, 450, null);
    }
    
    public Image loadImage (String imageName) {
        ImageIcon ii = new ImageIcon (imageName);
        Image image = ii.getImage();
        return image;
    }
    
}
