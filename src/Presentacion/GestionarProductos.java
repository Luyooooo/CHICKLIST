
package Presentacion;

import Logica.Producto;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class GestionarProductos extends javax.swing.JFrame {

    private String usuario;
    public GestionarProductos(String usuario) {
        initComponents();
        this.usuario=usuario;
        cargarProductosEnTabla();
    }
    
    private void cargarProductosEnTabla() {
        DefaultTableModel modelo = (DefaultTableModel) tablaProductos.getModel();
        modelo.setRowCount(0); // limpiar tabla

        List<Producto> productos = Persistencia.ManejoDeProductos.cargarProductos(usuario);
        for (Producto p : productos) {
            Object[] fila = { p.getNombre(), p.getCodigoProducto(), p.getPrecio(), p.getCantidad() };
            modelo.addRow(fila);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondo = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        codigoField = new javax.swing.JTextField();
        precioField = new javax.swing.JTextField();
        cantidadField = new javax.swing.JTextField();
        nombreField = new javax.swing.JTextField();
        editar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fondo.setBackground(new java.awt.Color(238, 238, 238));
        fondo.setMinimumSize(new java.awt.Dimension(690, 430));
        fondo.setPreferredSize(new java.awt.Dimension(690, 430));
        fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Codigo", "Precio", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProductosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaProductos);

        jScrollPane1.setViewportView(jScrollPane2);

        fondo.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 300));

        codigoField.setBackground(new java.awt.Color(255, 255, 255));
        codigoField.setText("Codigo del producto seleccionado");
        codigoField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                codigoFieldMousePressed(evt);
            }
        });
        fondo.add(codigoField, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 360, 270, -1));

        precioField.setBackground(new java.awt.Color(255, 255, 255));
        precioField.setText("Precio del producto seleccionado");
        precioField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                precioFieldMousePressed(evt);
            }
        });
        fondo.add(precioField, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 400, 270, -1));

        cantidadField.setBackground(new java.awt.Color(255, 255, 255));
        cantidadField.setText("Cantidad de unidades del producto seleccionado");
        cantidadField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cantidadFieldMousePressed(evt);
            }
        });
        fondo.add(cantidadField, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 440, 280, -1));

        nombreField.setBackground(new java.awt.Color(255, 255, 255));
        nombreField.setText("Nombre del producto seleccionado");
        nombreField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                nombreFieldMousePressed(evt);
            }
        });
        fondo.add(nombreField, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, 270, -1));

        editar.setText("Guardar cambios");
        editar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarActionPerformed(evt);
            }
        });
        fondo.add(editar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 320, 130, -1));

        eliminar.setText("Eliminar producto");
        eliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });
        fondo.add(eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 350, 130, -1));

        jButton1.setText("Volver");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        fondo.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 390, 130, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Codigo:");
        fondo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Precio:");
        fondo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Cantidad:");
        fondo.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Nombre:");
        fondo.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, 792, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(fondo, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProductosMouseClicked
        // TODO add your handling code here:
        int fila = tablaProductos.getSelectedRow();
        if (fila >= 0) {
            nombreField.setText(tablaProductos.getValueAt(fila, 0).toString());
            codigoField.setText(tablaProductos.getValueAt(fila,1).toString());
            precioField.setText(tablaProductos.getValueAt(fila, 2).toString());
            cantidadField.setText(tablaProductos.getValueAt(fila, 3).toString());
        }
    }//GEN-LAST:event_tablaProductosMouseClicked

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed
        // TODO add your handling code here:
        int fila = tablaProductos.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(this, "Selecciona un producto.");
            return;
        }

        String nombre = nombreField.getText().trim();
        
        double precio;
        int cantidad;

        try {
            precio = Double.parseDouble(precioField.getText().trim());
            cantidad = Integer.parseInt(cantidadField.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Precio o cantidad inválidos.");
            return;
        }

        List<Producto> productos = Persistencia.ManejoDeProductos.cargarProductos(usuario);
        for (Producto p : productos) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                p.setPrecio(precio);
                p.setCantidad(cantidad);
                break;
            }
        }

        Persistencia.ManejoDeProductos.sobrescribirProductos(usuario,productos);
        cargarProductosEnTabla();
        JOptionPane.showMessageDialog(this, "Producto actualizado.");
    }//GEN-LAST:event_editarActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        // TODO add your handling code here:
        int fila = tablaProductos.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(this, "Selecciona un producto.");
            return;
        }

        String nombre = tablaProductos.getValueAt(fila, 0).toString();

        List<Producto> productos = Persistencia.ManejoDeProductos.cargarProductos(usuario);
        productos.removeIf(p -> p.getNombre().equalsIgnoreCase(nombre));
        Persistencia.ManejoDeProductos.sobrescribirProductos(usuario,productos);
        cargarProductosEnTabla();
        JOptionPane.showMessageDialog(this, "Producto eliminado.");
    }//GEN-LAST:event_eliminarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new Presentacion.Inventario(usuario).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void nombreFieldMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nombreFieldMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreFieldMousePressed

    private void codigoFieldMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_codigoFieldMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_codigoFieldMousePressed

    private void precioFieldMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_precioFieldMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_precioFieldMousePressed

    private void cantidadFieldMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cantidadFieldMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cantidadFieldMousePressed

    
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
            java.util.logging.Logger.getLogger(GestionarProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionarProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionarProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionarProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionarProductos("pepito34").setVisible(true);
            }
        });*/
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cantidadField;
    private javax.swing.JTextField codigoField;
    private javax.swing.JButton editar;
    private javax.swing.JButton eliminar;
    private javax.swing.JPanel fondo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField nombreField;
    private javax.swing.JTextField precioField;
    private javax.swing.JTable tablaProductos;
    // End of variables declaration//GEN-END:variables
}
