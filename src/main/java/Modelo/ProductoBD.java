
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProductoBD {
    private Connection con;
    private Conexion cn;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public ProductoBD(){
        cn=new Conexion();
    }
    public boolean registrarProducto(Producto pro){
        boolean res=false;
        String sql="INSERT INTO producto (CODIGO, MARCA, MODELO, CANTIDAD, PROVEEDOR, "
                + "PRECIO) VALUES (?,?,?,?,?,?)";
        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getCodigo());
            ps.setString(2, pro.getMarca());
            ps.setString(3, pro.getModelo());
            ps.setInt(4, pro.getCantidad());
            ps.setString(5, pro.getProveedor());
            ps.setInt(6, pro.getPrecio());
            ps.execute();
            res=true;
        } catch (Exception e) {
            System.out.println("Error en registrar producto: "+e.toString());
        }
        return res;
    }
}
