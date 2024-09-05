package com.admin.administradordepedidos.Clases;

import com.admin.administradordepedidos.Libs.GenerarID;

import java.io.Serializable;

public class Producto implements Serializable {
    private String id;
    private String nombre;
    private String tipo;
    private String imagen;
    private String color;
    private double precio;
    private int stock;

    private int catidad = 1;

    public Producto( String nombre, String tipo, String imagen, String color,double precio, int stock) {
        this.id = GenerarID.generarRandomID();
        this.nombre = nombre;
        this.tipo = tipo;
        this.imagen = imagen;
        this.color = color;
        this.precio = precio;
        this.stock = stock;
    }

    public int getCatidad() {
        return catidad;
    }

    public void setCatidad(int catidad) {
        this.catidad = catidad;
    }

    public void updateProduct(){
        this.stock = stock - catidad;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
