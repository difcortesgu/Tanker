package Menus;

import Conexiones.Cliente;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Entrar extends javax.swing.JPanel {

    public Entrar(Ventana m) {
        initComponents();
        this.ingresarIP.setText("localhost");
        this.jFrame1 = m;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        atras = new javax.swing.JButton();
        entrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        ingresarIP = new javax.swing.JTextField();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        atras.setText("atras");
        atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasActionPerformed(evt);
            }
        });
        add(atras, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        entrar.setText("Entrar");
        entrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entrarActionPerformed(evt);
            }
        });
        add(entrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 320, -1, -1));

        jLabel1.setText("Ingresa la direccion IP del servidor");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, -1, -1));

        ingresarIP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresarIPActionPerformed(evt);
            }
        });
        add(ingresarIP, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, 180, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasActionPerformed
        ((Ventana)jFrame1).Cambiar_panel("Jugar","Entrar");
    }//GEN-LAST:event_atrasActionPerformed

    private void entrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entrarActionPerformed
       
            ((Ventana)jFrame1).Cambiar_panel("Espera", "Entrar");
            ((Espera)((Ventana)jFrame1).getPanel("Espera")).getIniciar().setVisible(false);
            Cliente c = new Cliente(ingresarIP.getText(),(Ventana)jFrame1);            
        
                
    }//GEN-LAST:event_entrarActionPerformed

    private void ingresarIPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingresarIPActionPerformed

    }//GEN-LAST:event_ingresarIPActionPerformed

        @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image Fondo = loadImage ("fondo1.jpg");
        g.drawImage(Fondo, 0, 0, null);
    }

    public Image loadImage (String imageName) {
        ImageIcon ii = new ImageIcon (imageName);
        Image image = ii.getImage();
        return image;
    }
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atras;
    private javax.swing.JButton entrar;
    private javax.swing.JTextField ingresarIP;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
