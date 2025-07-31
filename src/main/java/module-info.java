module projeto {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens projeto to javafx.fxml;
    opens projeto.view to javafx.fxml;
    exports projeto;
}
