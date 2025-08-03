package projeto.controller.cadastros;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import projeto.controller.FuncoesComunsController;
import projeto.service.VooDados;
import projeto.service.VooService;
import projeto.util.Aviso;
import projeto.view.GerenciamentoVooView;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class CadastroVooController extends FuncoesComunsController {

    public final VooService servico = new VooService();

    @FXML
    private TextField campoOrigem;
    @FXML
    private TextField campoDestino;
    @FXML
    private TextField campoQuant;
    @FXML
    private TextField campoHoraChegada;
    @FXML
    private TextField campoHoraEmbarque;
    @FXML
    private DatePicker campoData;
    @FXML
    private RadioButton international, nacional;
    @FXML
    private ToggleGroup tipoVooGroup;

    @FXML
    public void cancelar(ActionEvent evento) throws IOException {
        trocarTela(evento, GerenciamentoVooView.carregar(), "Gerenciamento de voo");
    }

    @FXML
    public void cadastrar(ActionEvent evento) {

        try {
            VooDados dadosDaTela = new VooDados( // copia os dados da tela
                    campoOrigem.getText(),
                    campoDestino.getText(),
                    campoQuant.getText(),
                    campoData.getValue(),
                    LocalTime.parse(campoHoraEmbarque.getText()),
                    LocalTime.parse(campoHoraChegada.getText()),
                    international.isSelected());

            servico.cadastrarNovoVoo(dadosDaTela); // validação de dados acontece aqui
            // se continuar deu tudo certo
            trocarTela(evento, GerenciamentoVooView.carregar(), "Gerenciamento de voo");

        } catch (NumberFormatException e) { // os catchs fazem o tratamento do erro lançado no servico
            Aviso.erro("Erro de Formato", "A quantidade de passageiros deve ser um número inteiro válido");
        } catch (DateTimeParseException e) {
            Aviso.erro("Erro de Formato", "A hora deve estar no formato HH:mm (ex: 14:30).");
        } catch (Exception e) {
            Aviso.erro("Erro Inesperado", "Ocorreu um erro ao processar sua solicitação: " + e.getMessage());
            e.printStackTrace();
        }
    }

}