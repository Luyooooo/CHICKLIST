
package Presentacion;

import Logica.Cliente;
import Logica.Producto;
import Logica.Venta;
import Persistencia.ManejoDeClientes;
import Persistencia.ManejoDeProductos;
import Persistencia.ManejoDeVentas;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class RegistrarVenta extends javax.swing.JFrame {
    
    
    private List<Producto> productosSeleccionados = new ArrayList<>();
    private String usuario;
    public RegistrarVenta(String usuario) {
        initComponents();
        this.usuario=usuario;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        ProductoField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        CantidadField = new javax.swing.JTextField();
        CedulaField = new javax.swing.JTextField();
        PagadoCheckbox = new java.awt.Checkbox();
        AgregarProducto = new javax.swing.JButton();
        RegistrarVenta = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Resumen = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fondo.setBackground(new java.awt.Color(238, 238, 238));
        fondo.setMinimumSize(new java.awt.Dimension(690, 430));
        fondo.setPreferredSize(new java.awt.Dimension(690, 430));
        fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Producto(nombre):");
        fondo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        ProductoField.setBackground(new java.awt.Color(255, 255, 255));
        ProductoField.setText("Ingrese el nombre del producto");
        ProductoField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ProductoFieldMousePressed(evt);
            }
        });
        ProductoField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProductoFieldActionPerformed(evt);
            }
        });
        fondo.add(ProductoField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 280, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Cantidad:");
        fondo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Cedula del cliente:");
        fondo.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        CantidadField.setBackground(new java.awt.Color(255, 255, 255));
        CantidadField.setText("Ingrese la cantidad");
        CantidadField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CantidadFieldMousePressed(evt);
            }
        });
        fondo.add(CantidadField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 280, 30));

        CedulaField.setBackground(new java.awt.Color(255, 255, 255));
        CedulaField.setText("Ingrese el numero de cedula del cliente");
        CedulaField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CedulaFieldMousePressed(evt);
            }
        });
        fondo.add(CedulaField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 280, 30));

        PagadoCheckbox.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        PagadoCheckbox.setLabel("Pagado");
        fondo.add(PagadoCheckbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 70, -1, -1));

        AgregarProducto.setText("Agregar producto");
        AgregarProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarProductoActionPerformed(evt);
            }
        });
        fondo.add(AgregarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 110, 130, 50));

        RegistrarVenta.setText("Registrar venta");
        RegistrarVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        RegistrarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarVentaActionPerformed(evt);
            }
        });
        fondo.add(RegistrarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 180, 130, 50));

        Resumen.setBackground(new java.awt.Color(255, 255, 204));
        Resumen.setColumns(20);
        Resumen.setRows(5);
        jScrollPane1.setViewportView(Resumen);

        fondo.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 280, 160));

        jButton1.setText("Volver al menu");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        fondo.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 250, 130, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, 792, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ProductoFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProductoFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProductoFieldActionPerformed

    private void AgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarProductoActionPerformed
        // TODO add your handling code here:
        String nombreProducto = ProductoField.getText().trim();
        String cantidadTexto = CantidadField.getText().trim();

        if (nombreProducto.isEmpty() || cantidadTexto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor ingresa producto y cantidad.");
            return;
        }

        int cantidad;
        try {
            cantidad = Integer.parseInt(cantidadTexto);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Cantidad inválida.");
            return;
        }
        
        List<Producto> inventario = ManejoDeProductos.cargarProductos(usuario);
        Producto encontrado = null;

        for (Producto p : inventario) {
            if (p.getNombre().equalsIgnoreCase(nombreProducto)) {
                encontrado = p;
                break;
            }
        }

        if (encontrado == null) {
            JOptionPane.showMessageDialog(this, "Producto no encontrado.");
            return;
        }
        
        if (cantidad > encontrado.getCantidad()) {
        JOptionPane.showMessageDialog(this, "Stock insuficiente.");
        return;
        }

        productosSeleccionados.add(new Producto(encontrado.getNombre(), encontrado.getCodigoProducto(), encontrado.getPrecio(), cantidad));
        Resumen.append("*" + encontrado.getNombre() + " x" + cantidad + "="+(encontrado.getPrecio()*cantidad) + "\n");

        // limpiar campos
        ProductoField.setText("");
        CantidadField.setText("");
        
    }//GEN-LAST:event_AgregarProductoActionPerformed

    private void RegistrarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarVentaActionPerformed
        // TODO add your handling code here:
        String cedulaTexto = CedulaField.getText().trim();

        if (cedulaTexto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingresa la cédula del cliente.");
            return;
        }

        int cedula;
        try {
            cedula = Integer.parseInt(cedulaTexto);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Cédula inválida.");
            return;
        }
        
        List<Cliente> clientes = ManejoDeClientes.cargarClientes(usuario);
        Cliente cliente = null;
        for (Cliente c : clientes) {
            if (c.getCedula() == cedula) {
                cliente = c;
                break;
            }
        }

        if (cliente == null) {
            JOptionPane.showMessageDialog(this, "Cliente no encontrado.");
            return;
        }
        
        if (productosSeleccionados.isEmpty()) {
        JOptionPane.showMessageDialog(this, "No has agregado productos.");
        return;
        }

        Venta venta = new Venta(cliente, productosSeleccionados);
        if (PagadoCheckbox.getState()) {
            venta.marcarComoPagada();
        } else {
            cliente.agregarVenta(venta); // suma al saldo pendiente
        }

        ManejoDeVentas.guardarVenta(venta,usuario);
        
        // actualizar inventario
        List<Producto> inventario = ManejoDeProductos.cargarProductos(usuario);
        for (Producto comprado : productosSeleccionados) {
            for (Producto p : inventario) {
                if (p.getNombre().equalsIgnoreCase(comprado.getNombre())) {
                    p.disminuirCantidad(comprado.getCantidad());
                }
            }
        }
        ManejoDeProductos.sobrescribirProductos(usuario,inventario);

        JOptionPane.showMessageDialog(this, "Venta registrada correctamente.");
        new Presentacion.MenuPrincipal(usuario).setVisible(true);
        this.dispose(); // cerrar ventana
        
    }//GEN-LAST:event_RegistrarVentaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new Presentacion.MenuPrincipal(usuario).setVisible(true);
        this.dispose(); // cerrar ventana
    }//GEN-LAST:event_jButton1ActionPerformed

    private void CedulaFieldMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CedulaFieldMousePressed
        // TODO add your handling code here:
        CedulaField.setText("");
        
    }//GEN-LAST:event_CedulaFieldMousePressed

    private void ProductoFieldMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProductoFieldMousePressed
        // TODO add your handling code here:
        ProductoField.setText("");
    }//GEN-LAST:event_ProductoFieldMousePressed

    private void CantidadFieldMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CantidadFieldMousePressed
        // TODO add your handling code here:
        CantidadField.setText("");
    }//GEN-LAST:event_CantidadFieldMousePressed

    
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
            java.util.logging.Logger.getLogger(RegistrarVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarVenta("pepito34").setVisible(true);
            }
        });*/
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AgregarProducto;
    private javax.swing.JTextField CantidadField;
    private javax.swing.JTextField CedulaField;
    private java.awt.Checkbox PagadoCheckbox;
    private javax.swing.JTextField ProductoField;
    private javax.swing.JButton RegistrarVenta;
    private javax.swing.JTextArea Resumen;
    private javax.swing.JPanel fondo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
