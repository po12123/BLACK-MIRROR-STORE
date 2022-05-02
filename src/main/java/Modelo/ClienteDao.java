
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ClienteDao {
 
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
   public boolean RegistrarCliente(Cliente cl){
       String sql = "INSERT INTO clientes(ci, nombre, telefono, direccion) VALUES (?, ?, ?, ?)";
       try {
           con = cn.conectar();
           ps = con.prepareStatement(sql);
           ps.setInt(1, cl.getCi());
           ps.setString(2, cl.getNombre());
           ps.setInt(3, cl.getTelefono());
           ps.setString(4, cl.getDireccion());
           ps.execute();
           return true;
         } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, e.toString());
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
