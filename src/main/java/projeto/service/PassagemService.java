package projeto.service;

import projeto.DAO.ObjectDAO;
import projeto.DAO.PassagemDAOImpl;
import projeto.models.Passagem;

public class PassagemService {

    private final ObjectDAO<Passagem> passagemDAO = new PassagemDAOImpl();

    public void cadastrar(PassagemDados dados){
        validarRegrasDeNegocio(dados);

        passagemDAO.criar(dados.toModel());
    }

    private void validarRegrasDeNegocio(PassagemDados dados){

    }

}
