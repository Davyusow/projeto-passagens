package projeto.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import projeto.DAO.ObjectDAO;
import projeto.DAO.VooDAOImpl;
import projeto.models.Voo.Voo;
import projeto.view.TelaEntradaView;

public class SelectVooPassagemController extends FuncoesComunsController {
    
    @FXML
    private TableView<Voo> tabelaViagens;
    @FXML
    private TableColumn<Voo, String> colunaDestino;
    @FXML
    private TableColumn<Voo, LocalDate> colunaData;
    @FXML
    private TableColumn<Voo, Boolean> colunaTipo;
    @FXML
    private TableColumn<Voo, Integer> colunaId;

    ObjectDAO vooDAO = new VooDAOImpl();

    @FXML
    public void initialize() {
        colunaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colunaDestino.setCellValueFactory(new PropertyValueFactory<>("localChegada"));
        colunaTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        colunaData.setCellValueFactory(new PropertyValueFactory<>("horarioChegadaEstimada"));

        carregarViagens();
    }

    private void carregarViagens() {
        tabelaViagens.getItems().clear();
        List<Voo> voos = vooDAO.findAll();
        ObservableList<Voo> observableVoos = FXCollections.observableArrayList(voos);
        tabelaViagens.setItems(observableVoos);
    }

    @FXML
    void handleCancelar(ActionEvent event) throws IOException {
        trocarTela(event, TelaEntradaView.carregar(), "Menu inicial");
    }

}
