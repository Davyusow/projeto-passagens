package projeto.DAO;

import java.util.List;

import projeto.models.Passagem;
import projeto.repos.RepositorioPassagens;

public class PassagemDAOImpl implements ObjectDAO<Passagem> {

	private final RepositorioPassagens repositorio = RepositorioPassagens.getInstance();
	
	@Override
	public void criar(Passagem passagem) {
		repositorio.criarPassagem(passagem);
	}
	
	@Override
	public Passagem procurar(int id) {
		return repositorio.procurarPassagem(id);
	}
	
	@Override
	public boolean editar(Passagem Passagem) {
		return repositorio.editarPassagem(Passagem);
	}
	
	
	@Override
	public boolean remover(Passagem passagem) {
		return repositorio.removerPassagem(passagem);
	}
	
	
	@Override
	public List<Passagem> findAll() {
		return repositorio.getPassagens();
	}
}
