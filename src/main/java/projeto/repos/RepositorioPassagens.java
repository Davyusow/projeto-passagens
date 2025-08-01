package projeto.repos;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

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
	
	public int procurarPassagem(int id) {
		for (Passagem p : passagens) {
			if (p.getId() == id) {
				return p.getId();
			}
		}
		return -1;
	}
	
	public boolean editarPassagem(Passagem passagem) {
		int busca = procurarPassagem(passagem.getId());
		if (busca == -1) {
			return false;
		}
		
		Passagem passagemExistente = passagens.get(busca);
		passagemExistente.setPassageiro(passagem.getPassageiro());
		passagemExistente.setVoo(passagem.getVoo());
		passagemExistente.setAssento(passagem.getAssento());
		
		return true;
	}
	
	public boolean removerPassagem(Passagem passagem) {
		int busca = procurarPassagem(passagem.getId());
		if (busca == -1) {
			return false;
		}
		
		passagens.remove(busca);
		return true;
	}
	
	public List<Passagem> findAll() {
		return new ArrayList<>(passagens);
	}
}
