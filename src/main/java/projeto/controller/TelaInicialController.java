package projeto.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class TelaInicialController extends FuncoesComunsController {

    @FXML
    public void cadastrarPassageiro(ActionEvent evento){
        trocarTela(evento, "cadastro/CadastrarPassageiro.fxml", "Cadastro de Passageiro");
    }
}
