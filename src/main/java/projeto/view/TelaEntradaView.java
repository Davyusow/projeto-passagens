package projeto.view;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class TelaEntradaView {

    @SuppressWarnings("exports")
    public static Parent carregar() throws IOException {
        FXMLLoader loader = new FXMLLoader(
                TelaEntradaView.class.getResource("TelaEntrada.fxml"));
        return loader.load();
    }

}
