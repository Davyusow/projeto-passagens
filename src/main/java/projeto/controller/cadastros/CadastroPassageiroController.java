package projeto.controller.cadastros;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import projeto.controller.FuncoesComunsController;

public class CadastroPassageiroController extends FuncoesComunsController {

    @FXML
    private TextField campoNome;
    @FXML
    private TextField campoCpf;
    @FXML
    private TextField campoTelefone;


    @FXML
    public void cancelar(ActionEvent evento){
        fecharPopup(evento);
    }
}
