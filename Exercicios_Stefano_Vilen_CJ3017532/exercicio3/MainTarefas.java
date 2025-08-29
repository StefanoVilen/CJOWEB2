import java.util.ArrayList;
import java.util.Scanner;

public class MainTarefas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Tarefa> tarefas = new ArrayList<>();
        int opcao;

        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Adicionar tarefa");
            System.out.println("2 - Remover tarefa");
            System.out.println("3 - Listar tarefas");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");
            while (!sc.hasNextInt()) {
                System.out.print("Digite um número válido: ");
                sc.next();
            }
            opcao = sc.nextInt();
            sc.nextLine(); // consumir quebra de linha

            switch (opcao) {
                case 1:
                    System.out.print("Código da tarefa: ");
                    while (!sc.hasNextInt()) {
                        System.out.print("Digite um código numérico: ");
                        sc.next();
                    }
                    int codigo = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Título da tarefa: ");
                    String titulo = sc.nextLine();
                    tarefas.add(new Tarefa(codigo, titulo));
                    System.out.println("Tarefa adicionada!");
                    break;

                case 2:
                    System.out.print("Digite o código da tarefa para remover: ");
                    while (!sc.hasNextInt()) {
                        System.out.print("Digite um código numérico: ");
                        sc.next();
                    }
                    int codRemover = sc.nextInt();
                    sc.nextLine();
                    boolean removida = tarefas.removeIf(t -> t.getCodigo() == codRemover);
                    if (removida) {
                        System.out.println("Tarefa removida!");
                    } else {
                        System.out.println("Tarefa não encontrada!");
                    }
                    break;

                case 3:
                    System.out.println("\n=== LISTA DE TAREFAS ===");
                    if (tarefas.isEmpty()) {
                        System.out.println("Nenhuma tarefa cadastrada.");
                    } else {
                        for (Tarefa t : tarefas) {
                            System.out.println(t);
                        }
                    }
                    break;

                case 4:
                    System.out.println("Saindo do programa...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 4);

        sc.close();
    }
}
