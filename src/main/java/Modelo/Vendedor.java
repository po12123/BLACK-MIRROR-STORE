
package Modelo;

import java.sql.Date;

public class Vendedor {
    private String nombre;
    private String  ci;
    private String direccion;
    private int telefono;
    private String correo;
    private Date nacimiento;
    private String usuario;
    private String contrasenia;
    
    public Vendedor(){}
    public Vendedor(String nombre, String ci, String direccion, int telefono, String correo, 
                    Date nacimiento, String usuario, String contrasenia){
        this.nombre=nombre;
        this.ci=ci;
        this.direccion=direccion;
        this.telefono=telefono;
        this.correo=correo;
        this.nacimiento=nacimiento;
        this.usuario=usuario;
        this.contrasenia=contrasenia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCi() {
        return ci;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public Date getNacimiento() {
        return nacimiento;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
}
