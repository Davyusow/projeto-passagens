package projeto.service;

import projeto.DAO.ObjectDAO;
import projeto.DAO.PassagemDAOImpl;
import projeto.models.Passagem;

public class AssentoService {

    private final PassagemService passagemService;
    private final ReservaService reservaService;
    private ObjectDAO<Passagem> passagemDAO = new PassagemDAOImpl();

    public AssentoService() {
        this.passagemService = new PassagemService();
        this.reservaService = new ReservaService();
    }

    public void realizarReserva(PassagemDados passagemDados) {
        Passagem passagem = passagemService.cadastrar(passagemDados);
        ReservaDados reservaDados = new ReservaDados(passagemDados.passageiro().getId(), passagem.getId(), passagemDados.voo().getId());
        reservaService.cadastrar(reservaDados);
    }

}
