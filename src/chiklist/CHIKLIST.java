
package chiklist;

import Presentacion.PantallaInicial;

public class CHIKLIST {

    
    public static void main(String[] args) {
        
        // Esto es para que Swing corra en el hilo adecuado
        javax.swing.SwingUtilities.invokeLater(() -> {
            // Opcional: cambiar el diseño visual
            try {
                javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                System.err.println("Error al establecer el look and feel");
            }

            // Abrir la primera ventana
            new PantallaInicial().setVisible(true); // ← cambia esto según tu clase inicial
        });
        
        
    }
    
}
