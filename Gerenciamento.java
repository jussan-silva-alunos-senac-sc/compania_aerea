import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.*;

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
                System.out.println("Saindo do Sistema, até a próxima!");
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
                System.out.println("Saindo do Sistema, até a próxima!");
            }
        }

        public static void cadastrarAeronave(Scanner scann) throws SQLException {   
            System.out.println("Escolha o tipo de aeronave: ");	
            System.out.println("A - Avião!");
            System.out.println("H - Helicóptero!");
            System.out.println("J - Jato!");
            System.out.println("S - Sair!");
            String tipo = scann.next();
            tipo = tipo.toUpperCase();
            switch (tipo) {
                case "A":
                    System.out.println("Digite a marca do Avião: ");
                    String marca = scann.next();
                    System.out.println("Digite o modelo do Avião: ");
                    String modelo = scann.next();
                    boolean isPrefixoInvalid = true;
                    Identificacao identificacao = new Identificacao();

                    while (isPrefixoInvalid) {
                        System.out.println("Digite o prefixo do Avião: composto por 3 letras e 4 números: ");
                        String prefixo = scann.next();
                        prefixo = prefixo.toUpperCase();

                        if (prefixo.matches("[A-Z]{3}[0-9]{4}")) {
                            System.out.println("Prefixo válido!");
                            identificacao = new Identificacao(prefixo);
                            isPrefixoInvalid = false;

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
                    System.out.println(companhia.toString());         
                    Aviao aviao = new Aviao(marca, modelo, identificacao, capacidade, companhia);
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
                        System.out.println("Saindo do Sistema, até a próxima!");
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
                        System.out.println("Saindo do Sistema, até a próxima!");
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
                        System.out.println("Saindo do Sistema, até a próxima!");
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
            System.out.println("Digite o id do Avião: ");
            int idAviao = scann.nextInt();
            Aviao aviao = Aviao.getById(idAviao);
            while (aviao == null) {
                System.out.println("Avião não encontrado!");
                System.out.println("Digite um id de Avião Válido: ");
                idAviao = scann.nextInt();
            }
            System.out.println(aviao.toString());
            Hangar hangar = new Hangar(local, idAviao);
            try {
                hangar.insert();
                System.out.println("Hangar cadastrado com sucesso!");
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
                System.out.println("Saindo do Sistema, até a próxima!");
            }
        }

        public static void cadastrarPista(Scanner scann) throws SQLException {
            System.out.println("Cadastrar Pista!");
            boolean isNumeroInvalido = true;
            Identificacao identificacao = new Identificacao<>();
            while (isNumeroInvalido) {
                System.out.println("Digite o numero da Pista:  Composto por 1 letra e 2 números. Ex: A01 ");
                String numero = scann.nextLine();
                numero = numero.toUpperCase();
                if (numero.matches("[A-Z]{1}[0-9]{2}")) {
                    System.out.println("Numero da Pista válido!");
                    identificacao = new Identificacao(numero);
                    isNumeroInvalido = false;
                } else { 
                    System.out.println("Numero da Pista inválido! Digite Novamente!");
                }
            Pista pista = new Pista(identificacao);
            try {
                System.out.println("Cadastrando Pista...");
                pista.insert();
                System.out.println("Pista cadastrada com sucesso!");
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
                System.out.println("Saindo do Sistema, até a próxima!");
            }
        }

        public static void cadastrarVoo(Scanner scann) throws SQLException {
            System.out.println("Cadastrar Voo!");
            boolean isNumeroInvalido = true;
            Identificacao identificacao = new Identificacao<>();
            while (isNumeroInvalido) {
                System.out.println("Digite o numero da Pista:  Composto por 3 letras e 6 números. Ex: ABC123456 ");
                String numero = scann.nextLine();
                numero = numero.toUpperCase();
                if (numero.matches("[A-Z]{3}[0-9]{6}")) {
                    System.out.println("Numero da Pista válido!");
                    identificacao = new Identificacao(numero);
                    isNumeroInvalido = false;
                } else { 
                    System.out.println("Numero da Pista inválido! Digite Novamente!");
                }
            System.out.println("Digite a data do Voo:  Ex: 2020-12-31");
            String data = scann.nextLine();
            System.out.println("Digite o horário do Voo: Ex: 12:00");
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
            String observacao = scann.nextLine();
            System.out.println("Digite o id da Pista: ");
            int idPista = scann.nextInt();
            Pista pista = Pista.getById(idPista);
            while (pista == null) {
                System.out.println("Pista não encontrada!");
                System.out.println("Digite um id de Pista Válido: ");
                idPista = scann.nextInt();
            }
            System.out.println(pista.toString());
            
            System.out.println("Digite o id da Aeronave: ");
            int idAeronave = scann.nextInt();
            Aeronave aeronave = Aeronave.getById(idAeronave);
            while (aeronave == null) {
                System.out.println("Aeronave não encontrada!");
                System.out.println("Digite um id de Aeronave Válido: ");
                idAeronave = scann.nextInt();
            }
            System.out.println(aeronave.toString());

            Voo voo = new Voo(identificacao, data, hora, origem, destino, piloto, copiloto, observacao, idPista, idAeronave);
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
                System.out.println("Saindo do Sistema, até a próxima!");
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
                System.out.println("Saindo do Sistema, até a próxima!");
            }
        }

        public static void listarAeronaves() throws SQLException {
            System.out.println("Listar Aeronaves!");
            System.out.println("Escolha qual tipo de Aeronave deseja listar: ");
            System.out.println("A - Avião!");
            System.out.println("H - Helicóptero!");
            System.out.println("J - Jato!");
            Scanner scann = new Scanner(System.in);
            String opcao = scann.nextLine();
            opcao = opcao.toUpperCase();
            switch (opcao) {
                case "A":
                    Aviao aviao = new Aviao();
                    try {
                        System.out.println("Listando todos os Aviões cadastrados em nosso sistema!");
                        List<Aviao> avs = aviao.getAll();
                        for(Aviao av : avs){
                            System.out.println(av.toString());
                        }
                        System.out.println("Listagem concluída com Sucesso!");
                        System.out.println("--------------------------------------------------");
                    } catch (Exception eAviao) {
                        // TODO Auto-generated catch block
                        eAviao.printStackTrace();
                    }
                    System.out.println("--------------------------------------------------");
                    System.out.println("Digite 21 para realizar nova operação ou 22 para sair: ");
                    int opcao2 = scann.nextInt();
                    if (opcao2 == 21) {
                        main(null);
                    } else {
                        System.out.println("Saindo do Sistema, até a próxima!");
                    }
                    break;
                case "H":
                    Helicoptero helicoptero = new Helicoptero();
                    try {
                        System.out.println("Listando todos os Helicópteros cadastrados em nosso sistema!");
                        List<Helicoptero> helis = helicoptero.getAll();
                        for(Helicoptero heli : helis){
                            System.out.println(heli.toString());
                        }
                        System.out.println("Listagem concluída com Sucesso!");
                        System.out.println("--------------------------------------------------");
                    } catch (Exception eHelicoptero) {
                        // TODO Auto-generated catch block
                        eHelicoptero.printStackTrace();
                    }
                    System.out.println("--------------------------------------------------");
                    System.out.println("Digite 21 para realizar nova operação ou 22 para sair: ");
                    int opcao3 = scann.nextInt();
                    if (opcao3 == 21) {
                        main(null);
                    } else {
                        System.out.println("Saindo do Sistema, até a próxima!");
                    }
                    break;
                case "J":
                    Jato jato = new Jato();
                    try {
                        System.out.println("Listando todos os Jatos cadastrados em nosso sistema!");
                        List<Jato> jts = jato.getAll();
                        for(Jato jt : jts){
                            System.out.println(jt.toString());
                        }
                        System.out.println("Listagem concluída com Sucesso!");
                        System.out.println("--------------------------------------------------");
                    } catch (Exception eJato) {
                        // TODO Auto-generated catch block
                        eJato.printStackTrace();
                    }
                    System.out.println("--------------------------------------------------");
                    System.out.println("Digite 21 para realizar nova operação ou 22 para sair: ");
                    int opcao4 = scann.nextInt();
                    if (opcao4 == 21) {
                        main(null);
                    } else {
                        System.out.println("Saindo do Sistema, até a próxima!");
                    }
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }

        public static void listarHangares() throws SQLException {
            System.out.println("Listar Hangares!");
            try {
                System.out.println("Listando todos os Hangares cadastrados em nosso sistema!");
                List<Hangar> hgs = Hangar.getAll();
                for(Hangar hg : hgs){
                    System.out.println(hg.toString());
                }
                System.out.println("Listagem concluída com Sucesso!");
                System.out.println("--------------------------------------------------");
            } catch (Exception eHangar) {
                // TODO Auto-generated catch block
                eHangar.printStackTrace();
            }
            System.out.println("--------------------------------------------------");
            System.out.println("Digite 21 para realizar nova operação ou 22 para sair: ");
            Scanner scann = new Scanner(System.in);
            int opcao = scann.nextInt();
            if (opcao == 21) {
                main(null);
            } else {
                System.out.println("Saindo do Sistema, até a próxima!");
            }
        }

        public static void listarPistas() throws SQLException {
            System.out.println("Listar Pista!");
            try {
                System.out.println("Listando todas as Pistas cadastradas em nosso sistema!");
                List<Pista> psts = Pista.getAll();
                for(Pista pst : psts){
                    System.out.println(pst.toString());
                }
                System.out.println("Listagem concluída com Sucesso!");
                System.out.println("--------------------------------------------------");
            } catch (Exception ePista) {
                // TODO Auto-generated catch block
                ePista.printStackTrace();
            }
            System.out.println("--------------------------------------------------");
            System.out.println("Digite 21 para realizar nova operação ou 22 para sair: ");
            Scanner scann = new Scanner(System.in);
            int opcao = scann.nextInt();
            if (opcao == 21) {
                main(null);
            } else {
                System.out.println("Saindo do Sistema, até a próxima!");
            }
        }

        public static void listarVoos() throws SQLException {
            System.out.println("Listar Voos!");
            try {
                System.out.println("Listando todos os Voos cadastrados em nosso sistema!");
                List<Voo> vvs = Voo.getAll();
                for(Voo vv : vvs){
                    System.out.println(vv.toString());
                }
                System.out.println("Listagem concluída com Sucesso!");
                System.out.println("Deseja exportar essa lista em um arquivo de texto? (S/N)");
                Scanner scann = new Scanner(System.in);
                String opcao = scann.nextLine();
                opcao = opcao.toUpperCase();
                if (opcao.equals("S")) {
                    System.out.println("Digite o nome do arquivo: ");
                    String nomeArquivo = scann.nextLine();
                    nomeArquivo = nomeArquivo + ".txt";
                    File arquivo = new File(nomeArquivo);
                    FileWriter fw = new FileWriter(arquivo);
                    BufferedWriter bw = new BufferedWriter(fw);
                    for(Voo vv : vvs){
                        bw.write(vv.toString());
                        bw.newLine();
                    }
                    System.out.println("Arquivo exportado com sucesso!");
                    bw.close();
                    fw.close();
                    System.out.println("Arquivo exportado com sucesso!");
                } else {
                    System.out.println("Operação cancelada!");
                }
                System.out.println("--------------------------------------------------");
            } catch (Exception eVoo) {
                // TODO Auto-generated catch block
                eVoo.printStackTrace();
            }
            System.out.println("--------------------------------------------------");
            System.out.println("Digite 21 para realizar nova operação ou 22 para sair: ");
            Scanner scann = new Scanner(System.in);
            int opcao = scann.nextInt();
            if (opcao == 21) {
                main(null);
            } else {
                System.out.println("Saindo do Sistema, até a próxima!");
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
                System.out.println("Saindo do Sistema, até a próxima!");
            }
        }

        public static void alterarAeronave(Scanner scann) throws SQLException {
            System.out.println("Alterar Aeronave!");
            System.out.println("Digite o tipo da Aeronave: ");
            System.out.println("Digite A - para Avião: ");
            System.out.println("Digite H - para Helicóptero: ");
            System.out.println("Digite J - para Jato: ");
            String tipo = scann.next();
            tipo = tipo.toUpperCase();
            switch (tipo) {
                case "A":
                    System.out.println("Digite o id do Avião: ");
                    int idAviao = scann.nextInt();
                    System.out.println("Digite a marca do Avião: ");
                    String marca = scann.next();
                    System.out.println("Digite o modelo do Avião: ");
                    String modelo = scann.next();
                    boolean isPrefixoInvalid = true;
                    Identificacao identificacao = new Identificacao();

                    while (isPrefixoInvalid) {
                        System.out.println("Digite o prefixo do Avião: composto por 3 letras e 4 números: ");
                        String prefixo = scann.next();
                        prefixo = prefixo.toUpperCase();

                        if (prefixo.matches("[A-Z]{3}[0-9]{4}")) {
                            System.out.println("Prefixo válido!");
                            identificacao = new Identificacao(prefixo);
                            isPrefixoInvalid = false;

                        } else {
                            System.out.println("Prefixo inválido! Digite novamente: ");
                        }

                    }
                    System.out.println("Digite a capacidade do Avião: ");
                    int capacidade = scann.nextInt();
                    System.out.println("Digite o Id da companhia Aérea: ");
                    int idCompanhia = scann.nextInt();
                    Companhia companhia = Companhia.getById(idCompanhia);
                    Aviao aviao = new Aviao(idAviao, marca, modelo, identificacao, capacidade, companhia);
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
                        System.out.println("Saindo do Sistema, até a próxima!");
                    }
                    break;
                case "H":
                    System.out.println("Digite o id do Helicoptero: ");
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
                        System.out.println("Saindo do Sistema, até a próxima!");
                    }
                    break;
                case "J":
                    System.out.println("Digite o id do Jato: ");
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
                        System.out.println("Saindo do Sistema, até a próxima!");
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
            System.out.println("Digite o id do Avião: ");
            int idAviao = scann.nextInt();
            Aviao aviao = Aviao.getById(idAviao);
            while (aviao == null) {
                System.out.println("Avião não encontrado!");
                System.out.println("Digite um id de Avião Válido: ");
                idAviao = scann.nextInt();
            }
            System.out.println(aviao.toString());
            Hangar hangar = new Hangar(idHangar, local, idAviao);
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
                System.out.println("Saindo do Sistema, até a próxima!");
            }
        }

        public static void alterarPista(Scanner scann) throws SQLException {
            System.out.println("Alterar Pista!");
            System.out.println("Digite o id da Pista: ");
            int idPista = scann.nextInt();
            boolean isNumeroInvalido = true;
            Identificacao identificacao = new Identificacao<>();
            while (isNumeroInvalido) {
                System.out.println("Digite o numero da Pista:  Composto por 1 letra e 2 números. Ex: A01 ");
                String numero = scann.nextLine();
                numero = numero.toUpperCase();
                if (numero.matches("[A-Z]{1}[0-9]{2}")) {
                    System.out.println("Numero da Pista válido!");
                    identificacao = new Identificacao(numero);
                    isNumeroInvalido = false;
                } else { 
                    System.out.println("Numero da Pista inválido! Digite Novamente!");
                }
            Pista pista = new Pista(idPista, identificacao);
            try {
                System.out.println("Cadastrando Pista...");
                pista.update();
                System.out.println("Pista cadastrada com sucesso!");
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
                System.out.println("Saindo do Sistema, até a próxima!");
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
                System.out.println("Saindo do Sistema, até a próxima!");
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
                System.out.println("Saindo do Sistema, até a próxima!");
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
            tipo = tipo.toUpperCase();
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
                        System.out.println("Saindo do Sistema, até a próxima!");
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
                        System.out.println("Saindo do Sistema, até a próxima!");
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
                        System.out.println("Saindo do Sistema, até a próxima!");
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
                System.out.println("Saindo do Sistema, até a próxima!");
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
                System.out.println("Saindo do Sistema, até a próxima!");
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
                System.out.println("Saindo do Sistema, até a próxima!");
            }
        }

        public void sair() {
            System.out.println("Saindo do Sistema, até a próxima!");
        }        
}
