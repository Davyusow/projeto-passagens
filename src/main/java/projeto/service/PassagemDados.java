package projeto.service;

import projeto.models.Passageiro;
import projeto.models.Passagem;
import projeto.models.Voo.Voo;

public record PassagemDados(
        Passageiro passageiro,
        Voo voo,
        String assento
){
    public Passagem toModel() {
        return new Passagem(passageiro, voo, assento);
   }
}
