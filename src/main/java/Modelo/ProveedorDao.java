package Modelo;


import Modelo.Proveedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ProveedorDao {
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
   public boolean RegistrarProveedor(Proveedor pr){
       String sql = "INSERT INTO proveedor(ci, nombre, telefono, direccion) VALUES (?, ?, ?, ?)";
       try {
           con = cn.getConnection();
           ps = con.prepareStatement(sql);
           ps.setInt(1, pr.getId());
           ps.setString(2, pr.getNombre());
           ps.setInt(3, pr.getTelefono());
           ps.setString(4, pr.getDireccion());
           ps.execute();
           return true;
       } catch (SQLException e) {
           System.out.println(e.toString());
           return false;
       }finally{
           try {
               con.close();
           } catch (SQLException e) {
               System.out.println(e.toString());
           }
       }
   }
}