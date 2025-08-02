package projeto.util;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class GerenciadorDeErros {

    public static void informacao(String titulo, String conteudo) {
        Alert alerta = new Alert(AlertType.INFORMATION);
        alerta.setTitle(titulo);
        // alerta.setHeaderText(null);
        alerta.setContentText(conteudo);
        alerta.showAndWait();
    }

    public static void erro(String titulo, String conteudo) {
        Alert alerta = new Alert(AlertType.ERROR);
        alerta.setTitle(titulo);
        // alerta.setHeaderText(null);
        alerta.setContentText(conteudo);
        alerta.showAndWait();
    }

    private static boolean confirmacao(String titulo, String conteudo) {
        Alert alerta = new Alert(AlertType.CONFIRMATION);
        alerta.setTitle(titulo);
        // alerta.setHeaderText(null);
        alerta.setContentText(conteudo);

        Optional<ButtonType> resultado = alerta.showAndWait();
        return resultado.isPresent() && resultado.get() == ButtonType.OK;
    }

}
