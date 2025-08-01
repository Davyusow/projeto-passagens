package projeto.DAO;

import projeto.models.Passageiro;

import java.util.List;

public interface PassageiroDAO {

    public void criarPassageiro(Passageiro passageiro);

    public Passageiro procurarPassageiro(int id);

    public boolean editarPassageiro(Passageiro passageiro);

    public boolean removerPassageiro(Passageiro passageiro);

    public List<Passageiro> findAll();
}
