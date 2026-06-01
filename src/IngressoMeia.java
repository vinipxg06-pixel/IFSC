public class IngressoMeia extends Ingresso {

    @Override
    public double calcularPreco(double valoBase) {
        return (valoBase-valoBase*0.5);
    }

    @Override
    public void exibirResumo() {
        exibirResumo();
    }
}
