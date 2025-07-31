package projeto.view;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class GerenciamentoVooView {

    @SuppressWarnings("exports")
    public static Parent carregar() throws IOException {
        FXMLLoader loader = new FXMLLoader(
                TelaEntradaView.class.getResource("GerenciamentoVoo.fxml"));
        return loader.load();
    }

}
