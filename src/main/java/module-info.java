module com.uniajc.tallersistemaacademico {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.uniajc.tallersistemaacademico to javafx.fxml;
    exports com.uniajc.tallersistemaacademico;
}