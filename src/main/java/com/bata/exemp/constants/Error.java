package com.bata.exemp.constants;

public enum Error {

    CONTA_INEXISTENTE("E01", "A conta indicada não foi encontrada.");

    final String codErro;
    final String mensagem;
    Error(String codErro, String mensagem){
        this.codErro = codErro;
        this.mensagem = mensagem;
    }
}
