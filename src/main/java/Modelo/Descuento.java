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
    private  Date fechaIni;
    private Date fechaFin;
    public Descuento(){
        
    }
    public Descuento(Date fechaIni, Date fechaFin){
        this.fechaIni=fechaIni;
        this.fechaFin=fechaFin;
        
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
