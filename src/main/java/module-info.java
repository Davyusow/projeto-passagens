module projeto {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    
    exports projeto;
    exports projeto.view;
    exports projeto.controller;

    opens projeto to javafx.fxml;
    opens projeto.view to javafx.fxml;
    opens projeto.controller to javafx.fxml;
    
}
