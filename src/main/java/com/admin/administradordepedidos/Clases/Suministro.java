package com.admin.administradordepedidos.Clases;

import com.admin.administradordepedidos.Libs.GenerarID;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Suministro implements Serializable {
    private Date fechaEntrega;

    private String id;

    ArrayList<Producto> productos;

    public Suministro(){
        this.id = GenerarID.generarRandomID();
        productos = new ArrayList<Producto>();
    }
    public Suministro(ArrayList<Producto> productos) {
        this.fechaEntrega = new Date();
        this.id = GenerarID.generarRandomID();
        this.productos = productos;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public String getId() {
        return id;
    }

    public void setProductos(Producto productos) {
        this.productos.add(productos);
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }
}
