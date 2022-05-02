package Modelo;

public class Proveedor {
    private int id;
    private String nombre;
    private int telefono;
    private String Direccion;
    
    public Proveedor(){
    
    }

    public Proveedor(int id, String nombre, int telefono, String Direccion) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.Direccion = Direccion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
