/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Modelo.Conexion;
import Modelo.Descuento;
import Modelo.Producto;
import Modelo.ProductoBD;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


/**
 *
 * @author rybel
 */
public class Descuentos extends javax.swing.JFrame {

    /**
     * Creates new form Producto
     */
    private Conexion cn = new Conexion();
    private Connection con=cn.conectar();
    private Producto producto;
    private ProductoBD productoBD;
    
    public Descuentos() {  
        initComponents();
        producto=new Producto();
        productoBD=new ProductoBD();
    }

   private void buscarProducto(java.awt.event.KeyEvent evt){
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!"".equals(textCodigo.getText())) {
                String codigo =textCodigo.getText();
                producto = productoBD.buscarProducto(codigo);
                if (producto.getId()!= 0) {
                    textModelo.setText("" + producto.getModelo());
                    textCodigo.requestFocus();
                } else {
                    textCodigo.requestFocus();
                    JOptionPane.showMessageDialog(null, "No existe el producto: "+textCodigo.getText());
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese el Codigo de producto");
                textCodigo.requestFocus();
            }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        textCodigo = new javax.swing.JTextField();
        textModelo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        textPrecio = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDescuentos = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jButton6 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Codigo:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 58, 43, 25));

        textCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textCodigoActionPerformed(evt);
            }
        });
        textCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textCodigoKeyPressed(evt);
            }
        });
        jPanel2.add(textCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 59, 140, -1));
        jPanel2.add(textModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 143, 142, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Modelo:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 146, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Fecha inicio:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 189, -1, -1));

        textPrecio.setText("Bs");
        textPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textPrecioActionPerformed(evt);
            }
        });
        jPanel2.add(textPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 300, 142, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Precio con descuento:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 269, -1, 22));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Fecha fin:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, -1));

        tablaDescuentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Modelo", "FechaIni", "FechaFin", "PrecioPromo"
            }
        ));
        jScrollPane1.setViewportView(tablaDescuentos);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(317, 80, 570, 351));
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 416, -1, -1));

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Save_37110.png"))); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel2.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, -1, -1));

        jDateChooser1.setDateFormatString("yyyy-MM-dd");
        jPanel2.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 140, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buscarIcono.png"))); // NOI18N
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 360, -1, -1));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SystemFolder_256x256_icon-icons.com_76749.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 360, -1, -1));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/new_page_document_16676.png"))); // NOI18N
        jPanel2.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, 50));

        jDateChooser2.setDateFormatString("yyyy-MM-dd");
        jPanel2.add(jDateChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 140, -1));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/arrow_refresh_15732.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 10, -1, -1));

        jLabel9.setBackground(new java.awt.Color(102, 51, 0));
        jLabel9.setFont(new java.awt.Font("OCR A Extended", 1, 28)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Descuentos");
        jLabel9.setToolTipText("");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, -1, -1));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Buscar");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 390, 60, 20));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editado.jpeg"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -30, 900, 490));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-8, 3, 1040, 460));
        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textCodigoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
       String fechaIni =((JTextField)jDateChooser1.getDateEditor().getUiComponent()).getText();
       String fechaFin =((JTextField)jDateChooser2.getDateEditor().getUiComponent()).getText();
       Descuento desc=new Descuento();
       desc.setFechaIni(Date.valueOf(fechaIni));
       desc.setFechaFin(Date.valueOf(fechaFin));
       desc.setCodigo(textCodigo.getText());
       desc.setModelo(textModelo.getText());
       desc.setPrecioDescuento(Integer.valueOf(textPrecio.getText()));
       System.out.println(desc.toString());
       try{
           PreparedStatement ps=con.prepareStatement("INSERT INTO descuento(idDesc, fechaIniDesc,"
                   + "fechaFinDesc, codigoProd, nombreProd, descuento) VALUES(null,?,?,?,?,?) ");
           ps.setDate(1, (Date) desc.getFechaIni());
           ps.setDate(2, (Date) desc.getFechaFin());
           ps.setString(3, desc.getCodigo());
           ps.setString(4, desc.getModelo());
           ps.setInt(5, desc.getPrecioDescuento());
           ps.execute();
           System.out.println("Fecha:"+fechaIni);
           System.out.println("Fecha:"+fechaFin);
           JOptionPane.showMessageDialog(null, "Datos guardados correctamente");
       }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No se puede registrar: "+e.toString());
       }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void textPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textPrecioActionPerformed

    private void textCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textCodigoKeyPressed
        // TODO add your handling code here:
        buscarProducto(evt);
    }//GEN-LAST:event_textCodigoKeyPressed

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
            java.util.logging.Logger.getLogger(Descuentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Descuentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Descuentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Descuentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Descuentos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaDescuentos;
    private javax.swing.JTextField textCodigo;
    private javax.swing.JTextField textModelo;
    private javax.swing.JTextField textPrecio;
    // End of variables declaration//GEN-END:variables
    
}

