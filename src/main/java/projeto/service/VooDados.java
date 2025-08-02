package projeto.service;

import java.time.LocalDate;
import java.time.LocalTime;

public record VooDados( //serve para copiar os dados da tela do usuário para validar no service
    String origem,
    String destino,
    String quantidade,
    LocalDate data,
    LocalTime horaEmbarque,
    LocalTime horaChegada,
    boolean isInternational
) {}
