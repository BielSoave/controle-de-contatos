package com.api.controle_de_contatos.enums;

import io.swagger.v3.oas.annotations.media.Schema;

public enum ContatoTipoEnum {
    @Schema(description = "Tipo 0")
    TELEFONE(0),
    @Schema(description = "Tipo 1")
    CELULAR(1);

    ContatoTipoEnum(int value) {
    }
}
