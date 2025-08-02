package projeto.models.Voo;

import java.time.*;
import java.util.Objects;

public abstract class Voo {
	
	private int id;
    private String codigo;
    private LocalDateTime horarioEmbarque;
    private LocalDateTime horarioChegadaEstimada;
    private Integer qtdPassageiros;
    private String localEmbarque;
    private String localChegada;

    public Voo(String codigo, LocalDateTime horarioEmbarque, LocalDateTime horarioChegadaEstimada, Integer qtdPassageiros, String localEmbarque, String localChegada) {
    	this.codigo = codigo;
        this.horarioEmbarque = horarioEmbarque;
        this.horarioChegadaEstimada = horarioChegadaEstimada;
        this.qtdPassageiros = qtdPassageiros;
        this.localEmbarque = localEmbarque;
        this.localChegada = localChegada;
    }
    
    public Voo() {
        codigo = "0000";
        horarioEmbarque = LocalDateTime.now();
        horarioChegadaEstimada = horarioEmbarque.plusHours(5);
        qtdPassageiros = 1;
        localEmbarque = "";
        localChegada =  "";

    }

    public abstract double calcularPreco();
    
    public int getId() {
    	return id;
    }
    
    public void setId(int id) {
    	this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public LocalDateTime getHorarioEmbarque() {
        return horarioEmbarque;
    }

    public void setHorarioEmbarque(LocalDateTime horarioEmbarque) {
        this.horarioEmbarque = horarioEmbarque;
    }

    public LocalDateTime getHorarioChegadaEstimada() {
        return horarioChegadaEstimada;
    }

    public void setHorarioChegadaEstimada(LocalDateTime horarioChegadaEstimada) {
        this.horarioChegadaEstimada = horarioChegadaEstimada;
    }

    public Integer getQtdPassageiros() {
        return qtdPassageiros;
    }

    public void setQtdPassageiros(Integer qtdPassageiros) {
        this.qtdPassageiros = qtdPassageiros;
    }

    public String getLocalEmbarque() {
        return localEmbarque;
    }

    public void setLocalEmbarque(String localEmbarque) {
        this.localEmbarque = localEmbarque;
    }

    public String getLocalChegada() {
        return localChegada;
    }

    public void setLocalChegada(String localChegada) {
        this.localChegada = localChegada;
    }

    @Override
    public String toString() {
        return "Voo{" +
        		"id='" + id + '\'' +
                "Codigo='" + codigo + '\'' +
                ", HorarioEmbarque=" + horarioEmbarque +
                ", HorarioChegadaEstimada=" + horarioChegadaEstimada +
                ", QtdPassageiros=" + qtdPassageiros +
                ", LocalEmbarque='" + localEmbarque + '\'' +
                ", LocalChegada='" + localChegada + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Voo voo = (Voo) o;
        return Objects.equals(id, voo.id) &&
        		Objects.equals(codigo, voo.codigo) &&
        		Objects.equals(horarioEmbarque, voo.horarioEmbarque) &&
        		Objects.equals(horarioChegadaEstimada, voo.horarioChegadaEstimada) &&
        		Objects.equals(qtdPassageiros, voo.qtdPassageiros) &&
        		Objects.equals(localEmbarque, voo.localEmbarque) &&
        		Objects.equals(localChegada, voo.localChegada);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, codigo, horarioEmbarque, horarioChegadaEstimada, qtdPassageiros, localEmbarque, localChegada);
    }
}
