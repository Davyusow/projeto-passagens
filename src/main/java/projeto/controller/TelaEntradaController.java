package projeto.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import projeto.view.GerenciamentoPassageiroView;
import projeto.view.GerenciamentoVooView;
import projeto.view.SelectPassagemReservasView;

public class TelaEntradaController extends FuncoesComunsController {

    @FXML
    @SuppressWarnings("exports")
    public void gerenciarPassageiro(ActionEvent evento) throws IOException {
        trocarTela(evento, GerenciamentoPassageiroView.carregar(), "Gerenciamento de Passageiro");
    }

    @FXML
    @SuppressWarnings("exports")
    public void gerenciarVoos(ActionEvent evento) throws IOException {
        trocarTela(evento, GerenciamentoVooView.carregar(), "Gerenciamento de voo");
    }

    @FXML
    @SuppressWarnings("exports")
    public void visualizarReservas(ActionEvent evento) throws IOException {
        trocarTela(evento, SelectPassagemReservasView.carregar(), "Visualização das Reservas");
    }

}
