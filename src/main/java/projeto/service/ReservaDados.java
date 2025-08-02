package projeto.service;

import projeto.models.Reserva;

public record ReservaDados(
    Integer passageiroId,
    Integer passagemId,
    Integer vooId
) {
    public Reserva toModel() {
        return new Reserva(passageiroId, passagemId, vooId);
    }
}
