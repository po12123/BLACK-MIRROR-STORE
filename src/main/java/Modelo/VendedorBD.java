
package Modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class VendedorBD {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn;  
    
    public VendedorBD(){
    cn=new Conexion();
    }
    
    public Vendedor buscarVendedorLogin(String usuario, String contrasenia){
        Vendedor v=new Vendedor();
        String sql="SELECT USUARIOLOGINVR, CONTRASENIALOGINVR "
                + "FROM vendedor INNER JOIN vendedorlogin USING(IDVR)"
                + "WHERE USUARIOLOGINVR = ? AND CONTRASENIALOGINVR = ?";
        try {
            con=cn.conectar();
            ps=con.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, contrasenia);
            rs=ps.executeQuery();
            if(rs.next()){
                v.setUsuario(rs.getString("USUARIOLOGINVR"));
                v.setContrasenia(rs.getString("CONTRASENIALOGINVR"));
                System.out.println("u: "+rs.getString("USUARIOLOGINVR"));
                System.out.println("c: "+rs.getString("CONTRASENIALOGINVR"));
            }
        } catch (Exception e) {
            System.out.println("Error en clase VendedorBD: "+e.toString());
        }
        return v;
    }
    
    
   public boolean registrarVendedor(Vendedor ven){
       
            String sql = "INSERT INTO vendedor (NOMBREVR,CIVR,DIRECCIONVR,TELEFONOVR,CORREOELECTRONICOVR,FECHADENACIMIENTOVR)VALUES (?,?,?,?,?,?)";
            
            
            try{
                con=cn.conectar();
                ps=con.prepareStatement(sql);
                ps.setString(1,ven.getNombre());
                ps.setString(2,ven.getCi());
                ps.setString(3,ven.getDireccion());
                ps.setInt(4,ven.getTelefono());
                ps.setString(5,ven.getCorreo());
                ps.setString(6,ven.getNacimiento());
                ps.execute();
                
                return true;
                
           /* }catch (Exception e){
                System.out.println("Error en registrar vendedor"+ e.toString());
            }  
            return false;*/
               
            } catch (SQLException e){
                JOptionPane.showMessageDialog(null,e.toString());
                return false;
            }finally{
                try{
                    con.close();
                }catch(SQLException e){
                    System.out.println(e.toString());
                }
                
            }
        
        
   }      
   
}

