package projeto.service;

import projeto.DAO.ObjectDAO;
import projeto.DAO.PassagemDAOImpl;
import projeto.models.Passagem;

public class PassagemService {

    private final ObjectDAO<Passagem> passagemDAO = new PassagemDAOImpl();

    public Passagem cadastrar(PassagemDados dados){
        validarRegrasDeNegocio(dados);
        Passagem passagem = dados.toModel();
        passagemDAO.criar(passagem);
        return passagem;
    }

    private void validarRegrasDeNegocio(PassagemDados dados){

    }

}
