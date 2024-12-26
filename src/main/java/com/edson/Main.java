package com.edson;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Tarefa> tarefas = new ArrayList<>();
        mock(tarefas);


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
                        buscarTarefa(tarefas);
                        break;
                    case 4:
                        System.out.println("Atualizar tarefa");
                        atualizarTarefa(tarefas);
                        break;
                    case 5:
                        System.out.println("Remover tarefa");
                        deletarTarefa(tarefas);
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

//        Atualizar o status de uma tarefa.
//        Remover uma tarefa pelo ID.
    }

    public static void menu() {
        System.out.println(" ");
        System.out.println("Digite uma opção:");
        System.out.println("1-cadastrar tarefa");
        System.out.println("2-listar tarefas");
        System.out.println("3-buscar tarefa");
        System.out.println("4-atualizar tarefa");
        System.out.println("5-remover tarefa");
    }

    public static void mock(List<Tarefa> tarefas) {
        tarefas.add(new Tarefa(1, "Tarefa 1", "Pendente"));
        tarefas.add(new Tarefa(2, "Tarefa 2", "Finalizado"));
        tarefas.add(new Tarefa(3, "Tarefa 3", "Pendente"));
        tarefas.add(new Tarefa(4, "Tarefa 4", "Pendente"));
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
                System.out.println("Digite o novo status da tarefa:");
                String novoStatus = scanner.nextLine();
                tarefaEncontrada.setStatus(novoStatus);
                System.out.println("Status da tarefa atualizada com sucesso!");
            }else{
                System.out.println("Tarefa com o ID informado não foi encontrada.");
            }
        }catch (Exception e){
            System.out.println("ID inválido. Tente novamente.");
            scanner.nextLine();
        }
    }

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