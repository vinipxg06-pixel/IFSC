import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner leia = new Scanner(System.in);

        System.out.println("=================================\nVoce entrou no sistema do cinema\n=================================");
        int idCliente = 0, idFilme = 0, idSessao = 0, opcao;
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Filme> filmes = new ArrayList<>();
        ArrayList<Sessao> sessoes = new ArrayList<>();

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
                                Cliente buscador = new Cliente(0, "", "", "", "");
                                buscador.setClientes(clientes);
                                buscador.buscarCliente(idBuscar);
                            } else {
                                System.out.println("Nenhum cliente cadastrado.");
                            }
                            break;
                        case 4:
                            System.out.println("Digite o ID do cliente:");
                            int idAtualizar = leia.nextInt();
                            if (clientes.size() != 0) {
                                Cliente atualizador = new Cliente(0, "", "", "", "");
                                atualizador.setClientes(clientes);
                                atualizador.atualizarCliente(idAtualizar);
                            } else {
                                System.out.println("Nenhum cliente cadastrado.");
                            }
                            break;
                        case 5:
                            if (clientes.size() != 0) {
                                System.out.println("Digite o ID do cliente que deseja remover:");
                                int idRemover = leia.nextInt();
                                if (clientes.size() != idRemover) {
                                    Cliente remover = new Cliente(0, "", "", "", "");
                                    remover.setClientes(clientes);
                                    remover.removerCliente(idRemover);
                                    System.out.println("Cliente removido!!");
                                } else {
                                    System.out.println("Cliente não encontrado!");
                                }
                            } else {
                                System.out.println("Nenhum cliente cadastrado.");
                            }
                            break;
                        default:
                            System.out.println("Opção não encontrada! Tente novamente");
                            break;
                    }
                default:
                    System.out.println("Opção não encontrada! Tente novamente");
                    break;
                case 2:
                    menuFilmes();
                    int opcaoFilme = leia.nextInt();
                    switch (opcaoFilme) {
                        case 1:
                            System.out.println("Digite o titulo do Filme:");
                            String titulo = leia.next();
                            System.out.println("Digite a descrição do Filme:");
                            String descricao = leia.next();
                            System.out.println("Digite o genero do Filme(ACAO, COMEDIA, DRAMA, TERROR, FICCAO_CIENTIFICA, ROMANCE):");
                            Genero genero = Genero.valueOf(leia.next().toUpperCase());
                            System.out.println("Digite a classificação do Filme(LIVRE, DEZ, DOZE, QUATORZE, DEZESSEIS, DEZOITO): ");
                            Classificacao classificacao = Classificacao.valueOf(leia.next().toUpperCase());
                            System.out.println("Digite o tempo do Filme(em minutos):");
                            int duracaoEmMin = leia.nextInt();
                            Filme novo = new Filme(idFilme, descricao, classificacao, genero, titulo, duracaoEmMin);
                            idFilme++;
                            filmes.add(novo);
                            break;
                        case 2:
                            if (filmes.size() != 0) {
                                for (int i = 0; i < filmes.size(); i++) {
                                    filmes.get(i).mostrarInformacao();
                                }
                            } else {
                                System.out.println("Nenhum filme cadastrado!");
                            }
                            break;
                        case 3:
                            if (filmes.size() != 0) {
                                System.out.println("Digite o ID do Filme que deseja buscar:");
                                int idBuscar = leia.nextInt();
                                if (filmes.get(idBuscar) != null) {
                                    filmes.get(idBuscar).mostrarInformacao();
                                } else {
                                    System.out.println("Filme não encontrado!");
                                }
                            } else {
                                System.out.println("Nenhum filme cadastrado!");
                            }
                            break;
                        case 4:
                            if (filmes.size() != 0) {
                                System.out.println("Digite o ID do Filme que deseja atualizar:");
                                int idAtualizar = leia.nextInt();
                                filmes.set(idAtualizar, filmes.get(idAtualizar).atualizarFilme(idAtualizar));
                            } else {
                                System.out.println("Nenhum filme cadastrado!");
                            }
                            break;
                        case 5:
                            if (filmes.size() != 0) {
                                System.out.println("Digite o filme que deseja remover:");
                                int idRemover = leia.nextInt();
                                for (int i = 0; i < filmes.size(); i++) {
                                    if (filmes.get(i).getId() == idRemover) {
                                        filmes.remove(idRemover);
                                        System.out.println("Filme removido!");
                                        break;
                                    }
                                }
                            } else {
                                System.out.println("Nenhum filme cadastrado!");
                            }
                            break;
                        default:
                            System.out.println("Opção não encontrada! Tente novamente");
                            break;

                    }
                case 3:
                    menuSessoes();
                    int opcaoSessao = leia.nextInt();
                    switch (opcaoSessao) {
                        case 1:
                            Filme filmeSelecionado = null;
                            for (int i = 0; i < filmes.size(); i++) {
                                if (filmes.get(i).getId() == filmeSelecionado.getId()) {
                                    filmeSelecionado = filmes.get(i);
                                }
                            }
                            System.out.println("Digite o número da sala:");
                            int sala = leia.nextInt();
                            System.out.println("Digite o horário (Ex: 19:30):");
                            String horario = leia.next();
                            System.out.println("Digite a capacidade máxima da sala:");
                            int capacidade = leia.nextInt();
                            System.out.println("Digite o valor base do ingresso:");
                            double valorBase = leia.nextDouble();
                            Sessao novaSessao = new Sessao(idSessao, capacidade, horario, sala, filmeSelecionado, capacidade, valorBase);
                            idSessao++;
                            sessoes.add(novaSessao);
                            System.out.println("Sessão cadastrada com sucesso!");
                            break;
                        case 2:
                            if (sessoes.size() != 0) {
                                for (int i = 0; i < sessoes.size(); i++) {
                                    sessoes.get(i).mostrarInformacao();
                                }
                            } else {
                                System.out.println("Nenhuma sessão cadastrada.");
                            }
                            break;
                        case 3:
                            System.out.println("Digite o ID da sessão:");
                            int idBuscar = leia.nextInt();
                            if (sessoes.size() != 0) {
                                Sessao buscador = new Sessao(0, 0, "", 0, null, 0, 0.0);
                                buscador.setSessaos(sessoes);
                                buscador.buscarSessao(idBuscar);
                            } else {
                                System.out.println("Nenhuma sessão cadastrada.");
                            }
                            break;
                        case 4:
                            System.out.println("Digite o ID da sessão:");
                            int idAtualizar = leia.nextInt();
                            if (sessoes.size() != 0) {
                                if (idAtualizar >= 0 && idAtualizar < sessoes.size()) {
                                    Sessao atualizador = new Sessao(0, 0, "", 0, null, 0, 0.0);
                                    atualizador.setSessaos(sessoes);
                                    atualizador.atualizarSessao(sessoes.get(idAtualizar));
                                } else {
                                    System.out.println("Sessão não encontrada!");
                                }
                            } else {
                                System.out.println("Nenhuma sessão cadastrada.");
                            }
                            break;
                        case 5:
                            if (sessoes.size() != 0) {
                                System.out.println("Digite o ID da sessão que deseja remover:");
                                int idRemover = leia.nextInt();
                                if (sessoes.size() != idRemover) {
                                    Sessao remover = new Sessao(0, 0, "", 0, null, 0, 0.0);
                                    remover.setSessaos(sessoes);
                                    remover.removerSessao(idRemover);
                                    System.out.println("Sessão removida!!");
                                } else {
                                    System.out.println("Sessão não encontrada!");
                                }
                            } else {
                                System.out.println("Nenhuma sessão cadastrada.");
                            }
                            break;
                        default:
                            System.out.println("Opção não encontrada! Tente novamente");
                            break;
                    }
                    break;


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
