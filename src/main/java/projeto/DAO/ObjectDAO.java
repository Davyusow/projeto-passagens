package projeto.DAO;

import java.util.List;

public interface ObjectDAO<N> {
	
	public void criar(N o);
	
	public N procurar(int id);
	
	public boolean editar(N o);
	
	public boolean remover(N o);
	
	public List<N> findAll();
}
