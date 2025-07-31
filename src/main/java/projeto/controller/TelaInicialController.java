package projeto.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import projeto.view.GerenciamentoPassageiroView;
import projeto.view.GerenciamentoVooView;
import projeto.view.SelectPassageiroReservasView;
import projeto.view.SelectPassagemReservasView;


public class TelaInicialController extends FuncoesComunsController {

    @FXML
    public void gerenciarPassageiro(ActionEvent evento) throws IOException{
        trocarTela(evento, GerenciamentoPassageiroView.load(), "Gerenciamento de Passageiro");
    }
    
    @FXML
    public void gerenciarVoos(ActionEvent evento) throws IOException{
        trocarTela(evento, GerenciamentoVooView.load(), "Gerenciamento de voo");
    }

    @FXML
    public void visualizarReservas(ActionEvent evento) throws IOException{
        trocarTela(evento, SelectPassagemReservasView.load(), "Visualização das Reservas");
    }

}
