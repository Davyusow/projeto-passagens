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
import projeto.models.Passageiro;
import projeto.models.Voo.Voo;
import projeto.view.SelectAssentoPassagemView;
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

    ObjectDAO<Voo> vooDAO = new VooDAOImpl();

    private static Passageiro passageiro;
    public static void setPassageiro(Passageiro novoPassageiro){
        passageiro = novoPassageiro;
    }

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
    public void handleCancelar(ActionEvent evento) throws IOException {
        trocarTela(evento, TelaEntradaView.carregar(), "Menu inicial");
    }

    @FXML
    public void handleAvancar(ActionEvent evento) throws IOException{
        Voo selecionado = tabelaViagens.getSelectionModel().getSelectedItem();
        if(selecionado != null){
            SelectAssentoPassagemController.setPassageiro(passageiro);
            SelectAssentoPassagemController.setVoo(selecionado);
        }
        trocarTela(evento, SelectAssentoPassagemView.carregar(), "Selecione o Assento");
    }

}
