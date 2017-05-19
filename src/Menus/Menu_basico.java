package Menus;

import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JPanel;
import tanker.Tablero;

public class Menu_basico extends JFrame{
    
    private HashMap<String,JPanel> paneles;

    public Menu_basico() {

        paneles = new HashMap();
        
        paneles.put("Principal", new Principal(this));
        paneles.put("Jugar", new Jugar(this));
        paneles.put("Opciones", new Opciones(this));
        paneles.put("Crear", new Crear(this));
        paneles.put("Entrar", new Entrar(this));
        paneles.put("Tablero", new Tablero(this));
        
        add(paneles.get("Principal"));
        setTitle("TANKER");
        setSize(600, 450);
        setLocationRelativeTo(null); //Center the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public void Cambiar_panel(String s){
        add(paneles.get(s));
        paneles.get(s).setVisible(true);
        
    }
    
    public static void main(String[] args) {
        Menu_basico mb = new Menu_basico();
        Principal p = new Principal(mb);
        
    }
        
}
