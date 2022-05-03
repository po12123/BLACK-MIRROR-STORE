/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author njesp
 */
public class ConfigTiendaDao {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean ActualizarTienda(ConfigTienda ct1){
       String sql = "UPDATE datostienda SET NombreTienda=?,Nit=? , TelefonoT=?, DireccionT=?,RazonSocial=?  WHERE id=?";
       try {
           ps = con.prepareStatement(sql);   
           ps.setString(1, ct1.getNombre());
           ps.setString(2, ct1.getNit());
           ps.setString(3, ct1.getTelefono());
           ps.setString(4, ct1.getDireccion());
           ps.setString(5, ct1.getMensaje());
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
