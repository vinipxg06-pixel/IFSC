public abstract class Ingresso {

    private int id;
    private Cliente cliente;
    private Sessao sessao;
    private double valorBase;

    public abstract double calcularPreco(double valorBase);

    public void exibirResumo(){
        System.out.println("Id: " + this.id);
        System.out.println("Cliente: " + this.cliente.getNome());
        System.out.println("Sessão: " + this.sessao.getFilme());
        System.out.println("Preço: " + this.valorBase);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValorBase() {
        return valorBase;
    }

    public void setValorBase(double valorBase) {
        this.valorBase = valorBase;
    }

    public Sessao getSessao() {
        return sessao;
    }

    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
