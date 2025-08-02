package projeto.DAO;

import java.util.List;

import projeto.models.Voo.Voo;
import projeto.repos.RepositorioVoos;

public class VooDAOImpl implements VooDAO{

    private final RepositorioVoos repositorioVoos = RepositorioVoos.getInstance() ;

    @Override
    public void criarVoo(Voo voo) {
        repositorioVoos.criarVoo(voo);
    }

    @Override
    public Voo procurarVoo(int id) {
        return repositorioVoos.procurarVoo(id);
    }

    @Override
    public boolean editarVoo(Voo voo) {
        return repositorioVoos.editarVoo(voo);
    }

    @Override
    public boolean removerVoo(Voo voo) {
        return repositorioVoos.removerVoo(voo);
    }

    @Override
    public List<Voo> findAll() {
        return repositorioVoos.findAll();
    }

}
