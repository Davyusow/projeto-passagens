package projeto.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import projeto.view.TelaEntradaView;
import projeto.view.cadastro.CadastroVooView;

import java.io.IOException;

public class GerenciamentoVooController extends FuncoesComunsController {

//    @FXML
//    private TableView<Voo> tabelaViagens;
//    @FXML
//    private TableColumn<Voo, String> colunaDestino;
//    @FXML
//    private TableColumn<Voo, LocalDate> colunaData;
//    @FXML
//    private TableColumn<Voo, Boolean> colunaTipo;
//    @FXML
//    private TableColumn<Voo, Integer> colunaId;
//
//    @FXML
//    public void initialize() {
//        colunaId.setCellValueFactory(new PropertyValueFactory<>("id"));
//        colunaDestino.setCellValueFactory(new PropertyValueFactory<>("destino"));
//        colunaTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
//        colunaData.setCellValueFactory(new PropertyValueFactory<>("data"));
//
//        carregarViagens();
//    }
//
//    private void carregarViagens() {
//        tabelaViagens.getItems().clear();
//        List<Voo> voos = vooDAO.findAll();
//        ObservableList<Voo> observableVoos = FXCollections.observableArrayList(voos);
//        tabelaViagens.setItems(observableVoos);
//    }

    @FXML
    void handleAdicionarVoo(ActionEvent event) throws IOException{
        abrirPopup(CadastroVooView.carregar(),"Cadastro de Passageiro", ((Node) event.getSource()).getScene().getWindow());
    }

//    @FXML
//    void handleRemoverVoo(ActionEvent event){
//        Voo selecionado = tabelaViagens.getSelectionModel().getSelectedItem();
//        if (selecionado != null) {
//            ButtonType botaoSim = new ButtonType("Confirmar", ButtonBar.ButtonData.OK_DONE);
//            ButtonType botaoNao = new ButtonType("Cancelar", ButtonBar.ButtonData.CANCEL_CLOSE);
//
//            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "", botaoSim, botaoNao);
//            alert.setTitle("Confirmação");
//            alert.setHeaderText("Tem certeza que deseja excluir este voo?");
//            alert.setContentText("Voo: " + selecionado.getNome() + "\nEsta ação não pode ser desfeita.");
//
//            Optional<ButtonType> resultado = alert.showAndWait();
//
//            if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
//                vooDAO.remover(selecionado.getId());
//                carregarViagens();
//            }
//        }
//    }

    @FXML
    void handleCancelar(ActionEvent event) throws IOException{
        trocarTela(event, TelaEntradaView.carregar(), "Menu inicial");        
    }
}
