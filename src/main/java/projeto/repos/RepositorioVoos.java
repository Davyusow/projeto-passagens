package projeto.repos;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import projeto.exceptions.ListaVaziaException;
import projeto.exceptions.ObjetoNaoEncontradoException;
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
	
	public Voo procurarVoo(int id) throws ObjetoNaoEncontradoException {
		boolean idEncontrado = false;
		
		for (Voo voo : voos) {
			if (voo.getId() == id) {
				return voo;
			}
		}
		
		if (!idEncontrado) {
			throw new ObjetoNaoEncontradoException("Não foi encontrado nenhum(a) " + " voo " + " com ID " + id);
		}
		
		return null;
	}

	public boolean editarVoo(Voo voo) throws ObjetoNaoEncontradoException {
		Voo busca = procurarVoo(voo.getId());
		if (busca == null) {
			throw new ObjetoNaoEncontradoException("Tentativa de edição falha:" + " Voo " +
													voo.getId() + " não foi  encontrado");
		}
		
		Voo vooExistente = voos.get(voo.getId());
		vooExistente.setCodigo(voo.getCodigo());
		vooExistente.setHorarioEmbarque(voo.getHorarioEmbarque());
		vooExistente.setHorarioChegadaEstimada(voo.getHorarioChegadaEstimada());
		vooExistente.setQtdPassageiros(voo.getQtdPassageiros());
		vooExistente.setLocalEmbarque(voo.getLocalEmbarque());
		vooExistente.setLocalChegada(voo.getLocalChegada());
		
		return true;
	}
	
	public boolean removerVoo(Voo voo) throws ObjetoNaoEncontradoException {
		Voo busca = procurarVoo(voo.getId());
		if (busca == null) {
			throw new ObjetoNaoEncontradoException("Tentativa de remoção falha:" + " Voo " +
													voo.getId() + " não foi  encontrado(a)");
		}
		
		voos.remove(busca);
		return true;
	}
	
	public List<Voo> findAll() throws ListaVaziaException {
		List<Voo> lista = this.getVoos();
		
		if (lista.isEmpty()) {
			throw new ListaVaziaException("A lista pedida está vazia");
		}

		return new ArrayList<>(lista);
	}
	
}
