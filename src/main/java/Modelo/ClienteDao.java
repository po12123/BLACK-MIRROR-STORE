
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ClienteDao {
 
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    private ResultSet rs;
   public boolean RegistrarCliente(Cliente cl){
       String sql = "INSERT INTO cliente(CICLI, NOMBRECLI, TELEFONOCLI, DIRECCIONCLI) VALUES (?, ?, ?, ?)";
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
    public Cliente buscarCliente(int ci){
        Cliente cl=new Cliente();
        String sql="SELECT * FROM cliente WHERE CICLI = ?";
        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, ci);
            rs=ps.executeQuery();
            if(rs.next()){
                cl.setCi(rs.getInt(1));
                cl.setNombre(rs.getString(2));
                cl.setTelefono(rs.getInt(3));
                cl.setDireccion(rs.getString(4));
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return cl;
    }
    public ArrayList<Cliente> listarClientes(){
        ArrayList<Cliente> listaClientes=new ArrayList();
        String sql="SELECT * FROM cliente ORDER BY NOMBRECLI ASC"; 
        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Cliente cl=new Cliente();
                cl.setCi(rs.getInt(1));
                cl.setNombre(rs.getString(2));
                cl.setTelefono(rs.getInt(3));
                cl.setDireccion(rs.getString(4));
                listaClientes.add(cl);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return listaClientes;
    }
}
