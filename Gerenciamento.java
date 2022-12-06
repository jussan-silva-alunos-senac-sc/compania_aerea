import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
public class Gerenciamento {

    public static void main(String[] args) throws SQLException {

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
        System.out.println("21 - Realizar nova operação!");
        System.out.println("22 - Sair!");
        System.out.println("--------------------------------------------------");
        System.out.println("Digite a opção desejada: ");
        Scanner scann = new Scanner(System.in);
        int opcao = scann.nextInt();
        switch (opcao) {
            case 1:
                System.out.println("Digite o nome da Companhia Aérea: ");
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
                listarCompanhias();
                break;
            case 7:
                System.out.println("Listar Aeronaves!");
                listarAeronaves();
                break;
            case 8:
                System.out.println("Listar Hangares!");
                listarHangares();
                break;
            case 9:
                System.out.println("Listar Pistas!");
                listarPistas();
                break;
            case 10:
                System.out.println("Listar Voos!");
                listarVoos();
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
                System.out.println("Realizar nova operação!");
                main(null);
                break;
            case 22:
                System.out.println("Sair!");
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }

// Métodos de cadastrar, listar, alterar e excluir do Menu

        public static void cadastrarCompanhia(Scanner scann) throws SQLException {
            System.out.println("Cadastrar Companhia Aérea!");
            System.out.println("Digite o nome da Companhia Aérea: ");
            String nome = scann.next();
            System.out.println("Digite o CNPJ da Companhia Aérea: ");
            String cnpj = scann.next();
            Companhia companhia = new Companhia(nome, cnpj);
            try {
                companhia.insert();
                System.out.println("Companhia Aérea cadastrada com sucesso!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println("--------------------------------------------------");
            System.out.println("Digite 21 para realizar nova operação ou 22 para sair: ");
            int opcao = scann.nextInt();
            if (opcao == 21) {
                main(null);
            } else {
                System.out.println("Sair!");
            }
        }

        public static void cadastrarAeronave(Scanner scann) throws SQLException {   
            System.out.println("Escolha o tipo de aeronave: ");	
            System.out.println("A - Avião!");
            System.out.println("H - Helicóptero!");
            System.out.println("J - Jato!");
            System.out.println("S - Sair!");
            String tipo = scann.next();
            if (tipo == "A" || tipo == "a"){
                tipo = "A";
            } else if (tipo == "H" || tipo == "h"){
                tipo = "H";
            } else if (tipo == "J" || tipo == "j"){
                tipo = "J";
            } else if (tipo == "S" || tipo == "s"){
                System.out.println("Sair!");
            } else {
                System.out.println("Opção inválida!");
            }
            switch (tipo) {
                case "A":
                    System.out.println("Digite a marca do Avião: ");
                    String marca = scann.next();
                    System.out.println("Digite o modelo do Avião: ");
                    String modelo = scann.next();
                    System.out.println("Digite o prefixo do Avião: composto por 3 letras e 4 números: ");
                    while (true) {
                        String prefixo = scann.next();
                        if (prefixo.matches("[A-Z]{3}[0-9]{4}")) {
                            System.out.println("Prefixo válido!");
                            Identificacao identificacao = new Identificacao(prefixo);
                        } else {
                            System.out.println("Prefixo inválido! Digite novamente: ");
                        }
                    }
                    System.out.println("Digite a capacidade do Avião: ");
                    int capacidade = scann.nextInt();
                    System.out.println("Digite o id da Companhia Aérea: ");
                    int idCompanhia = scann.nextInt();
                    Companhia companhia = Companhia.getById(idCompanhia);
                    while (companhia == null) {
                        System.out.println("Companhia Aérea não encontrada!");
                        System.out.println("Digite um id de Companhia Aérea Válido: ");
                        idCompanhia = scann.nextInt();
                    }
                    Aviao aviao = new Aviao(marca, modelo, prefixo, capacidade, companhia);
                    try {
                        System.out.println("Cadastrando Avião!");
                        aviao.insert();
                        System.out.println("Avião cadastrado com sucesso!");
                        System.out.println("--------------------------------------------------");
                    } catch (Exception eAviao) {
                        // TODO Auto-generated catch block
                        eAviao.printStackTrace();
                    }
                    System.out.println("--------------------------------------------------");
                    System.out.println("Digite 21 para realizar nova operação ou 22 para sair: ");
                    int opcao = scann.nextInt();
                    if (opcao == 21) {
                        main(null);
                    } else {
                        System.out.println("Sair!");
                    }
                    break;
                case "H":
                    System.out.println("Digite a marca do Helicóptero: ");
                    String marcah = scann.next();
                    System.out.println("Digite o modelo do Helicóptero: ");
                    String modeloh = scann.next();
                    System.out.println("Digite a cor do Helicóptero: ");
                    String cor = scann.next();
                    System.out.println("Digite a capacidade do Helicóptero: ");
                    capacidade = scann.nextInt();
                    Helicoptero helicoptero = new Helicoptero(marcah, modeloh, cor, capacidade);
                    try {
                        helicoptero.insert();
                        System.out.println("Helicóptero cadastrado com sucesso!");
                        System.out.println("--------------------------------------------------");
                    } catch (Exception eHelicoptero) {
                        // TODO Auto-generated catch block
                        eHelicoptero.printStackTrace();
                    }
                    System.out.println("--------------------------------------------------");
                    System.out.println("Digite 21 para realizar nova operação ou 22 para sair: ");
                    opcao = scann.nextInt();
                    if (opcao == 21) {
                        main(null);
                    } else {
                        System.out.println("Sair!");
                    }
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
                    try {
                        jato.insert();
                        System.out.println("Jato cadastrado com sucesso!");
                        System.out.println("--------------------------------------------------");
                    } catch (Exception eJato) {
                        // TODO Auto-generated catch block
                        eJato.printStackTrace();
                    }
                    System.out.println("--------------------------------------------------");
                    System.out.println("Digite 21 para realizar nova operação ou 22 para sair: ");
                    opcao = scann.nextInt();
                    if (opcao == 21) {
                        main(null);
                    } else {
                        System.out.println("Sair!");
                    }
                    break;
                case "S":   
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }

        public static void cadastrarHangar(Scanner scann) throws SQLException {
            System.out.println("Cadastrar Hangar!");
            System.out.println("Digite o nome do Hangar: ");
            String local = scann.nextLine();
            System.out.println("Digite o id da Aeronave: ");
            int idAeronave = scann.nextInt();
            Hangar hangar = new Hangar(local, idAeronave);
            try {
                hangar.insert();
                System.out.println("Hangar cadastrado com sucesso!");
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("--------------------------------------------------");
            System.out.println("Digite 21 para realizar nova operação ou 22 para sair: ");
            int opcao = scann.nextInt();
            if (opcao == 21) {
                main(null);
            } else {
                System.out.println("Sair!");
            }
        }

        public static void cadastrarPista(Scanner scann) throws SQLException {
            System.out.println("Cadastrar Pista!");
            System.out.println("Digite o numero da Pista: ");
            String numero = scann.nextLine();
            Pista pista = new Pista(numero);
            try {
                pista.insert();
                System.out.println("Pista cadastrada com sucesso!");
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("--------------------------------------------------");
            System.out.println("Digite 21 para realizar nova operação ou 22 para sair: ");
            int opcao = scann.nextInt();
            if (opcao == 21) {
                main(null);
            } else {
                System.out.println("Sair!");
            }
        }

        public static void cadastrarVoo(Scanner scann) throws SQLException {
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
            try {
                voo.insert();
                System.out.println("Voo cadastrado com sucesso!");
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("--------------------------------------------------");
            System.out.println("Digite 21 para realizar nova operação ou 22 para sair: ");
            int opcao = scann.nextInt();
            if (opcao == 21) {
                main(null);
            } else {
                System.out.println("Sair!");
            }
        }

        public static void listarCompanhias() throws SQLException {
            Companhia companhia = new Companhia();
            try {
                System.out.println("Listando todas as Companhias cadastradas em nosso sistema!");
                List<Companhia> comps = companhia.getAll();
                for(Companhia comp : comps){
                System.out.println(comp.toString());
                }
                System.out.println("Listagem concluída com Sucesso!");
                System.out.println("--------------------------------------------------");
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("--------------------------------------------------");
            System.out.println("Digite 21 para realizar nova operação ou 22 para sair: ");
            Scanner scann = new Scanner(System.in);
            int opcao = scann.nextInt();
            if (opcao == 21) {
                main(null);
            } else {
                System.out.println("Sair!");
            }
        }

        public static void listarAeronaves() throws SQLException {
            System.out.println("Listar Aeronaves!");
            System.out.println("Escolha qual tipo de Aeronave deseja listar: ");
            System.out.println("A - Avião!");
            System.out.println("H - Helicóptero!");
            System.out.println("J - Jato!");
            System.out.println("S - Sair!");
            Scanner scann = new Scanner(System.in);
            String opcao = scann.nextLine();
            if (opcao == "A" || opcao == "a") {
                opcao = "A";
            } else if (opcao == "H" || opcao == "h") {
                opcao = "H";
            } else if (opcao == "J" || opcao == "j") {
                opcao = "J";
            } else if (opcao == "S" || opcao == "s") {
                System.out.println("Sair!");
            } else {
                System.out.println("Opção inválida!");
            }
            switch (opcao) {
                case "A":
                    Aviao aviao = new Aviao();
                    try {
                        System.out.println("Listando todos os Aviões cadastrados em nosso sistema!");
                        aviao.getAll();
                    } catch (Exception eAviao) {
                        // TODO Auto-generated catch block
                        eAviao.printStackTrace();
                    }
                    break;
                case "H":
                    Helicoptero helicoptero = new Helicoptero();
                    try {
                        System.out.println("Listando todos os Helicópteros cadastrados em nosso sistema!");
                        helicoptero.getAll();
                    } catch (Exception eHelicoptero) {
                        // TODO Auto-generated catch block
                        eHelicoptero.printStackTrace();
                    }
                    break;
                case "J":
                    Jato jato = new Jato();
                    try {
                        System.out.println("Listando todos os Jatos cadastrados em nosso sistema!");
                        jato.getAll();
                    } catch (Exception eJato) {
                        // TODO Auto-generated catch block
                        eJato.printStackTrace();
                    }
                    break;
                case "S":
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
            System.out.println("--------------------------------------------------");
            System.out.println("Digite 21 para realizar nova operação ou 22 para sair: ");
            int opcao2 = scann.nextInt();
            if (opcao2 == 21) {
                main(null);
            } else {
                System.out.println("Sair!");
            }
        }

        public static void listarHangares() throws SQLException {
            System.out.println("Listar Hangares!");
            try {
                System.out.println("Listando todos os Hangares cadastrados em nosso sistema!");
                Hangar.getAll();
                System.out.println("Listagem concluída com Sucesso!");
                System.out.println("--------------------------------------------------");
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("--------------------------------------------------");
            System.out.println("Digite 21 para realizar nova operação ou 22 para sair: ");
            Scanner scann = new Scanner(System.in);
            int opcao = scann.nextInt();
            if (opcao == 21) {
                main(null);
            } else {
                System.out.println("Sair!");
            }
        }

        public static void listarPistas() throws SQLException {
            System.out.println("Listar Pista!");
            try {
                System.out.println("Listando todas as Pistas cadastradas em nosso sistema!");
                Pista.getAll();
                System.out.println("Listagem concluída com Sucesso!");
                System.out.println("--------------------------------------------------");
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("--------------------------------------------------");
            System.out.println("Digite 21 para realizar nova operação ou 22 para sair: ");
            Scanner scann = new Scanner(System.in);
            int opcao = scann.nextInt();
            if (opcao == 21) {
                main(null);
            } else {
                System.out.println("Sair!");
            }
        }

        public static void listarVoos() throws SQLException {
            System.out.println("Listar Voos!");
            try {
                System.out.println("Listando todos os Voos cadastrados em nosso sistema!");
                Voo.getAll();
                System.out.println("Listagem concluída com Sucesso!");
                System.out.println("--------------------------------------------------");
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("--------------------------------------------------");
            System.out.println("Digite 21 para realizar nova operação ou 22 para sair: ");
            Scanner scann = new Scanner(System.in);
            int opcao = scann.nextInt();
            if (opcao == 21) {
                main(null);
            } else {
                System.out.println("Sair!");
            }
        }

        public static void alterarCompanhia(Scanner scann) throws SQLException {
            System.out.println("Alterar Companhia Aérea!");
            System.out.println("Digite o id da Companhia Aérea: ");
            int idCompanhia = scann.nextInt();
            System.out.println("Digite o nome da Companhia Aérea: ");
            String nome = scann.next();
            System.out.println("Digite o cnpj da Companhia Aérea: ");
            String cnpj = scann.next();
            Companhia companhia = new Companhia(idCompanhia, nome, cnpj);
            try {
                System.out.println("Alterando Companhia Aérea!");
                companhia.update();
                System.out.println("Alteração concluída com Sucesso!");
                System.out.println("--------------------------------------------------");
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("--------------------------------------------------");
            System.out.println("Digite 21 para realizar nova operação ou 22 para sair: ");
            int opcao = scann.nextInt();
            if (opcao == 21) {
                main(null);
            } else {
                System.out.println("Sair!");
            }
        }

        public static void alterarAeronave(Scanner scann) throws SQLException {
            System.out.println("Alterar Aeronave!");
            System.out.println("Digite o tipo da Aeronave: ");
            System.out.println("Digite A - para Avião: ");
            System.out.println("Digite H - para Helicóptero: ");
            System.out.println("Digite J - para Jato: ");
            String tipo = scann.next();
            if (tipo == "A" || tipo == "a") {
                tipo = "A";
            } else if (tipo == "H" || tipo == "h") {
                tipo = "H";
            } else if (tipo == "J" || tipo == "j") {
                tipo = "J";
            } else {
                System.out.println("Tipo de Aeronave inválido!");
            }
            switch (tipo) {
                case "A":
                    System.out.println("Digite o id da Aeronave: ");
                    int idAviao = scann.nextInt();
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
                    Companhia companhia = Companhia.getById(idCompanhia);
                    Aviao aviao = new Aviao();
                    try {
                        System.out.println("Alterando Avião!");
                        aviao.update();
                        System.out.println("Alteração concluída com Sucesso!");
                        System.out.println("--------------------------------------------------");
                    } catch (SQLException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                    System.out.println("--------------------------------------------------");
                    System.out.println("Digite 21 para realizar nova operação ou 22 para sair: ");
                    int opcao = scann.nextInt();
                    if (opcao == 21) {
                        main(null);
                    } else {
                        System.out.println("Sair!");
                    }
                    break;
                case "H":
                    System.out.println("Digite o id da Aeronave: ");
                    int idHelicoptero = scann.nextInt();
                    System.out.println("Digite a marca do Helicóptero: ");
                    marca = scann.next();
                    System.out.println("Digite o modelo do Helicóptero: ");
                    modelo = scann.next();
                    System.out.println("Digite a cor do Helicóptero: ");
                    String cor = scann.next();
                    System.out.println("Digite a capacidade do Helicóptero: ");
                    capacidade = scann.nextInt();
                    Helicoptero helicoptero = new Helicoptero(idHelicoptero, marca, modelo, cor, capacidade);
                    try {
                        System.out.println("Alterando Helicóptero!");
                        helicoptero.update();
                        System.out.println("Alteração concluída com Sucesso!");
                        System.out.println("--------------------------------------------------");
                    } catch (Exception e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                    System.out.println("--------------------------------------------------");
                    System.out.println("Digite 21 para realizar nova operação ou 22 para sair: ");
                    opcao = scann.nextInt();
                    if (opcao == 21) {
                        main(null);
                    } else {
                        System.out.println("Sair!");
                    }
                    break;
                case "J":
                    System.out.println("Digite o id da Aeronave: ");
                    int idJato = scann.nextInt();
                    System.out.println("Digite a marca do Jato: ");
                    marca = scann.next();
                    System.out.println("Digite o modelo do Jato: ");
                    modelo = scann.next();
                    System.out.println("Digite a cor do Jato: ");
                    cor = scann.next();
                    System.out.println("Digite a velocidade do Jato: ");
                    int velocidade = scann.nextInt();
                    Jato jato = new Jato(idJato, marca, modelo, cor, velocidade);
                    try {
                        System.out.println("Alterando Jato!");
                        jato.update();
                        System.out.println("Alteração concluída com Sucesso!");
                        System.out.println("--------------------------------------------------");
                    } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    System.out.println("--------------------------------------------------");
                    System.out.println("Digite 21 para realizar nova operação ou 22 para sair: ");
                    opcao = scann.nextInt();
                    if (opcao == 21) {
                        main(null);
                    } else {
                        System.out.println("Sair!");
                    }
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }

        public static void alterarHangar(Scanner scann) throws SQLException {
            System.out.println("Alterar Hangar!");
            System.out.println("Digite o id do Hangar: ");
            int idHangar = scann.nextInt();
            System.out.println("Digite o nome do Hangar: ");
            String local = scann.next();
            System.out.println("Digite o id da Aeronave: ");
            int idAeronave = scann.nextInt();
            Hangar hangar = new Hangar(idHangar, local, idAeronave);
            try {
                System.out.println("Alterando Hangar!");
                hangar.update();
                System.out.println("Alteração concluída com Sucesso!");
                System.out.println("--------------------------------------------------");
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("--------------------------------------------------");
            System.out.println("Digite 21 para realizar nova operação ou 22 para sair: ");
            int opcao = scann.nextInt();
            if (opcao == 21) {
                main(null);
            } else {
                System.out.println("Sair!");
            }
        }

        public static void alterarPista(Scanner scann) throws SQLException {
            System.out.println("Alterar Pista!");
            System.out.println("Digite o id da Pista: ");
            int idPista = scann.nextInt();
            System.out.println("Digite o numero da Pista: ");
            String numero = scann.next();
            Pista pista = new Pista(idPista, numero);
            try {
                System.out.println("Alterando Pista!");
                pista.update();
                System.out.println("Alteração concluída com Sucesso!");
                System.out.println("--------------------------------------------------");
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("--------------------------------------------------");
            System.out.println("Digite 21 para realizar nova operação ou 22 para sair: ");
            int opcao = scann.nextInt();
            if (opcao == 21) {
                main(null);
            } else {
                System.out.println("Sair!");
            }
        }

        public static void alterarVoo(Scanner scann) throws SQLException {
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
            try {
                System.out.println("Alterando Voo!");
                voo.update();
                System.out.println("Alteração concluída com Sucesso!");
                System.out.println("--------------------------------------------------");
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("--------------------------------------------------");
            System.out.println("Digite 21 para realizar nova operação ou 22 para sair: ");
            int opcao = scann.nextInt();
            if (opcao == 21) {
                main(null);
            } else {
                System.out.println("Sair!");
            }
        }

        public static void excluirCompanhia(Scanner scann) throws SQLException {
            System.out.println("Excluir Companhia!");
            System.out.println("Digite o id da Companhia: ");
            int idCompanhia = scann.nextInt();
            Companhia companhia = new Companhia();
            try {
                System.out.println("Excluindo Companhia!");
                companhia.delete();
                System.out.println("Exclusão concluída com Sucesso!");
                System.out.println("--------------------------------------------------");
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("--------------------------------------------------");
            System.out.println("Digite 21 para realizar nova operação ou 22 para sair: ");
            int opcao = scann.nextInt();
            if (opcao == 21) {
                main(null);
            } else {
                System.out.println("Sair!");
            }
        }

        public static void excluirAeronave(Scanner scann) throws SQLException {
            System.out.println("Excluir Aeronave!");
            System.out.println("Digite o tipo da Aeronave: ");
            System.out.println("A - Avião");
            System.out.println("H - Helicóptero");
            System.out.println("J - Jato");
            System.out.println("S - Sair");
            String tipo = scann.next();
            if (tipo == "A" || tipo =="a") {
                tipo = "A";
            } else if (tipo == "H" || tipo =="h") {
                tipo = "H";
            } else if (tipo == "J" || tipo =="j") {
                tipo = "J";
            } else {
                System.out.println("Sair!");
            }
            switch (tipo) {
                case "A":
                    System.out.println("Digite o id da Aeronave: ");
                    int idAeronave = scann.nextInt();
                    Aviao aviao = new Aviao();
                    try {
                        System.out.println("Excluindo Aeronave!");
                        aviao.delete();
                        System.out.println("Exclusão concluída com Sucesso!");
                        System.out.println("--------------------------------------------------");
                    } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    System.out.println("--------------------------------------------------");
                    System.out.println("Digite 21 para realizar nova operação ou 22 para sair: ");
                    int opcao = scann.nextInt();
                    if (opcao == 21) {
                        main(null);
                    } else {
                        System.out.println("Sair!");
                    }
                    break;
                case "H":
                    System.out.println("Digite o id da Aeronave: ");
                    idAeronave = scann.nextInt();
                    Helicoptero helicoptero = new Helicoptero();
                    try {
                        System.out.println("Excluindo Aeronave!");
                        helicoptero.delete();
                        System.out.println("Helicóptero excluído com sucesso!");
                        System.out.println("--------------------------------------------------");
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    System.out.println("--------------------------------------------------");
                    System.out.println("Digite 21 para realizar nova operação ou 22 para sair: ");
                    opcao = scann.nextInt();
                    if (opcao == 21) {
                        main(null);
                    } else {
                        System.out.println("Sair!");
                    }
                    break;
                case "J":
                    System.out.println("Digite o id da Aeronave: ");
                    idAeronave = scann.nextInt();
                    Jato jato = new Jato();
                    try {
                        System.out.println("Excluindo Aeronave!");
                        jato.delete();
                        System.out.println("Jato excluído com sucesso!");
                        System.out.println("--------------------------------------------------");
                    } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    System.out.println("--------------------------------------------------");
                    System.out.println("Digite 21 para realizar nova operação ou 22 para sair: ");
                    opcao = scann.nextInt();
                    if (opcao == 21) {
                        main(null);
                    } else {
                        System.out.println("Sair!");
                    }
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
        
        
       

        public static void excluirHangar(Scanner scann) throws SQLException {
            System.out.println("Excluir Hangar!");
            System.out.println("Digite o id do Hangar: ");
            int idHangar = scann.nextInt();
            Hangar hangar = new Hangar();
            try {
                System.out.println("Excluindo Hangar!");
                hangar.delete();
                System.out.println("Hangar excluído com sucesso!");
                System.out.println("--------------------------------------------------");
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("--------------------------------------------------");
            System.out.println("Digite 21 para realizar nova operação ou 22 para sair: ");
            int opcao = scann.nextInt();
            if (opcao == 21) {
                main(null);
            } else {
                System.out.println("Sair!");
            }
        }

        public static void excluirPista(Scanner scann) throws SQLException {
            System.out.println("Excluir Pista!");
            System.out.println("Digite o id da Pista: ");
            int idPista = scann.nextInt();
            Pista pista = new Pista();
            try {
                System.out.println("Excluindo Pista!");
                pista.delete();
                System.out.println("Pista excluída com sucesso!");
                System.out.println("--------------------------------------------------");
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("--------------------------------------------------");
            System.out.println("Digite 21 para realizar nova operação ou 22 para sair: ");
            int opcao = scann.nextInt();
            if (opcao == 21) {
                main(null);
            } else {
                System.out.println("Sair!");
            }
        }

        public static void excluirVoo(Scanner scann) throws SQLException {
            System.out.println("Excluir Voo!");
            System.out.println("Digite o id do Voo: ");
            int idVoo = scann.nextInt();
            Voo voo = new Voo();
            try {
                System.out.println("Excluindo Voo!");
                voo.delete();
                System.out.println("Voo excluído com sucesso!");
                System.out.println("--------------------------------------------------");
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("--------------------------------------------------");
            System.out.println("Digite 21 para realizar nova operação ou 22 para sair: ");
            int opcao = scann.nextInt();
            if (opcao == 21) {
                main(null);
            } else {
                System.out.println("Sair!");
            }
        }

        public void sair() {
            System.out.println("Sair!");
        }        
}
