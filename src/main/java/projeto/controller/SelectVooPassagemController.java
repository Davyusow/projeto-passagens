package projeto.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import projeto.view.TelaEntradaView;

public class SelectVooPassagemController extends FuncoesComunsController {
    
    @FXML
    void handleCancelar(ActionEvent event) throws IOException {
        trocarTela(event, TelaEntradaView.carregar(), "Menu inicial");
    }

}
