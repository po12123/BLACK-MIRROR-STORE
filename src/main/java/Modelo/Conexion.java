
package Modelo;

import java.sql.DriverManager;
import java .sql.Connection;
import javax.swing.JOptionPane;

public class Conexion {
    Connection conexion=null;
    String url="jdbc:mysql://localhost:3306/sistemadeventas";
    String usuario="root";
    String contraseña="contraseña";
        
    public Connection conectar(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion= DriverManager.getConnection(url,usuario,contraseña);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en conexion: "+e.getMessage());
        }
        return conexion;
    }
}