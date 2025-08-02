package projeto.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

public abstract class FuncoesComunsController {
    
    @SuppressWarnings("exports") //é só pro compilador parar de reclamar
    public void trocarTela(ActionEvent evento, Parent arquivoFXML, String titulo) {
        try {
            Parent page = arquivoFXML;
            Stage janela = (Stage) ((Node) evento.getSource()).getScene().getWindow();
            Scene aba = new Scene(page);
            janela.setTitle(titulo);
            janela.setScene(aba);
        } catch (Exception e) {
            System.err.println("\n--- OCORREU UM ERRO AO CARREGAR A TELA ---");
            e.printStackTrace();
            System.err.println("--- FIM DO ERRO ---");
        }
    }
    
    @SuppressWarnings("exports")
    public void trocarAba(Pane pane, Parent arquivoFXML) {
        try {
            Parent root = arquivoFXML;
            pane.getChildren().setAll(root);
        } catch (Exception e) {
            System.err.println("\n--- OCORREU UM ERRO AO CARREGAR A TELA ---");
            e.printStackTrace();
            System.err.println("--- FIM DO ERRO ---");
        }
    }

    @SuppressWarnings("exports")
    public void abrirPopup(Parent arquivoFXML, String titulo, Window janelaPai) throws IOException {
        Parent root = arquivoFXML;
        Stage popupStage = new Stage();
        popupStage.setTitle(titulo);
        popupStage.setScene(new Scene(root));
        popupStage.initModality(Modality.WINDOW_MODAL);
        popupStage.initOwner(janelaPai);
        popupStage.showAndWait();
    }

    @SuppressWarnings("exports")
    public void fecharPopup(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    public void exibirAlerta(Alert.AlertType tipo, String titulo, String conteudo) {
        Alert alerta = new Alert(tipo);
        alerta.setHeaderText(titulo);
        alerta.setContentText(conteudo);
        alerta.showAndWait();
    }

}
