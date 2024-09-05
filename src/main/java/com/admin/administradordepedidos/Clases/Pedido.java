package com.admin.administradordepedidos.Clases;

import com.admin.administradordepedidos.Libs.GenerarID;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Pedido implements Serializable {
    private String id;
    private int valor;
    private Date fecha;
    ArrayList<Producto> productos;

    public Pedido() {
        this.productos = new ArrayList<>();
    }

    public Pedido(int valor, ArrayList<Producto> productos) {
        this.id = GenerarID.generarRandomID();
        this.valor = valor;
        this.fecha = new Date();
        this.productos = productos;
    }


    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProducto(Producto productos) {
        this.productos.add(productos);
    }
}
