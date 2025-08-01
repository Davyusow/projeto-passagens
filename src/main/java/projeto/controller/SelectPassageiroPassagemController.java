package projeto.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import projeto.view.TelaEntradaView;

import java.io.IOException;

public class SelectPassageiroPassagemController extends FuncoesComunsController{

    @FXML
    void handleCancelar(ActionEvent event) throws IOException {
        trocarTela(event, TelaEntradaView.carregar(), "Menu inicial");
    }

    @FXML
    void handleAvancar(ActionEvent event) throws IOException {
        //
    }
}
