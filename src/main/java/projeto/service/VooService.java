package projeto.service;

import java.time.LocalDateTime;

import projeto.DAO.ObjectDAO;
import projeto.DAO.VooDAOImpl;
import projeto.exceptions.CapacidadeIncoerenteException;
import projeto.exceptions.EmbarqueIgualChegadaException;
import projeto.exceptions.OrigemIgualDestinoException;
import projeto.models.Voo.Voo;
import projeto.models.Voo.VooInternacional;
import projeto.models.Voo.VooNacional;

public class VooService {
    
    private final ObjectDAO<Voo> vooDAO = new VooDAOImpl();

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

        vooDAO.criar(novoVoo);
    }
    
    private void validarRegrasDeNegocio(VooDados dados) throws Exception {
       if(dados.origem().equals(dados.destino())) { 
           throw new OrigemIgualDestinoException("O endereço de origem e de destino são iguais");
       }
       if(dados.horaEmbarque().equals(dados.horaChegada())) {
    	   throw new EmbarqueIgualChegadaException("O horário de embarque e de destino são iguais");
       }
       if(Integer.parseInt(dados.quantidade()) <= 0) {
    	   throw new CapacidadeIncoerenteException("A capacidade do voo é incorente"); 
       }
    }
}
