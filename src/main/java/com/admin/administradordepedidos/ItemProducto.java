package com.admin.administradordepedidos;

import com.admin.administradordepedidos.Clases.Producto;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ItemProducto {
    @FXML
    private ImageView img;

    @FXML
    private Label nameLabel;

    @FXML
    private Label priceLable;

    @FXML
    private void click(MouseEvent mouseEvent) {
        myListener.onClickListener(producto);
    }

    private Producto producto;
    private MyListener myListener;

    public void setData(Producto producto, MyListener myListener) {
        this.producto = producto;
        this.myListener = myListener;
        nameLabel.setText(producto.getNombre());
        priceLable.setText("$" + producto.getPrecio());
        Image image = new Image(getClass().getResourceAsStream(producto.getImagen()));
        img.setImage(image);
    }
}
