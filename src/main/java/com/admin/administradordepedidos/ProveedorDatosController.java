package com.admin.administradordepedidos;

import com.admin.administradordepedidos.Clases.Cliente;
import com.admin.administradordepedidos.Clases.Proveedor;
import com.admin.administradordepedidos.Libs.BaseDatosArchivos;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class ProveedorDatosController {

    @FXML
    private TextField inputDireccion;

    @FXML
    private TextField inputEdad;

    @FXML
    private TextField inputNombre;
    @FXML
    private BorderPane paneCambia;

    @FXML
    void eventBtnCuenta(MouseEvent event) {
        String nombre = inputNombre.getText();
        String direccion = inputDireccion.getText();
        int edad = Integer.parseInt(inputEdad.getText());

        Proveedor proveedor = new Proveedor(nombre, edad, 0);
        BaseDatosArchivos bd = new BaseDatosArchivos();
        bd.guardarDatos(proveedor);

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Proveedor-suministros.fxml"));
        try {
            BorderPane hBox = loader.load();
            ProveedorSuministrosController proveedorSuministrosController = loader.getController();
            if (proveedorSuministrosController != null) {
                proveedorSuministrosController.setData(proveedor);
                paneCambia.getChildren().setAll(hBox);
            } else {
                System.out.println("El controlador no pudo ser cargado. Revisa el archivo FXML.");
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al cargar el archivo FXML", e);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error desconocido", e);
        }
    }

}
