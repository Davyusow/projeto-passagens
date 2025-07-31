package projeto.models;
import java.time.*;
import java.util.Objects;

abstract class Voo {
    protected String Codigo;
    protected LocalDateTime HorarioEmbarque;
    protected LocalDateTime HorarioChegadaEstimada;
    protected Integer QtdPassageiros;
    String LocalEmbarque;
    String LocalChegada;

    public Voo(String codigo, LocalDateTime horarioEmbarque, LocalDateTime horarioChegadaEstimada, Integer qtdPassageiros, String localEmbarque, String localChegada) {
        this.Codigo = codigo;
        this.HorarioEmbarque = horarioEmbarque;
        this.HorarioChegadaEstimada = horarioChegadaEstimada;
        this.QtdPassageiros = qtdPassageiros;
        this.LocalEmbarque = localEmbarque;
        this.LocalChegada = localChegada;
    }
    public Voo(){
        Codigo = "0000";
        HorarioEmbarque = LocalDateTime.now();
        HorarioChegadaEstimada = HorarioEmbarque.plusHours(5);
        QtdPassageiros = 1;
        LocalEmbarque = "";
        LocalChegada =  "";

    }

    public abstract double calcularPreco();

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String codigo) {
        Codigo = codigo;
    }

    public LocalDateTime getHorarioEmbarque() {
        return HorarioEmbarque;
    }

    public void setHorarioEmbarque(LocalDateTime horarioEmbarque) {
        HorarioEmbarque = horarioEmbarque;
    }

    public LocalDateTime getHorarioChegadaEstimada() {
        return HorarioChegadaEstimada;
    }

    public void setHorarioChegadaEstimada(LocalDateTime horarioChegadaEstimada) {
        HorarioChegadaEstimada = horarioChegadaEstimada;
    }

    public Integer getQtdPassageiros() {
        return QtdPassageiros;
    }

    public void setQtdPassageiros(Integer qtdPassageiros) {
        QtdPassageiros = qtdPassageiros;
    }

    public String getLocalEmbarque() {
        return LocalEmbarque;
    }

    public void setLocalEmbarque(String localEmbarque) {
        LocalEmbarque = localEmbarque;
    }

    public String getLocalChegada() {
        return LocalChegada;
    }

    public void setLocalChegada(String localChegada) {
        LocalChegada = localChegada;
    }
abstract class VooNacional extends Voo {
    public VooNacional(String codigo, LocalDateTime horarioEmbarque, LocalDateTime horarioChegadaEstimada, Integer qtdPassageiros, String localEmbarque, String localChegada) {
        super(codigo, horarioEmbarque, horarioChegadaEstimada, qtdPassageiros, localEmbarque, localChegada);
    }

    @Override
    public double calcularPreco() {
        return 500;
    }
}
abstract class VooInternacional extends Voo {
    public VooInternacional(String codigo, LocalDateTime horarioEmbarque, LocalDateTime horarioChegadaEstimada, Integer qtdPassageiros, String LocalEmbarque, String LocalChegada) {
        super(codigo, horarioEmbarque, horarioChegadaEstimada, qtdPassageiros, LocalEmbarque, LocalChegada);
    }

    @Override
    public double calcularPreco() {
        return 1000;
    }
}

    @Override
    public String toString() {
        return "Voo{" +
                "Codigo='" + Codigo + '\'' +
                ", HorarioEmbarque=" + HorarioEmbarque +
                ", HorarioChegadaEstimada=" + HorarioChegadaEstimada +
                ", QtdPassageiros=" + QtdPassageiros +
                ", LocalEmbarque='" + LocalEmbarque + '\'' +
                ", LocalChegada='" + LocalChegada + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Voo voo = (Voo) o;
        return Objects.equals(Codigo, voo.Codigo) && Objects.equals(HorarioEmbarque, voo.HorarioEmbarque) && Objects.equals(HorarioChegadaEstimada, voo.HorarioChegadaEstimada) && Objects.equals(QtdPassageiros, voo.QtdPassageiros) && Objects.equals(LocalEmbarque, voo.LocalEmbarque) && Objects.equals(LocalChegada, voo.LocalChegada);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Codigo, HorarioEmbarque, HorarioChegadaEstimada, QtdPassageiros, LocalEmbarque, LocalChegada);
    }
}
