module com.uniajc.tallersistemaacademico {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.uniajc.tallersistemaacademico to javafx.fxml;
    exports com.uniajc.tallersistemaacademico;
}