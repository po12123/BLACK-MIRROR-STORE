
package Modelo;


public class Cliente {
    private int ci;
    private String nombre;
    private int telefono;
    private String direccion;

    public Cliente() {
    }

    public Cliente(int ci, String nombre, int telefono, String direccion) {
        this.ci = ci;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public int getCi() {
        return ci;
    }

    public void setCi(int ci) {
        this.ci = ci;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
}
