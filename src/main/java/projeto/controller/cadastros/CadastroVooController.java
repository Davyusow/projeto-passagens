package projeto.controller.cadastros;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import projeto.DAO.VooDAO;
import projeto.DAO.VooDAOImpl;
import projeto.controller.FuncoesComunsController;
import projeto.models.Voo.Voo;
import projeto.models.Voo.VooInternacional;
import projeto.models.Voo.VooNacional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class CadastroVooController extends FuncoesComunsController {

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

    private final VooDAO vooDAO = new VooDAOImpl();

    @FXML
    public void cancelar(ActionEvent evento) {
        fecharPopup(evento);
    }

    @FXML
    public void cadastrar(ActionEvent evento) {
        System.out.println("Pênis");
        if (!validarCampos()) {
            return;
        }

        try {
            String origem = campoOrigem.getText();
            String destino = campoDestino.getText();
            Integer quantidade = Integer.parseInt(campoQuant.getText());

            LocalDate data = campoData.getValue();
            LocalTime horaEmbarque = LocalTime.parse(campoHoraEmbarque.getText());
            LocalTime horaChegada = LocalTime.parse(campoHoraChegada.getText());

            LocalDateTime embarque = LocalDateTime.of(data, horaEmbarque);
            LocalDateTime chegada = LocalDateTime.of(data, horaChegada);

            String codigoVoo = origem.substring(0, 1).toUpperCase() + destino.substring(0, 1).toUpperCase()
                    + (1000 + (int) (Math.random() * 9000));

            Voo novoVoo;
            if (international.isSelected()) {
                novoVoo = new VooInternacional(codigoVoo, embarque, chegada, quantidade, origem, destino);
                vooDAO.criarVoo(novoVoo);
            } else {
                novoVoo = new VooNacional(codigoVoo, embarque, chegada, quantidade, origem, destino);
                vooDAO.criarVoo(novoVoo);
            }

            fecharPopup(evento);

        } catch (NumberFormatException e) {
            exibirAlerta(Alert.AlertType.ERROR, "Erro de Formato",
                    "A quantidade de passageiros deve ser um número inteiro válido.");
        } catch (DateTimeParseException e) {
            exibirAlerta(Alert.AlertType.ERROR, "Erro de Formato", "A hora deve estar no formato HH:mm (ex: 14:30).");
        } catch (Exception e) {
            exibirAlerta(Alert.AlertType.ERROR, "Erro Inesperado",
                    "Ocorreu um erro ao processar sua solicitação: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private boolean validarCampos() {
        StringBuilder erros = new StringBuilder();

        if (campoOrigem.getText().isBlank())
            erros.append("O campo Origem é obrigatório.\n");
        if (campoDestino.getText().isBlank())
            erros.append("O campo Destino é obrigatório.\n");
        if (campoData.getValue() == null)
            erros.append("O campo Data é obrigatório.\n");
        if (campoHoraEmbarque.getText().isBlank())
            erros.append("O campo Hora de Embarque é obrigatório.\n");
        if (campoHoraChegada.getText().isBlank())
            erros.append("O campo Hora de Chegada é obrigatório.\n");
        if (campoQuant.getText().isBlank())
            erros.append("O campo Quantidade de Passageiros é obrigatório.\n");
        if (tipoVooGroup.getSelectedToggle() == null)
            erros.append("Selecione o tipo de voo (Nacional/Internacional).\n");

        if (!erros.isEmpty()) {
            exibirAlerta(Alert.AlertType.WARNING, "Campos Inválidos", erros.toString());
            return false;
        }
        return true;
    }

}