package Menus;

import Conexiones.Servidor;
import Conexiones.*;
import Menus.Ventana;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Crear extends javax.swing.JPanel {

    public Crear(Ventana m) {
        initComponents();
        modo="ffa";
        this.jFrame1 = m;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        nombre = new javax.swing.JTextPane();
        viento = new javax.swing.JToggleButton();
        ffa = new javax.swing.JRadioButton();
        teams = new javax.swing.JRadioButton();
        crear = new javax.swing.JButton();
        atras = new javax.swing.JButton();
        etiqueta_nombre = new javax.swing.JLabel();

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

        jScrollPane1.setViewportView(nombre);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 260, 30));

        viento.setText("viento");
        add(viento, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 150, -1, -1));

        buttonGroup1.add(ffa);
        ffa.setSelected(true);
        ffa.setText("Todos contra todos");
        ffa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ffaActionPerformed(evt);
            }
        });
        add(ffa, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, -1, -1));

        buttonGroup1.add(teams);
        teams.setText("Por equipos");
        teams.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teamsActionPerformed(evt);
            }
        });
        add(teams, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 270, -1, -1));

        crear.setText("Crear");
        crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearActionPerformed(evt);
            }
        });
        add(crear, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 340, -1, -1));

        atras.setText("atras");
        atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasActionPerformed(evt);
            }
        });
        add(atras, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        etiqueta_nombre.setText("Nombre del servidor");
        add(etiqueta_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void crearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearActionPerformed
        s = new Servidor(viento.isSelected(), "fondo", modo);
        ((Ventana)jFrame1).Cambiar_panel("Espera","Crear");
    }//GEN-LAST:event_crearActionPerformed

    private void atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasActionPerformed
        ((Ventana)jFrame1).Cambiar_panel("Jugar","Crear");
    }//GEN-LAST:event_atrasActionPerformed

    private void ffaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ffaActionPerformed
        modo = "ffa";
    }//GEN-LAST:event_ffaActionPerformed

    private void teamsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teamsActionPerformed
        modo = "teams";
    }//GEN-LAST:event_teamsActionPerformed

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

    public Servidor getS() {
        return s;
    }

    private String modo;
    private Servidor s;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atras;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton crear;
    private javax.swing.JLabel etiqueta_nombre;
    private javax.swing.JRadioButton ffa;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane nombre;
    private javax.swing.JRadioButton teams;
    private javax.swing.JToggleButton viento;
    // End of variables declaration//GEN-END:variables
}
