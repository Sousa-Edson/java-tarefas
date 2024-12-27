package com.edson.services;

import com.edson.model.Tarefa;

import java.util.List;
import java.util.Scanner;

public class DeletarTarefas {
    public static void deletarTarefa(List<Tarefa> tarefas) {
        System.out.println("#Deletar uma tarefa:");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o ID da tarefa:");
        try {
            int id = scanner.nextInt();
            for(Tarefa tarefa : tarefas){
                if(tarefa.getId()==id) {
                    tarefas.remove(tarefa);
                    System.out.println("Tarefa REMOVIDA com sucesso");
                    break;
                }
            }
        }catch (Exception e){
            System.out.println("ID inválido. Tente novamente.");
            scanner.nextLine();
        }
    }
}
