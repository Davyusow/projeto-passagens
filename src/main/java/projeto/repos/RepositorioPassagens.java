package projeto.repos;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import projeto.exceptions.ListaVaziaException;
import projeto.exceptions.ObjetoNaoEncontradoException;
import projeto.models.Passagem;

public class RepositorioPassagens {
	
	private List<Passagem> passagens;
	private static AtomicInteger contador = new AtomicInteger();
	private static RepositorioPassagens instance;
	
	private RepositorioPassagens() {
		this.passagens = new ArrayList<>();
	}
	
	public List<Passagem> getPassagens() {
		return passagens;
	}
	
	public AtomicInteger getContador() {
		return contador;
	}
	
	public static RepositorioPassagens getInstance() {
		if (instance == null) {
			instance = new RepositorioPassagens();
		}
		return instance;
	}
	
	public void criarPassagem(Passagem passagem) {
		passagem.setId(contador.getAndIncrement());
		passagens.add(passagem);
	}
	
	public Passagem procurarPassagem(int id) throws ObjetoNaoEncontradoException {
		boolean idEncontrado = false;
		
		for (Passagem passagem : passagens) {
			if (passagem.getId() == id) {
				return passagem;
			}
		}
		
		if (!idEncontrado) {
			throw new ObjetoNaoEncontradoException("Não foi encontrado nenhum(a) " + " passagem " + " com ID " + id);
		}
		
		return null;
	}
	
	public boolean editarPassagem(Passagem passagem) throws ObjetoNaoEncontradoException {
		Passagem busca = procurarPassagem(passagem.getId());
		if (busca == null) {
			throw new ObjetoNaoEncontradoException("Tentativa de edição falha:" + " Passagem " +
													passagem.getId() + " não foi  encontrado");
		}
		
		Passagem passagemExistente = passagens.get(passagem.getId());
		passagemExistente.setPassageiro(passagem.getPassageiro());
		passagemExistente.setVoo(passagem.getVoo());
		passagemExistente.setAssento(passagem.getAssento());
		
		return true;
	}

	public boolean removerPassagem(Passagem passagem) throws ObjetoNaoEncontradoException {
		Passagem busca = procurarPassagem(passagem.getId());
		if (busca == null) {
			throw new ObjetoNaoEncontradoException("Tentativa de remoção falha:" + " Passagem " +
													passagem.getId() + " não foi  encontrado(a)");
		}
		
		passagens.remove(busca);
		return true;
	}
	
	public List<Passagem> findAll() throws ListaVaziaException {
		List<Passagem> lista = this.getPassagens();
		
		if (lista.isEmpty()) {
			throw new ListaVaziaException("A lista pedida está vazia");
		}

		return new ArrayList<>(lista);
	}
}
