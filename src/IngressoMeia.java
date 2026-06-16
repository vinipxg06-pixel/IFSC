public class IngressoMeia extends Ingresso {

    public IngressoMeia(int id, Cliente cliente, Sessao sessao, double valorBase) {
        super(id, cliente, sessao, valorBase);
    }

    @Override
    public double calcularPreco() {
        return getValorBase() * 0.5;
    }

    @Override
    public void mostrarInformacao() {
        super.mostrarInformacao();
    }
}