package projeto.controller.cadastros;

import java.io.IOException;

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
    public void cancelar(ActionEvent evento) throws IOException {
        trocarTela(evento, GerenciamentoPassageiroView.carregar(), "Gerenciamento de passageiros");
    }

    @FXML
    public void cadastrar(ActionEvent event) {
        try {
            
            PassageiroDados dadosDaTela = new PassageiroDados(
                campoNome.getText(),
                campoCpf.getText(),
                campoEmail.getText());

            servico.cadastrarNovoPassageiro(dadosDaTela); 
            trocarTela(event, GerenciamentoPassageiroView.carregar(), "Gerenciamento de Passageiros");

        } catch (Exception e) { //tratamento dos erros lançados pelo servico
            Aviso.erro("Campos Vazios!", "Você não preencheu todos os campos necessários!");
        }
    }
}
