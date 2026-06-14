import java.util.ArrayList;
import java.util.Scanner;

public class Filme {

    Scanner leia = new Scanner(System.in);

    private int id;
    private String titulo;
    private Genero genero;
    private Classificacao classificacao;
    private int duracaoEmMinutos;
    private String descricao;
    private ArrayList<Filme> filmes;


    public Filme(int id, String descricao, Classificacao classificacao, Genero genero, String titulo, int duracaoEmMinutos) {
        this.id = id;
        this.descricao = descricao;
        this.classificacao = classificacao;
        this.genero = genero;
        this.titulo = titulo;
        this.duracaoEmMinutos = duracaoEmMinutos;
        this.filmes = new ArrayList<>();
    }

    void cadrastrarFilme(Filme filme) {
        filmes.add(filme);
    }

    void mostrarInformacao() {
        System.out.println("Titulo: " + this.titulo);
        System.out.println("Genero: " + this.genero);
        System.out.println("Classificação: " + this.classificacao);
        System.out.println("Duração em minutos: " + this.duracaoEmMinutos);
        System.out.println("Descrição: " + this.descricao);
    }

    void listarFilmes() {
        for (int i = 0; i < filmes.size(); i++) {
            filmes.get(i).mostrarInformacao();
            System.out.println();
        }
    }
    void buscarFilme(int posicao) {
        if (posicao >= 0 && posicao < filmes.size()) {
            System.out.println("Filme encontrado:");
            filmes.get(posicao).mostrarInformacao();
        } else {
            System.out.println("Filme não encontrado!");
        }
    }



    void atualizarFilme(Filme filme) {
        System.out.println("Digite o novo titulo:");
        String novoTitulo = leia.next();
        filme.setTitulo(novoTitulo);
        System.out.println("Digite o novo gênero (Ex: ACAO, DRAMA, TERROR):");
        String novoGenero = leia.next().toUpperCase();
        filme.setGenero(Genero.valueOf(novoGenero));
        System.out.println("Digite a nova classificação (Ex: LIVRE, DEZ, DEZOITO):");
        String novaClassificacaoStr = leia.next().toUpperCase();
        filme.setClassificacao(Classificacao.valueOf(novaClassificacaoStr));
        System.out.println("Digite a nova duração em minutos:");
        int novaDuracao = leia.nextInt();
        filme.setDuracaoEmMinutos(novaDuracao);
        System.out.println("Digite a nova descrição:");
        String novaDescricao = leia.nextLine();
        filme.setDescricao(novaDescricao);
        System.out.println("Filme atualizado com sucesso!!");
        filme.mostrarInformacao();
    }

    void removerFilme(Filme filme) {
        filmes.remove(filme);

    }

    void removeFilme(int posicao) {
        filmes.remove(posicao);
    }

    public Scanner getLeia() {
        return leia;
    }

    public void setLeia(Scanner leia) {
        this.leia = leia;
    }

    public ArrayList<Filme> getFilmes() {
        return filmes;
    }

    public void setFilmes(ArrayList<Filme> filmes) {
        this.filmes = filmes;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public Enum getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Enum getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(Classificacao classificacao) {
        this.classificacao = classificacao;
    }
}
