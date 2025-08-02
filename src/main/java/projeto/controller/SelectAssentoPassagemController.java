package projeto.controller;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import projeto.models.Passageiro;
import projeto.models.Voo.Voo;
import projeto.service.AssentoService;
import projeto.service.PassagemDados;
import projeto.util.Aviso;
import projeto.view.TelaEntradaView;

public class SelectAssentoPassagemController extends FuncoesComunsController {

    @FXML
    private Label textoNumeroVoo;
    @FXML
    private Label textoDestino;
    @FXML
    private Label textoData;
    @FXML
    private Label textoPassageiro;
    @FXML
    private GridPane gridAssentos;
    @FXML
    private Button btConfirmar;

    private static Voo vooSelecionado;
    private static Passageiro passageiroSelecionado;
    private String assentoSelecionado;
    private AssentoService service = new AssentoService();

    @SuppressWarnings("exports")
    public static void setVoo(Voo voo) {
        vooSelecionado = voo;
    }

    public static void setPassageiro(Passageiro passageiro) {
        passageiroSelecionado = passageiro;
    }

    @FXML
    public void initialize() {
        if (vooSelecionado != null && passageiroSelecionado != null) {
            textoNumeroVoo.setText(String.valueOf(vooSelecionado.getId()));
            textoDestino.setText(vooSelecionado.getLocalChegada());
            textoData.setText(
                    vooSelecionado.getHorarioChegadaEstimada().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            textoPassageiro.setText(passageiroSelecionado.getNome());

            carregarAssentos();
        }
    }

    @SuppressWarnings("unused")
    private void carregarAssentos() {
        try {
            gridAssentos.getChildren().clear();

            int colunas = 6;
            int capacidade = vooSelecionado.getQtdPassageiros();
            int fileiras = (int) Math.ceil((double) capacidade / colunas);

            for (int fileira = 0; fileira < fileiras; fileira++) {
                for (int coluna = 0; coluna < colunas; coluna++) {
                    int assentoNum = fileira * colunas + coluna + 1;
                    if (assentoNum > capacidade)
                        break;

                    String assento = String.format("%02d", assentoNum);
                    Button btAssento = new Button(assento);
                    btAssento.setPrefSize(40, 40);

                    if (verificarAssentoOcupado(assento)) {
                        btAssento.setStyle("-fx-background-color: #c41313ff; -fx-text-fill: #666;");
                        btAssento.setDisable(true);
                    }
                    if (!verificarAssentoOcupado(assento)) {
                        btAssento.setStyle("-fx-background-color: #e6f7ff;");
                        btAssento.setOnAction(evento -> selecionarAssento(assento, btAssento));
                    }

                    gridAssentos.add(btAssento, coluna, fileira);
                }
            }
        } catch (Exception e) {
            Aviso.erro("Erro", "Erro inesperado ao carregar os assentos");
        }
    }

    private boolean verificarAssentoOcupado(String assento) {
        return vooSelecionado.isAssentoOcupado(assento);
    }

    private void selecionarAssento(String assento, Button btn) {
        gridAssentos.getChildren().forEach(node -> {
            if (node instanceof Button) {
                ((Button) node).setStyle("-fx-background-color: #e6f7ff;");
            }
        });

        btn.setStyle("-fx-background-color: #99ccff; -fx-font-weight: bold;");
        assentoSelecionado = assento;
        btConfirmar.setDisable(false);
    }

    @FXML
    private void handleVoltar(javafx.event.ActionEvent evento) throws IOException {
            trocarTela(evento, TelaEntradaView.carregar(), "Menu Inicial");
    }

    @FXML
    private void handleConfirmar(javafx.event.ActionEvent evento) throws IOException {
        if (assentoSelecionado != null) {
            try {
                PassagemDados dados = new PassagemDados(passageiroSelecionado, vooSelecionado, assentoSelecionado);                
                service.realizarReserva(dados);

                trocarTela(evento, TelaEntradaView.carregar(), "Confirmação");

            } catch (Exception e) {
                Aviso.erro("Erro", "Erro ao salvar a reserva");
            }

        }
    }
}