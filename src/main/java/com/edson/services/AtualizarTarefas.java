package com.edson.services;

import com.edson.enums.Status;
import com.edson.model.Tarefa;

import java.util.List;
import java.util.Scanner;

public class AtualizarTarefas {
    public static void atualizarTarefa(List<Tarefa> tarefas) {
        System.out.println("#Atualizar uma tarefa:");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o ID da tarefa:");
        try {
            int id = scanner.nextInt();
            scanner.nextLine();
            Tarefa tarefaEncontrada = null;
            for(Tarefa tarefa : tarefas){
                if(tarefa.getId()==id) {
                    tarefaEncontrada=tarefa;
                    break;
                }
            }
            if(tarefaEncontrada!=null){
                System.out.println("Tarefa encntrada: "+tarefaEncontrada);
                System.out.println("Selecione o novo status da tarefa:");
                System.out.println();
                System.out.println("1-Pendente");
                System.out.println("2-Em andamento");
                System.out.println("3-Concluida");
                String novoStatus = scanner.nextLine();
                switch (novoStatus) {
                    case "pendente", "1" -> tarefaEncontrada.setStatus(Status.PENDENTE);
                    case "em andamento", "2" -> tarefaEncontrada.setStatus(Status.EM_ANDAMENTO);
                    case "concluida", "3" -> tarefaEncontrada.setStatus(Status.CONCLUIDA);
                    default -> {
                        System.out.println("Status inválido. Tente novamente.");
                        tarefaEncontrada.setStatus(Status.PENDENTE);
                    }
                }

                System.out.println("Status da tarefa atualizada com sucesso!");
            }else{
                System.out.println("Tarefa com o ID informado não foi encontrada.");
            }
        }catch (Exception e){
            System.out.println("ID inválido. Tente novamente.");
            scanner.nextLine();
        }
    }
}
