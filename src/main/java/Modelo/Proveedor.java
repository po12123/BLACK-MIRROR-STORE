package Modelo;

public class Proveedor {
    private int ci;
    private String nombre;
    private int telefono;
    private String Direccion;
    
    public Proveedor(){
    
    }

    public Proveedor(int ci, String nombre, int telefono, String Direccion) {
        this.ci = ci;
        this.nombre = nombre;
        this.telefono = telefono;
        this.Direccion = Direccion;
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
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }
    
    
}
