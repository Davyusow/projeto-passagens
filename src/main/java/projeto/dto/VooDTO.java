package projeto.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public record VooDTO(
    String origem,
    String destino,
    String quantidade,
    LocalDate data,
    LocalTime horaEmbarque,
    LocalTime horaChegada,
    boolean isInternational
) {}
