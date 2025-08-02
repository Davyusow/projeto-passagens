package projeto.DAO;

import projeto.models.Passageiro;
import projeto.repos.RepositorioPassageiros;

import java.util.List;

public class PassageiroDAOImpl implements ObjectDAO<Passageiro> {
    private final RepositorioPassageiros repositorio = RepositorioPassageiros.getInstance();

    public void criar(Passageiro passageiro){
        repositorio.criarPassageiro(passageiro);
    }

    public Passageiro procurar(int id){
        Passageiro buscado = repositorio.procurarPassageiro(id);
        return buscado;
    }

    public boolean editar(Passageiro passageiro){
       return false;
    }

    public boolean remover(Passageiro passageiro){
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
