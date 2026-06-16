import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);

        System.out.println("=================================\nVoce entrou no sistema do cinema\n=================================");

        int idCliente = 0, idFilme = 0, idSessao = 0, idIngresso = 0, opcao;
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Filme> filmes = new ArrayList<>();
        ArrayList<Sessao> sessoes = new ArrayList<>();
        ArrayList<Ingresso> ingressos = new ArrayList<>();

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
                            System.out.println("Cliente cadastrado com sucesso!");
                            break;

                        case 2:
                            if (clientes.size() != 0) {
                                System.out.println("\n==Clientes==");
                                for (int i = 0; i < clientes.size(); i++) {
                                    clientes.get(i).mostrarInformacao();
                                    System.out.println("-----");
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
                            if (clientes.size()!=0){
                                System.out.println("Digite o ID do cliente:");
                                int idAtualizar = leia.nextInt();
                                if (idAtualizar >= 0 && idAtualizar < clientes.size()) {
                                    Cliente atualizador = new Cliente(0, "", "", "", "");
                                    atualizador.setClientes(clientes);
                                    atualizador.atualizarCliente(idAtualizar);
                                } else {
                                    System.out.println("Você digitou um ID inválido.");
                                }
                            } else {
                                System.out.println("Nenhum cliente cadastrado.");
                            }
                            break;

                        case 5:
                            if (clientes.size() != 0) {
                                System.out.println("Digite o ID do cliente que deseja remover:");
                                int idRemover = leia.nextInt();
                                if (idRemover >= 0 && idRemover < clientes.size()) {
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

                        case 0:
                            break;

                        default:
                            System.out.println("Opção não encontrada! Tente novamente");
                            break;
                    }
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
                            System.out.println("Filme cadastrado com sucesso!");
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
                                if (idBuscar >= 0 && idBuscar < filmes.size()) {
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
                                if (idAtualizar >= 0 && idAtualizar < filmes.size()) {
                                    filmes.set(idAtualizar, filmes.get(idAtualizar).atualizarFilme(idAtualizar));
                                    System.out.println("Filme atualizado com sucesso!");
                                } else {
                                    System.out.println("Filme não encontrado!");
                                }
                            } else {
                                System.out.println("Nenhum filme cadastrado!");
                            }
                            break;

                        case 5:
                            if (filmes.size() != 0) {
                                System.out.println("Digite o ID do filme que deseja remover:");
                                int idRemover = leia.nextInt();
                                boolean encontrado = false;
                                for (int i = 0; i < filmes.size(); i++) {
                                    if (filmes.get(i).getId() == idRemover) {
                                        filmes.remove(i);
                                        System.out.println("Filme removido!");
                                        encontrado = true;
                                        break;
                                    }
                                }
                                if (!encontrado) {
                                    System.out.println("Filme não encontrado!");
                                }
                            } else {
                                System.out.println("Nenhum filme cadastrado!");
                            }
                            break;

                        case 0:
                            break;

                        default:
                            System.out.println("Opção não encontrada! Tente novamente");
                            break;
                    }
                    break;

                case 3:
                    menuSessoes();
                    int opcaoSessao = leia.nextInt();

                    switch (opcaoSessao) {
                        case 1:
                            if (filmes.size() != 0) {
                                System.out.println("Digite o ID do filme:");
                                int idFilmeSessao = leia.nextInt();
                                Filme filmeSelecionado = null;

                                for (int i = 0; i < filmes.size(); i++) {
                                    if (filmes.get(i).getId() == idFilmeSessao) {
                                        filmeSelecionado = filmes.get(i);
                                        break;
                                    }
                                }

                                if (filmeSelecionado != null) {
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
                                } else {
                                    System.out.println("Filme não encontrado!");
                                }
                            } else {
                                System.out.println("Nenhum filme cadastrado. Cadastre um filme primeiro.");
                            }
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
                                    System.out.println("Sessão atualizada com sucesso!");
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
                                if (idRemover >= 0 && idRemover < sessoes.size()) {
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

                        case 0:
                            break;

                        default:
                            System.out.println("Opção não encontrada! Tente novamente");
                            break;
                    }
                    break;

                case 4:
                    menuIngressos();
                    int opcaoIngresso = leia.nextInt();

                    switch (opcaoIngresso) {
                        case 1:
                            if (clientes.size() != 0 && sessoes.size() != 0) {
                                System.out.println("Digite o ID do Cliente:");
                                int idClienteIngresso = leia.nextInt();
                                System.out.println("Digite o ID da Sessão:");
                                int idSessaoIngresso = leia.nextInt();
                                System.out.println("Digite o preço do Ingresso:");
                                double precoIngresso = leia.nextDouble();

                                Cliente clienteEncontrado = null;
                                Sessao sessaoEncontrada = null;

                                for (int i = 0; i < clientes.size(); i++) {
                                    if (clientes.get(i).getId() == idClienteIngresso) {
                                        clienteEncontrado = clientes.get(i);
                                        break;
                                    }
                                }

                                for (int i = 0; i < sessoes.size(); i++) {
                                    if (sessoes.get(i).getId() == idSessaoIngresso) {
                                        sessaoEncontrada = sessoes.get(i);
                                        break;
                                    }
                                }

                                if (clienteEncontrado != null && sessaoEncontrada != null) {
                                    IngressoInteira venderInteira = new IngressoInteira(idIngresso, clienteEncontrado, sessaoEncontrada, precoIngresso);
                                    idIngresso++;
                                    ingressos.add(venderInteira);
                                    System.out.println("Ingresso inteira vendido com sucesso!");
                                } else {
                                    System.out.println("Cliente ou Sessão não encontrados!");
                                }
                            } else {
                                System.out.println("Cadastre clientes e sessões antes de vender ingressos.");
                            }
                            break;

                        case 2:
                            if (clientes.size() != 0 && sessoes.size() != 0) {
                                System.out.println("Digite o ID do Cliente:");
                                int idClienteIngresso = leia.nextInt();
                                System.out.println("Digite o ID da Sessão:");
                                int idSessaoIngresso = leia.nextInt();
                                System.out.println("Digite o preço do Ingresso:");
                                double precoIngresso = leia.nextDouble();

                                Cliente clienteEncontrado = null;
                                Sessao sessaoEncontrada = null;

                                for (int i = 0; i < clientes.size(); i++) {
                                    if (clientes.get(i).getId() == idClienteIngresso) {
                                        clienteEncontrado = clientes.get(i);
                                        break;
                                    }
                                }

                                for (int i = 0; i < sessoes.size(); i++) {
                                    if (sessoes.get(i).getId() == idSessaoIngresso) {
                                        sessaoEncontrada = sessoes.get(i);
                                        break;
                                    }
                                }

                                if (clienteEncontrado != null && sessaoEncontrada != null) {
                                    IngressoMeia venderMeia = new IngressoMeia(idIngresso, clienteEncontrado, sessaoEncontrada, precoIngresso);
                                    idIngresso++;
                                    ingressos.add(venderMeia);
                                    System.out.println("Ingresso meia vendido com sucesso!");
                                } else {
                                    System.out.println("Cliente ou Sessão não encontrados!");
                                }
                            } else {
                                System.out.println("Cadastre clientes e sessões antes de vender ingressos.");
                            }
                            break;

                        case 3:
                            if (ingressos.size() != 0) {
                                for (int i = 0; i < ingressos.size(); i++) {
                                    ingressos.get(i).mostrarInformacao();
                                }
                            } else {
                                System.out.println("Nenhum ingresso vendido.");
                            }
                            break;

                        case 4:
                            if (ingressos.size() != 0) {
                                System.out.println("Digite o ID do ingresso:");
                                int idBuscar = leia.nextInt();
                                boolean encontrado = false;
                                for (int i = 0; i < ingressos.size(); i++) {
                                    if (ingressos.get(i).getId() == idBuscar) {
                                        ingressos.get(i).mostrarInformacao();
                                        encontrado = true;
                                        break;
                                    }
                                }
                                if (!encontrado) {
                                    System.out.println("Ingresso não encontrado!");
                                }
                            } else {
                                System.out.println("Nenhum ingresso vendido.");
                            }
                            break;

                        case 5:
                            if (ingressos.size() != 0) {
                                System.out.println("Digite o ID do ingresso para cancelar:");
                                int idCancelar = leia.nextInt();
                                boolean removido = false;
                                for (int i = 0; i < ingressos.size(); i++) {
                                    if (ingressos.get(i).getId() == idCancelar) {
                                        ingressos.remove(i);
                                        System.out.println("Ingresso cancelado com sucesso!");
                                        removido = true;
                                        break;
                                    }
                                }
                                if (!removido) {
                                    System.out.println("Ingresso não encontrado!");
                                }
                            } else {
                                System.out.println("Nenhum ingresso vendido.");
                            }
                            break;

                        case 0:
                            break;

                        default:
                            System.out.println("Opção não encontrada! Tente novamente");
                            break;
                    }
                    break;

                case 0:
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção não encontrada! Tente novamente");
                    break;
            }
        } while (opcao != 0);

        leia.close();
    }

    public static void menuCinema() {
        System.out.println("\n========= CINEMA =========");
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