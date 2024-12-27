package com.edson.services;

import com.edson.enums.Status;
import com.edson.model.Tarefa;

import java.util.List;
import java.util.Scanner;

public class CadastrarTarefa {
    public static void cadastrarTarefa(List<Tarefa> tarefas) {
        System.out.println("#Cadastrar tarefa");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite a descricao da tarefa:");
        String descricao = scanner.nextLine();
        Tarefa tarefa = new Tarefa(descricao, Status.PENDENTE);
        tarefas.add(tarefa);
    }
}
