package com.admin.administradordepedidos.Clases;

import com.admin.administradordepedidos.Libs.GenerarID;

import java.io.Serializable;

public class Proveedor extends Persona implements Serializable {
    private int valor;

    private Suministro suministro;

    public Proveedor( String nombre, int edad, int valor) {
        super(GenerarID.generarRandomID(), nombre, edad);
        this.valor = valor;
    }

    public Suministro getSuministro() {
        return suministro;
    }

    public void setSuministro(Suministro suministro) {
        this.suministro = suministro;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
