package projeto.service;

public record PassageiroDados(//serve para copiar os dados da tela do usuário para validar no service
    String nome,
    String cpf,
    String email
) {}
