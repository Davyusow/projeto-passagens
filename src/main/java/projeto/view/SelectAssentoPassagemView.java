package projeto.view;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class SelectAssentoPassagemView {
    
    @SuppressWarnings("exports")
    public static Parent carregar() throws IOException {
        FXMLLoader loader = new FXMLLoader(
                TelaEntradaView.class.getResource("SelectAssentoPassagem.fxml"));
        return loader.load();
    }

}
