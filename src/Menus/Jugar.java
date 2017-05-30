package Menus;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class Jugar extends javax.swing.JPanel {

    public Jugar(Ventana m) {
        initComponents();
        armazon.setValue(1);
        oruga.setValue(1);
        File f= new File("datos_J.txt");
        if(!f.exists()){
            try {
                f.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(Jugar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        Scanner sc1;
        this.jFrame1=m;
        try {
            sc1= new Scanner(f);
            sc1.useDelimiter(",");
            if(sc1.hasNext()){
                armazon.setValue(sc1.nextInt());
                oruga.setValue(sc1.nextInt());
            }
            ps1 = new PrintStream(f);
            sc1.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Jugar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        Crear = new javax.swing.JButton();
        Entrar = new javax.swing.JButton();
        atras = new javax.swing.JButton();
        armazon = new javax.swing.JSpinner();
        oruga = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

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

        Crear.setText("Crear partida");
        Crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearActionPerformed(evt);
            }
        });
        add(Crear, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 370, -1, -1));

        Entrar.setText("Entrar a partida");
        Entrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EntrarActionPerformed(evt);
            }
        });
        add(Entrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 370, -1, -1));

        atras.setText("atras");
        atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasActionPerformed(evt);
            }
        });
        add(atras, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        armazon.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                armazonStateChanged(evt);
            }
        });
        add(armazon, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 120, -1, -1));

        oruga.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                orugaStateChanged(evt);
            }
        });
        add(oruga, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 220, -1, -1));

        jLabel1.setText("Armazon");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 100, -1, -1));

        jLabel2.setText("Orugas");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 200, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void CrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearActionPerformed
        ((Ventana)jFrame1).Cambiar_panel("Crear","Jugar");
        ps1.println(armazon.getValue()+","+oruga.getValue()+",");
    }//GEN-LAST:event_CrearActionPerformed

    private void atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasActionPerformed
        ((Ventana)jFrame1).Cambiar_panel("Principal","Jugar");
    }//GEN-LAST:event_atrasActionPerformed

    private void EntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EntrarActionPerformed
        ((Ventana)jFrame1).Cambiar_panel("Entrar","Jugar");
        ps1.println(armazon.getValue()+","+oruga.getValue()+",");
    }//GEN-LAST:event_EntrarActionPerformed

    private void armazonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_armazonStateChanged
        if((int)armazon.getValue() < 1){
            armazon.setValue(1);
        }
        if((int)armazon.getValue()>4){
            armazon.setValue(4);
        }
        repaint();
    }//GEN-LAST:event_armazonStateChanged

    private void orugaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_orugaStateChanged
        if((int)oruga.getValue()<1){
            oruga.setValue(1);
        }
        if((int)oruga.getValue()>4){
            oruga.setValue(4);
        }
        repaint();
    }//GEN-LAST:event_orugaStateChanged

        @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //g.drawImage(loadImage ("fondo1.jpg"), 0, 0, null);
        tipoArmazon=(int)armazon.getValue()-1;
        tipoOruga= 2*((int)(oruga.getValue())-1);
        g.drawImage(loadImage("Tanque.png"), 150, 75, 350, 275, tipoOruga*181,0,(tipoOruga+1)* 181,181,this);
        g.drawImage(loadImage("Rojos.png"), 150, 75, 350, 275, tipoArmazon*181,0, (tipoArmazon+1)*181,181,this);

    }

    public Image loadImage (String imageName) {
        ImageIcon ii = new ImageIcon (imageName);
        Image image = ii.getImage();
        return image;
    }
    private int tipoOruga,tipoArmazon;
    private PrintStream ps1;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Crear;
    private javax.swing.JButton Entrar;
    private javax.swing.JSpinner armazon;
    private javax.swing.JButton atras;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSpinner oruga;
    // End of variables declaration//GEN-END:variables
}
