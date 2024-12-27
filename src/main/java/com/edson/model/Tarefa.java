package com.edson.model;

import com.edson.enums.Status;

public class Tarefa {
    private static int contadorId = 1;
    private int id;
    private String descricao;
    private Status status;

    public Tarefa() {
        this.id = contadorId++;
    }

    public Tarefa(String descricao, Status status) {
        this.id = contadorId++;
        this.descricao = descricao;
        this.status = status;
    }

    public Tarefa(int id, String descricao, Status status) {
        this.id = id;
        this.descricao = descricao;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public static void atualizarContadorId(int maiorId) {
        contadorId = maiorId + 1;
    }

    @Override
    public String toString() {
        return "Tarefa{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
