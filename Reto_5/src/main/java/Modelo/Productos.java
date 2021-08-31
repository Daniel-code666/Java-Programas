/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 *
 * @author Daniel
 */
@Table("productos")
public class Productos{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column("codigo")
    private int codigo;
    
    @Column("nombre")
    private String nombre;
    
    @Column("precio")
    private double precio;
    
    @Column("inventario")
    private int inventario;

    public Productos() {
    }

    public Productos(String nombre, double precio, int inventario) {
        this.nombre = nombre;
        this.precio = precio;
        this.inventario = inventario;
    }
    
    public static Productos addProd(String nombre, double precio, int inventario)
    {
        return new Productos(nombre, precio, inventario);
    }
    
    public static Productos addProd()
    {
        return new Productos();
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getInventario() {
        return inventario;
    }

    public void setInventario(int inventario) {
        this.inventario = inventario;
    }

    @Override
    public String toString() {
        return "Productos{" + "codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio + ", inventario=" + inventario + '}';
    }
    
    
}