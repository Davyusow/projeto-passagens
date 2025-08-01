package projeto.models.Voo;

import java.time.LocalDateTime;

public class VooNacional extends Voo {
    
	public VooNacional(int id, String codigo, LocalDateTime horarioEmbarque, LocalDateTime horarioChegadaEstimada, Integer qtdPassageiros, String localEmbarque, String localChegada) {
        super(id, codigo, horarioEmbarque, horarioChegadaEstimada, qtdPassageiros, localEmbarque, localChegada);
    }

    @Override
    public double calcularPreco() {
        return 500;
    }
}
