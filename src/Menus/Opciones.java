package Menus;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Opciones extends javax.swing.JPanel {

    public Opciones(Ventana m) {
        initComponents();
        this.jFrame1=m;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        atras = new javax.swing.JButton();
        controles = new javax.swing.JLabel();
        sonido = new javax.swing.JLabel();
        mouse = new javax.swing.JRadioButton();
        teclado = new javax.swing.JRadioButton();
        slider_sonido = new javax.swing.JSlider();

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

        controles.setText("Controles");
        add(controles, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, -1, -1));

        sonido.setText("Sonido");
        add(sonido, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 260, -1, -1));

        mouse.setText("Mouse");
        mouse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mouseActionPerformed(evt);
            }
        });
        add(mouse, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, -1, -1));

        teclado.setText("Teclado");
        teclado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tecladoActionPerformed(evt);
            }
        });
        add(teclado, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 180, -1, -1));

        slider_sonido.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                slider_sonidoStateChanged(evt);
            }
        });
        add(slider_sonido, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 300, 260, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void slider_sonidoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_slider_sonidoStateChanged
        this.repaint();
    }//GEN-LAST:event_slider_sonidoStateChanged

    private void mouseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mouseActionPerformed
        teclado.setSelected(false);
        mouse.setSelected(true);
    }//GEN-LAST:event_mouseActionPerformed

    private void tecladoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tecladoActionPerformed
        mouse.setSelected(false);
        teclado.setSelected(true);
        
    }//GEN-LAST:event_tecladoActionPerformed

    private void atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasActionPerformed
        ((Ventana)jFrame1).Cambiar_panel("Principal","Opciones");
        this.setVisible(false);
    }//GEN-LAST:event_atrasActionPerformed

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Image i;
        if(slider_sonido.getValue()>0){
            i = loadImage("sonido_on.png");
        }else{
            i = loadImage("sonido_off.png");
        }
        g.drawImage(i, 100, 290, 50, 50, null);
        g.drawImage(loadImage("fondo1.jpg"), 0, 0, null);
    }
    
    public Image loadImage (String imageName) {
        ImageIcon ii = new ImageIcon (imageName);
        Image image = ii.getImage();
        return image;
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atras;
    private javax.swing.JLabel controles;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JRadioButton mouse;
    private javax.swing.JSlider slider_sonido;
    private javax.swing.JLabel sonido;
    private javax.swing.JRadioButton teclado;
    // End of variables declaration//GEN-END:variables
}
