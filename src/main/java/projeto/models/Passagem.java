package projeto.models;

import java.util.Objects;

import projeto.models.Voo.Voo;

public class Passagem {
	
	private int id;
    private Passageiro passageiro;
    private Voo voo;
    private String assento;

    public Passagem(int id, Passageiro passageiro, Voo voo, String assento) {
        this.id = id;
    	this.passageiro = passageiro;
        this.voo = voo;
        this.assento = assento;
    }
    
    public Passagem() {
    }
    
    public int getId() {
    	return id;
    }
    
    public void setId(int id) {
    	this.id = id;
    }

    public Passageiro getPassageiro() {
        return passageiro;
    }

    public void setPassageiro(Passageiro passageiro) {
        this.passageiro = passageiro;
    }

    public Voo getVoo() {
        return voo;
    }

    public void setVoo(Voo voo) {
        this.voo = voo;
    }

    public String getAssento() {
        return assento;
    }

    public void setAssento(String assento) {
        this.assento = assento;
    }

    @Override
    public String toString() {
        return "Passagem{" +
                "passageiro=" + passageiro +
                ", voo=" + voo +
                ", assento='" + assento + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Passagem passagem = (Passagem) o;
        return Objects.equals(passageiro, passagem.passageiro) && Objects.equals(voo, passagem.voo) && Objects.equals(assento, passagem.assento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passageiro, voo, assento);
    }
}
