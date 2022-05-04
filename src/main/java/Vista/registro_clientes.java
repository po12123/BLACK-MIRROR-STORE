/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Modelo.Cliente;
import Modelo.ClienteDao;
import java.awt.Color;
import java.awt.event.KeyEvent;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class registro_clientes extends javax.swing.JFrame {

    Cliente cl = new Cliente();
    ClienteDao cliente = new ClienteDao();
    private DefaultTableModel modelo;
    private MenuPrincipal menuP;
    private MsgDatosIncorrectos2 msgInco; 
    public registro_clientes() {
        initComponents();
        modelo=new DefaultTableModel();
        txtCI.setBackground(new java.awt.Color(0,0,0,1));
        jDireccionTextField.setBackground(new java.awt.Color(0,0,0,1));
        txtNombre.setBackground(new java.awt.Color(0,0,0,1));
        txtTelefono.setBackground(new java.awt.Color(0,0,0,1));
        jTable1.setBackground(new java.awt.Color(0,0,0,1));
        listarClientes();
    }

    private void buscarCliente(java.awt.event.KeyEvent evt){
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!"".equals(txtCI.getText())) {
                int ci = Integer.valueOf(txtCI.getText());
                cl = cliente.buscarCliente(ci);
                if (cl.getCi() != 0) {
                    txtNombre.setText("" + cl.getNombre());
                    txtTelefono.setText("" + cl.getTelefono());
                    jDireccionTextField.setText("" + cl.getDireccion());
                    txtCI.requestFocus();
                } else {
                    txtCI.requestFocus();
                    JOptionPane.showMessageDialog(null, "No existe el cliente con CI: "+txtCI.getText());
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese el CI de cliente");
                txtCI.requestFocus();
            }
        }
    }
    private void listarClientes(){
        ArrayList<Cliente> listaClientes=new ArrayList();
        listaClientes=cliente.listarClientes();
        modelo=(DefaultTableModel) jTable1.getModel();
        Object[] ob = new Object[4];
        for(int i=0; i<listaClientes.size(); i++){
            ob[0]=listaClientes.get(i).getCi();
            ob[1]=listaClientes.get(i).getNombre();
            ob[2]=listaClientes.get(i).getTelefono();
            ob[3]=listaClientes.get(i).getDireccion();
            modelo.addRow(ob);
        }
        jTable1.setModel(modelo);
    }
    private void limpiarTabla(){
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }    
    }
    private void limpiarCliente(){
        txtCI.setText("");
        txtNombre.setText("");
        txtTelefono.setText("");
        jDireccionTextField.setText("");
    }
    
       
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jActualizarButton = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jDireccionTextField = new javax.swing.JTextField();
        txtCI = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        btnMenu = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        ImgFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CI", "NOMBRE", "TELF/CEL", "DIRECCIÓN"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, 490, 300));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Clientes");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 240, 60));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("CI:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, -1, -1));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nombre:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, -1));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Teléfono o cel:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Dirección:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, -1, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Save_37110.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, -1, -1));

        jActualizarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/arrow_refresh_15732.png"))); // NOI18N
        jActualizarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jActualizarButtonActionPerformed(evt);
            }
        });
        getContentPane().add(jActualizarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, -1, -1));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/new_page_document_16676.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 280, -1, -1));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SystemFolder_256x256_icon-icons.com_76749.png"))); // NOI18N
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 280, -1, -1));

        jDireccionTextField.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jDireccionTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 170, -1));

        txtCI.setForeground(new java.awt.Color(255, 255, 255));
        txtCI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCIKeyPressed(evt);
            }
        });
        getContentPane().add(txtCI, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 170, -1));

        txtTelefono.setForeground(new java.awt.Color(255, 255, 255));
        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });
        getContentPane().add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 170, -1));

        txtNombre.setForeground(new java.awt.Color(255, 255, 255));
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 170, -1));

        btnMenu.setBackground(new java.awt.Color(255, 51, 153));
        btnMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMenuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMenuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMenuMouseExited(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("MENU");
        btnMenu.add(jLabel1);

        getContentPane().add(btnMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 20, 80, 30));

        ImgFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editado.jpeg"))); // NOI18N
        getContentPane().add(ImgFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 400));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
     String ci=txtCI.getText();
     String nombre=txtNombre.getText();
     String telefono = txtTelefono.getText();
     
    if(!(ci.matches("^[0-9]+$")||(nombre.matches("^[a-zA-Z\\s]+$"))||(telefono.matches("^[0-9]+$")))){
      
          msgInco =new MsgDatosIncorrectos2();
          msgInco.setVisible(true);
      
     }else{
        if(!"".equals(txtCI.getText()) || !"".equals(txtNombre.getText()) || !"".equals(txtTelefono.getText()) || !"".equals(jDireccionTextField.getText())){
            cl.setCi(Integer.parseInt(txtCI.getText()));
            cl.setNombre(txtNombre.getText());
            cl.setTelefono(Integer.parseInt(txtTelefono.getText()));
            cl.setDireccion(jDireccionTextField.getText());
            cliente.RegistrarCliente(cl);
            MsgRegistroExitoso b = new MsgRegistroExitoso();
            b.setVisible(true);
            cl = new Cliente();
            limpiarTabla();
            limpiarCliente();
            listarClientes();
            
        }else{
            MsgCamposVacios2 a = new MsgCamposVacios2();
            a.setVisible(true);
        }
       }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtCIKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCIKeyPressed
        // TODO add your handling code here:
        buscarCliente(evt);
    }//GEN-LAST:event_txtCIKeyPressed

    private void jActualizarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jActualizarButtonActionPerformed
        if("".equals(txtCI.getText())){
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }else{
            if(!"".equals(txtCI.getText()) || !"".equals(txtNombre.getText()) || !"".equals(txtTelefono.getText()) || !"".equals(jDireccionTextField.getText())){
                cl.setCi(Integer.parseInt(txtCI.getText()));
                cl.setNombre(txtNombre.getText());
                cl.setTelefono(Integer.parseInt(txtTelefono.getText()));
                cl.setDireccion(jDireccionTextField.getText());
                cliente.ModificarCliente(cl);
                limpiarTabla();
                limpiarCliente();
                listarClientes();
            }else{
                MsgCamposVacios2 a = new MsgCamposVacios2();
                a.setVisible(true);
            }
        }
    }//GEN-LAST:event_jActualizarButtonActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        limpiarCliente();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuMouseClicked
        menuP= new MenuPrincipal();
        menuP.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMenuMouseClicked

    private void btnMenuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuMouseEntered
       btnMenu.setBackground(Color.PINK);
    }//GEN-LAST:event_btnMenuMouseEntered

    private void btnMenuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuMouseExited
       btnMenu.setBackground(new Color(255,51,153));
    }//GEN-LAST:event_btnMenuMouseExited

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

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
            java.util.logging.Logger.getLogger(registro_clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(registro_clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(registro_clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(registro_clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new registro_clientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ImgFondo;
    private javax.swing.JPanel btnMenu;
    private javax.swing.JButton jActualizarButton;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JTextField jDireccionTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtCI;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
