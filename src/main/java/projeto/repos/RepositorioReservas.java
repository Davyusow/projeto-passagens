package projeto.repos;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import projeto.exceptions.ListaVaziaException;
import projeto.exceptions.ObjetoNaoEncontradoException;
import projeto.models.Reserva;

public class RepositorioReservas {
	
	private List<Reserva> reservas;
	private static AtomicInteger contador = new AtomicInteger();
	private static RepositorioReservas instance;
	
	public RepositorioReservas() {
		this.reservas = new ArrayList<>();
	}
	
	public List<Reserva> getReservas() {
		return reservas;
	}
	
	public AtomicInteger getContador() {
		return contador;
	}
	
	public static RepositorioReservas getInstance() {
		if (instance == null) {
			instance = new RepositorioReservas();
		}
		return instance;
	}
	
	public void criarReserva(Reserva reserva) {
		reserva.setId(contador.getAndIncrement());
		reservas.add(reserva);
	}

	public Reserva procurarReserva(int id) throws ObjetoNaoEncontradoException {
		boolean idEncontrado = false;
		
		for (Reserva reserva : reservas) {
			if (reserva.getId() == id) {
				return reserva;
			}
		}
		
		if (!idEncontrado) {
			throw new ObjetoNaoEncontradoException("Não foi encontrado nenhum(a) " + " reserva " + " com ID " + id);
		}
		
		return null;
	}
	
	public boolean editarReserva(Reserva reserva) throws ObjetoNaoEncontradoException {
		Reserva busca = procurarReserva(reserva.getId());
		if (busca == null) {
			throw new ObjetoNaoEncontradoException("Tentativa de edição falha:" + " Reserva " +
													reserva.getId() + " não foi  encontrado");
		}
		
		Reserva reservaExistente = reservas.get(reserva.getId());
		reservaExistente.setIdPassageiro(reserva.getIdPassageiro());
		reservaExistente.setIdPassagem(reserva.getIdPassageiro());
		reservaExistente.setIdVoo(reserva.getIdVoo());
		
		return true;
	}

	public boolean removerReserva(Reserva reserva) throws ObjetoNaoEncontradoException {
		Reserva busca = procurarReserva(reserva.getId());
		if (busca == null) {
			throw new ObjetoNaoEncontradoException("Tentativa de remoção falha:" + " Reserva " +
													reserva.getId() + " não foi  encontrado(a)");

		}
		
		reservas.remove(busca);
		return true;
	}
	
	public List<Reserva> findAll() throws ListaVaziaException {
		List<Reserva> lista = this.getReservas();
		
		if (lista.isEmpty()) {
			throw new ListaVaziaException("A lista pedida está vazia");
		}

		return new ArrayList<>(lista);
	}
}
