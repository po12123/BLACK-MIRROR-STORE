package Vista;

import Modelo.ProveedorDao;
import Modelo.Proveedor;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ProveedorGUI extends javax.swing.JFrame {

    Proveedor pr = new Proveedor();
    ProveedorDao PrDao = new ProveedorDao();
    DefaultTableModel modelo = new DefaultTableModel();
    private MenuPrincipal menuPrincipal;
    public ProveedorGUI() {
        initComponents();
    }

    public void LimpiarTable(){
        for(int i = 0; i < modelo.getRowCount(); i++){
            modelo.removeRow(i);
            i = i - 1;
        }
    }
    private void LimpiarProveedor(){
        jCiTextField.setText("");
        jNombreTextField.setText("");
        jTelefonoTextField.setText("");
        jDireccionTextField.setText("");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jNombreTextField = new javax.swing.JTextField();
        jCiTextField = new javax.swing.JTextField();
        jDireccionTextField = new javax.swing.JTextField();
        jTelefonoTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableProveedor = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jEliminarButton = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnAtras = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("CI:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Telefono:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Direccion:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, -1));

        jNombreTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNombreTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(jNombreTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 160, -1));

        jCiTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCiTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(jCiTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 160, -1));

        jDireccionTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDireccionTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(jDireccionTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 160, -1));

        jTelefonoTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTelefonoTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(jTelefonoTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 160, -1));

        TableProveedor.setAutoCreateRowSorter(true);
        TableProveedor.setBackground(new java.awt.Color(58, 122, 241));
        TableProveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "CI", "Nombre", "Telefono", "Direccion"
            }
        ));
        TableProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableProveedorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableProveedor);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, 440, 340));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Save_37110.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, -1, -1));

        jEliminarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SystemFolder_256x256_icon-icons.com_76749.png"))); // NOI18N
        jEliminarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEliminarButtonActionPerformed(evt);
            }
        });
        jPanel1.add(jEliminarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 260, -1, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/new_page_document_16676.png"))); // NOI18N
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, -1, -1));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/arrow_refresh_15732.png"))); // NOI18N
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 260, -1, -1));

        btnAtras.setBackground(new java.awt.Color(255, 51, 153));
        btnAtras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAtrasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAtrasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAtrasMouseExited(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("MENÚ");
        btnAtras.add(jLabel6);

        jPanel1.add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 10, 60, 30));

        jLabel7.setBackground(new java.awt.Color(102, 51, 0));
        jLabel7.setFont(new java.awt.Font("OCR A Extended", 1, 28)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Proveedores");
        jLabel7.setToolTipText("");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editado.jpeg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 450));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 450));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jNombreTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNombreTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jNombreTextFieldActionPerformed

    private void jCiTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCiTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCiTextFieldActionPerformed

    private void jDireccionTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDireccionTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jDireccionTextFieldActionPerformed

    private void jTelefonoTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTelefonoTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTelefonoTextFieldActionPerformed

    private void btnAtrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAtrasMouseClicked
       menuPrincipal=new MenuPrincipal();
       menuPrincipal.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_btnAtrasMouseClicked

    private void btnAtrasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAtrasMouseEntered
      btnAtras.setBackground(Color.pink);
    }//GEN-LAST:event_btnAtrasMouseEntered

    private void btnAtrasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAtrasMouseExited
         btnAtras.setBackground(new Color(255,51,153));
    }//GEN-LAST:event_btnAtrasMouseExited

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        if (!"".equals(jNombreTextField.getText()) || !"".equals(jCiTextField.getText()) || !"".equals(jDireccionTextField.getText()) || !"".equals(jTelefonoTextField.getText())){
            pr.setCi(Integer.parseInt(jCiTextField.getText()));
            pr.setNombre(jNombreTextField.getText());
            pr.setTelefono(Integer.parseInt(jTelefonoTextField.getText()));
            pr.setDireccion(jDireccionTextField.getText());
            PrDao.RegistrarProveedor(pr);
            MsgRegistroExitoso b = new MsgRegistroExitoso();
            b.setVisible(true);
            pr = new Proveedor();
            LimpiarTable();
            LimpiarProveedor();
            
        }else{
            MsgCamposVacios2 a = new MsgCamposVacios2();
            a.setVisible(true);
            
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void TableProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableProveedorMouseClicked
    int fila = TableProveedor.rowAtPoint(evt.getPoint());
    jCiTextField.setText(TableProveedor.getValueAt(fila, 0).toString());
    jNombreTextField.setText(TableProveedor.getValueAt(fila, 1).toString());
    jTelefonoTextField.setText(TableProveedor.getValueAt(fila, 2).toString());
    jDireccionTextField.setText(TableProveedor.getValueAt(fila, 3).toString());
    }//GEN-LAST:event_TableProveedorMouseClicked

    private void jEliminarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEliminarButtonActionPerformed
        if(!"".equals(jCiTextField.getText())){
            int pregunta = JOptionPane.showConfirmDialog(null, "Esta seguro de el;iminar");
            if(pregunta == 0){
                int ci = Integer.parseInt(jCiTextField.getText());
                PrDao.eliminarProveedor(ci);
                LimpiarTable();
                LimpiarProveedor();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }
    }//GEN-LAST:event_jEliminarButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Proveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Proveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Proveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Proveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProveedorGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableProveedor;
    private javax.swing.JPanel btnAtras;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JTextField jCiTextField;
    private javax.swing.JTextField jDireccionTextField;
    private javax.swing.JButton jEliminarButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField jNombreTextField;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTelefonoTextField;
    // End of variables declaration//GEN-END:variables
    
}
