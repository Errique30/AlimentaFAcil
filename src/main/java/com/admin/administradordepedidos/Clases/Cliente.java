package com.admin.administradordepedidos.Clases;

import com.admin.administradordepedidos.Libs.GenerarID;

import java.io.Serializable;
import java.util.ArrayList;

public class Cliente extends Persona implements Serializable {

    private String direccion;

    private Pedido pedido;

    public Cliente( String nombre, int edad, String direccion) {
        super(GenerarID.generarRandomID(), nombre, edad);
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Pedido getPedidos() {
        return pedido;
    }

    public void setPedidos(Pedido pedidos) {
        this.pedido = pedidos;
    }
}
