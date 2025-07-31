package projeto.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import projeto.view.cadastro.CadastroPassageiroView;

public class TelaInicialController extends FuncoesComunsController {

    @FXML
    public void cadastrarPassageiro(ActionEvent evento) throws IOException{
        trocarTela(evento, CadastroPassageiroView.load(), "Cadastro de Passageiro");
    }

}
