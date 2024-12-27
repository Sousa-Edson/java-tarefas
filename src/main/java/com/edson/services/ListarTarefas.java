package com.edson.services;

import com.edson.model.Tarefa;

import java.util.List;

public class ListarTarefas {
    public static void listarTarefa(List<Tarefa> tarefas) {
        System.out.println("#Lista de tarefas:");
        for(Tarefa tarefa : tarefas){
            System.out.println(tarefa);
        }
    }
}
