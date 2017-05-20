package menus;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;


public class Principal extends javax.swing.JPanel {

     public Principal(Ventana m) {
        initComponents();
        this.jFrame1=m;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        titulo = new javax.swing.JLabel();
        jugar = new javax.swing.JButton();
        opciones = new javax.swing.JButton();

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

        titulo.setFont(new java.awt.Font("Ubuntu", 0, 36)); // NOI18N
        titulo.setText("Tanker");
        add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, -1, -1));

        jugar.setText("Jugar");
        jugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jugarActionPerformed(evt);
            }
        });
        add(jugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 230, -1, -1));

        opciones.setText("Opciones");
        opciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionesActionPerformed(evt);
            }
        });
        add(opciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 310, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jugarActionPerformed
        ((Ventana)jFrame1).Cambiar_panel("Jugar");
        this.setVisible(false);
    }//GEN-LAST:event_jugarActionPerformed

    private void opcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionesActionPerformed
        ((Ventana)jFrame1).Cambiar_panel("Opciones");
        this.setVisible(false);
    }//GEN-LAST:event_opcionesActionPerformed

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFrame jFrame1;
    private javax.swing.JButton jugar;
    private javax.swing.JButton opciones;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
