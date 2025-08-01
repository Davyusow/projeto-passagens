package projeto.repos;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

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

	public int procurarPassageiro(int id) {
		for (Passageiro p : passageiros) {
			if (p.getId() == id) {
				return p.getId();
			}
		}
		return -1;
	}
	
	public boolean editarPassageiro(Passageiro passageiro) {
		int busca = procurarPassageiro(passageiro.getId());
		if (busca == -1) {
			return false;
		}
		
		Passageiro passageiroExistente = passageiros.get(busca);
		passageiroExistente.setNome(passageiro.getNome());;
		passageiroExistente.setCpf(passageiro.getCpf());
		passageiroExistente.setEmail(passageiro.getEmail());
		
		return true;
	}
	
	public boolean removerPassageiro(Passageiro passageiro) {
		int busca = procurarPassageiro(passageiro.getId());
		if (busca == -1) {
			return false;
		}
		
		passageiros.remove(busca);
		return true;
	}
	
	public List<Passageiro> findAll() {
		return new ArrayList<>(passageiros);
	}
}
