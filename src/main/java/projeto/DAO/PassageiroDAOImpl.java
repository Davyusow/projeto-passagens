package projeto.DAO;

import projeto.models.Passageiro;
import projeto.repos.RepositorioPassageiros;

import java.util.List;

public class PassageiroDAOImpl implements PassageiroDAO{
    private final RepositorioPassageiros repositorio = RepositorioPassageiros.getInstance();

    public void criarPassageiro(Passageiro passageiro){
        repositorio.criarPassageiro(passageiro);
    }

    public Passageiro procurarPassageiro(int id){
        Passageiro buscado = repositorio.procurarPassageiro(id);
        return buscado;
    }

    public boolean editarPassageiro(Passageiro passageiro){
       return false;
    }

    public boolean removerPassageiro(Passageiro passageiro){
        boolean existe = repositorio.removerPassageiro(passageiro);
        if(!existe){
            //Exceção: ObjectNonExistentException
        }
        return existe;
    }

    public List<Passageiro> findAll(){
        List<Passageiro> lista = repositorio.getPassageiros();
        if(lista == null) {
            //Exceção: EmptyListException
        }
        return lista;
    }
}
