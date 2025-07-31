package projeto.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import projeto.view.TelaEntradaView;
import projeto.view.cadastro.CadastroPassageiroView;

import java.io.IOException;

public class GerenciamentoPassageiroController extends FuncoesComunsController {

//    @FXML
//    private TableView<Passageiro> tabelaPassageiros;
//    @FXML
//    private TableColumn<Passageiro, String> colunaNome;
//    @FXML
//    private TableColumn<Passageiro, Integer> colunaTelefone;
//    @FXML
//    private TableColumn<Passageiro, Integer> colunaCpf;
//    @FXML
//    private TableColumn<Passageiro, Integer> colunaId;
//
//    @FXML
//    public void initialize() {
//        colunaId.setCellValueFactory(new PropertyValueFactory<>("id"));
//        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
//        colunaCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
//        colunaTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
//
//        carregarPassageiros();
//    }
//
//    private void carregarPassageiros() {
//        tabelaPassageiros.getItems().clear();
//        List<Passageiro> passageiros = passageiroDAO.findAll();
//        ObservableList<Passageiro> observablePassageiros = FXCollections.observableArrayList(passageiros);
//        tabelaPassageiros.setItems(observablePassageiros);
//    }

    @FXML
    void handleAdicionarPassageiro(ActionEvent event) throws IOException{
        abrirPopup(CadastroPassageiroView.carregar(),"Cadastro de Passageiro", ((Node) event.getSource()).getScene().getWindow());
    }

//    @FXML
//    void handleRemoverPassageiro(ActionEvent event){
//        Passageiro selecionado = tabelaPassageiros.getSelectionModel().getSelectedItem();
//        if (selecionado != null) {
//            ButtonType botaoSim = new ButtonType("Confirmar", ButtonBar.ButtonData.OK_DONE);
//            ButtonType botaoNao = new ButtonType("Cancelar", ButtonBar.ButtonData.CANCEL_CLOSE);
//
//            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "", botaoSim, botaoNao);
//            alert.setTitle("Confirmação");
//            alert.setHeaderText("Tem certeza que deseja excluir este passageiro?");
//            alert.setContentText("Passageiro: " + selecionado.getNome() + "\nEsta ação não pode ser desfeita.");
//
//            Optional<ButtonType> resultado = alert.showAndWait();
//
//            if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
//                passageiroDAO.remover(selecionado.getId());
//                carregarPassageiros();
//            }
//        }
//    }

    @FXML
    void handleCancelar(ActionEvent event) throws IOException{
        trocarTela(event, TelaEntradaView.carregar(), "Menu inicial");        
    }

}
