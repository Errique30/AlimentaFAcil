package com.admin.administradordepedidos;

import com.admin.administradordepedidos.Clases.Cliente;
import com.admin.administradordepedidos.Clases.Producto;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ClientEditPedidosController {

    @FXML
    private GridPane grid;

    @FXML
    private ScrollPane scroll;



    private ArrayList<Producto> productos;

    private  MyListener myListener;

    private ClientePedidos clientePedidos;

    @FXML
    void home(MouseEvent event) throws IOException {
        clientePedidos.vBoxProductos.getChildren().clear();
        clientePedidos.vBoxProductos.getChildren().setAll(clientePedidos.vBoxScroll);
        clientePedidos.vBoxBotton.getChildren().clear();
        clientePedidos.vBoxBotton.getChildren().setAll(clientePedidos.buttonAddCard);
    }
    void setData(ArrayList<Producto> productos, ClientePedidos clientePedidos, Cliente cliente){
        this.productos = productos;
        this.clientePedidos = clientePedidos;

        removeElement();
        if (productos.size() > 0) {
            myListener = new MyListener() {
                @Override
                public void onClickListener(Producto producto) {
                    clientePedidos.setDate(producto);
                    clientePedidos.buttonEditController.setData(producto, cliente, clientePedidos);
                }
            };
        }
        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < productos.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("item-producto.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                ItemProducto itemProducto = fxmlLoader.getController();
                itemProducto.setData(productos.get(i),myListener);

                if (column == 3) {
                    column = 0;
                    row++;
                }
                grid.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void removeElement(){
        grid.getChildren().clear();
    }

}
