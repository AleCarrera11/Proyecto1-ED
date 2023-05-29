/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyecto1;

/**
 *
 * @author alejandra, isabela y adrian
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        archivos = new javax.swing.JMenu();
        cargarArchivo = new javax.swing.JMenuItem();
        archivoDefault = new javax.swing.JMenuItem();
        actualizarArchivo = new javax.swing.JMenuItem();
        mostrarRelaciones = new javax.swing.JMenu();
        mostrarIslas = new javax.swing.JMenu();
        BFS = new javax.swing.JMenuItem();
        DFS = new javax.swing.JMenuItem();
        puentes = new javax.swing.JMenu();
        editarRelaciones = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/redes.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 0, 550, 360));

        archivos.setText("Archivos");
        archivos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        cargarArchivo.setText("Cargar archivo");
        cargarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarArchivoActionPerformed(evt);
            }
        });
        archivos.add(cargarArchivo);

        archivoDefault.setText("Archivo Default");
        archivos.add(archivoDefault);

        actualizarArchivo.setText("Actualizar archivo");
        archivos.add(actualizarArchivo);

        jMenuBar1.add(archivos);

        mostrarRelaciones.setText("Mostrar Relaciones");
        mostrarRelaciones.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuBar1.add(mostrarRelaciones);

        mostrarIslas.setText("Mostrar Islas");
        mostrarIslas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        BFS.setText("Recorrido por anchura");
        mostrarIslas.add(BFS);

        DFS.setText("Recorrido por profundidad");
        mostrarIslas.add(DFS);

        jMenuBar1.add(mostrarIslas);

        puentes.setText("Puentes");
        puentes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuBar1.add(puentes);

        editarRelaciones.setText("Editar Relaciones");
        editarRelaciones.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuBar1.add(editarRelaciones);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cargarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarArchivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cargarArchivoActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem BFS;
    private javax.swing.JMenuItem DFS;
    private javax.swing.JMenuItem actualizarArchivo;
    private javax.swing.JMenuItem archivoDefault;
    private javax.swing.JMenu archivos;
    private javax.swing.JMenuItem cargarArchivo;
    private javax.swing.JMenu editarRelaciones;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenu mostrarIslas;
    private javax.swing.JMenu mostrarRelaciones;
    private javax.swing.JMenu puentes;
    // End of variables declaration//GEN-END:variables
}
