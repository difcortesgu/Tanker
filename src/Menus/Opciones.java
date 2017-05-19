package Menus;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import org.netbeans.lib.awtextra.*;
import javax.swing.JSplitPane;
import javax.swing.JToggleButton;

public class Opciones extends JPanel{

    private Image i;
    private JSlider sonido;
    private JSplitPane controles;
    private JToggleButton mouse,teclado;
    private JLabel control,sound,titulo;
    private JButton atras;
    private final Menu_basico menu;


    public Opciones(Menu_basico menu) {
        this.menu=menu;
        initComponents();
    }
    
    private void initComponents() {

        setLayout(new AbsoluteLayout());
        
        control = new JLabel();
        sound = new JLabel();
        titulo = new JLabel();
        sonido = new JSlider();
        controles = new JSplitPane();
        mouse = new JToggleButton();
        teclado = new JToggleButton();
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

        
        //Configuracion de la barra del sonido
        sonido.setMinimum(0);
        sonido.setMaximum(100);
        sonido.setMajorTickSpacing(20);
        sonido.setMinorTickSpacing(10);
        sonido.setPaintLabels(true);
        sonido.addChangeListener((ChangeEvent e) -> {
            repaint();
            //Acion cuando se mueve la barra de volumen
        });
        add(sonido,new AbsoluteConstraints(200, 300, 300, -1));  
        
        //configuracion de los botos para escoger los controles
        mouse.setText("MOUSE");
        mouse.addActionListener((ActionEvent e) -> {
            mouse.setSelected(true);
            teclado.setSelected(false);
            //Configuracion para los controles del mouse
        });

        teclado.setText("TECLADO");
        teclado.addActionListener((ActionEvent e) -> {
            teclado.setSelected(true);
            mouse.setSelected(false);
            //Configuracion para los controles del mouse
        });
  
        //Configuracion del contenedor de los botones de arriba    
        controles.setLeftComponent(mouse);
        controles.setRightComponent(teclado);
        controles.setDividerLocation(0.5);
        add(controles, new AbsoluteConstraints(200, 150, 200, -1));
        
        //Configuracion de los titulos
        control.setText("CONTROLES");
        control.setFont(new Font("Ubuntu", 0, 25));
        add(control,new AbsoluteConstraints(200, 100, -1, -1));

        sound.setText("SONIDO");
        sound.setFont(new Font("Ubuntu", 0, 25));
        add(sound,new AbsoluteConstraints(200, 250, -1, -1));
        
        titulo.setText("OPCIONES");
        titulo.setFont(new Font("Ubuntu", 0, 35));
        add(titulo,new AbsoluteConstraints(200, 10, -1, -1));
        
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(sonido.getValue()>0){
            i = loadImage("sonido_on.png");
        }else{
            i = loadImage("sonido_off.png");
        }
        g.drawImage(i, 150, 290, 50, 50, null);
    }
    
    public Image loadImage (String imageName) {
        ImageIcon ii = new ImageIcon (imageName);
        Image image = ii.getImage();
        return image;
    }

    
}
