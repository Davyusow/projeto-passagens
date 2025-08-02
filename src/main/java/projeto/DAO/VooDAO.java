package projeto.DAO;

import java.util.List;

import projeto.models.Voo.Voo;

public interface VooDAO {

    public void criarVoo(Voo voo);

    public Voo procurarVoo(int id);

    public boolean editarVoo(Voo voo);

    public boolean removerVoo(Voo voo);

    public List<Voo> findAll();
}
