package projeto.view;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Optional;

public class CadastrarPassageiro {

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
    void handleAdicionarPassageiro(ActionEvent event){
//logica do codigo
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
    void handleCancelar(ActionEvent event){
//logica do codigo
    }

}
