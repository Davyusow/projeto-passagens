package projeto.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import projeto.view.TelaEntradaView;

public class SelectPassagemReservasController extends FuncoesComunsController {

    @FXML
    public void cancelar(ActionEvent evento) throws IOException{
        trocarTela(evento, TelaEntradaView.carregar(), "Menu Inicial");
    }
}
