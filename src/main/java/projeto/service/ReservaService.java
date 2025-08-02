package projeto.service;

import projeto.DAO.ObjectDAO;
import projeto.DAO.ReservaDAOImpl;
import projeto.models.Reserva;

public class ReservaService {

    private final ObjectDAO<Reserva> reservaDAO = new ReservaDAOImpl();

    public void cadastrar(ReservaDados dados){
        validarRegrasDeNegocio(dados);

        reservaDAO.criar(dados.toModel());
    }

    private void validarRegrasDeNegocio(ReservaDados dados){

    }
}
