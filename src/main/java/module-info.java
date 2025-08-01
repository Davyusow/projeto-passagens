module projeto {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    
    
    //opens projeto to javafx.fxml;
    opens projeto.controller to javafx.fxml;
    opens projeto.models to javafx.fxml;
    opens projeto.controller.cadastros to javafx.fxml;
    opens projeto.view to javafx.fxml;
    
    exports projeto;
    exports projeto.models;
    exports projeto.view;
    exports projeto.controller;
}
