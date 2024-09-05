package com.admin.administradordepedidos;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Home implements Initializable {
    @FXML
    private VBox paneCambia;

    @FXML
    void eventBtnCuenta(MouseEvent event) throws IOException {
        Pane ventanaGestionarCuentaFXML = FXMLLoader.load(getClass().getResource("client-datos-view.fxml"));
        paneCambia.getChildren().setAll(ventanaGestionarCuentaFXML);
    }

    @FXML
    void eventBtnProveedor(MouseEvent event) throws IOException{
        Pane ventanaGestionarCuentaFXML = FXMLLoader.load(getClass().getResource("Proveedor-datos-view.fxml"));
        paneCambia.getChildren().setAll(ventanaGestionarCuentaFXML);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Pane ventanaGestionarCuentaFXML = null;
        try {
            ventanaGestionarCuentaFXML = FXMLLoader.load(getClass().getResource("client-datos-view.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        paneCambia.getChildren().setAll(ventanaGestionarCuentaFXML);
    }
}