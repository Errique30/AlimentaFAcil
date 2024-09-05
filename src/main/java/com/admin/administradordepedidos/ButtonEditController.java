package com.admin.administradordepedidos;

import com.admin.administradordepedidos.Clases.Cliente;
import com.admin.administradordepedidos.Clases.Producto;
import com.admin.administradordepedidos.Libs.BaseDatosArchivos;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class ButtonEditController implements Initializable {

    private Cliente cliente;
    private Producto producto;
    private ClientePedidos clientePedidos;

    private BaseDatosArchivos bd = new BaseDatosArchivos();
    @FXML
    private Button buttonDelete;

    @FXML
    private Button buttonEdit;
    @FXML
    private void clickEdit(MouseEvent mouseEvent) {
        producto.setCatidad(clientePedidos.cantidadProduct);
        boolean isRemuving = clientePedidos.pedido.getProductos().removeIf(producto1 -> producto1.getId().equals(producto.getId()));
        if (isRemuving){
            cliente.setPedidos(clientePedidos.pedido);
        }
        bd.actualizarCliente(cliente);

        clientePedidos.monto = clientePedidos.monto+(clientePedidos.cantidadProduct*producto.getPrecio());

        clientePedidos.textMnto.setText(String.valueOf(clientePedidos.monto));
    }
    @FXML
    void clickDelete(MouseEvent event) {
        producto.setCatidad(clientePedidos.cantidadProduct);
        clientePedidos.pedido.getProductos().removeIf(producto1 -> producto1.getId().equals(producto.getId()));
        clientePedidos.clientEditPedidosController.setData(cliente.getPedidos().getProductos(), clientePedidos, cliente);
    }

    void setData(Producto producto, Cliente cliente, ClientePedidos clientePedidos) {
        this.cliente = cliente;
        this.producto = producto;
        this.clientePedidos = clientePedidos;
        buttonDelete.setDisable(false);
        buttonEdit.setDisable(false);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (cliente == null){
            buttonDelete.setDisable(true);
            buttonEdit.setDisable(true);
        }
    }
}
