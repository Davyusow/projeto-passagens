package projeto.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import projeto.controller.cadastros.CadastroPassageiroController;
import projeto.controller.cadastros.CadastroVooController;
import projeto.models.Passageiro;
import projeto.models.Passagem;
import projeto.models.Voo.Voo;
import projeto.service.PassageiroDados;
import projeto.service.PassagemDados;
import projeto.service.VooDados;
import projeto.view.SelectAssentoPassagemView;
import projeto.view.SelectPassageiroPassagemView;
import projeto.view.SelectPassageiroReservasView;
import projeto.view.SelectPassagemReservasView;
import projeto.view.SelectVooPassagemView;
import projeto.view.TelaEntradaView;

public class FachadaController extends FuncoesComunsController {

    private final CadastroPassageiroController cadastroPassageiroController;
    private final CadastroVooController cadastroVooController;
    private final GerenciamentoPassageiroController gerenciamentoPassageiroController;
    private final GerenciamentoVooController gerenciamentoVooController;
    private final SelectAssentoPassagemController selectAssentoPassagemController;
    private final SelectPassageiroPassagemController selectPassageiroPassagemController;
    private final SelectPassageiroReservasController selectPassageiroReservasController;
    private final SelectPassagemReservasController selectPassagemReservasController;
    private final SelectVooPassagemController selectVooPassagemController;
    private final TelaEntradaController telaEntradaController;

    private static FachadaController instance;

    private FachadaController() {
        this.cadastroPassageiroController = new CadastroPassageiroController();
        this.cadastroVooController = new CadastroVooController();
        this.gerenciamentoPassageiroController = new GerenciamentoPassageiroController();
        this.gerenciamentoVooController = new GerenciamentoVooController();
        this.selectAssentoPassagemController = new SelectAssentoPassagemController();
        this.selectPassageiroPassagemController = new SelectPassageiroPassagemController();
        this.selectPassageiroReservasController = new SelectPassageiroReservasController();
        this.selectPassagemReservasController = new SelectPassagemReservasController();
        this.selectVooPassagemController = new SelectVooPassagemController();
        this.telaEntradaController = new TelaEntradaController();
    }

    public static FachadaController getInstance() {
        if (instance == null)
            instance = new FachadaController();

        return instance;
    }
    
    //passageiro

    
    public ObservableList<Passageiro> listarTodosPassageiros() {
        return gerenciamentoPassageiroController.tabelaPassageiros.getItems();
    }
    
    public void removerPassageiro(Passageiro passageiro) {
        gerenciamentoPassageiroController.passageiroDAO.remover(passageiro);
        gerenciamentoPassageiroController.carregarPassageiros();
    }
    
    public void navegarParaCadastroPassageiro(ActionEvent event) throws IOException {
        gerenciamentoPassageiroController.handleAdicionarPassageiro(event);
    }

    public void cadastrarPassageiro(String nome, String cpf, String email) throws Exception {
        PassageiroDados dados = new PassageiroDados(nome, cpf, email);
        cadastroPassageiroController.servico.cadastrarPassageiro(dados);
    }

    //voo

    public void cadastrarVoo(String origem, String destino, String quantidade,
            LocalDate data, LocalTime horaEmbarque,
            LocalTime horaChegada, boolean internacional) throws Exception {
            VooDados dados = new VooDados(origem, destino, quantidade, data,
                horaEmbarque, horaChegada, internacional);
                
        cadastroVooController.servico.cadastrarNovoVoo(dados);
    }

    public ObservableList<Voo> listarTodosVoos() {
        return gerenciamentoVooController.tabelaViagens.getItems();
    }
    
    public void removerVoo(Voo voo) {
        gerenciamentoVooController.vooDAO.remover(voo);
        gerenciamentoVooController.carregarViagens();
    }
    
    public void navegarParaCadastroVoo(ActionEvent event) throws IOException {
        gerenciamentoVooController.handleAdicionarVoo(event);
    }

