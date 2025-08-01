package projeto.models;

import java.util.Objects;

public class Passageiro {
	
	private int id;
    private String nome;
    private String cpf;
    private String email;

    public Passageiro(int id, String nome, String cpf, String email) {
    	this.id = id; 
    	this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    public Passageiro() {
    	this.nome = "";
    	this.cpf = "0";
    	this.email = "@";
    }
    
    public int getId() {
    	return id;
    }
    
    public void setId(int id) {
    	this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Passageiro {" +
        		"id='" + id + '\'' +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Passageiro passageiro = (Passageiro) o;
        return Objects.equals(id, passageiro.id) &&
        		Objects.equals(nome, passageiro.nome) &&
        		Objects.equals(cpf, passageiro.cpf) &&
        		Objects.equals(email, passageiro.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, cpf, email);
    }
}
