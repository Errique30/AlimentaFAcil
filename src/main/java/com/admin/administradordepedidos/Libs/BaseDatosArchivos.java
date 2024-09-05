package com.admin.administradordepedidos.Libs;


import com.admin.administradordepedidos.Clases.Cliente;
import com.admin.administradordepedidos.Clases.Producto;
import com.admin.administradordepedidos.Clases.Proveedor;

import java.io.*;
import java.util.ArrayList;

public class BaseDatosArchivos {

    private String rutaArcivo = "BaseDatos/";


    public void guardarDatos(Cliente cliente) {
        //ArrayList<Cliente> c = leerDatosCliente();
        ArrayList<Cliente> c = new ArrayList<Cliente>();
        c.add(cliente);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(String.format("%sClientes.txt", rutaArcivo), false))) {
            oos.writeObject(c);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void guardarDatos(Proveedor proveedor) {
        //ArrayList<Proveedor> p = leerDatosProveedor();
        ArrayList<Proveedor> p = new ArrayList<Proveedor>();
        p.add(proveedor);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(String.format("%sProveedor.txt", rutaArcivo), false))) {
            oos.writeObject(p);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void guardarDatos(Producto producto) {
        ArrayList<Producto> productos = leerDatosProducto();
        //ArrayList<Producto> productos = new ArrayList<Producto>();
        productos.add(producto);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(String.format("%sProductos.txt", rutaArcivo), false))) {
            oos.writeObject(productos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void guardarDatos(ArrayList<Producto> productos) {
        //ArrayList<Producto> productos = leerDatosProducto();
        //ArrayList<Producto> productos = new ArrayList<Producto>();
        //productos.add(producto);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(String.format("%sProductos.txt", rutaArcivo), false))) {
            oos.writeObject(productos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void actualizarCliente(Cliente cliente){
        ArrayList<Cliente> clientes = new ArrayList<>(leerDatosCliente());
        boolean isRemoving = clientes.removeIf(cliente1 -> cliente1.getId().equals(cliente.getId()));
        if (isRemoving){
            clientes.add(cliente);
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(String.format("%sClientes.txt", rutaArcivo), false))) {
                oos.writeObject(clientes);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void actualizarProvedor(Proveedor proveedor){
        ArrayList<Proveedor> proveedors = new ArrayList<>(leerDatosProveedor());
        boolean isRemoving = proveedors.removeIf(proveedor1 -> proveedor1.getId().equals(proveedor.getId()));
        if (isRemoving){
            proveedors.add(proveedor);
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(String.format("%sProveedor.txt", rutaArcivo), false))) {
                oos.writeObject(proveedors);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<Cliente> leerDatosCliente() {
        String archivo = String.format("%sClientes.txt", rutaArcivo);
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        try {
            fis = new FileInputStream(archivo);
            ois = new ObjectInputStream(fis);
            clientes = (ArrayList<Cliente>) ois.readObject();

        }catch (IOException | ClassNotFoundException  e) {
            e.printStackTrace(System.out);
        } finally {
            try {
                if (ois != null) ois.close();
                if (fis != null) fis.close();
            } catch (IOException e) {
                e.printStackTrace(System.out);
            }
        }
        return clientes;
    }

    public ArrayList<Proveedor> leerDatosProveedor() {
        String archivo = String.format("%sProveedor.txt", rutaArcivo);
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        ArrayList<Proveedor> proveedors = new ArrayList<Proveedor>();
        try {
            fis = new FileInputStream(archivo);
            ois = new ObjectInputStream(fis);
            proveedors = (ArrayList<Proveedor>) ois.readObject();

        }catch (IOException | ClassNotFoundException  e) {
            e.printStackTrace(System.out);
        } finally {
            try {
                if (ois != null) ois.close();
                if (fis != null) fis.close();
            } catch (IOException e) {
                e.printStackTrace(System.out);
            }
        }
        return proveedors;
    }

    public ArrayList<Producto> leerDatosProducto() {
        String archivo = String.format("%sProductos.txt", rutaArcivo);
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        ArrayList<Producto> productos= new ArrayList<Producto>();
        try {
            fis = new FileInputStream(archivo);
            ois = new ObjectInputStream(fis);
            productos = (ArrayList<Producto>) ois.readObject();

        }catch (IOException | ClassNotFoundException  e) {
            e.printStackTrace(System.out);
        } finally {
            try {
                if (ois != null) ois.close();
                if (fis != null) fis.close();
            } catch (IOException e) {
                e.printStackTrace(System.out);
            }
        }
        return productos;
    }

    public void borrarDatosProducto(){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(String.format("%sProductos.txt", rutaArcivo)))) {
            oos.writeObject(new ArrayList<Producto>());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void borrarDatosCliente(){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(String.format("%sClientes.txt", rutaArcivo)))) {
            oos.writeObject(new ArrayList<Cliente>());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void borrarDatosCliente(int index){
        ArrayList<Cliente> clientes = new ArrayList<>(leerDatosCliente());
        clientes.remove(index);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(String.format("%sClientes.txt", rutaArcivo), false))) {
            oos.writeObject(clientes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void borrarDatosProducto(int index){
        ArrayList<Producto> productos = new ArrayList<>(leerDatosProducto());
        productos.remove(index);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(String.format("%sProductos.txt", rutaArcivo), false))) {
            oos.writeObject(productos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

