package com.admin.administradordepedidos;

import com.admin.administradordepedidos.Clases.Cliente;
import com.admin.administradordepedidos.Libs.BaseDatosArchivos;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class ClientDatosView {
    @FXML
    private TextField inputDireccion;
    @FXML
    private TextField inputEdad;
    @FXML
    private TextField inputNombre;
    @FXML
    private BorderPane paneCambia;
    public FXMLLoader loader;

    @FXML
    void eventBtnCuenta(MouseEvent event) throws IOException {
        String nombre = inputNombre.getText();
        String direccion = inputDireccion.getText();
        int edad = Integer.parseInt(inputEdad.getText());

        Cliente cliente = new Cliente(nombre, edad, direccion);
        BaseDatosArchivos bd = new BaseDatosArchivos();
        bd.guardarDatos(cliente);

        loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("cliente-pedidos.fxml"));
        try {
            BorderPane hBox = loader.load();
            ClientePedidos clientePedidos = loader.getController();
            if (clientePedidos != null) {
                clientePedidos.setDate(cliente);
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
