import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final int NUMERO_SIMULACOES = 1000;
    private static double tempoMedioAtendimentoPorCliente = 5.0;
    private static double desvioPadrao = 0.5;
    private static int numeroCaixas = 1;
    private static int numeroClientes = 100;

    public static void main(String...args){
        try (Scanner scanner = new Scanner(System.in)) {

            boolean executando = true;
            while (executando) {
                exibirMenu();
                try {
                    String linha = scanner.nextLine();
                    int opcao = Integer.parseInt(linha);

                    switch (opcao) {
                        case 1 -> rodarSimulacao();
                        case 2 -> {
                            System.out.println("Digite o novo tempo médio de atendimento: ");
                            tempoMedioAtendimentoPorCliente = Double.parseDouble(scanner.nextLine());
                        }
                        case 3 -> {
                            System.out.println("Digite o novo desvio padrão: ");
                            desvioPadrao = Double.parseDouble(scanner.nextLine());
                        }
                        case 4 -> {
                            System.out.println("Digite o novo número de caixas: ");
                            numeroCaixas = Integer.parseInt(scanner.nextLine());
                        }
                        case 5 -> {
                            System.out.println("Digite o novo número de clientes: ");
                            numeroClientes = Integer.parseInt(scanner.nextLine());
                        }
                        case 0 -> {
                            System.out.println("Saindo do simulador.");
                            executando = false;
                        } // Sai do switch, o loop while vai terminar
                        default -> System.out.println("Opção inválida. Tente novamente.");
                    }
                    if (executando) {
                        System.out.println("\nPressione Enter para continuar...");
                        scanner.nextLine(); // Aguarda o usuário pressionar Enter
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida. Por favor, digite um número.");
                    System.out.println("\nPressione Enter para continuar...");
                    scanner.nextLine();
                }
            }
        }
    }

    private static void exibirMenu() {
        System.out.println("\n--- Simulador de Caixa de Supermercado ---");
        System.out.println("Parâmetros atuais:");
        System.out.printf("  - Tempo médio de atendimento: %.2f\n", tempoMedioAtendimentoPorCliente);
        System.out.printf("  - Desvio padrão: %.2f\n", desvioPadrao);
        System.out.printf("  - Número de caixas: %d\n", numeroCaixas);
        System.out.printf("  - Número de clientes: %d\n", numeroClientes);
        System.out.println("\nEscolha uma opção:");
        System.out.println("1. Rodar simulação");
        System.out.println("2. Editar tempo médio de atendimento");
        System.out.println("3. Editar desvio padrão");
        System.out.println("4. Editar número de caixas");
        System.out.println("5. Editar número de clientes");
        System.out.println("0. Sair");
        System.out.print("Opção: ");
    }

    private static void rodarSimulacao() {
        System.out.println("\nIniciando simulação com os parâmetros atuais...");
        final List<Double> mediasAtendimento = new ArrayList<>();
        SimulacaoCaixaSupermercado simulador = new SimulacaoCaixaSupermercado();
        simulador.setNumeroCaixas(numeroCaixas);
        simulador.setNumeroClientes(numeroClientes);
        simulador.setMediaTempoAtendimentoPorCliente(tempoMedioAtendimentoPorCliente);
        simulador.setDesvioPadraoTempoAtendimentoPorCliente(desvioPadrao);

        for (int i = 0; i < NUMERO_SIMULACOES; i++) {
            double tempoAtendimento = simulador.simular();
            mediasAtendimento.add(tempoAtendimento);
        }

        double media = media(mediasAtendimento);
        double dp = desvioPadrao(mediasAtendimento, media);

        System.out.printf("\n--- Resultados da Simulação ---\n");
        System.out.printf("Média dos tempos totais de atendimento (%d simulações): %.3f min%n",
                NUMERO_SIMULACOES, media);
        System.out.printf("Desvio-padrão das médias: %.3f min%n", dp);
    }

    private static double media(List<Double> xs) {
        double s = 0.0;
        for (double x : xs) s += x;
        return s / xs.size();
    }

    private static double desvioPadrao(List<Double> xs, double m) {
        double s2 = 0.0;
        for (double x : xs) {
            double d = x - m;
            s2 += d * d;
        }
        return Math.sqrt(s2 / (xs.size() - 1));
    }
}
