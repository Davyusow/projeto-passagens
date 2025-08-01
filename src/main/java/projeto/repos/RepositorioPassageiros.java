package projeto.repos;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import projeto.DAO.PassageiroDAO;
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

	public Passageiro procurarPassageiro(int id) {
		for (Passageiro p : passageiros) {
			if (p.getId() == id) {
				return p;
			}
		}
		return null;
	}
	
	public boolean editarPassageiro(Passageiro passageiro) {
		Passageiro busca = procurarPassageiro(passageiro.getId());
		if (busca == null) {
			return false;
		}
		
		Passageiro passageiroExistente = passageiros.get(passageiro.getId());
		passageiroExistente.setNome(passageiro.getNome());;
		passageiroExistente.setCpf(passageiro.getCpf());
		passageiroExistente.setEmail(passageiro.getEmail());
		
		return true;
	}
	
	public boolean removerPassageiro(Passageiro passageiro) {
		Passageiro busca = procurarPassageiro(passageiro.getId());
		if (busca == null) {
			return false;
		}
		
		passageiros.remove(busca);
		return true;
	}
	
	public List<Passageiro> findAll() {
		return new ArrayList<>(passageiros);
	}
}
