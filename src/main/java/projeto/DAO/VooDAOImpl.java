package projeto.DAO;

import java.util.List;

import projeto.models.Passageiro;
import projeto.models.Voo.Voo;
import projeto.repos.RepositorioVoos;

public class VooDAOImpl implements ObjectDAO<Voo>{

    private final RepositorioVoos repositorioVoos = RepositorioVoos.getInstance() ;

    @Override
    public void criar(Voo voo) {
        repositorioVoos.criarVoo(voo);
    }

    @Override
    public Voo procurar(int id) {
        return repositorioVoos.procurarVoo(id);
    }

    @Override
    public boolean editar(Voo voo) {
        return repositorioVoos.editarVoo(voo);
    }

    @Override
    public boolean remover(Voo voo) {
    	boolean existe = repositorioVoos.removerVoo(voo);
    	if (!existe) {
    		//Exceção: objeto não existe
    	}
    
    	return existe;
    }

    @Override
    public List<Voo> findAll() {
        List<Voo> lista = repositorioVoos.findAll();
        if (lista == null) {
        	//exceção: lista vazia
        }
                
        return lista;
    }
}
