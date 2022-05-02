
package Modelo;

public class Producto {
    private int id;
    private String codigo;
    private String marca;
    private String modelo;
    private int cantidad;
    private String proveedor;
    private int precio;
    
    public Producto(){}
    
    public Producto(int id, String codigo, String marca, String proveedor, 
                    String proveedorPro, int cantidad, int precio){
        this.id = id;
        this.codigo = codigo;
        this.marca = marca;
        this.proveedor = proveedor;
        this.proveedor = proveedor;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
}
