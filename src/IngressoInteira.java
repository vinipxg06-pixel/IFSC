public class IngressoInteira extends Ingresso {

    public IngressoInteira(int id, Cliente cliente, Sessao sessao, double valorBase) {
        super(id, cliente, sessao, valorBase);
    }

    @Override
    public double calcularPreco() {
        return getValorBase();
    }

    @Override
    public void mostrarInformacao() {
        super.mostrarInformacao();
    }
}