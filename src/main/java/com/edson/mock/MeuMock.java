package com.edson.mock;

import com.edson.enums.Status;
import com.edson.model.Tarefa;

import java.util.List;

public class MeuMock {
    public static void mock(List<Tarefa> tarefas) {
        tarefas.add(new Tarefa( "Tarefa 1", Status.CONCLUIDA));
        tarefas.add(new Tarefa( "Tarefa 2", Status.EM_ANDAMENTO));
        tarefas.add(new Tarefa( "Tarefa 3", Status.PENDENTE));
        tarefas.add(new Tarefa( "Tarefa 4", Status.CONCLUIDA));
        tarefas.add(new Tarefa( "Tarefa 5", Status.EM_ANDAMENTO));
    }
}
