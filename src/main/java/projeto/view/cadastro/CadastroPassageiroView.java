package projeto.view.cadastro;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import projeto.view.TelaEntradaView;

public class CadastroPassageiroView {
    public static Parent carregar() throws IOException {
        FXMLLoader loader = new FXMLLoader(
            TelaEntradaView.class.getResource("cadastro/CadastroPassageiro.fxml"));
        return loader.load();
    }
}
