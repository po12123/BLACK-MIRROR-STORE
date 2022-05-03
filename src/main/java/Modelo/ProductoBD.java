
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductoBD {
    private Connection con;
    private Conexion cn;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public ProductoBD(){
        cn=new Conexion();
    }
    public boolean registrarProducto(Producto pro){
        boolean res=false;
        String sql="INSERT INTO producto (CODIGO, MARCA, MODELO, CANTIDAD, PROVEEDOR, PRECIO, CATEGORIA) VALUES (?,?,?,?,?,?,?)";
        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getCodigo());
            ps.setString(2, pro.getMarca());
            ps.setString(3, pro.getModelo());
            ps.setInt(4, pro.getCantidad());
            ps.setString(5, pro.getProveedor());
            ps.setInt(6, pro.getPrecio());
            ps.setString(7, pro.getCategoria());
            ps.execute();
            res=true;
        } catch (SQLException e) {
            System.out.println("Error en registrar producto: "+e.toString());
        }
        return res;
    }
    public boolean ModificarProductos(Producto pro){
    String sql="UPDATE producto SET CODIGO=?, MARCA=?, MODELO=?, CANTIDAD=?, PROVEEDOR=?, PRECIO=?, CATEGORIA=? WHERE CODIGO=? ";
       
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getCodigo());
            ps.setString(2, pro.getMarca());
            ps.setString(3, pro.getModelo());
            ps.setInt(4, pro.getCantidad());
            ps.setString(5, pro.getProveedor());
            ps.setInt(6, pro.getPrecio());
            ps.setString(7, pro.getCategoria());
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
    public ArrayList<Producto> listarProductos(){
        ArrayList<Producto> listaProductos=new ArrayList();
        String sql="SELECT * FROM producto"; 
        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Producto pro=new Producto();
                pro.setId(rs.getInt(1));
                pro.setCodigo(rs.getString(2));
                pro.setMarca(rs.getString(3));
                pro.setModelo(rs.getString(4));
                pro.setCantidad(rs.getInt(5));
                pro.setProveedor(rs.getString(6));
                pro.setPrecio(rs.getInt(7));
                pro.setCategoria(rs.getString(8));
                listaProductos.add(pro);
            }
        } catch (Exception e) {
            System.out.println("Error en listar producto: "+e.toString());
        }
        return listaProductos;
    }
    public ArrayList<Producto> listarProductosCategoria(String categoria){
        ArrayList<Producto> listaProductos=new ArrayList();
        String sql="SELECT * FROM producto WHERE CATEGORIA = ?"; 
        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, categoria);
            rs=ps.executeQuery();
            while(rs.next()){
                Producto pro=new Producto();
                pro.setId(rs.getInt(1));
                pro.setCodigo(rs.getString(2));
                pro.setMarca(rs.getString(3));
                pro.setModelo(rs.getString(4));
                pro.setCantidad(rs.getInt(5));
                pro.setProveedor(rs.getString(6));
                pro.setPrecio(rs.getInt(7));
                pro.setCategoria(rs.getString(8));
                listaProductos.add(pro);
            }
        } catch (Exception e) {
            System.out.println("Error en listar producto por categoria: "+e.toString());
        }
        return listaProductos;
    }
    public Producto buscarProducto(String codigo){
        Producto pro=new Producto();
        String sql="SELECT * FROM producto WHERE CODIGO = ?";
        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, codigo);
            rs=ps.executeQuery();
            if(rs.next()){
                pro.setId(rs.getInt(1));
                pro.setCodigo(rs.getString(2));
                pro.setMarca(rs.getString(3));
                pro.setModelo(rs.getString(4));
                pro.setCantidad(rs.getInt(5));
                pro.setProveedor(rs.getString(6));
                pro.setPrecio(rs.getInt(7));
                pro.setCategoria(rs.getString(8));
            }
        } catch (Exception e) {
            System.out.println("Error en buscar producto: "+e.toString());
        }
        return pro;
    }
    
}
