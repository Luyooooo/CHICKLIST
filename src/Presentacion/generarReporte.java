
package Presentacion;

import Logica.Cliente;
import Logica.Pago;
import Logica.Venta;
import java.util.List;
import javax.swing.JOptionPane;


public class generarReporte extends javax.swing.JFrame {

    private String ususario;
    public generarReporte(String usuario) {
        initComponents();
        this.ususario=usuario;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Reporte = new javax.swing.JTextArea();
        GenerarReporte = new javax.swing.JButton();
        GuardarArchivo = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(238, 238, 238));
        jPanel2.setMinimumSize(new java.awt.Dimension(690, 430));
        jPanel2.setPreferredSize(new java.awt.Dimension(690, 430));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Reporte.setBackground(new java.awt.Color(255, 255, 204));
        Reporte.setColumns(20);
        Reporte.setForeground(new java.awt.Color(0, 0, 0));
        Reporte.setRows(5);
        Reporte.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(Reporte);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 310, 380));

        GenerarReporte.setBackground(new java.awt.Color(153, 255, 153));
        GenerarReporte.setForeground(new java.awt.Color(0, 0, 0));
        GenerarReporte.setText("Generar reporte");
        GenerarReporte.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        GenerarReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenerarReporteActionPerformed(evt);
            }
        });
        jPanel2.add(GenerarReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 80, 150, 50));

        GuardarArchivo.setBackground(new java.awt.Color(255, 255, 102));
        GuardarArchivo.setForeground(new java.awt.Color(0, 0, 0));
        GuardarArchivo.setText("Guardar en archivo");
        GuardarArchivo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        GuardarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarArchivoActionPerformed(evt);
            }
        });
        jPanel2.add(GuardarArchivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 160, 150, 50));

        jButton1.setBackground(new java.awt.Color(255, 102, 102));
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Volver al menu");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 250, 150, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 792, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GenerarReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenerarReporteActionPerformed
        // TODO add your handling code here:
        List<Cliente> clientes =    Persistencia.ManejoDeClientes.cargarClientes(ususario);
        List<Venta> ventas = Persistencia.ManejoDeVentas.cargarVentas(clientes,ususario);
        List<Pago> pagos = Persistencia.ManejoDePagos.cargarPagos(clientes,ususario);

        Logica.ReporteDiario reporte = new Logica.ReporteDiario(ventas, pagos,clientes);

        Reporte.setText(reporte.generarResumenTexto());
    }//GEN-LAST:event_GenerarReporteActionPerformed

    private void GuardarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarArchivoActionPerformed
        // TODO add your handling code here:
        List<Cliente> clientes = Persistencia.ManejoDeClientes.cargarClientes(ususario);
        List<Venta> ventas = Persistencia.ManejoDeVentas.cargarVentas(clientes,ususario);
        List<Pago> pagos = Persistencia.ManejoDePagos.cargarPagos(clientes,ususario);

        Persistencia.ManejoDeReportes.generarReporteDiario(ventas, pagos,ususario);
        JOptionPane.showMessageDialog(this, "Reporte guardado correctamente.");
    }//GEN-LAST:event_GuardarArchivoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new Presentacion.MenuPrincipal(ususario).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(generarReporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(generarReporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(generarReporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(generarReporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*Create and display the form 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new generarReporte().setVisible(true);
            }
        });*/
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton GenerarReporte;
    private javax.swing.JButton GuardarArchivo;
    private javax.swing.JTextArea Reporte;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
