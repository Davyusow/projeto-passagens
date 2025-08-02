package projeto.models.Voo;

import java.time.LocalDateTime;

public class VooNacional extends Voo {
    
	private final String tipo = "Nacional";
    
    public VooNacional(String codigo, LocalDateTime horarioEmbarque, LocalDateTime horarioChegadaEstimada, Integer qtdPassageiros, String localEmbarque, String localChegada) {
        super(codigo, horarioEmbarque, horarioChegadaEstimada, qtdPassageiros, localEmbarque, localChegada);
    }

    public String getTipo() {
        return this.tipo;
    }

    @Override
    public double calcularPreco() {
        return 500;
    }
}
