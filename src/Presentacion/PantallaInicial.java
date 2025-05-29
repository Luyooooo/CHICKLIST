
package Presentacion;


public class PantallaInicial extends javax.swing.JFrame {

    
    public PantallaInicial() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondo = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        pregunta = new javax.swing.JLabel();
        botonIniciarSesion = new javax.swing.JButton();
        botonRegistrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fondo.setBackground(new java.awt.Color(255, 255, 255));
        fondo.setMinimumSize(new java.awt.Dimension(690, 430));
        fondo.setPreferredSize(new java.awt.Dimension(690, 430));
        fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titulo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        titulo.setForeground(new java.awt.Color(0, 0, 0));
        titulo.setText("BIENVENIDO A CHIKLIST");
        fondo.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 310, -1));

        pregunta.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        pregunta.setForeground(new java.awt.Color(0, 0, 0));
        pregunta.setText("¿Qué deseas hacer?");
        fondo.add(pregunta, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 290, -1));

        botonIniciarSesion.setBackground(new java.awt.Color(204, 204, 0));
        botonIniciarSesion.setForeground(new java.awt.Color(0, 0, 0));
        botonIniciarSesion.setText("Iniciar sesion");
        botonIniciarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonIniciarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonIniciarSesionMouseClicked(evt);
            }
        });
        botonIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonIniciarSesionActionPerformed(evt);
            }
        });
        fondo.add(botonIniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 150, 50));

        botonRegistrar.setBackground(new java.awt.Color(204, 204, 0));
        botonRegistrar.setForeground(new java.awt.Color(0, 0, 0));
        botonRegistrar.setText("Registrarse");
        botonRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonRegistrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonRegistrarMouseClicked(evt);
            }
        });
        botonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistrarActionPerformed(evt);
            }
        });
        fondo.add(botonRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 150, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/POLLO MEAT INI.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        fondo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, -100, 660, 660));

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

    private void botonIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIniciarSesionActionPerformed
        // TODO add your handling code here:
        new Presentacion.InicioDeSesion().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_botonIniciarSesionActionPerformed

    private void botonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistrarActionPerformed
        // TODO add your handling code here:
        new Presentacion.Registro().setVisible(true);
        //this.dispose(); la dejo asi mientras tanto xd
    }//GEN-LAST:event_botonRegistrarActionPerformed

    private void botonIniciarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonIniciarSesionMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_botonIniciarSesionMouseClicked

    private void botonRegistrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonRegistrarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_botonRegistrarMouseClicked

    
    public static void main(String args[]) {
        
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
            java.util.logging.Logger.getLogger(PantallaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaInicial().setVisible(true);
            }
        });*/
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonIniciarSesion;
    private javax.swing.JButton botonRegistrar;
    private javax.swing.JPanel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel pregunta;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
