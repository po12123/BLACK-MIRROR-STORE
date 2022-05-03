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
       String sql = "INSERT INTO proveedor(CIPR, NOMBREPR, TELEFONOPR, DIRECCIONPR) VALUES (?, ?, ?, ?)";
       try {
           con = cn.conectar();
           ps = con.prepareStatement(sql);
           ps.setInt(1, pr.getCi());
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
   
   public boolean eliminarProveedor(int ci){
       String sql = "DELETE FROM proveedor WHERE CIPR=?";
       try {
           con = cn.conectar();
           ps = con.prepareStatement(sql);
           ps.setInt(1, ci);
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
