package projeto;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import projeto.view.TelaEntradaView;

public class App extends Application {

    @Override
    @SuppressWarnings("exports")
    public void start(Stage janela) throws Exception {
        Parent raiz = TelaEntradaView.carregar();
        janela.setScene(new Scene(raiz));
        janela.setTitle("Menu inicial");
        janela.setMinWidth(600);
        janela.setMinHeight(400);
        janela.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}