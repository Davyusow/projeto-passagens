package projeto.repos;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

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
	
	public int procurarReserva(int id) {
		for (Reserva r : reservas) {
			if (r.getId() == id) {
				return r.getId();
			}
		}
		return -1;
	}
	
	public boolean editarReserva(Reserva reserva) {
		int busca = procurarReserva(reserva.getId());
		if (busca == -1) {
			return false;
		}
		
		Reserva reservaExistente = reservas.get(busca);
		reservaExistente.setIdPassageiro(reserva.getIdPassageiro());
		reservaExistente.setIdPassagem(reserva.getIdPassageiro());
		reservaExistente.setIdVoo(reserva.getIdVoo());
		return true;
	}

	public boolean removerReserva(Reserva reserva) {
		int busca = procurarReserva(reserva.getId());
		if (busca == -1) {
			return false;
		}
		
		reservas.remove(busca);
		return true;
	}
	
	public List<Reserva> findAll() {
		return new ArrayList<>(reservas); 
	}
}
