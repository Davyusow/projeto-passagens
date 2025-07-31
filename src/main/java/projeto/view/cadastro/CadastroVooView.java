package projeto.view.cadastro;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import projeto.view.TelaEntradaView;

public class CadastroVooView {
    public static Parent carregar() throws IOException {
        FXMLLoader loader = new FXMLLoader(
            TelaEntradaView.class.getResource("cadastro/CadastroVoo.fxml"));
        return loader.load();
    }
}
