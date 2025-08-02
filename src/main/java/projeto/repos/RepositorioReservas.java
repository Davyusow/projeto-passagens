package projeto.repos;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import projeto.exceptions.ReservaNEncontradaException;
import projeto.exceptions.VooNEncontradoException;
import projeto.models.Reserva;
import projeto.models.Voo.Voo;

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

	private Reserva buscarReservaPorId(int id) {
		for (Reserva reserva : reservas) {
			if (reserva.getId() == id) {
				return reserva;
			}
		}
		return null;
	}

	public Reserva procurarReserva(int id) throws ReservaNEncontradaException {
		Reserva reserva = buscarReservaPorId(id);
		if (reserva == null) {
			throw new ReservaNEncontradaException("Reserva com ID " + id + " não encontrada");
		}
		return reserva;
	}
	
	public boolean editarReserva(Reserva reserva) throws ReservaNEncontradaException {
		Reserva busca = buscarReservaPorId(reserva.getId());
		if (busca == null) {
			throw new ReservaNEncontradaException("Reserva não encontrada");
		}
		
		Reserva reservaExistente = reservas.get(reserva.getId());
		reservaExistente.setIdPassageiro(reserva.getIdPassageiro());
		reservaExistente.setIdPassagem(reserva.getIdPassageiro());
		reservaExistente.setIdVoo(reserva.getIdVoo());
		return true;
	}

	public boolean removerReserva(Reserva reserva) throws ReservaNEncontradaException {
		Reserva busca = buscarReservaPorId(reserva.getId());
		if (busca == null) {
			throw new ReservaNEncontradaException("Reserva não encontrada");

		}
		
		reservas.remove(busca);
		return true;
	}
	
	public List<Reserva> findAll() {
		return new ArrayList<>(reservas); 
	}
}
