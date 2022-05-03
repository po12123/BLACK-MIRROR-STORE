/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Date;

/**
 *
 * @author ZenBook
 */
public class Descuento {
    private int id;
    private String codigo;
    private String modelo;
    private Date fechaIni;
    private Date fechaFin;
    private int precioDescuento;
    public Descuento(){
        
    }
    public Descuento(int id, String codigo, String modelo, Date fechaIni, Date fechaFin, int precioDescuento){
        this.id=id;
        this.codigo=codigo;
        this.modelo=modelo;
        this.fechaIni=fechaIni;
        this.fechaFin=fechaFin;
        this.precioDescuento=precioDescuento;
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

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getPrecioDescuento() {
        return precioDescuento;
    }

    public void setPrecioDescuento(int precioDescuento) {
        this.precioDescuento = precioDescuento;
    }
    
     public Date getFechaFin(){
        return fechaFin;
    }
    
    public Date getFechaIni(){
        return fechaIni;
    }
    
    public void setFechaIni(Date fechaIni){
        this.fechaIni=fechaIni;
    }
    
    public void setFechaFin(Date fechaFin){
        this.fechaFin=fechaFin;
    }
}
