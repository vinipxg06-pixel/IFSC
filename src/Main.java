import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner leia = new Scanner(System.in);

        System.out.println("=================================\nVoce entrou no sistema do cinema\n=================================");
        int idCliente = 0;
        int opcao;
        ArrayList<Cliente> clientes = new ArrayList<>();

        do {
            menuCinema();
            opcao = leia.nextInt();
            switch (opcao) {
                case 1:
                    menuClientes();
                    int opcaoCliente = leia.nextInt();
                    switch (opcaoCliente) {
                        case 1:
                            System.out.println("Digite o nome:");
                            String nomeCliente = leia.next();
                            System.out.println("Digite o CPF:");
                            String cpfCliente = leia.next();
                            System.out.println("Digite o email:");
                            String emailCliente = leia.next();
                            System.out.println("Digite o telefone:");
                            String telefoneCliente = leia.next();
                            Cliente cliente = new Cliente(idCliente, telefoneCliente, emailCliente, cpfCliente, nomeCliente);
                            idCliente++;
                            clientes.add(cliente);
                            break;
                        case 2:
                            if (clientes.size() != 0) {
                                for (int i = 0; i < clientes.size(); i++) {
                                    clientes.get(i).mostrarInformacao();
                                }
                            } else {
                                System.out.println("Nenhum cliente cadastrado.");
                            }
                            break;
                        case 3:
                            System.out.println("Digite o ID do cliente:");
                            int idBuscar = leia.nextInt();
                            if (clientes.size() != 0) {
                                clientes.get(idBuscar).buscarCliente(idBuscar);
                            } else {
                                System.out.println("Nenhum cliente cadastrado.");
                            }
                            break;
                        case 4:
                            System.out.println("Digite o ID do cliente:");
                            int idAtualizar = leia.nextInt();
                            if (clientes.size()!=0){
                               clientes.get(idAtualizar).atualizarCliente(idAtualizar);
                            } else {
                                System.out.println("Nenhum cliente cadastrado.");
                            }
                            break;

                    }
            }
        } while (opcao != 0);


    }


    public static void menuCinema() {
        System.out.println("========= CINEMA =========");
        System.out.println("1 - Menu Clientes");
        System.out.println("2 - Menu Filmes");
        System.out.println("3 - Menu Sessões");
        System.out.println("4 - Menu Venda de Ingressos");
        System.out.println("0 - Sair do Sistema");
        System.out.print("Escolha uma opção: ");
    }

    public static void menuClientes() {
        System.out.println("\n====== CLIENTES ======");
        System.out.println("1 - Cadastrar Cliente");
        System.out.println("2 - Listar Clientes");
        System.out.println("3 - Buscar Cliente");
        System.out.println("4 - Atualizar Cliente");
        System.out.println("5 - Remover Cliente");
        System.out.println("0 - Voltar");
        System.out.print("Escolha uma opção: ");
    }

    public static void menuFilmes() {
        System.out.println("\n====== FILMES ======");
        System.out.println("1 - Cadastrar Filme");
        System.out.println("2 - Listar Filmes");
        System.out.println("3 - Buscar Filme");
        System.out.println("4 - Atualizar Filme");
        System.out.println("5 - Remover Filme");
        System.out.println("0 - Voltar");
        System.out.print("Escolha uma opção: ");
    }

    public static void menuSessoes() {
        System.out.println("\n====== SESSÕES ======");
        System.out.println("1 - Cadastrar Sessão");
        System.out.println("2 - Listar Sessões");
        System.out.println("3 - Buscar Sessão");
        System.out.println("4 - Atualizar Sessão");
        System.out.println("5 - Remover Sessão");
        System.out.println("0 - Voltar");
        System.out.print("Escolha uma opção: ");
    }

    public static void menuIngressos() {
        System.out.println("\n====== INGRESSOS ======");
        System.out.println("1 - Vender Ingresso Inteira");
        System.out.println("2 - Vender Ingresso Meia");
        System.out.println("3 - Listar Ingressos");
        System.out.println("4 - Buscar Ingresso");
        System.out.println("5 - Cancelar Venda");
        System.out.println("0 - Voltar");
        System.out.print("Escolha uma opção: ");
    }


}
