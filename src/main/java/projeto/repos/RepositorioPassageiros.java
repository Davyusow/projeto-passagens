package projeto.repos;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import projeto.exceptions.ObjetoNaoEncontradoException;
import projeto.exceptions.PassageiroNEncontradoException;
import projeto.exceptions.PassagemNEncontradaException;
import projeto.models.Passageiro;

public class RepositorioPassageiros {
	
	private List<Passageiro> passageiros;
	private static AtomicInteger contador = new AtomicInteger();
	private static RepositorioPassageiros instance;
	
	private RepositorioPassageiros() {
		this.passageiros = new ArrayList<>();
	}
	
	public List<Passageiro> getPassageiros() {
		return passageiros;
	}
	
	public AtomicInteger getContador() {
		return contador;
	}
	
	public static RepositorioPassageiros getInstance() {
		if (instance == null) {
			instance = new RepositorioPassageiros();
		} 
		return instance;
	}
	
	public void criarPassageiro(Passageiro passageiro) {
		passageiro.setId(contador.getAndIncrement());
		passageiros.add(passageiro);
	}
	
	private Passageiro buscarPassageiroPorId(int id){
		for (Passageiro passageiro : passageiros){
			if (passageiro.getId() == id) {
				return passageiro;
			}
		}
		return null;
	}

	public Passageiro procurarPassageiro(int id) throws ObjetoNaoEncontradoException {
		Passageiro passageiro = buscarPassageiroPorId(id);
		if (passageiro == null){
			throw new PassagemNEncontradaException("Passageiro com ID" + id + "não encontrado");
		}
		return passageiro;
	}
	
	public boolean editarPassageiro(Passageiro passageiro) throws ObjetoNaoEncontradoException {
		Passageiro busca = procurarPassageiro(passageiro.getId());
		if (busca == null) {
			throw new PassageiroNEncontradoException("Passageiro n encontrado");
		}
		
		Passageiro passageiroExistente = passageiros.get(passageiro.getId());
		passageiroExistente.setNome(passageiro.getNome());;
		passageiroExistente.setCpf(passageiro.getCpf());
		passageiroExistente.setEmail(passageiro.getEmail());
		
		return true;
	}
	
	public boolean removerPassageiro(Passageiro passageiro) throws ObjetoNaoEncontradoException {
		Passageiro busca = buscarPassageiroPorId(passageiro.getId());
		if (busca == null) {
			throw new ObjetoNaoEncontradoException("Passageiro não encontrado");
		}
        /*boolean existe = repositorio.removerPassageiro(passageiro);
        if (!existe) {
            //Exceção: ObjectNonExistentException
        }*/
		passageiros.remove(busca);
		return true;
	}
	
	public List<Passageiro> findAll() {
		/*        List<Passageiro> lista = repositorio.getPassageiros();
        if (lista == null) {
            //Exceção: EmptyListException
        }
        */
		return new ArrayList<>(passageiros);
	}
}
