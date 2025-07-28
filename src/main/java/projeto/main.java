package projeto;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class main extends Application {

    @Override
    public void start(Stage janela) throws Exception {
        Parent raiz = FXMLLoader.load(getClass().getResource("tela.fxml"));
        janela.setScene(new Scene(raiz));
        janela.setTitle("Menu inicial");
        janela.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}