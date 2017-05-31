package Menus;

import Conexiones.Cliente;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Entrar extends javax.swing.JPanel {

    public Entrar(Ventana m) {
        initComponents();
        this.jFrame1 = m;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        atras = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        partidas = new javax.swing.JTable();
        entrar = new javax.swing.JButton();

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

        partidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "", "Nombre", "Jugadores", "Modo de juego"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(partidas);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 560, 210));

        entrar.setText("Entrar");
        entrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entrarActionPerformed(evt);
            }
        });
        add(entrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 360, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasActionPerformed
        ((Ventana)jFrame1).Cambiar_panel("Jugar","Entrar");
    }//GEN-LAST:event_atrasActionPerformed

    private void entrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entrarActionPerformed
        ((Ventana)jFrame1).Cambiar_panel("Espera", "Entrar");
        ((Espera)((Ventana)jFrame1).getPanel("Espera")).getIniciar().setVisible(false);
        Cliente c = new Cliente("localhost",(Ventana)jFrame1);
    }//GEN-LAST:event_entrarActionPerformed

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
    private javax.swing.JFrame jFrame1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable partidas;
    // End of variables declaration//GEN-END:variables
}
