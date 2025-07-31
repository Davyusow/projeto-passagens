package projeto.controller.cadastros;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import projeto.controller.FuncoesComunsController;

public class CadastroVooController extends FuncoesComunsController {

    @FXML
    private TextField campoOrigem;
    @FXML
    private TextField campoDestino;
    @FXML
    private TextField campoQuant;
    @FXML
    private TextField campoHora;
    @FXML
    private DatePicker campoData;

    @FXML
    public void cancelar(ActionEvent evento){
        fecharPopup(evento);
    }
}
