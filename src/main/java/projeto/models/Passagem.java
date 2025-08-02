package projeto.models;

import java.util.Objects;

import projeto.models.Voo.Voo;
import projeto.models.Voo.VooInternacional;
import projeto.models.Voo.VooNacional;

public class Passagem {
	
	private int id;
    private Passageiro passageiro;
    private Voo voo;
    private String assento;
    // private String tipo; //esses dois são para a tabela
    // private String destino;

    public Passagem(Passageiro passageiro, Voo voo, String assento) {
    
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

    public String getTipo(){
        if(voo instanceof VooInternacional){
            return ((VooInternacional)voo).getTipo();
        }else{
            return ((VooNacional)voo).getTipo();
        }
    }

    public String getDestino(){
        return voo.getLocalChegada();
    }


    @Override
    public String toString() {
        return "Passagem {" +
        		"id='" + id + '\'' + 
                "passageiro=" + passageiro +
                ", voo=" + voo +
                ", assento='" + assento + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Passagem passagem = (Passagem) o;
        return Objects.equals(id, passagem.id) &&
        		Objects.equals(passageiro, passagem.passageiro) &&
        		Objects.equals(voo, passagem.voo) &&
        		Objects.equals(assento, passagem.assento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, passageiro, voo, assento);
    }
}
