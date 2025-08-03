package projeto.repos;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import projeto.exceptions.ListaVaziaException;
import projeto.exceptions.ObjetoNaoEncontradoException;
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

	public Passageiro procurarPassageiro(int id) throws ObjetoNaoEncontradoException {
		boolean idEncontrado = false;
		
		for (Passageiro passageiro : passageiros) {
			if (passageiro.getId() == id) {
				return passageiro;				
			}
		}
		
		if (!idEncontrado) {
			throw new ObjetoNaoEncontradoException("Não foi encontrado nenhum(a) " + " passageiro " + " com ID " + id);
		}
		
		return null;
	}
	
	public boolean editarPassageiro(Passageiro passageiro) throws ObjetoNaoEncontradoException {
		Passageiro busca = procurarPassageiro(passageiro.getId());
		if (busca == null) {
			throw new ObjetoNaoEncontradoException("Tentativa de edição falha:" + " Passageiro " +
													passageiro.getId() + " não foi  encontrado");
		}
		
		Passageiro passageiroExistente = passageiros.get(passageiro.getId());
		passageiroExistente.setNome(passageiro.getNome());;
		passageiroExistente.setCpf(passageiro.getCpf());
		passageiroExistente.setEmail(passageiro.getEmail());
		
		return true;
	}
	
	public boolean removerPassageiro(Passageiro passageiro) throws ObjetoNaoEncontradoException {
		Passageiro busca = procurarPassageiro(passageiro.getId());
		if (busca == null) {
			throw new ObjetoNaoEncontradoException("Tentativa de remoção falha:" + "Passageiro " +
													passageiro.getId() + " não foi  encontrado(a)");
		}
		
		passageiros.remove(busca);
		return true;
	}
	
	public List<Passageiro> findAll() throws ListaVaziaException {
		List<Passageiro> lista = this.getPassageiros();
		
		if (lista.isEmpty()) {
			throw new ListaVaziaException("A lista pedida está vazia");
		}

		return new ArrayList<>(lista);
	}
}
