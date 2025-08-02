package projeto.service;

import projeto.DAO.ObjectDAO;
import projeto.DAO.PassageiroDAOImpl;
import projeto.models.Passageiro;

public class PassageiroService {

    private final ObjectDAO passageiroDAO = new PassageiroDAOImpl();

    public void cadastrarNovoPassageiro(PassageiroDados dados) throws Exception{
        validarRegrasDeNegocio(dados);

        Passageiro novoPassageiro = new Passageiro(dados.nome(),dados.cpf(),dados.email());
        passageiroDAO.criar(novoPassageiro);
    }

    private void validarRegrasDeNegocio(PassageiroDados dados) throws Exception{
        if(dados.nome() == ""){
            throw new Exception("Exemplo");
        }
        //throws das exceções
    }

}
