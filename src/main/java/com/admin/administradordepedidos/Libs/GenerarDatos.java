package com.admin.administradordepedidos.Libs;

import com.admin.administradordepedidos.Clases.Cliente;
import com.admin.administradordepedidos.Clases.Producto;

public class GenerarDatos {
    public static void main(String[] args) {
        extracted();
        /*Cliente cliente = new Cliente("cabeza de mango",30 , "la q me de la gana");
        cliente.setId("meJH!!L#K9");
        BaseDatosArchivos bd = new BaseDatosArchivos();
        //System.out.println(cliente.getId());
        //bd.guardarDatos(cliente);
        bd.actualizarCliente(cliente);

        bd.leerDatosCliente().forEach(cliente1 -> System.out.print(cliente1.getNombre()+"\n"+cliente1.getId()+"\n"));*/
    }

    private static void extracted() {
        Producto p1 = new Producto("Banana","Comida", "Images/banana.png","E7C00F",1.49,46);
        Producto p2 = new Producto("Kiwi","Comida", "Images/kiwi.png","6A7324",1.49,46);
        Producto p3 = new Producto("Coconut","Comida", "Images/coconut.png","A7745B",1.49,46);
        Producto p4 = new Producto("Peach","Comida", "Images/peach.png","F16C31",1.49,46);
        Producto p5 = new Producto("Grapes","Comida", "Images/grapes.png","291D36",1.49,46);
        Producto p6 = new Producto("Watermelon","Comida", "Images/watermelon.png","22371D",1.49,46);
        Producto p7 = new Producto("Orange","Comida", "Images/orange.png","FB5D03",1.49,46);
        Producto p8 = new Producto("StrawBerry","Comida", "Images/strawberry.png","80080C",1.49,46);
        Producto p9 = new Producto("Mango","Comida", "Images/mango.png","FFB605",1.49,46);
        Producto p10 = new Producto("Cherry","Comida", "Images/cherry.png","5F060E",1.49,46);

        BaseDatosArchivos bd = new BaseDatosArchivos();

        //bd.guardarDatos(p1);
        bd.guardarDatos(p2);
        bd.guardarDatos(p3);
        bd.guardarDatos(p4);
        bd.guardarDatos(p5);
        bd.guardarDatos(p6);
        bd.guardarDatos(p7);
        bd.guardarDatos(p8);
        bd.guardarDatos(p9);
        bd.guardarDatos(p10);
    }
}
