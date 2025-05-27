
package Presentacion;

import Logica.Cliente;
import Persistencia.ManejoDeClientes;
import Persistencia.ManejoDePagos;
import Persistencia.ManejoDeVentas;
import java.util.List;
import javax.swing.table.DefaultTableModel;


public class ClientesDeudores extends javax.swing.JFrame {

    private String usuario;
    public ClientesDeudores(String usuario) {
        initComponents();
        this.usuario=usuario;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        cargarDeudores = new javax.swing.JButton();
        volver = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaDeudores = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fondo.setBackground(new java.awt.Color(238, 238, 238));
        fondo.setMinimumSize(new java.awt.Dimension(690, 430));
        fondo.setName(""); // NOI18N
        fondo.setPreferredSize(new java.awt.Dimension(690, 430));
        fondo.setRequestFocusEnabled(false);
        fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(0, 102, 102));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Tabla de deudores");
        fondo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 180, 30));

        jScrollPane1.setBackground(new java.awt.Color(221, 221, 221));
        jScrollPane1.setForeground(new java.awt.Color(221, 221, 221));
        fondo.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 560, 340));

        cargarDeudores.setText("Cargar deudores");
        cargarDeudores.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cargarDeudores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarDeudoresActionPerformed(evt);
            }
        });
        fondo.add(cargarDeudores, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 160, 120, 40));

        volver.setText("Volver al menú");
        volver.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });
        fondo.add(volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 210, 120, 40));

        tablaDeudores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellido", "Cedula", "Saldo pendiente"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaDeudores);

        fondo.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 560, 370));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(fondo, javax.swing.GroupLayout.PREFERRED_SIZE, 792, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cargarDeudoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarDeudoresActionPerformed
        // Cargar datos
        List<Cliente> clientes = ManejoDeClientes.cargarClientes(usuario);
        ManejoDeVentas.cargarVentas(clientes, usuario);
        ManejoDePagos.cargarPagos(clientes, usuario);

        // Configurar tabla
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new String[] { "Nombre", "Apellido", "Cédula", "Saldo pendiente" });

        for (Cliente c : clientes) {
            if (c.getSaldoPendiente() > 0) {
                modelo.addRow(new Object[] {
                    c.getNombre(),
                    c.getApellido(),
                    c.getCedula(),
                    "$" + c.getSaldoPendiente()
                });
            }
        }

        tablaDeudores.setModel(modelo);
    }//GEN-LAST:event_cargarDeudoresActionPerformed

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
        new Presentacion.MenuPrincipal(usuario).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_volverActionPerformed

    
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
            java.util.logging.Logger.getLogger(ClientesDeudores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientesDeudores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientesDeudores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientesDeudores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientesDeudores("pepito34").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cargarDeudores;
    private javax.swing.JPanel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaDeudores;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}
