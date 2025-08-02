package projeto.models.Voo;

import java.time.LocalDateTime;

public class VooInternacional extends Voo {

    private final String tipo = "Internacional";

    public VooInternacional(String codigo, LocalDateTime horarioEmbarque, LocalDateTime horarioChegadaEstimada,
            Integer qtdPassageiros, String LocalEmbarque, String LocalChegada) {
        super(codigo, horarioEmbarque, horarioChegadaEstimada, qtdPassageiros, LocalEmbarque, LocalChegada);
    }

    public String getTipo() {
        return this.tipo;
    }

    @Override
    public double calcularPreco() {
        return 1000;
    }
}
