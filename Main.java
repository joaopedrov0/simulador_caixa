import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String...args){

        final int NUMERO_SIMULACOES= 1000;
        final List<Double> mediasAtendimento = new ArrayList<>();
        final int tempoAtendimentoPorCliente = 5;
        final double desvioPadrao = 0.50;
        final int numeroCaixas = 10;
        final int numeroClientes = 200;


        SimulacaoCaixaSupermercado simulador = new SimulacaoCaixaSupermercado();
        simulador.setNumeroCaixas(numeroCaixas);
        simulador.setNumeroClientes(numeroClientes);
        simulador.setMediaTempoAtendimentoPorCliente(tempoAtendimentoPorCliente);
        simulador.setDesvioPadraoTempoAtendimentoPorCliente(desvioPadrao);

        for (int i =0; i < NUMERO_SIMULACOES;i++){
            double tempoAtendimento = simulador.simular();

            mediasAtendimento.add(tempoAtendimento);
        }

        double media = media(mediasAtendimento);
        double dp = desvioPadrao(mediasAtendimento, media);

        System.out.printf("Média dos tempos de atendimento (%.0f simulações): %.3f min%n",
        (double) NUMERO_SIMULACOES, media);
        System.out.printf("Desvio-padrão das médias: %.3f min%n", dp);
    }

    private static double media(List<Double> xs) {
        double s = 0.0;
        for (double x : xs)s += x;
        return s / xs.size();
    }

    private static double desvioPadrao(List<Double> xs, double m) {
        double s2 = 0.0;
        for (double x : xs){
            double d = x- m;
            s2 += d* d;
        }
        return Math.sqrt(s2/ (xs.size()- 1));
    }
}
