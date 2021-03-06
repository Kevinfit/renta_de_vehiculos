/*
this is the second report
 */
package Interfaces;

import Procedimientos.Instancias;
import Procedimientos.Reporte2_procedimiento;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Kevin
 */
public class Reporte_2 extends javax.swing.JDialog {

    /**
     * Creates new form Reporte_2
     */
    Instancias instancias = new Instancias();
    Reporte2_procedimiento reporte = new Reporte2_procedimiento();
    int prueba = 0;

    public Reporte_2(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Reporte 2");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Estado = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel1.setText("Seleccione un Estado");

        Estado.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        Estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ocupado", "Disponible" }));

        jButton1.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        jButton1.setText("Generar PDF");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N
        jButton2.setText("Atrás");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(Estado, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton2))
                .addGap(48, 48, 48)
                .addComponent(Estado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if ("".equals(Estado.getSelectedItem().toString())) {
            JOptionPane.showMessageDialog(null, "Ingrese algún Estado!");
        } else {
            if (Estado.getSelectedItem().toString().equals("Disponible")) {
                prueba += 1;
                reporte.generar_PDF_Reporte2("Reporte 2\nVehiculos Disponibles ", reporte.Infoplaca(), reporte.Infomarca(), reporte.Infomodelo(), reporte.Infoestilo(), "Grupo Kevin Y Caro RENT A CAR",
                        "" + "Reportes2_prueba " + prueba + ".pdf");
                try {
                    String file = new String("Reportes2_prueba " + prueba + ".pdf");
                    File path = new File(file);
                    Desktop.getDesktop().open(path);
                } catch (IOException ex) {
                    Logger.getLogger(Reporte_1.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                prueba += 1;
                reporte.generar_PDF_Reporte2("Reporte 2\nVehiculos Ocupados ", reporte.Infoplaca(), reporte.Infomarca(), reporte.Infomodelo(), reporte.Infoestilo(), "Grupo Kevin Y Caro RENT A CAR",
                        "" + "Reportes2_prueba " + prueba + ".pdf");
                try {
                    String file = new String("Reportes2_prueba " + prueba + ".pdf");
                    File path = new File(file);
                    Desktop.getDesktop().open(path);
                } catch (IOException ex) {
                    Logger.getLogger(Reporte_1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
        instancias.reportes();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JComboBox<String> Estado;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
