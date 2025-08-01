package projeto.repos;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import projeto.models.Voo.Voo;

public class RepositorioVoos {

	private List<Voo> voos;
	private static AtomicInteger contador = new AtomicInteger();
	private static RepositorioVoos instance;

	private RepositorioVoos() {
		this.voos = new ArrayList<>();
	}
	
	public List<Voo> getVoos() {
		return voos;
	}
	
	public AtomicInteger getContador() {
		return contador;
	}
	
	public static RepositorioVoos getInstance() {
		if (instance == null) {
			instance = new RepositorioVoos();
		}
		return instance;
	}
	
	public void criarVoo(Voo voo) {
		voo.setId(contador.getAndIncrement());
		voos.add(voo);
	}

	public int procurarVoo(int id) {
		for (Voo v : voos) {
			if (v.getId() == id) {
				return v.getId();
			}
		}
		return -1;
	}

	public boolean editarVoo(Voo voo) {
		int busca = procurarVoo(voo.getId());
		if (busca == -1) {
			return false;
		}
		
		Voo vooExistente = voos.get(busca);
		vooExistente.setCodigo(voo.getCodigo());
		vooExistente.setHorarioEmbarque(voo.getHorarioEmbarque());
		vooExistente.setHorarioChegadaEstimada(voo.getHorarioChegadaEstimada());
		vooExistente.setQtdPassageiros(voo.getQtdPassageiros());
		vooExistente.setLocalEmbarque(voo.getLocalEmbarque());
		vooExistente.setLocalChegada(voo.getLocalChegada());
		
		return true;
	}
	
	public boolean removerVoo(Voo voo) {
		int busca = procurarVoo(voo.getId());
		if (busca == -1) {
			return false;
		}
		
		voos.remove(busca);
		return true;
	}
	
	public List<Voo> findAll() {
		return new ArrayList<>(voos);
	}
	
}
