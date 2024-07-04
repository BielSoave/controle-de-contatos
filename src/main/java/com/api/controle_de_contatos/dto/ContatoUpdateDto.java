package com.api.controle_de_contatos.dto;

import com.api.controle_de_contatos.enums.ContatoTipoEnum;
import io.swagger.v3.oas.annotations.media.Schema;

public record ContatoUpdateDto(
        @Schema(description = "Tipo de contato", allowableValues = {"0", "1"})
        ContatoTipoEnum tipo,
        String contato
) {
}
