package Menus;

import Conexiones.Servidor;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Crear extends javax.swing.JPanel {

    public Crear(Ventana m) {
        initComponents();
        fondos.setValue(1);
        fondo="fondo1.png";
        modo="ffa";
        wind=false;
        this.jFrame1 = m;

    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        viento = new javax.swing.JToggleButton();
        ffa = new javax.swing.JRadioButton();
        teams = new javax.swing.JRadioButton();
        crear = new javax.swing.JButton();
        atras = new javax.swing.JButton();
        fondos = new javax.swing.JSpinner();

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

        viento.setText("viento");
        viento.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                vientoStateChanged(evt);
            }
        });
        add(viento, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 200, -1, -1));

        buttonGroup1.add(ffa);
        ffa.setSelected(true);
        ffa.setText("Todos contra todos");
        ffa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ffaActionPerformed(evt);
            }
        });
        add(ffa, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 250, -1, -1));

        buttonGroup1.add(teams);
        teams.setText("Por equipos");
        teams.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teamsActionPerformed(evt);
            }
        });
        add(teams, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 290, -1, -1));

        crear.setText("Crear");
        crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearActionPerformed(evt);
            }
        });
        add(crear, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 350, -1, -1));

        atras.setText("atras");
        atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasActionPerformed(evt);
            }
        });
        add(atras, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        fondos.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                fondosStateChanged(evt);
            }
        });
        add(fondos, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 100, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void crearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearActionPerformed
        s = new Servidor(fondo,modo,wind);
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

    private void vientoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_vientoStateChanged
        wind = viento.isSelected();
    }//GEN-LAST:event_vientoStateChanged

    private void fondosStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_fondosStateChanged
        if((int)fondos.getValue()<1){
            fondos.setValue(1);
        }
        if((int)fondos.getValue()>4){
            fondos.setValue(4);
        }
        switch((int)fondos.getValue()){
            case 1:fondo="fondo1.png";break;
            case 2:fondo="fondo2.png";break;
            case 3:fondo="fondo3.png";break;
            case 4:fondo="fondo4.png";break;
        }
        this.repaint();
    }//GEN-LAST:event_fondosStateChanged

            @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawRect(175, 20, 250, 150);
        g.drawImage(loadImage(fondo),175, 20, 250, 150, null);
    }

    public Image loadImage (String imageName) {
        ImageIcon ii = new ImageIcon (imageName);
        Image image = ii.getImage();
        return image;
    }

    public Servidor getS() {
        return s;
    }

    private String modo,fondo;
    private boolean wind;
    private Servidor s;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atras;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton crear;
    private javax.swing.JRadioButton ffa;
    private javax.swing.JSpinner fondos;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JRadioButton teams;
    private javax.swing.JToggleButton viento;
    // End of variables declaration//GEN-END:variables
}
