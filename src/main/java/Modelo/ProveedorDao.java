package Modelo;


import Modelo.Proveedor;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ProveedorDao {
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
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
   
   public List ListarProveedor(){
       List<Proveedor>Listapr = new ArrayList();
       String sql = "SELECT * FROM proveedor";
       try {
           con = cn.conectar();
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           while (rs.next()) {               
               Proveedor prov = new Proveedor();
               prov.setCi(rs.getInt(1));
               prov.setNombre(rs.getString(2));
               prov.setTelefono(rs.getInt(3));
               prov.setDireccion(rs.getString(4));
               Listapr.add(prov);
           }
       } catch (SQLException e) {
           System.out.println(e.toString());
       }
       return Listapr;
   }
   public boolean ModificarProveedor(Proveedor pr){
       String sql = "UPDATE proveedor SET CIPR=?, NOMBREPR=?, TELEFONOPR=?, DIRECCIONPR=? WHERE CIPR=?";
       try{
           con=cn.conectar();
           ps = con.prepareStatement(sql);
           ps.setInt(1, pr.getCi());
           ps.setString(2, pr.getNombre());
           ps.setInt(3, pr.getTelefono());
           ps.setString(4, pr.getDireccion());
           ps.setInt(5, pr.getCi());
           ps.execute();
           return true;
       }catch(SQLException e){
           System.out.println(e.toString());
           return false;
       }finally{
           try {
               con.close();
           } catch (SQLException e) {
               System.out.println(e.toString());
           }
       }
}}
