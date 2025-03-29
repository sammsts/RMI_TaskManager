package taskmanager.service;

import taskmanager.model.TaskManager;

import java.rmi.Naming;
import java.util.List;
import java.util.Scanner;

public class TaskMainClient {
    public static void main(String[] args) {
        try {
            TaskManager servidor = (TaskManager) Naming.lookup("rmi://localhost/TaskManager");
            Scanner scanner = new Scanner(System.in);
            boolean rodando = true;

            while (rodando) {
                System.out.println("Menu:");
                System.out.println("1. Adicionar Task");
                System.out.println("2. Listar Tasks");
                System.out.println("3. Concluir Task");
                System.out.println("4. Sair");
                System.out.print("Escolha uma opção: ");
                int escolha = scanner.nextInt();
                scanner.nextLine(); // Consumir a nova linha

                switch (escolha) {
                    case 1:
                        System.out.print("Digite a descrição da tarefa: ");
                        String descricao = scanner.nextLine();
                        servidor.adicionarTask(descricao);
                        break;

                    case 2:
                        List<String> tasks = servidor.listarTasks();
                        for (String task : tasks) {
                            System.out.println(task);
                        }
                        break;

                    case 3:
                        System.out.print("Digite o ID da tarefa para concluir: ");
                        int id = scanner.nextInt();
                        if (servidor.marcarComoConcluida(id)) {
                            System.out.println("Tarefa concluída com sucesso.");
                        } else {
                            System.out.println("Tarefa não encontrada ou já concluída.");
                        }
                        break;

                    case 4:
                        rodando = false;
                        break;

                    default:
                        System.out.println("Opção inválida.");
                }
            }

            scanner.close();
        } catch (Exception e) {
            System.err.println("Erro no cliente: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
