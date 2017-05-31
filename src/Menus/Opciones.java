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

public class Opciones extends javax.swing.JPanel {

    public Opciones(Ventana m) {
        
            initComponents();
            controls=true;
            this.jFrame1=m;
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
                teniaAlgo=sc1.hasNext();
                if(teniaAlgo){
                    a=sc1.nextInt();
                    b=sc1.nextInt();
                    controls = sc1.nextBoolean();                    
                    ps1 = new PrintStream(f);
                }else{
                    ps1 = new PrintStream(f);
                    a=0;
                    b=0;
                    controls=true;
                }
                
                sc1.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Jugar.class.getName()).log(Level.SEVERE, null, ex);
            }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        buttonGroup1 = new javax.swing.ButtonGroup();
        atras = new javax.swing.JButton();
        controles = new javax.swing.JLabel();
        sonido = new javax.swing.JLabel();
        mouse = new javax.swing.JRadioButton();
        teclado = new javax.swing.JRadioButton();
        slider_sonido = new javax.swing.JSlider();
        jpInstruccionesTeclado = new javax.swing.JPanel();
        jlImageTeclado = new javax.swing.JLabel();
        jdInstruccionesMouse = new javax.swing.JPanel();
        jlMouseIcon = new javax.swing.JLabel();

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

        buttonGroup1.add(mouse);
        mouse.setSelected(true);
        mouse.setText("Mouse");
        mouse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mouseActionPerformed(evt);
            }
        });
        add(mouse, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, -1, -1));

        buttonGroup1.add(teclado);
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

        jlImageTeclado.setIcon(new ImageIcon("gifteclado.gif"));

        javax.swing.GroupLayout jpInstruccionesTecladoLayout = new javax.swing.GroupLayout(jpInstruccionesTeclado);
        jpInstruccionesTeclado.setLayout(jpInstruccionesTecladoLayout);
        jpInstruccionesTecladoLayout.setHorizontalGroup(
            jpInstruccionesTecladoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpInstruccionesTecladoLayout.createSequentialGroup()
                .addComponent(jlImageTeclado)
                .addGap(0, 180, Short.MAX_VALUE))
        );
        jpInstruccionesTecladoLayout.setVerticalGroup(
            jpInstruccionesTecladoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpInstruccionesTecladoLayout.createSequentialGroup()
                .addComponent(jlImageTeclado)
                .addGap(0, 130, Short.MAX_VALUE))
        );

        add(jpInstruccionesTeclado, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 100, 180, 130));

        jlMouseIcon.setIcon(new ImageIcon("gifcursor.gif"));

        javax.swing.GroupLayout jdInstruccionesMouseLayout = new javax.swing.GroupLayout(jdInstruccionesMouse);
        jdInstruccionesMouse.setLayout(jdInstruccionesMouseLayout);
        jdInstruccionesMouseLayout.setHorizontalGroup(
            jdInstruccionesMouseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdInstruccionesMouseLayout.createSequentialGroup()
                .addComponent(jlMouseIcon)
                .addGap(0, 146, Short.MAX_VALUE))
        );
        jdInstruccionesMouseLayout.setVerticalGroup(
            jdInstruccionesMouseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdInstruccionesMouseLayout.createSequentialGroup()
                .addComponent(jlMouseIcon)
                .addGap(0, 116, Short.MAX_VALUE))
        );

        add(jdInstruccionesMouse, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void slider_sonidoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_slider_sonidoStateChanged
        this.repaint();
    }//GEN-LAST:event_slider_sonidoStateChanged

    private void mouseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mouseActionPerformed
        controls=true;
    }//GEN-LAST:event_mouseActionPerformed

    private void tecladoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tecladoActionPerformed
        controls=false;
    }//GEN-LAST:event_tecladoActionPerformed

    private void atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasActionPerformed
        ((Ventana)jFrame1).Cambiar_panel("Principal","Opciones"); 
        ps1.print(a+","+b+","+controls+",");
        ps1.close();
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

    private PrintStream ps1;
    private boolean controls,teniaAlgo;
    private int a,b;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atras;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel controles;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JPanel jdInstruccionesMouse;
    private javax.swing.JLabel jlImageTeclado;
    private javax.swing.JLabel jlMouseIcon;
    private javax.swing.JPanel jpInstruccionesTeclado;
    private javax.swing.JRadioButton mouse;
    private javax.swing.JSlider slider_sonido;
    private javax.swing.JLabel sonido;
    private javax.swing.JRadioButton teclado;
    // End of variables declaration//GEN-END:variables
}
