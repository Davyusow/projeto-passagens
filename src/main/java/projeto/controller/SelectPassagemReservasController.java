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
import projeto.DAO.ObjectDAO;
import projeto.DAO.PassagemDAOImpl;
import projeto.models.Passagem;
import projeto.view.TelaEntradaView;

public class SelectPassagemReservasController extends FuncoesComunsController {

    @FXML
    private TableView<Passagem> tabelaPassagem;
    @FXML
    private TableColumn<Passagem, String> colunaDestino; 
    @FXML
    private TableColumn<Passagem, String> colunaAssento;
    @FXML
    private TableColumn<Passagem, String> colunaTipo;
    @FXML
    private TableColumn<Passagem, Integer> colunaId;

    ObjectDAO<Passagem> passagemDAO = new PassagemDAOImpl();

    @FXML
    public void initialize(){
        colunaDestino.setCellValueFactory(new PropertyValueFactory<>("id"));
        colunaAssento.setCellValueFactory(new PropertyValueFactory<>("assento"));
        colunaTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        colunaId.setCellValueFactory(new PropertyValueFactory<>("id"));

        carregarPassagens();
    }

    private void carregarPassagens(){
        tabelaPassagem.getItems().clear();
        List<Passagem> passagens = passagemDAO.findAll();
        ObservableList<Passagem> observablePassagens = FXCollections.observableArrayList(passagens);
        tabelaPassagem.setItems(observablePassagens);
    }

    @FXML
    @SuppressWarnings("exports")
    public void cancelar(ActionEvent evento) throws IOException{
        trocarTela(evento, TelaEntradaView.carregar(), "Menu Inicial");
    }

    
}
