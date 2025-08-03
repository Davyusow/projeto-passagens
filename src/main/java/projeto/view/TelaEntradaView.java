package projeto.view;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import projeto.controller.FachadaController;

public class TelaEntradaView {

    private static FachadaController fachada = FachadaController.getInstance();

    @SuppressWarnings("exports")
    public static Parent carregar() throws IOException {
        FXMLLoader loader = new FXMLLoader(
                TelaEntradaView.class.getResource("TelaEntrada.fxml"));
        return loader.load();
    }

}
