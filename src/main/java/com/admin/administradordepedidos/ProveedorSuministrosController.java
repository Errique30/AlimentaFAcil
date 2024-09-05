package com.admin.administradordepedidos;
import com.admin.administradordepedidos.Clases.Producto;
import com.admin.administradordepedidos.Clases.Proveedor;
import com.admin.administradordepedidos.Clases.Suministro;
import com.admin.administradordepedidos.Libs.BaseDatosArchivos;
/*git config --global user.email "brayancespedes57@gmail.com"
 4024  git config --global user.name "Bryan4638"
*/
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ProveedorSuministrosController implements Initializable {
    @FXML
    private Button buttonAddCard;

    @FXML
    private ImageView imagenPuesta;

    @FXML
    private VBox chosenFruitCard;

    @FXML
    private ImageView fruitImg;

    @FXML
    private Label fruitNameLable;
    @FXML
    private Text textCantidad;
    @FXML
    private GridPane grid;

    @FXML
    private HBox hBoxText;

    @FXML
    private ScrollPane scroll;

    @FXML
    private Label stockLabel;


    @FXML
    private Text textMnto;

    @FXML
    private Text textNombre;

    @FXML
    private VBox vBoxBotton;

    @FXML
    private VBox vBoxScroll;
    @FXML
    private TextField imputStock;

    @FXML
    private TextField inputPrecio;

    private Proveedor proveedor;
    private Producto producto;
    public double monto = 0;

    @FXML
    private Label labelAddImage;
    @FXML
    private ColorPicker colorPicker;

    @FXML
    private TextField inputNombre;
    @FXML
    private Label labelAddImage1;

    private String imagePath;
    private Suministro suministro = new Suministro();
    private BaseDatosArchivos bd = new BaseDatosArchivos();
    private MyListener myListener;

    @FXML
    void buttonAdd(MouseEvent event) {
        Color color = colorPicker.getValue();
        String hex = String.format("%02X%02X%02X",
                (int) (color.getRed() * 255),
                (int) (color.getGreen() * 255),
                (int) (color.getBlue() * 255));
        System.out.println(hex);
        Producto producto1 = new Producto(inputNombre.getText(), "", imagePath, hex, Double.parseDouble(inputPrecio.getText()), Integer.parseInt(imputStock.getText()));
        suministro.setProductos(producto1);
        proveedor.setSuministro(suministro);
        ArrayList<Producto> productos = bd.leerDatosProducto();
        productos.add(producto1);
        bd.guardarDatos(productos);
        bd.actualizarProvedor(proveedor);
        monto = monto+(producto1.getPrecio()*producto1.getStock());
        textMnto.setText(String.valueOf(monto));
        imagePath = "";
        System.out.println(imagenPuesta.getImage().getUrl());
        initialize(null, null);

    }

    @FXML
    void examinarPonerFoto(MouseEvent event) {
        FileChooser fileChooser = new FileChooser();

        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Archivos de imagen", "*.png", "*.jpg"));

        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile!= null) {
            imagePath = "Images/"+selectedFile.getName();

            try {
                // Cargar la imagen directamente usando la clase Image de JavaFX
                Image image = new Image(selectedFile.toURI().toString());
                imagenPuesta.setImage(image);
                labelAddImage.setText("");
                labelAddImage1.setText("");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    void setData(Proveedor proveedor){
        this.proveedor = proveedor;
    }
    void setData(Producto producto){
        this.producto = producto;
        Image image = new Image(getClass().getResourceAsStream(producto.getImagen()));
        imagenPuesta.setImage(image);
        image.cancel();
        textNombre.setText(producto.getNombre());
        imagePath = producto.getImagen();
        textMnto.setText(String.valueOf(monto));
        colorPicker.setValue(Color.web(producto.getColor()));
        chosenFruitCard.setStyle("-fx-background-color: #" + producto.getColor() + ";-fx-background-radius: 30;");
        inputNombre.setText(producto.getNombre());
        inputPrecio.setText(String.valueOf(producto.getPrecio()));
        imputStock.setText(String.valueOf(producto.getStock()));
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        BaseDatosArchivos bd = new BaseDatosArchivos();
        ArrayList<Producto> productos = bd.leerDatosProducto();
        grid.getChildren().clear();
        if (productos.size() > 0) {
            myListener = new MyListener() {
                @Override
                public void onClickListener(Producto producto) {
                    setData(producto);
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
