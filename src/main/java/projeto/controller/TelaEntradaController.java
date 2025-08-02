package projeto.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import projeto.view.GerenciamentoPassageiroView;
import projeto.view.GerenciamentoVooView;
import projeto.view.SelectPassageiroPassagemView;
import projeto.view.SelectPassageiroReservasView;

public class TelaEntradaController extends FuncoesComunsController {

    @FXML
    @SuppressWarnings("exports")
    public void gerenciarPassageiro(ActionEvent evento) throws IOException {
        trocarTela(evento, GerenciamentoPassageiroView.carregar(), "Gerenciamento de Passageiros");
    }

    @FXML
    @SuppressWarnings("exports")
    public void gerenciarVoos(ActionEvent evento) throws IOException {
        trocarTela(evento, GerenciamentoVooView.carregar(), "Gerenciamento de voo");
    }

    @FXML
    @SuppressWarnings("exports")
    public void visualizarReservas(ActionEvent evento) throws IOException {
        trocarTela(evento, SelectPassageiroReservasView.carregar(), "Visualização das Reservas");
    }

    @FXML
    @SuppressWarnings("exports")
    public void comprarPassagens(ActionEvent evento) throws IOException {
        trocarTela(evento, SelectPassageiroPassagemView.carregar(), "Comprar Passagens");
    }
}
