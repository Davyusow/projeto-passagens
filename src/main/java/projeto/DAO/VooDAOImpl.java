package projeto.DAO;

import java.util.List;

import projeto.models.Voo.Voo;
import projeto.repos.RepositorioVoos;

public class VooDAOImpl implements ObjectDAO<Voo> {

    private final RepositorioVoos repositorio = RepositorioVoos.getInstance() ;

    @Override
    public void criar(Voo voo) {
        repositorio.criarVoo(voo);
    }

    @Override
    public Voo procurar(int id) {
        return repositorio.procurarVoo(id);
    }

    @Override
    public boolean editar(Voo voo) {
        return repositorio.editarVoo(voo);
    }

    @Override
    public boolean remover(Voo voo) {
    	return repositorio.removerVoo(voo);
    }

    @Override
    public List<Voo> findAll() {   
        return repositorio.findAll();
    }
    
    public Integer getContador() {
    	return repositorio.getContador().get();
    }

    public boolean ocuparAssento(int idVoo, String assento) {
        Voo voo = procurar(idVoo);
        if (voo != null) {
            voo.ocuparAssento(assento);
            return editar(voo);
        }
        return false;
    }
    
    public boolean liberarAssento(int idVoo, String assento) {
        Voo voo = procurar(idVoo);
        if (voo != null) {
            voo.liberarAssento(assento);
            return editar(voo);
        }
        return false;
    }
}
