package com.admin.administradordepedidos;
import com.admin.administradordepedidos.Clases.Cliente;
import com.admin.administradordepedidos.Clases.Pedido;
import com.admin.administradordepedidos.Clases.Producto;
import com.admin.administradordepedidos.Libs.BaseDatosArchivos;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ClientePedidos implements Initializable {
    @FXML
    private VBox chosenFruitCard;
    @FXML
    private ImageView fruitImg;
    @FXML
    private Label fruitNameLable;
    @FXML
    private Label fruitPriceLabel;
    @FXML
    private Label stockLabel;
    @FXML
    private Text textCantidad;

    @FXML
    private GridPane grid;
    @FXML
    public VBox vBoxProductos;
    @FXML
    public ScrollPane scroll;
    @FXML
    public HBox hBoxText;
    @FXML
    public VBox vBoxScroll;
    @FXML
    public Button buttonAddCard;
    @FXML
    private Text textDireccion;
    @FXML
    public Text textMnto;
    @FXML
    private Text textNombre;
    @FXML
    public VBox vBoxBotton;

    private MyListener myListener;

    private Cliente cliente;
    private Producto producto;
    public int cantidadProduct = 1 ;
    public double monto = 0;
    public Pedido pedido = new Pedido();
    public ButtonEditController buttonEditController;
    public  ClientEditPedidosController clientEditPedidosController;
    private BaseDatosArchivos bd = new BaseDatosArchivos();
    void setDate(Cliente cliente){
        this.cliente = cliente;
        textNombre.setText(cliente.getNombre());
        textDireccion.setText(cliente.getDireccion());
    }

    void setDate(Producto producto){
        this.producto = producto;
        Image image = new Image(getClass().getResourceAsStream(producto.getImagen()));
        fruitImg.setImage(image);
        image.cancel();
        textCantidad.setText(String.valueOf(cantidadProduct));
        textMnto.setText(String.valueOf(monto));
        chosenFruitCard.setStyle("-fx-background-color: #" + producto.getColor() + ";-fx-background-radius: 30;");
        fruitNameLable.setText(producto.getNombre());
        fruitPriceLabel.setText("$" + producto.getPrecio()*cantidadProduct);
        stockLabel.setText(String.valueOf(producto.getStock()));
    }



    @FXML
    void addToCard(MouseEvent event) {
        producto.setCatidad(cantidadProduct);
        pedido.setProducto(producto);
        cliente.setPedidos(pedido);
        bd.actualizarCliente(cliente);
        monto = monto+(cantidadProduct*producto.getPrecio());
        textMnto.setText(String.valueOf(monto));
    }

    @FXML
    void addToProduct(MouseEvent event) {
        if (cantidadProduct >= producto.getStock()){
            return;
        }
        cantidadProduct++;
        setDate(producto);
    }
    @FXML
    void removeToProduct(MouseEvent event) {
        if (cantidadProduct > 1){
            cantidadProduct--;
            setDate(producto);
        }else {
            cantidadProduct = 1;
        }
    }

    @FXML
    private void clickEdit(MouseEvent mouseEvent) {
        vBoxBotton.getChildren().clear();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("button-edit.fxml"));
            HBox button = fxmlLoader.load();
            buttonEditController = fxmlLoader.getController();
            vBoxBotton.getChildren().add(button);

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("client-edit-pedidos.fxml"));
            VBox vBox = loader.load();
            clientEditPedidosController = loader.getController();
            clientEditPedidosController.setData(cliente.getPedidos().getProductos(), this, cliente);

            vBoxProductos.getChildren().clear();
            vBoxProductos.getChildren().setAll(vBox);


        }catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al cargar el archivo FXML", e);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error desconocido", e);
        }

    }


    void removeElement(){
        grid.getChildren().clear();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<Producto> productos = bd.leerDatosProducto();
        removeElement();
        if (productos.size() > 0) {
            setDate(productos.get(0));
            myListener = new MyListener() {
                @Override
                public void onClickListener(Producto producto) {
                    setDate(producto);
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
}
