import java.util.List;
import java.util.Scanner;
public class Gerenciamento {

    public static void main(String[] args) {

        System.out.println("Sistema de Gerenciamento do Aeroporto Jatinho Feliz");
        System.out.println("--------------------------------------------------");
        System.out.println(" 1 - Cadastrar Companhia Aérea!");
        System.out.println(" 2 - Cadastrar Aeronave!");
        System.out.println(" 3 - Cadastrar Hangar!");
        System.out.println(" 4 - Cadastrar pista!");
        System.out.println(" 5 - Cadastrar Voo!");
        System.out.println(" 6 - Listar Companhias Aéreas!");
        System.out.println(" 7 - Listar Aeronaves!");
        System.out.println(" 8 - Listar Hangares!");
        System.out.println(" 9 - Listar Pistas!");
        System.out.println("10 - Listar Voos!");
        System.out.println("11 - Alterar Companhia Aérea!");
        System.out.println("12 - Alterar Aeronave!");
        System.out.println("13 - Alterar Hangar!");
        System.out.println("14 - Alterar Pista!");
        System.out.println("15 - Alterar Voo!");
        System.out.println("16 - Excluir Companhia Aérea!");
        System.out.println("17 - Excluir Aeronave!");
        System.out.println("18 - Excluir Hangar!");
        System.out.println("19 - Excluir Pista!");
        System.out.println("20 - Excluir Voo!");
        System.out.println("21 - Sair!");
        System.out.println("--------------------------------------------------");
        System.out.println("Digite a opção desejada: ");
        Scanner scann = new Scanner(System.in);
        int opcao = scann.nextInt();
        switch (opcao) {
            case 1:
                System.out.println("Cadastrar Companhia Aérea!");
                cadastrarCompanhia(scann);
                break;
            case 2:
                System.out.println("Cadastrar Aeronave!");
                cadastrarAeronave(scann);
                break;
            case 3:
                System.out.println("Cadastrar Hangar!");
                cadastrarHangar(scann);
                break;
            case 4:
                System.out.println("Cadastrar Pista!");
                cadastrarPista(scann);
                break;
            case 5:
                System.out.println("Cadastrar Voo!");
                cadastrarVoo(scann);
                break;
            case 6:
                System.out.println("Listar Companhias Aéreas!");
                listarCompanhias(scann);
                break;
            case 7:
                System.out.println("Listar Aeronaves!");
                listarAeronaves(scann);
                break;
            case 8:
                System.out.println("Listar Hangares!");
                listarHangares(scann);
                break;
            case 9:
                System.out.println("Listar Pistas!");
                listarPistas(scann);
                break;
            case 10:
                System.out.println("Listar Voos!");
                listarVoos(scann);
                break;
            case 11:
                System.out.println("Alterar Companhia Aérea!");
                alterarCompanhia(scann);
                break;
            case 12:
                System.out.println("Alterar Aeronave!");
                alterarAeronave(scann);
                break;
            case 13:
                System.out.println("Alterar Hangar!");
                alterarHangar(scann);
                break;
            case 14:
                System.out.println("Alterar Pista!");
                alterarPista(scann);
                break;
            case 15:
                System.out.println("Alterar Voo!");
                alterarVoo(scann);
                break;
            case 16:
                System.out.println("Excluir Companhia Aérea!");
                excluirCompanhia(scann);
                break;
            case 17:
                System.out.println("Excluir Aeronave!");
                excluirAeronave(scann);
                break;
            case 18:
                System.out.println("Excluir Hangar!");
                excluirHangar(scann);
                break;
            case 19:
                System.out.println("Excluir Pista!");
                excluirPista(scann);
                break;
            case 20:
                System.out.println("Excluir Voo!");
                excluirVoo(scann);
                break;
            case 21:
                System.out.println("Sair!");
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }

// Métodos de cadastrar, listar, alterar e excluir do Menu

        public static void cadastrarCompanhia(Scanner scann) {
            System.out.println("Cadastrar Companhia Aérea!");
            System.out.println("Digite o nome da Companhia Aérea: ");
            String nome = scann.nextLine();
            System.out.println("Digite o CNPJ da Companhia Aérea: ");
            String cnpj = scann.nextLine();
            Companhia companhia = new Companhia(nome, cnpj);
            dataBase.insert(companhia);
        }

        public static void cadastrarAeronave(Scanner scann) {   
            System.out.println("Escolha o tipo de aeronave: ");	
            System.out.println("A - Avião!");
            System.out.println("H - Helicóptero!");
            System.out.println("J - Jato!");
            System.out.println("S - Sair!");
            String tipo = scann.next();
            switch (tipo) {
                case "A":
                    System.out.println("Digite a marca do Avião: ");
                    String marca = scann.next();
                    System.out.println("Digite o modelo do Avião: ");
                    String modelo = scann.next();
                    System.out.println("Digite o prefixo do Avião: ");
                    String prefixo = scann.next();
                    System.out.println("Digite a capacidade do Avião: ");
                    int capacidade = scann.nextInt();
                    System.out.println("Digite o id da Companhia Aérea: ");
                    int idCompanhia = scann.nextInt();
                    Aviao aviao = new Aviao(marca, modelo, prefixo, capacidade, idCompanhia);
                    dataBase.insert(aviao);
                    break;
                case "H":
                    System.out.println("Digite a marca do Helicóptero: ");
                    marca = scann.next();
                    System.out.println("Digite o modelo do Helicóptero: ");
                    modelo = scann.next();
                    System.out.println("Digite a cor do Helicóptero: ");
                    String cor = scann.next();
                    System.out.println("Digite a capacidade do Helicóptero: ");
                    capacidade = scann.nextInt();
                    Helicoptero helicoptero = new Helicoptero(marca, modelo, cor, capacidade);
                    dataBase.insert(helicoptero);
                    break;
                case "J":
                    System.out.println("Digite a marca do Jato: ");
                    marca = scann.next();
                    System.out.println("Digite o modelo do Jato: ");
                    modelo = scann.next();
                    System.out.println("Digite a cor do Jato: ");
                    cor = scann.next();
                    System.out.println("Digite a velocidade do Jato: ");
                    int velocidade = scann.nextInt();
                    Jato jato = new Jato(marca, modelo, cor, velocidade);
                    dataBase.insert(jato);
                    break;
                case "S":   
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }

        public static void cadastrarHangar(Scanner scann) {
            System.out.println("Cadastrar Hangar!");
            System.out.println("Digite o nome do Hangar: ");
            String local = scann.nextLine();
            System.out.println("Digite o id da Aeronave: ");
            int idAeronave = scann.nextInt();
            Hangar hangar = new Hangar(local, idAeronave);
            dataBase.insert(hangar);
        }

        public static void cadastrarPista(Scanner scann) {
            System.out.println("Cadastrar Pista!");
            System.out.println("Digite o numero da Pista: ");
            String numero = scann.nextLine();
            Pista pista = new Pista(numero);
            dataBase.insert(pista);
        }

        public static void cadastrarVoo(Scanner scann) {

            System.out.println("Cadastrar Voo!");
            System.out.println("Digite o numero do Voo: ");
            String numero = scann.nextLine();
            System.out.println("Digite a data do Voo: ");
            String data = scann.nextLine();
            System.out.println("Digite o horário do Voo: ");
            String hora = scann.nextLine();
            System.out.println("Digite a origem do Voo: ");
            String origem = scann.nextLine();
            System.out.println("Digite o destino do Voo: ");
            String destino = scann.nextLine();
            System.out.println("Digite o nome do Piloto: ");
            String piloto = scann.nextLine();
            System.out.println("Digite o nome do Copiloto: ");
            String copiloto = scann.nextLine();
            System.out.println("Digite a observação do Voo: ");
            System.out.println("Digite o id da Pista: ");
            int idPista = scann.nextInt();
            String observacao = scann.nextLine();
            System.out.println("Digite o id da Aeronave: ");
            int idAeronave = scann.nextInt();

            Voo voo = new Voo(numero, data, hora, origem, destino, piloto, copiloto, observacao, idPista, idAeronave);
            dataBase.insert(voo);
        }

        public static void listarCompanhias(Scanner scann) {
            System.out.println("Listar Companhia Aérea!");
            List<Companhia> companhias = dataBase.list();
            for (Companhia companhia : companhias) {
                System.out.println(companhia);
            }
        }

        public static void listarAeronaves(Scanner scann) {
            System.out.println("Listar Aeronave!");
            List<Aeronave> aeronaves = dataBase.list();
            for (Aeronave aeronave : aeronaves) {
                System.out.println(aeronave);
            }
        }

        public static void listarHangares(Scanner scann) {
            System.out.println("Listar Hangar!");
            List<Hangar> hangares = dataBase.list();
            for (Hangar hangar : hangares) {
                System.out.println(hangar);
            }
        }

        public static void listarPistas(Scanner scann) {
            System.out.println("Listar Pista!");
            List<Pista> pistas = dataBase.list();
            for (Pista pista : pistas) {
                System.out.println(pista);
            }
        }

        public static void listarVoos(Scanner scann) {
            System.out.println("Listar Voo!");
            List<Voo> voos = dataBase.list();
            for (Voo voo : voos) {
                System.out.println(voo);
            }
        }

        public static void alterarCompanhia(Scanner scann) {
            System.out.println("Alterar Companhia Aérea!");
            System.out.println("Digite o id da Companhia Aérea: ");
            int id = scann.nextInt();
            System.out.println("Digite o nome da Companhia Aérea: ");
            String nome = scann.next();
            System.out.println("Digite o cnpj da Companhia Aérea: ");
            String cnpj = scann.next();
            Companhia companhia = new Companhia(id, nome, cnpj);
            dataBase.update(companhia);
        }

        public static void alterarAeronave(Scanner scann) {
            System.out.println("Alterar Aeronave!");
            System.out.println("Digite o tipo da Aeronave: ");
            String tipo = scann.next();
            switch (tipo) {
                case "A":
                    System.out.println("Digite o id da Aeronave: ");
                    int idAeronave = scann.nextInt();
                    System.out.println("Digite a marca do Avião: ");
                    String marca = scann.next();
                    System.out.println("Digite o modelo do Avião: ");
                    String modelo = scann.next();
                    System.out.println("Digite o prefixo do Avião: ");
                    String prefixo = scann.next();
                    System.out.println("Digite a capacidade do Avião: ");
                    int capacidade = scann.nextInt();
                    System.out.println("Digite o Id da companhia Aérea: ");
                    int idCompanhia = scann.nextInt();
                    Aviao aviao = new Aviao(idAeronave, marca, modelo, prefixo, capacidade, idCompanhia);
                    dataBase.update(aviao);
                    break;
                case "H":
                    System.out.println("Digite o id da Aeronave: ");
                    idAeronave = scann.nextInt();
                    System.out.println("Digite a marca do Helicóptero: ");
                    marca = scann.next();
                    System.out.println("Digite o modelo do Helicóptero: ");
                    modelo = scann.next();
                    System.out.println("Digite a cor do Helicóptero: ");
                    String cor = scann.next();
                    System.out.println("Digite a capacidade do Helicóptero: ");
                    capacidade = scann.nextInt();
                    Helicoptero helicoptero = new Helicoptero(idAeronave, marca, modelo, cor, capacidade);
                    dataBase.update(helicoptero);
                    break;
                case "J":
                    System.out.println("Digite o id da Aeronave: ");
                    idAeronave = scann.nextInt();
                    System.out.println("Digite a marca do Jato: ");
                    marca = scann.next();
                    System.out.println("Digite o modelo do Jato: ");
                    modelo = scann.next();
                    System.out.println("Digite a cor do Jato: ");
                    cor = scann.next();
                    System.out.println("Digite a velocidade do Jato: ");
                    int velocidade = scann.nextInt();
                    Jato jato = new Jato(idAeronave, marca, modelo, cor, velocidade);
                    dataBase.update(jato);
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }

        public static void alterarHangar(Scanner scann) {
            System.out.println("Alterar Hangar!");
            System.out.println("Digite o id do Hangar: ");
            int idHangar = scann.nextInt();
            System.out.println("Digite o nome do Hangar: ");
            String local = scann.next();
            System.out.println("Digite o id da Aeronave: ");
            int idAeronave = scann.nextInt();
            Hangar hangar = new Hangar(idHangar, local, idAeronave);
            dataBase.update(hangar);
        }

        public static void alterarPista(Scanner scann) {
            System.out.println("Alterar Pista!");
            System.out.println("Digite o id da Pista: ");
            int idPista = scann.nextInt();
            System.out.println("Digite o numero da Pista: ");
            String numero = scann.next();
            Pista pista = new Pista(idPista, numero);
            dataBase.update(pista);
        }

        public static void alterarVoo(Scanner scann) {
            System.out.println("Alterar Voo!");
            System.out.println("Digite o id do Voo: ");
            int idVoo = scann.nextInt();
            System.out.println("Digite o numero do Voo: ");
            String numero = scann.next();
            System.out.println("Digite a data do Voo: ");
            String data = scann.next();
            System.out.println("Digite o horário do Voo: ");
            String hora = scann.next();
            System.out.println("Digite a origem do Voo: ");
            String origem = scann.next();
            System.out.println("Digite o destino do Voo: ");
            String destino = scann.next();
            System.out.println("Digite o Nome do Piloto: ");
            String piloto = scann.next();
            System.out.println("Digite o Nome do Copiloto: ");
            String copiloto = scann.next();
            System.out.println("Digite a observação do Voo: ");
            String observacao = scann.next();
            System.out.println("Digite o id da Aeronave: ");
            int idAeronave = scann.nextInt();
            System.out.println("Digite o id da Pista: ");
            int idPista = scann.nextInt();
            Voo voo = new Voo(idVoo, numero, data, hora, origem, destino, piloto, copiloto, observacao, idPista, idAeronave);
            dataBase.update(voo);
        }

        public static void excluirCompanhia(Scanner scann) {
            System.out.println("Excluir Companhia Aérea!");
            System.out.println("Digite o id da Companhia Aérea: ");
            int idCompanhia = scann.nextInt();
            dataBase.delete(idCompanhia);
        }

        public static void excluirAeronave(Scanner scann) {
            System.out.println("Excluir Aeronave!");
            System.out.println("Digite o id da Aeronave: ");
            int idAeronave = scann.nextInt();
            dataBase.delete(idAeronave);
        }

        public static void excluirHangar(Scanner scann) {
            System.out.println("Excluir Hangar!");
            System.out.println("Digite o id do Hangar: ");
            int idHangar = scann.nextInt();
            dataBase.delete(idHangar);
        }

        public static void excluirPista(Scanner scann) {
            System.out.println("Excluir Pista!");
            System.out.println("Digite o id da Pista: ");
            int idPista = scann.nextInt();
            dataBase.delete(idPista);
        }

        public static void excluirVoo(Scanner scann) {
            System.out.println("Excluir Voo!");
            System.out.println("Digite o id do Voo: ");
            int idVoo = scann.nextInt();
            dataBase.delete(idVoo);
        }

        
}
