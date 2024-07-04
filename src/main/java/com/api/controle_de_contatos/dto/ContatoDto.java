package com.api.controle_de_contatos.dto;

import com.api.controle_de_contatos.enums.ContatoTipoEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;

public record ContatoDto(
        @Schema(description = "Tipo de contato", allowableValues = {"0", "1"})
        ContatoTipoEnum tipo,
        String contato,
        Long pessoaId
) {
}
