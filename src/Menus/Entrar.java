package Menus;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.*;
import org.netbeans.lib.awtextra.*;

public class Entrar extends JPanel{

    private JTable lista;
    private final Menu_basico menu;
    private JButton entrar;

    public Entrar(Menu_basico menu) {
        this.menu=menu;
        initComponents();
    }
    
    private void initComponents() {

        setLayout(new AbsoluteLayout());
        
        entrar = new JButton();
        lista = new JTable();
        
        
        lista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nombre", "Jugadores", "Modo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            @Override
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        add(lista,new AbsoluteConstraints(100, 100, 400, 300));
        
        
        entrar.setText("ENTRAR");
        entrar.addActionListener((ActionEvent e) -> {
            //Accion del boton de entrar
            menu.Cambiar_panel("Tablero");
            this.setVisible(false);
        }); 
        add(entrar,new AbsoluteConstraints(250, 400, 100, -1));
 
    }
    
    @Override
    public void paintComponent(Graphics g){
    }
    
    public Image loadImage (String imageName) {
        ImageIcon ii = new ImageIcon (imageName);
        Image image = ii.getImage();
        return image;
    }

    
}
