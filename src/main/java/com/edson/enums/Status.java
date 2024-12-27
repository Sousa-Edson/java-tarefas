package com.edson.enums;

public enum Status {
    PENDENTE(1,"Pendente"),
    EM_ANDAMENTO(2,"Em andamento"),
    CONCLUIDA(3,"Concluida");

    private int id;
    private String descricao;

    Status(int id,String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
