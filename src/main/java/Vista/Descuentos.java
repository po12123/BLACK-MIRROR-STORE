/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Modelo.Conexion;
import Modelo.Descuento;
import Modelo.Producto;
import Modelo.ProductoBD;
import java.awt.Color;
import static java.awt.SystemColor.menu;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


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
    private ResultSet rs;
    private DefaultTableModel modelo;
    private MsgRegistroExitoso msgRegistroExitoso;
    private MenuPrincipal  menuP;
    private Descuento descuento;
    public Descuentos() {  
        initComponents();
        descuento=new Descuento();
        producto=new Producto();
        productoBD=new ProductoBD();
        modelo=new DefaultTableModel();
        listarDescuentos();
        msgRegistroExitoso = new  MsgRegistroExitoso();
    }

   private void buscarProducto(java.awt.event.KeyEvent evt){
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!"".equals(textCodigo.getText())) {
                String codigo =textCodigo.getText();
                producto = productoBD.buscarProducto(codigo);
                if (producto.getId()!= 0) {
                    txtProducto.setText("" + producto.getCategoria()+" "+ producto.getMarca()+
                                              " "+ producto.getModelo());
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
    
    public ArrayList<Descuento> obtenerDescuentos(){
        ArrayList<Descuento> listaDescuentos=new ArrayList();
        String sql="SELECT * FROM descuento"; 
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Descuento desc=new Descuento();
                desc.setId(rs.getInt(1));
                desc.setFechaIni(rs.getDate(2));
                desc.setFechaFin(rs.getDate(3));
                desc.setCodigo(rs.getString(4));
                desc.setNombreProd(rs.getString(5));
                desc.setPorcentajeDescuento(rs.getInt(6));
                listaDescuentos.add(desc);
            }
        } catch (Exception e) {
            System.out.println("Error en listar descuentos BD: "+e.toString());
        }
        return listaDescuentos;
    }
    
    private void listarDescuentos(){
        ArrayList<Descuento> listaDescuentos=new ArrayList();
        listaDescuentos=obtenerDescuentos();
        modelo=(DefaultTableModel) tablaDesc.getModel();
        Object[] ob = new Object[6];
        for(int i=0; i<listaDescuentos.size(); i++){
            ob[0]=listaDescuentos.get(i).getId();
            ob[1]=listaDescuentos.get(i).getCodigo();
            ob[2]=listaDescuentos.get(i).getNombreProd();
            ob[3]=listaDescuentos.get(i).getFechaIni();
            ob[4]=listaDescuentos.get(i).getFechaFin();
            ob[5]=listaDescuentos.get(i).getPorcentajeDescuento();
            modelo.addRow(ob);
        }
        tablaDesc.setModel(modelo);
    }
   
    private void limpiarTabla(){
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    } 
    
    public void modificarDescuento(Descuento desc){
        String sql="UPDATE descuento SET fechaIniDesc=?, fechaFinDesc=?, codigoProd=?, nombreProd=?, "
                + "descuento=? WHERE idDesc=? ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, desc.getFechaIni());
            ps.setDate(2, desc.getFechaFin());
            ps.setString(3, desc.getCodigo());
            ps.setString(4, desc.getNombreProd());
            ps.setInt(5, desc.getPorcentajeDescuento());
            ps.setInt(6, desc.getId());
            ps.execute();
            System.out.println("Se regitro correctamente");
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    
    public void eliminarDescuento(){
       String sql = "DELETE FROM descuento WHERE idDesc=?";
       try {
           PreparedStatement ps = con.prepareStatement(sql);
           ps.setInt(1, descuento.getId());
           ps.execute();
           System.out.println("Se elimino el descuento: "+descuento.getId());
       } catch (SQLException e) {
           System.out.println(e.toString());
       }
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        textCodigo = new javax.swing.JTextField();
        txtProducto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtDescuento = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        botonEliminar = new javax.swing.JButton();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDesc = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btnMenu = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        botonActualizar = new javax.swing.JButton();
        imgFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Codigo:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 43, 25));

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
        jPanel2.add(textCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 100, -1));
        jPanel2.add(txtProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, 450, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Producto:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Fecha inicio:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, -1));
        jPanel2.add(txtDescuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 90, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Descuento:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, 22));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Fecha fin:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, -1));
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 416, -1, -1));

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Save_37110.png"))); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel2.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 370, -1, -1));

        jDateChooser1.setDateFormatString("yyyy-MM-dd");
        jPanel2.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 120, -1));

        botonEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SystemFolder_256x256_icon-icons.com_76749.png"))); // NOI18N
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });
        jPanel2.add(botonEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 370, -1, -1));

        jDateChooser2.setDateFormatString("yyyy-MM-dd");
        jPanel2.add(jDateChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, 120, -1));

        tablaDesc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Codigo", "Producto", "Fecha inicio", "Fecha fin", "Descuento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaDesc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaDescMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaDesc);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 130, 510, 280));

        jLabel9.setBackground(new java.awt.Color(102, 51, 0));
        jLabel9.setFont(new java.awt.Font("OCR A Extended", 1, 28)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Descuentos");
        jLabel9.setToolTipText("");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, -1, -1));

        jLabel12.setFont(new java.awt.Font("Cooper Black", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("%");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 240, -1, -1));

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

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("MENÚ");
        btnMenu.add(jLabel2);

        jPanel2.add(btnMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 20, 60, 30));

        botonActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/arrow_refresh_15732.png"))); // NOI18N
        botonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarActionPerformed(evt);
            }
        });
        jPanel2.add(botonActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, -1, -1));

        imgFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editado.jpeg"))); // NOI18N
        jPanel2.add(imgFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -30, 790, 490));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-8, 3, 1040, 460));
        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
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
       desc.setNombreProd(txtProducto.getText());
       desc.setPorcentajeDescuento(Integer.valueOf(txtDescuento.getText()));
       try{
           PreparedStatement ps=con.prepareStatement("INSERT INTO descuento(idDesc, fechaIniDesc,"
                   + "fechaFinDesc, codigoProd, nombreProd, descuento) VALUES(null,?,?,?,?,?) ");
           ps.setDate(1, (Date) desc.getFechaIni());
           ps.setDate(2, (Date) desc.getFechaFin());
           ps.setString(3, desc.getCodigo());
           ps.setString(4, desc.getNombreProd());
           ps.setInt(5, desc.getPorcentajeDescuento());
           ps.execute();
           System.out.println("Fecha:"+fechaIni);
           System.out.println("Fecha:"+fechaFin);
           msgRegistroExitoso.setVisible(true);
           limpiarTabla();
           listarDescuentos();
                      
       }catch(Exception e){
            System.out.println("No se puede registrar: "+e.toString());
            
       }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        // TODO add your handling code here:
        if(!"".equals(textCodigo.getText())){
            eliminarDescuento();
            limpiarTabla();
            listarDescuentos();
        }else{
            JOptionPane.showMessageDialog(null,"Selecciona una fila");
        }
    }//GEN-LAST:event_botonEliminarActionPerformed

    private void textCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textCodigoKeyPressed
        // TODO add your handling code here:
        buscarProducto(evt);
    }//GEN-LAST:event_textCodigoKeyPressed

    private void btnMenuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuMouseEntered
        btnMenu.setBackground(Color.PINK);
    }//GEN-LAST:event_btnMenuMouseEntered

    private void btnMenuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuMouseExited
       btnMenu.setBackground(new Color(255,51,153));
    }//GEN-LAST:event_btnMenuMouseExited

    private void btnMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuMouseClicked
        MenuPrincipal menuP= new MenuPrincipal();
        menuP.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_btnMenuMouseClicked

    private void botonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarActionPerformed
        if("".equals(textCodigo.getText())){
            JOptionPane.showMessageDialog(null,"Selecciona una fila");
        }else{
            if (!"".equals(textCodigo.getText()) || !"".equals(txtProducto.getText())
                || !"".equals(txtDescuento.getText())){
                String fechaIni =((JTextField)jDateChooser1.getDateEditor().getUiComponent()).getText();
                String fechaFin =((JTextField)jDateChooser2.getDateEditor().getUiComponent()).getText();
                descuento.setFechaIni(Date.valueOf(fechaIni));
                descuento.setFechaFin(Date.valueOf(fechaFin));
                descuento.setCodigo(textCodigo.getText());
                descuento.setNombreProd(txtProducto.getText());
                descuento.setPorcentajeDescuento(Integer.valueOf(txtDescuento.getText()));
                modificarDescuento(descuento);
                MsgRegistroExitoso b = new MsgRegistroExitoso();
                b.setVisible(true);
                limpiarTabla();
                listarDescuentos();
            }
        }
    }//GEN-LAST:event_botonActualizarActionPerformed

    private void tablaDescMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaDescMouseClicked
        // TODO add your handling code here:
        int fila = tablaDesc.rowAtPoint(evt.getPoint());
        textCodigo.setText(tablaDesc.getValueAt(fila, 1).toString());
        txtProducto.setText(tablaDesc.getValueAt(fila, 2).toString());
        jDateChooser1.setDate((Date)tablaDesc.getValueAt(fila, 3));
        jDateChooser2.setDate((Date)tablaDesc.getValueAt(fila, 4));
        txtDescuento.setText(tablaDesc.getValueAt(fila, 5).toString());
        descuento.setId((int)((tablaDesc.getValueAt(fila, 0))));
    }//GEN-LAST:event_tablaDescMouseClicked

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
    private javax.swing.JButton botonActualizar;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JPanel btnMenu;
    private javax.swing.JLabel imgFondo;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaDesc;
    private javax.swing.JTextField textCodigo;
    private javax.swing.JTextField txtDescuento;
    private javax.swing.JTextField txtProducto;
    // End of variables declaration//GEN-END:variables
    
}

