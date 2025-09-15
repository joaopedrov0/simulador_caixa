
import java.util.ArrayList;
import java.util.List;

public class SimulacaoCaixaSupermercado {

    private double tempo = 0;
    private int numeroCaixas;
    private int numeroClientes;
    private double mediaTempoAtendimentoPorCliente;
    private double desvioPadraoTempoAtendimentoPorCliente;
    private static final double TEMPO_MINIMO_ATENDIMENTO = 0.1;
    private final java.util.Random rng= new java.util.Random(42);

    public List<Double> clientes = new ArrayList<>();
    private final List<CaixaSupermercado> caixas = new ArrayList<>();

    public void setNumeroCaixas(int n){ this.numeroCaixas = n; }
    public void setNumeroClientes(int n){ this.numeroClientes = n; }
    
    public void setMediaTempoAtendimentoPorCliente(double mu){
        this.mediaTempoAtendimentoPorCliente= mu;
    }
    public void setDesvioPadraoTempoAtendimentoPorCliente(double sigma) {
        this.desvioPadraoTempoAtendimentoPorCliente = sigma;
    }

    private double tempoAtendimentoNormalTruncado(){
        double z = rng.nextGaussian();
        double s = mediaTempoAtendimentoPorCliente + desvioPadraoTempoAtendimentoPorCliente* z;
        return (s < TEMPO_MINIMO_ATENDIMENTO) ?TEMPO_MINIMO_ATENDIMENTO : s;
    }

    public double simular() {
        tempo = 0;
        popularClientes();
        popularCaixas();
        while (true){
            if (clientes.isEmpty()){
                finish();
                break;
            } else {
                clock();
            }
        }
        return tempo;
    }

    public void popularCaixas(){
        caixas.clear();
        for(int i = 0; i < numeroCaixas; i++){
            caixas.add(new CaixaSupermercado());
        }
    }

    public void popularClientes(){
        clientes.clear();
        for (int i = 0; i < numeroClientes; i++) {
            clientes.add(tempoAtendimentoNormalTruncado());
        }
    }

    public void clock(){
        tempo += 1;
        for (CaixaSupermercado caixa : caixas) {
            if (clientes.isEmpty()) {
                break;
            }
            if (!caixa.isLocked(tempo)){
                caixa.setLockedUntil(tempo + clientes.removeFirst());
            }
        }
    }

    public void finish(){
        double biggerLock = 0;
        for (CaixaSupermercado caixa : caixas) {
            double current = caixa.getLockedUntil();
            if (current > biggerLock){
                biggerLock = current;
            }
        }
        tempo += biggerLock;
    }
}