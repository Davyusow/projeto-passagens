package projeto.models.Voo;

import java.time.LocalDateTime;

public class VooInternacional extends Voo {
    
	public VooInternacional(int id, String codigo, LocalDateTime horarioEmbarque, LocalDateTime horarioChegadaEstimada, Integer qtdPassageiros, String LocalEmbarque, String LocalChegada) {
        super(id, codigo, horarioEmbarque, horarioChegadaEstimada, qtdPassageiros, LocalEmbarque, LocalChegada);
    }

    @Override
    public double calcularPreco() {
        return 1000;
    }
}
