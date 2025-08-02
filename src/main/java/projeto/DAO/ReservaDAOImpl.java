package projeto.DAO;

import java.util.List;
import java.util.stream.Collectors;

import projeto.models.Reserva;
import projeto.repos.RepositorioReservas;

public class ReservaDAOImpl implements ObjectDAO<Reserva> {
	
	private final RepositorioReservas repositorio = RepositorioReservas.getInstance();

	@Override
	public void criar(Reserva reserva) {
		repositorio.criarReserva(reserva);
	}
	
	@Override
	public Reserva procurar(int id) {
		return repositorio.procurarReserva(id);
	}
	
	@Override
	public boolean editar(Reserva reserva) {
		return repositorio.editarReserva(reserva);
	}
	
	@Override
	public boolean remover(Reserva reserva) {
		return repositorio.removerReserva(reserva);
	}
	
	@Override
	public List<Reserva> findAll() {
		return repositorio.getReservas();
	}

	public List<Reserva> findReservaPassageiro(int idPassageiro){
		return repositorio.getReservas().stream()
            .filter(r -> r.getIdPassageiro() == idPassageiro)
            .collect(Collectors.toList());
	}

}
