
package Modelo;

import java.sql.DriverManager;
import java .sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
    Connection conexion=null;
    String url="jdbc:mysql://localhost:33065/sistemadeventas";
    String usuario="root";
    String contraseña="";
        
    public Connection conectar(){
        try {
            System.out.println("se conecto a la base datos");
            Class.forName("com.mysql.jdbc.Driver");
            conexion= DriverManager.getConnection(url,usuario,contraseña);
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en conexion: "+e.getMessage());
            System.out.println("Error en conexion: "+e.getMessage());
        }
        return conexion;
    }
}
