package projeto.service;

import projeto.models.Passageiro;

public record PassageiroDados(//serve para copiar os dados da tela do usuário para validar no service
    String nome,
    String cpf,
    String email
) {
	public Passageiro toModel() {
		return new Passageiro(nome, cpf, email);
	}
}
