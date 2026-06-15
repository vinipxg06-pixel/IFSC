import java.util.ArrayList;
import java.util.Scanner;

public class Sessao {

    Scanner leia = new Scanner(System.in);

    private int id;
    private Filme filme;
    private int sala;
    private String horario;
    private int capacidadeMaxima;
    private int assentosDisponiveis;
    private double valorBase;
    private ArrayList<Sessao> sessaos;

    public Sessao(int id, int capacidadeMaxima, String horario, int sala, Filme filme, int assentosDisponiveis, double valorBase) {
        this.id = id;
        this.capacidadeMaxima = capacidadeMaxima;
        this.horario = horario;
        this.sala = sala;
        this.filme = filme;
        this.assentosDisponiveis = assentosDisponiveis;
        this.valorBase = valorBase;
        this.sessaos = new ArrayList<>();
    }

    void cadrastrarSessao(Sessao sessao){
        sessaos.add(sessao);
    }

    void mostrarInformacao(){
        System.out.println("Filme: " + this.filme.getTitulo());
        System.out.println("Sala: " + this.sala);
        System.out.println("Horário: " + this.horario);
        System.out.println("Capacidade Máxima: " + this.capacidadeMaxima + " assentos");
        System.out.println("Assentos Disponíveis: " + this.assentosDisponiveis);
        System.out.printf("Valor do Ingresso: R$ %.2f\n", this.valorBase);
    }

    void listarSessoes(){
        for (int i = 0; i < sessaos.size(); i++) {
            mostrarInformacao();
            System.out.println();
        }
    }

    void buscarSessao(Sessao sessao){
        System.out.println("Sessão encontrada" + sessaos.indexOf(sessao));
    }

    void buscarSessao(int posicao){
        System.out.println("Sessão encontrada" + sessaos.get(posicao));
    }

    void atualizarSessao(Sessao sessao){
        System.out.println("Digite a nova sala:");
        int novaSala = leia.nextInt();
        sessao.setSala(novaSala);
        System.out.println("Digite o novo horário:");
        String novoHorario = leia.next();
        sessao.setHorario(novoHorario);
        System.out.println("Digite a nova capacidade máxima:");
        int novaCapacidade = leia.nextInt();
        sessao.setCapacidadeMaxima(novaCapacidade);
        System.out.println("Digite a nova quantidade de assentos disponíveis:");
        int novosAssentos = leia.nextInt();
        sessao.setAssentosDisponiveis(novosAssentos);
        System.out.println("Digite o novo valor base do ingresso:");
        double novoValor = leia.nextDouble();
        sessao.setValorBase(novoValor);
        System.out.println("Sessão atualizada com sucesso!!");
        sessao.mostrarInformacao();
    }

    void removerSessao(Sessao sessao){
        sessaos.remove(sessao);
    }

    void removerSessao(int posicao){
        sessaos.remove(posicao);
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

    public int getAssentosDisponiveis() {
        return assentosDisponiveis;
    }

    public void setAssentosDisponiveis(int assentosDisponiveis) {
        this.assentosDisponiveis = assentosDisponiveis;
    }

    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public void setCapacidadeMaxima(int capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getSala() {
        return sala;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public ArrayList<Sessao> getSessaos() {
        return sessaos;
    }

    public void setSessaos(ArrayList<Sessao> sessaos) {
        this.sessaos = sessaos;
    }
}
