package projeto.view;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class TelaEntradaView {

    public static Parent load() throws IOException {
        FXMLLoader loader = new FXMLLoader(
            TelaEntradaView.class.getResource("telaEntrada.fxml"));
        return loader.load();
    }
}
