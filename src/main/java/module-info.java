module com.admin.administradordepedidos {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens com.admin.administradordepedidos to javafx.fxml;
    exports com.admin.administradordepedidos;
}