    public void voltarParaMenuInicial(ActionEvent event) throws IOException {
        gerenciamentoPassageiroController.handleCancelar(event);
    }

    //reserva e compra

    public void iniciarProcessoReserva(ActionEvent event) throws IOException {
        selectPassageiroPassagemController.initialize();
        trocarTela(event, SelectPassageiroPassagemView.carregar(), "Seleção de Passageiro");
    }

    public void selecionarPassageiroEAvancar(ActionEvent event, Passageiro passageiro) throws IOException {
        SelectVooPassagemController.setPassageiro(passageiro);
        selectVooPassagemController.initialize();
        trocarTela(event, SelectVooPassagemView.carregar(), "Seleção de Voo");
    }

    public void selecionarVooEAvancar(ActionEvent event, Voo voo) throws IOException {
        SelectAssentoPassagemController.setPassageiro(SelectVooPassagemController.getPassageiro());
        SelectAssentoPassagemController.setVoo(voo);
        selectAssentoPassagemController.initialize();
        trocarTela(event, SelectAssentoPassagemView.carregar(), "Seleção de Assento");
    }

    public void confirmarReserva(ActionEvent event, String assento) throws IOException {
        Passageiro passageiro = SelectAssentoPassagemController.getPassageiro();
        Voo voo = SelectAssentoPassagemController.getVoo();
        
        PassagemDados dados = new PassagemDados(passageiro, voo, assento);
        selectAssentoPassagemController.servico.realizarReserva(dados);
        
        trocarTela(event, TelaEntradaView.carregar(), "Confirmação");
    }

    public ObservableList<Passageiro> getPassageirosParaSelecao() {
        return selectPassageiroPassagemController.tabelaPassageiros.getItems();
    }

    public ObservableList<Voo> getVoosParaSelecao() {
        return selectVooPassagemController.tabelaViagens.getItems();
    }
    
    // visualização da reserva

    public void iniciarConsultaReservas(ActionEvent event) throws IOException {
        selectPassageiroReservasController.initialize();
        trocarTela(event, SelectPassageiroReservasView.carregar(), "Consulta de Reservas");
    }

    public void consultarReservasPassageiro(ActionEvent event, Passageiro passageiro) throws IOException {
        SelectPassagemReservasController.setPassageiro(passageiro);
        selectPassagemReservasController.initialize();
        trocarTela(event, SelectPassagemReservasView.carregar(), "Reservas do Passageiro");
    }

    public ObservableList<Passageiro> getPassageirosParaConsulta() {
        return selectPassageiroReservasController.tabelaPassageiros.getItems();
    }

    public ObservableList<Passagem> getReservasPassageiro(Passageiro passageiro) {
        SelectPassagemReservasController.setPassageiro(passageiro);
        selectPassagemReservasController.carregarPassagens();
        return selectPassagemReservasController.tabelaPassagem.getItems();
    }

    public void cancelarConsultaReservas(ActionEvent event) throws IOException {
        SelectPassagemReservasController.setPassageiro(null);
        voltarParaMenuInicial(event);
    }

    // tela inicial

    public void navegarParaGerenciamentoPassageiros(ActionEvent event) throws IOException{
        gerenciamentoPassageiroController.initialize();
        telaEntradaController.gerenciarPassageiro(event);
    }

    public void navegarParaGerenciamentoVoos(ActionEvent event) throws IOException{
        gerenciamentoVooController.initialize();
        telaEntradaController.gerenciarVoos(event);
    }

    public void navegarParaCompraPassagem(ActionEvent event) throws IOException{
        selectPassageiroPassagemController.initialize();
        telaEntradaController.comprarPassagens(event);
    }

    public void navegarParaVizualizacaoReservas(ActionEvent event) throws IOException{
        selectPassageiroReservasController.initialize();
        telaEntradaController.visualizarReservas(event);
    }

}
