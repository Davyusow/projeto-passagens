package projeto.exceptions;

public class ObjetoNaoExisteException extends RuntimeException {
	
	public ObjetoNaoExisteException(String mensagem) {
		super(mensagem);
	}
}
