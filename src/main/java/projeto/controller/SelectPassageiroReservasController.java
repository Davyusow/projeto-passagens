package projeto.controller;

import java.io.IOException;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import projeto.DAO.PassageiroDAO;
import projeto.DAO.PassageiroDAOImpl;
import projeto.models.Passageiro;
import projeto.view.SelectPassagemReservasView;
import projeto.view.TelaEntradaView;

public class SelectPassageiroReservasController extends FuncoesComunsController {

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
    @SuppressWarnings("exports")
    public void handleCancelar(ActionEvent evento) throws IOException{
        trocarTela(evento, TelaEntradaView.carregar(), "Menu Inicial");
    }

    @FXML
    @SuppressWarnings("exports")
    public void handleAvancar(ActionEvent evento) throws IOException{
        trocarTela(evento, SelectPassagemReservasView.carregar(), "Reservas de passagem");
    }


}
