package com.edson;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Tarefa> tarefas = new ArrayList<>();


        boolean sair = false;
        do {
            menu();
            int opcao = 0;
            try {
                opcao = scanner.nextInt();

                switch (opcao) {
                    case 1:
                        System.out.println("Cadastrar tarefa");
                        cadastrarTarefa(tarefas);
                        break;
                    case 2:
                        System.out.println("Listar tarefas");
                        listarTarefa(tarefas);
                        break;
                    case 3:
                        System.out.println("Buscar tarefa");
                        break;
                    case 4:
                        System.out.println("Atualizar tarefa");
                        break;
                    case 5:
                        System.out.println("Remover tarefa");
                        break;
                    default:
                        System.out.println("Opção inválida");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida. Tente novamente.");
                scanner.nextLine();
            }
        } while (!sair);



//        Buscar uma tarefa pelo ID.
//        Atualizar o status de uma tarefa.
//        Remover uma tarefa pelo ID.
    }

    public static void menu() {
        System.out.println("Digite uma opção:");
        System.out.println("1-cadastrar tarefa");
        System.out.println("2-listar tarefas");
        System.out.println("3-buscar tarefa");
        System.out.println("4-atualizar tarefa");
        System.out.println("5-remover tarefa");
    }

    public static void cadastrarTarefa(List<Tarefa> tarefas) {
        System.out.println("#Cadastrar tarefa");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite a descricao da tarefa:");
        String descricao = scanner.nextLine();
        String status = "Pendente";
        Tarefa tarefa = new Tarefa(tarefas.size() + 1, descricao, status);
        tarefas.add(tarefa);
    }

    public static void listarTarefa(List<Tarefa> tarefas) {
        System.out.println("#Lista de tarefas:");
        for(Tarefa tarefa : tarefas){
            System.out.println(tarefa);
        }
    }

}