package projeto.DAO;

import projeto.models.Passageiro;
import projeto.repos.RepositorioPassageiros;

import java.util.List;

public class PassageiroDAOImpl implements ObjectDAO<Passageiro> {
    
	private final RepositorioPassageiros repositorio = RepositorioPassageiros.getInstance();

	@Override
    public void criar(Passageiro passageiro) {
        repositorio.criarPassageiro(passageiro);
    }

	@Override
    public Passageiro procurar(int id) {
        return repositorio.procurarPassageiro(id);
    }

	@Override
    public boolean editar(Passageiro passageiro) {
       return repositorio.editarPassageiro(passageiro);
    }
	
	@Override
    public boolean remover(Passageiro passageiro) {
        return repositorio.removerPassageiro(passageiro);
    }

	@Override
    public List<Passageiro> findAll() {
        return repositorio.getPassageiros();
    }
	
	public Integer getContador() {
		return repositorio.getContador().get();
	}
}
