package Menus;

import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JPanel;
import Tanker.Tablero;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Ventana extends JFrame{
    
    private final HashMap<String,JPanel> paneles;

    public Ventana() {

        paneles = new HashMap();
        paneles.put("Principal", new Principal(this));
        paneles.put("Jugar", new Jugar(this));
        paneles.put("Opciones", new Opciones(this));
        paneles.put("Crear", new Crear(this));
        paneles.put("Entrar", new Entrar(this));
        paneles.put("Tablero",new Tablero(this));
        
        
        add(paneles.get("Principal"));
        setTitle("TANKER");
        setIconImage(loadImage("icon.jpg"));
        setSize(600, 450);
        setLocationRelativeTo(null); //Center the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    public JPanel getPanel(String s) {
        return paneles.get(s);
    }
    
    public void Cambiar_panel(String s){
        add(paneles.get(s));
        paneles.get(s).setVisible(true);    
    }
    
    public static void main(String[] args) {
        Ventana mb = new Ventana();
    }

    public Image loadImage (String imageName) {
        ImageIcon ii = new ImageIcon (imageName);
        Image image = ii.getImage();
        return image;
    }

        
}
