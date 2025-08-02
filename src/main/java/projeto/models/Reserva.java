package projeto.models;


public class Reserva {
	
	private int id;
	private int idPassageiro;
	private int idPassagem;
	private int idVoo;
	
    public Reserva(int id, int idPassageiro, int idPassagem, int idVoo) {
    	this.setId(id);
    	this.setIdPassageiro(idPassageiro);
    	this.setIdPassagem(idPassagem);
    	this.setIdVoo(idVoo);
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdPassageiro() {
		return idPassageiro;
	}

	public void setIdPassageiro(int idPassageiro) {
		this.idPassageiro = idPassageiro;
	}

	public int getIdPassagem() {
		return idPassagem;
	}

	public void setIdPassagem(int idPassagem) {
		this.idPassagem = idPassagem;
	}

	public int getIdVoo() {
		return idVoo;
	}

	public void setIdVoo(int idVoo) {
		this.idVoo = idVoo;
	}

	@Override
	public String toString() {
		return "Reserva{" +
				"id=" + id +
				", idPassageiro=" + idPassageiro +
				", idPassagem=" + idPassagem +
				", idVoo=" + idVoo +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) return false;
		Reserva reserva = (Reserva) o;
		return id == reserva.id &&
				idPassageiro == reserva.idPassageiro &&
				idPassagem == reserva.idPassagem &&
				idVoo == reserva.idVoo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, idPassageiro, idPassagem, idVoo);
	}
}
