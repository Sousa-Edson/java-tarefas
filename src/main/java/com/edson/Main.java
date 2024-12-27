package com.edson;

import com.edson.arquivo.GerenciadorArquivo;
import com.edson.menu.MeuMenu;
import com.edson.mock.MeuMock;
import com.edson.model.Tarefa;
import com.edson.services.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Tarefa> tarefas = new ArrayList<>();
//        MeuMock.mock(tarefas);
        GerenciadorArquivo.carregarTarefas(tarefas);

        boolean sair = false;
        do {
            MeuMenu.menu();
            int opcao = 0;
            try {
                opcao = scanner.nextInt();

                switch (opcao) {
                    case 1:
                        System.out.println("Cadastrar tarefa");
                        CadastrarTarefa.cadastrarTarefa(tarefas);
                        break;
                    case 2:
                        System.out.println("Listar tarefas");
                        ListarTarefas.listarTarefa(tarefas);
                        break;
                    case 3:
                        System.out.println("Buscar tarefa");
                        BuscarTarefas.buscarTarefa(tarefas);
                        break;
                    case 4:
                        System.out.println("Atualizar tarefa");
                        AtualizarTarefas.atualizarTarefa(tarefas);
                        break;
                    case 5:
                        System.out.println("Remover tarefa");
                        DeletarTarefas.deletarTarefa(tarefas);
                        break;
                    case 0:
                        System.out.println("Saindo do programa...");
                        sair = true;
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
        GerenciadorArquivo.salvarTarefas(tarefas);
    }
}