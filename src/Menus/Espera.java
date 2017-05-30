package Menus;

import Conexiones.Cliente;
import Conexiones.Servidor;
import Menus.Ventana;
import javax.swing.JButton;

public class Espera extends javax.swing.JPanel {

    public Espera(Ventana v) {
        this.ventana=v;
        this.servidor=((Crear)(ventana.getPanel("Crear"))).getS();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Iniciar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        Iniciar.setText("Iniciar");
        Iniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IniciarActionPerformed(evt);
            }
        });

        jLabel1.setText("Esperando");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(245, 245, 245)
                        .addComponent(Iniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(275, 275, 275)
                        .addComponent(jLabel1)))
                .addContainerGap(265, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(jLabel1)
                .addGap(81, 81, 81)
                .addComponent(Iniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(218, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void IniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IniciarActionPerformed
        ((Crear)(ventana.getPanel("Crear"))).getS().setJugar(true);
        Cliente c = new Cliente("localhost",ventana);
        System.out.println("paso por aqui");
    }//GEN-LAST:event_IniciarActionPerformed

    public JButton getIniciar() {
        return Iniciar;
    }

    public void setIniciar(JButton Iniciar) {
        this.Iniciar = Iniciar;
    }

    
    
    private Servidor servidor;
    private Ventana ventana;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Iniciar;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
