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

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Iniciar.setText("Iniciar");
        Iniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IniciarActionPerformed(evt);
            }
        });
        add(Iniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 250, 110, 40));

        jLabel1.setText("Esperando Jugadores");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void IniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IniciarActionPerformed
        ((Crear)(ventana.getPanel("Crear"))).getS().setJugar(true);
        Cliente c = new Cliente("localhost",ventana);
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
