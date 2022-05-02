
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


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
    /*public boolean registrarVendedor(Vendedor ven){
        String sql = "INSERT INTO vendedor (nombre,ci,direccion,telefono,correo,nacimiento)VALUES (?,?,?,?,?.?)"; 
        
        return false;
    }*/
}
