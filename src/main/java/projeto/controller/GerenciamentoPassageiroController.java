package projeto.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import projeto.DAO.PassageiroDAO;
import projeto.DAO.PassageiroDAOImpl;
import projeto.models.Passageiro;
import projeto.util.Aviso;
import projeto.view.TelaEntradaView;
import projeto.view.cadastro.CadastroPassageiroView;

import java.io.IOException;
import java.util.List;

public class GerenciamentoPassageiroController extends FuncoesComunsController {

    @FXML
    private TableView<Passageiro> tabelaPassageiros;
    @FXML
    private TableColumn<Passageiro, String> colunaNome;
    @FXML
    private TableColumn<Passageiro, String> colunaEmail;
    @FXML
    private TableColumn<Passageiro, String> colunaCpf;
    @FXML
    private TableColumn<Passageiro, Integer> colunaId;

    PassageiroDAO passageiroDAO = new PassageiroDAOImpl();

    @FXML
    public void initialize() {
        colunaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        colunaEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        carregarPassageiros();
    }

    private void carregarPassageiros() {
        tabelaPassageiros.getItems().clear();
        List<Passageiro> passageiros = passageiroDAO.findAll();
        ObservableList<Passageiro> observablePassageiros = FXCollections.observableArrayList(passageiros);
        tabelaPassageiros.setItems(observablePassageiros);
    }

    @FXML
    void handleAdicionarPassageiro(ActionEvent event) throws IOException {
        trocarTela(event, CadastroPassageiroView.carregar(), "Cadastro de Passageiros");
    }

    @FXML
    void handleRemoverPassageiro(ActionEvent event) {
        Passageiro selecionado = tabelaPassageiros.getSelectionModel().getSelectedItem();
        if (selecionado != null) {
            if (Aviso.confirmacao("Confirmação", "Tem certeza que deseja excluir este passageiro?")) {
                passageiroDAO.removerPassageiro(selecionado);
                carregarPassageiros();
            }
        } else {
            System.out.println("Passageiro não selecionado");
        }
    }

    @FXML
    void handleCancelar(ActionEvent event) throws IOException {
        trocarTela(event, TelaEntradaView.carregar(), "Menu inicial");
    }

}
