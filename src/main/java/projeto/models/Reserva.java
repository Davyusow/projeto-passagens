package projeto.models;
import java.util.ArrayList;
import java.util.List;
public class Reserva {
    private List<Passagem> passagens;

public Reserva() {
    this.passagens = new ArrayList<>();
}

public void adicionarPassagem(Passagem passagem){
    passagens.add(passagem);
}
public List<Passagem> getPassagens() {
    return passagens;
}


}
