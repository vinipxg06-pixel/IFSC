import java.lang.ref.Cleaner;
import java.util.ArrayList;
import java.util.Scanner;

public class Cliente {

    Scanner leia = new Scanner(System.in);

    private int id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private ArrayList<Cliente> clientes;

    public Cliente(int id, String telefone, String email, String cpf, String nome) {
        this.id = id;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
        this.nome = nome;
        this.clientes = new ArrayList<>();
    }

    void cadastrarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    void mostrarInformacao() {
        System.out.println("Nome: " + this.nome);
        System.out.println("ID: " + this.id);
        System.out.println("Email: " + this.email);
        System.out.println("Telefone: " + this.telefone);
        System.out.println("CPF: " + this.cpf);
    }

    void listarClientes() {
        for (int i = 0; i < clientes.size(); i++) {
            clientes.get(i).mostrarInformacao();
        }
    }

    void buscarCliente(int posicao) {
        if (posicao >= 0 && posicao < clientes.size()) {
            System.out.println("Cliente encontrado:");
            clientes.get(posicao).mostrarInformacao();
        } else {
            System.out.println("Cliente não encontrado!");
        }
    }

     void atualizarCliente(int id) {
        Cliente cliente = getClientes().get(id);
        System.out.println("Digite novo nome:");
        String novoNome = leia.next();
        cliente.setNome(novoNome);
        System.out.println("Digite novo email:");
        String novoEmail = leia.next();
        cliente.setEmail(novoEmail);
        System.out.println("Digite novo telefone: ");
        String novoTelefone = leia.next();
        cliente.setTelefone(novoTelefone);
        System.out.println("Digite novo CPF:");
        String novoCPF = leia.next();
        cliente.setCpf(novoCPF);
        System.out.println("Cliente atualizado!!");
        cliente.mostrarInformacao();
    }

    void removerCliente(int posicao) {
        clientes.remove(posicao);
    }

    void removerCliente(Cliente cliente) {
        clientes.remove(cliente);
    }


    public Scanner getLeia() {
        return leia;
    }

    public void setLeia(Scanner leia) {
        this.leia = leia;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

}
