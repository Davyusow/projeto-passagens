package projeto.controller;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import projeto.DAO.ObjectDAO;
import projeto.DAO.PassagemDAOImpl;
import projeto.DAO.VooDAOImpl;
import projeto.models.Passageiro;
import projeto.models.Passagem;
import projeto.models.Voo.Voo;
import projeto.util.Aviso;
import projeto.view.TelaEntradaView;

public class SelectAssentoPassagemController extends FuncoesComunsController {

    @FXML
    private Label lblNumeroVoo;
    @FXML
    private Label lblDestino;
    @FXML
    private Label lblData;
    @FXML
    private Label lblPassageiro;
    @FXML
    private GridPane gridAssentos;
    @FXML
    private Button btnConfirmar;

    private static Voo vooSelecionado;
    private static Passageiro passageiroSelecionado;
    private String assentoSelecionado;

    public static void setVoo(Voo voo) {
        vooSelecionado = voo;
    }

    public static void setPassageiro(Passageiro passageiro) {
        passageiroSelecionado = passageiro;
    }

    @FXML
    public void initialize() {
        atualizarInformacoesPassageiro();
        atualizarInformacoesVoo();
    }

    private void atualizarInformacoesVoo() {
        if (vooSelecionado != null) {
            lblNumeroVoo.setText(String.valueOf(vooSelecionado.getId()));
            lblDestino.setText(vooSelecionado.getLocalChegada());
            lblData.setText(vooSelecionado.getHorarioChegadaEstimada()
                    .format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

            carregarAssentos();
        }
    }

    private void atualizarInformacoesPassageiro() {
        if (passageiroSelecionado != null) {
            lblPassageiro.setText(passageiroSelecionado.getNome());
        }
    }

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
                    Button btnAssento = new Button(assento);
                    btnAssento.setPrefSize(40, 40);

                    if (verificarAssentoOcupado(assento)) {
                        btnAssento.setStyle("-fx-background-color: #ffcccc; -fx-text-fill: #666;");
                        btnAssento.setDisable(true);
                    } else {
                        btnAssento.setStyle("-fx-background-color: #e6f7ff;");
                        btnAssento.setOnAction(e -> selecionarAssento(assento, btnAssento));
                    }

                    gridAssentos.add(btnAssento, coluna, fileira);
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
        btnConfirmar.setDisable(false);
    }

    @FXML
    private void handleVoltar(javafx.event.ActionEvent evento) throws IOException {
        if (Aviso.confirmacao("Confirmação", "Tem certeza que deseja sair?"))
            trocarTela(evento, TelaEntradaView.carregar(), "Menu Inicial");
    }

    @FXML
    private void handleConfirmar(javafx.event.ActionEvent evento) throws IOException {
        try {
            if (assentoSelecionado == null) {
                Aviso.informacao("Aviso", "Selecione um assento");
                return;
            }
            if (Aviso.confirmacao("Confirmação", "Deseja escolher este assento?")) {
                try {
                    Passagem passagem = new Passagem(0, passageiroSelecionado, vooSelecionado, assentoSelecionado);
                    ObjectDAO<Passagem> passagemDAO = new PassagemDAOImpl();
                    passagemDAO.criar(passagem);

                    VooDAOImpl vooDAO = new VooDAOImpl();
                    if (!vooDAO.ocuparAssento(vooSelecionado.getId(), assentoSelecionado)) {
                        throw new Exception("Falha ao ocupar assento no banco de dados");
                    }

                    trocarTela(evento, TelaEntradaView.carregar(), "Confirmação");

                } catch (Exception e) {
                    Aviso.erro("Erro", "Erro ao salvar a reserva");
                }

            }

        } catch (Exception e) {
            Aviso.erro("Erro", "Erro inesperado");
        }
    }
}