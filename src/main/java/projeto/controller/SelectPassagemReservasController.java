package projeto.controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import projeto.DAO.ObjectDAO;
import projeto.DAO.PassagemDAOImpl;
import projeto.DAO.ReservaDAOImpl;
import projeto.models.Passageiro;
import projeto.models.Passagem;
import projeto.models.Reserva;
import projeto.util.Aviso;
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
    private static Passageiro passageiro;


    public static void setPassageiro(Passageiro novoPassageiro){
        passageiro = novoPassageiro;
    }

    @FXML
    public void initialize(){
        colunaDestino.setCellValueFactory(new PropertyValueFactory<>("destino"));
        colunaAssento.setCellValueFactory(new PropertyValueFactory<>("assento"));
        colunaTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        colunaId.setCellValueFactory(new PropertyValueFactory<>("id"));

        carregarPassagens();
    }

    private void carregarPassagens() {
        try {
            tabelaPassagem.getItems().clear();
    
            if (passageiro == null) {
                Aviso.erro("Erro", "Nenhum passageiro selecionado");
                return;
            }
            
            ObjectDAO<Reserva> reservaDAO = new ReservaDAOImpl();
            List<Reserva> reservas = ((ReservaDAOImpl)reservaDAO).findReservaPassageiro(passageiro.getId());
            
            List<Passagem> passagens = reservas.stream()
                .map(reserva -> passagemDAO.procurar(reserva.getIdPassagem()))
                .filter(passagem -> passagem != null)
                .collect(Collectors.toList());
            
            ObservableList<Passagem> observablePassagens = FXCollections.observableArrayList(passagens);
            tabelaPassagem.setItems(observablePassagens);
            
        } catch (Exception e) {
            Aviso.erro("Erro", "Falha ao carregar passagens: " + e.getMessage());
        }
    }

    @FXML
    @SuppressWarnings("exports")
    public void cancelar(ActionEvent evento) throws IOException{
        trocarTela(evento, TelaEntradaView.carregar(), "Menu Inicial");
    }

}
