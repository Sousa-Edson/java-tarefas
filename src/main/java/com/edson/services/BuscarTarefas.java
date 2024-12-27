package com.edson.services;

import com.edson.model.Tarefa;

import java.util.List;
import java.util.Scanner;

public class BuscarTarefas {
    public static void buscarTarefa(List<Tarefa> tarefas) {
        System.out.println("#Buscar uma tarefa:");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o ID da tarefa:");
        try {
            int id = scanner.nextInt();
            for(Tarefa tarefa : tarefas){
                if(tarefa.getId()==id) {
                    System.out.println(tarefa);
                }
            }
        }catch (Exception e){
            System.out.println("ID inválido. Tente novamente.");
            scanner.nextLine();
        }
    }
}
