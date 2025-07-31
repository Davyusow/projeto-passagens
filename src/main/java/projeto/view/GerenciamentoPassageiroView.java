package projeto.view;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class GerenciamentoPassageiroView {
    public static Parent carregar() throws IOException {
        FXMLLoader loader = new FXMLLoader(
            TelaEntradaView.class.getResource("GerenciamentoPassageiro.fxml"));
        return loader.load();
    }
}
