
package Vista;

import Modelo.Combo;
import Modelo.Producto;
import Modelo.ProductoBD;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ProductoGUI extends javax.swing.JFrame {

    private MenuPrincipal menuPrincipal;
    private Producto producto;
    private ProductoBD productoBD;
    private DefaultTableModel modelo;
    
    public ProductoGUI() {        
        initComponents();
        producto=new Producto();
        productoBD=new ProductoBD();
        modelo=new DefaultTableModel();
        listarProductos();
        cBoxProveedor.addItem(new Combo(1, "Proveedor"));       
    }
    private void listarProductos(){
        ArrayList<Producto> listaProductos=new ArrayList();
        listaProductos=productoBD.listarProductos();
        modelo=(DefaultTableModel) tablaProductos.getModel();
        Object[] ob = new Object[8];
        for(int i=0; i<listaProductos.size(); i++){
            ob[0]=listaProductos.get(i).getId();
            ob[1]=listaProductos.get(i).getCodigo();
            ob[2]=listaProductos.get(i).getMarca();
            ob[3]=listaProductos.get(i).getModelo();
            ob[4]=listaProductos.get(i).getCantidad();
            ob[5]=listaProductos.get(i).getProveedor();
            ob[6]=listaProductos.get(i).getPrecio();
            ob[7]=listaProductos.get(i).getCategoria();
            modelo.addRow(ob);
        }
        tablaProductos.setModel(modelo);
    }
    private void listarProductosCategoria(){
        ArrayList<Producto> listaProductos=new ArrayList();
        listaProductos=productoBD.listarProductosCategoria(textCategoria.getText());
        modelo=(DefaultTableModel) tablaProductos.getModel();
        Object[] ob = new Object[8];
        for(int i=0; i<listaProductos.size(); i++){
            ob[0]=listaProductos.get(i).getId();
            ob[1]=listaProductos.get(i).getCodigo();
            ob[2]=listaProductos.get(i).getMarca();
            ob[3]=listaProductos.get(i).getModelo();
            ob[4]=listaProductos.get(i).getCantidad();
            ob[5]=listaProductos.get(i).getProveedor();
            ob[6]=listaProductos.get(i).getPrecio();
            ob[7]=listaProductos.get(i).getCategoria();
            modelo.addRow(ob);
        }
        tablaProductos.setModel(modelo);
    }
    private void registrarProducto(){
        if(!"".equals(textCodigo.getText()) || !"".equals(textMarca.getText()) ||
            !"".equals(textModelo.getText()) ||!"".equals(textCantidad1.getText()) ||
            !"".equals(cBoxProveedor.getSelectedItem()) ||
            !"".equals(textPrecio.getText()) || !"".equals(textCategoria.getText()))
        {
            producto.setCodigo(textCodigo.getText());
            producto.setMarca(textMarca.getText());
            producto.setModelo(textModelo.getText());
            producto.setCantidad(Integer.parseInt(textCantidad1.getText()));
            Combo item=(Combo)cBoxProveedor.getSelectedItem();
            producto.setProveedor(item.getNombre());
            producto.setPrecio(Integer.parseInt(textPrecio.getText()));
            producto.setCategoria(textCategoria.getText());
            if(productoBD.registrarProducto(producto)){
                System.out.println("Producto registrado");
                limpiarTabla();
                listarProductos();
            }else{
                System.out.println("Producto no registrado");
            }
        }else{
            System.out.println("Campos vacios");
        } 
    }
    private void buscarProducto(){
        if (!"".equals(textCodigo.getText())) {
                String codigo = textCodigo.getText();
                producto = productoBD.buscarProducto(codigo);
                if (producto.getCodigo()!= null) {
                    textMarca.setText("" + producto.getMarca());
                    textModelo.setText("" + producto.getModelo());
                    textCantidad1.setText("" + producto.getCantidad());
                    cBoxProveedor.addItem(new Combo(1, producto.getProveedor()));   
                    textPrecio.setText("" + producto.getPrecio());
                    textCategoria.setText("" + producto.getCategoria());
                } else {
                    JOptionPane.showMessageDialog(null, "No existe el producto: "+textCodigo.getText());
                    textCodigo.requestFocus();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese el codigo del productos");
                textCodigo.requestFocus();
            }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        textCodigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        textModelo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        textCategoria = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        textPrecio = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        textMarca = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cBoxProveedor = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnFiltrar = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnAtras = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        textCantidad1 = new javax.swing.JTextField();
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
        jPanel2.add(textCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 59, 140, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Marca:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 101, -1, -1));
        jPanel2.add(textModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 143, 142, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Modelo:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 146, -1, -1));
        jPanel2.add(textCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, 142, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Categoria:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        textPrecio.setText("Bs");
        jPanel2.add(textPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 269, 142, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Precio:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 269, -1, 22));
        jPanel2.add(textMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 101, 142, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Proveedor:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 230, -1, -1));

        jPanel2.add(cBoxProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 142, -1));

        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Codigo", "Marca", "Modelo", "Cantidad", "Proveedor", "Precio", "Categoria"
            }
        ));
        tablaProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaProductos);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(287, 70, 480, 330));
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 416, -1, -1));

        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Save_37110.png"))); // NOI18N
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        jPanel2.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, -1, -1));

        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/arrow_refresh_15732.png"))); // NOI18N
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel2.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 10, -1, -1));

        btnFiltrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/document_file_files_documents_icon_153885.png"))); // NOI18N
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });
        jPanel2.add(btnFiltrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 360, -1, -1));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SystemFolder_256x256_icon-icons.com_76749.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 360, -1, -1));

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/new_page_document_16676.png"))); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel2.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, 50));

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

        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 204, 204));
        jLabel8.setText("MENÚ");
        btnAtras.add(jLabel8);

        jPanel2.add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 20, 60, 30));

        jLabel9.setBackground(new java.awt.Color(102, 51, 0));
        jLabel9.setFont(new java.awt.Font("OCR A Extended", 1, 28)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Productos");
        jLabel9.setToolTipText("");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, -1, -1));
        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, 10, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Cantidad:");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 189, -1, -1));
        jPanel2.add(textCantidad1, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 186, 142, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editado.jpeg"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 790, 490));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 780, -1));
        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:
        registrarProducto();   
    }//GEN-LAST:event_btnRegistrarActionPerformed
    
    private void limpiarTabla(){
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    } 
    private void LimpiarProducto(){
        textCodigo.setText("");
        textMarca.setText("");
        textModelo.setText("");
        textCantidad1.setText("");
        textPrecio.setText("");
        textCategoria.setText("");
    }
    
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if(!"".equals(textCodigo.getText())){
            int pregunta = JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar");
            if(pregunta == 0){
                int codigo = Integer.parseInt(textCodigo.getText());
                productoBD.eliminarProducto(codigo);
                limpiarTabla();
                listarProductos();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        if("".equals(textCodigo.getText())){
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }else{
            if(!"".equals(textCodigo.getText()) || !"".equals(textMarca.getText()) ||
            !"".equals(textModelo.getText()) ||!"".equals(textCantidad1.getText()) ||
            !"".equals(cBoxProveedor.getSelectedItem()) ||
            !"".equals(textPrecio.getText()) || !"".equals(textCategoria.getText())){
                producto.setCodigo(textCodigo.getText());
                producto.setMarca(textMarca.getText());
                producto.setModelo(textModelo.getText());
                producto.setCantidad(Integer.parseInt(textCantidad1.getText()));
                producto.setProveedor(cBoxProveedor.getSelectedItem().toString());
                producto.setPrecio(Integer.parseInt(textPrecio.getText()));
                producto.setCategoria(textCategoria.getText());
                productoBD.ModificarProductos(producto);
                JOptionPane.showMessageDialog(null, "Producto Modificado");
                limpiarTabla();
                listarProductos();
            }
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

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

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        buscarProducto();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
        // TODO add your handling code here:
        if(!"".equals(textCategoria.getText())){
            limpiarTabla();
            listarProductosCategoria();
        }   
    }//GEN-LAST:event_btnFiltrarActionPerformed

    private void tablaProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProductosMouseClicked
        int fila = tablaProductos.rowAtPoint(evt.getPoint());
        textCodigo.setText(tablaProductos.getValueAt(fila, 0).toString());
        textMarca.setText(tablaProductos.getValueAt(fila, 1).toString());
        textModelo.setText(tablaProductos.getValueAt(fila, 2).toString());
        textCantidad1.setText(tablaProductos.getValueAt(fila, 3).toString());
        cBoxProveedor.setSelectedItem(tablaProductos.getValueAt(fila, 4).toString());
        textPrecio.setText(tablaProductos.getValueAt(fila, 5).toString());
        textCategoria.setText(tablaProductos.getValueAt(fila, 6).toString());
    }//GEN-LAST:event_tablaProductosMouseClicked

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
            java.util.logging.Logger.getLogger(ProductoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProductoGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JPanel btnAtras;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<Object> cBoxProveedor;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaProductos;
    private javax.swing.JTextField textCantidad1;
    private javax.swing.JTextField textCategoria;
    private javax.swing.JTextField textCodigo;
    private javax.swing.JTextField textMarca;
    private javax.swing.JTextField textModelo;
    private javax.swing.JTextField textPrecio;
    // End of variables declaration//GEN-END:variables
    
}

