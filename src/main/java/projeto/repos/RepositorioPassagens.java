package projeto.repos;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import projeto.exceptions.PassagemNEncontradaException;
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

	private Passagem buscarPassagemPorId(int id){
		for (Passagem passagem : passagens){
			if (passagem.getId() == id) {
				return passagem;
			}
		}
		return null;
	}

	public Passagem procurarPassagem(int id) throws PassagemNEncontradaException {
		Passagem passagem = buscarPassagemPorId(id);
		if (passagem == null){
			throw new PassagemNEncontradaException("Passagem com ID" + id + "não encontrada");
		}
		return passagem;
	}
	
	public boolean editarPassagem(Passagem passagem) throws PassagemNEncontradaException {
		Passagem busca = buscarPassagemPorId(passagem.getId());
		if (busca == null) {
			throw new PassagemNEncontradaException("Passagem não encontrada");
		}
		
		Passagem passagemExistente = passagens.get(passagem.getId());
		passagemExistente.setPassageiro(passagem.getPassageiro());
		passagemExistente.setVoo(passagem.getVoo());
		passagemExistente.setAssento(passagem.getAssento());
		
		return true;
	}
	
	public boolean removerPassagem(Passagem passagem) throws PassagemNEncontradaException {
		Passagem busca = buscarPassagemPorId(passagem.getId());
		if (busca == null) {
			throw new PassagemNEncontradaException("Passagem não encontrada");
		}
		
		passagens.remove(busca);
		return true;
	}
	
	public List<Passagem> findAll() {
		return new ArrayList<>(passagens);
	}
}
