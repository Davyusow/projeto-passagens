package projeto.controller.cadastros;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import projeto.DAO.PassageiroDAO;
import projeto.DAO.PassageiroDAOImpl;
import projeto.controller.FuncoesComunsController;
import projeto.models.Passageiro;
import projeto.view.GerenciamentoPassageiroView;
import projeto.view.cadastro.CadastroPassageiroView;

public class CadastroPassageiroController extends FuncoesComunsController {

    @FXML
    private TextField campoNome;
    @FXML
    private TextField campoCpf;
    @FXML
    private TextField campoEmail;

    public Passageiro passageiro;

    PassageiroDAO passageiroDAO = new PassageiroDAOImpl();

    @FXML
    public void cancelar(ActionEvent evento){
        fecharPopup(evento);
    }

    @FXML
    public void cadastrar(ActionEvent event){
      try{
          if(passageiro == null){
              Passageiro novoPassageiro = new Passageiro(campoNome.getText(), campoCpf.getText(), campoEmail.getText());
              passageiroDAO.criarPassageiro(novoPassageiro);
          }
          else {
              passageiro.setCpf(campoCpf.getText());
              passageiro.setEmail(campoEmail.getText());
              passageiro.setNome(campoNome.getText());

              passageiroDAO.editarPassageiro(passageiro);
          }
          trocarTela(event, GerenciamentoPassageiroView.carregar(), "Gerenciamento de Passageiros");
      } catch (Exception e) {
          Alert alerta = new Alert(Alert.AlertType.ERROR);
          alerta.setContentText("Você não preencheu todos os campos necessários!");
          alerta.setHeaderText("Campos Vazios!");
          alerta.show();
      }
    }
}
