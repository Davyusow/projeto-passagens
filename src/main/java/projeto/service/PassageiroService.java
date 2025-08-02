package projeto.service;

import projeto.DAO.PassageiroDAO;
import projeto.DAO.PassageiroDAOImpl;
import projeto.models.Passageiro;

public class PassageiroService {

    private final PassageiroDAO passageiroDAO = new PassageiroDAOImpl();

    public void cadastrarNovoPassageiro(PassageiroDados dados) throws Exception{
        validarRegrasDeNegocio(dados);

        Passageiro novoPassageiro = new Passageiro(dados.nome(),dados.cpf(),dados.email());
        passageiroDAO.criarPassageiro(novoPassageiro);
    }

    private void validarRegrasDeNegocio(PassageiroDados dados) throws Exception{
        if(dados.nome() == ""){
            throw new Exception("Exemplo");
        }
        //throws das exceções
    }

}
