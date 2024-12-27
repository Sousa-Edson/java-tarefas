package com.edson.arquivo;

import com.edson.enums.Status;
import com.edson.model.Tarefa;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.util.List;

public class GerenciadorArquivo {
    private static final String CAMINHO_ARQUIVO = "tarefas.txt";

    // Método para salvar as tarefas em um arquivo
    public static void salvarTarefas(List<Tarefa> tarefas) {
        try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(CAMINHO_ARQUIVO))) {
            for (Tarefa tarefa : tarefas) {
                writer.write(tarefa.toString());
                writer.newLine();
            }
            System.out.println("Tarefas salvas no arquivo com sucesso!");
        } catch (Exception e) {
            System.err.println("Erro ao salvar tarefas: " + e.getMessage());
        }
    }

    // Método para carregar as tarefas de um arquivo
    public static void carregarTarefas(List<Tarefa> tarefas) {
        File arquivo = new File(CAMINHO_ARQUIVO);
        if (!arquivo.exists()) {
            System.out.println("Arquivo não encontrado. Criando um novo arquivo vazio.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(CAMINHO_ARQUIVO))) {
            String linha;
            int maiorId = 0;
            while ((linha = reader.readLine()) != null) {
                // Remover prefixo "Tarefa{" e sufixo "}"
                linha = linha.trim().replace("Tarefa{", "").replace("}", "");

                // Dividir os atributos pelo delimitador ", "
                String[] dados = linha.split(", ");

                if (dados.length != 3) {
                    System.err.println("Formato incorreto na linha: " + linha);
                for(String dado : dados) {
                    System.out.println(dado);
                }
                    continue;
                }

                // Extrair e converter os atributos
                try {
                    int id = Integer.parseInt(dados[0].split("=")[1]);
                    String descricao = dados[1].split("=")[1].replace("'", ""); // Remover aspas simples
                    Status status = Status.valueOf(dados[2].split("=")[1].replace("'", ""));

                    // Criar a tarefa e adicioná-la à lista
                    Tarefa tarefa = new Tarefa(id, descricao, status);
                    tarefas.add(tarefa);
                    if (id > maiorId) {
                        maiorId = id;
                    }
                } catch (Exception e) {
                    System.err.println("Erro ao processar a linha: " + linha + " -> " + e.getMessage());
                    System.out.println("ERRO  "+e.getMessage());
                }
            }
            // Atualiza o contador de IDs na classe Tarefa
            Tarefa.atualizarContadorId(maiorId);
            System.out.println("Tarefas carregadas do arquivo com sucesso!");
        } catch (Exception e) {
            System.err.println("Erro ao carregar tarefas: " + e.getMessage());
        }
    }
}
