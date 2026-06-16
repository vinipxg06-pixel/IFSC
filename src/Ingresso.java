public abstract class Ingresso {
    private int id;
    private Cliente cliente;
    private Sessao sessao;
    private double valorBase;

    public abstract double calcularPreco();

    public Ingresso(int id, Cliente cliente, Sessao sessao, double valorBase) {
        this.id = id;
        this.cliente = cliente;
        this.sessao = sessao;
        this.valorBase = valorBase;
    }

    public void mostrarInformacao() {
        System.out.println("Id: " + this.id);
        System.out.println("Cliente: " + this.cliente.getNome());
        System.out.println("Sessão: " + this.sessao.getFilme().getTitulo());
        System.out.println("Preço Final: " + this.calcularPreco());
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