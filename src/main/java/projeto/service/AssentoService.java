package projeto.service;

import projeto.models.Passagem;

public class AssentoService {

    private final PassagemService passagemService;
    private final ReservaService reservaService;

    public AssentoService() {
        this.passagemService = new PassagemService();
        this.reservaService = new ReservaService();
    }

    public void realizarReserva(PassagemDados passagemDados) {
        Passagem passagem = passagemService.cadastrar(passagemDados);
        passagemDados.voo().ocuparAssento(passagemDados.assento());
        ReservaDados reservaDados = new ReservaDados(passagemDados.passageiro().getId(), passagem.getId(), passagemDados.voo().getId());
        reservaService.cadastrar(reservaDados);
    }

}
