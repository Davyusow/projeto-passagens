package projeto.service;

import java.time.LocalDateTime;

import projeto.DAO.VooDAO;
import projeto.DAO.VooDAOImpl;
import projeto.models.Voo.Voo;
import projeto.models.Voo.VooInternacional;
import projeto.models.Voo.VooNacional;

public class VooService {
    
    private final VooDAO vooDAO = new VooDAOImpl();

    public void cadastrarNovoVoo(VooDados dados) throws Exception {
        validarRegrasDeNegocio(dados);

        Integer quantidade = Integer.parseInt(dados.quantidade());
        LocalDateTime embarque = LocalDateTime.of(dados.data(), dados.horaEmbarque());
        LocalDateTime chegada = LocalDateTime.of(dados.data(), dados.horaChegada());
        String codigoVoo = "VO" + (1000 + (int) (Math.random() * 9000));

        Voo novoVoo;
        if (dados.isInternational()) {
            novoVoo = new VooInternacional(codigoVoo, embarque, chegada, quantidade, dados.origem(), dados.destino());
        } else {
            novoVoo = new VooNacional(codigoVoo, embarque, chegada, quantidade, dados.origem(), dados.destino());
        }

        vooDAO.criarVoo(novoVoo);
    }
    
    private void validarRegrasDeNegocio(VooDados dados) throws Exception { //aqui acontece os throws 
        if(dados.origem().equals(dados.destino())){ //exemplo de uma verifação
            throw new Exception("Exemplo"); //trhow da exceção, depois do trhow aqui você faz o catch (nesse caso no CadastroVooController) com o aviso do erro
        }
    }

}
