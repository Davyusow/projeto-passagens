package projeto.controller.cadastros;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import projeto.controller.FuncoesComunsController;
import projeto.service.PassageiroDados;
import projeto.service.PassageiroService;
import projeto.util.Aviso;
import projeto.view.GerenciamentoPassageiroView;

public class CadastroPassageiroController extends FuncoesComunsController {

    @FXML
    private TextField campoNome;
    @FXML
    private TextField campoCpf;
    @FXML
    private TextField campoEmail;

    PassageiroService servico = new PassageiroService();

    @FXML
    public void cancelar(ActionEvent evento) {
        fecharPopup(evento);
    }

    @FXML
    public void cadastrar(ActionEvent event) {
        try {
            
            PassageiroDados dadosDaTela = new PassageiroDados(
                campoNome.getText(),
                campoCpf.getText(),
                campoEmail.getText());

            servico.cadastrarNovoPassageiro(dadosDaTela); //valida os dados
            trocarTela(event, GerenciamentoPassageiroView.carregar(), "Gerenciamento de Passageiros");

        } catch (Exception e) { //tratamento dos erros lançados pelo servico
            Aviso.erro("Campos Vazios!", "Você não preencheu todos os campos necessários!");
        }
    }
}
