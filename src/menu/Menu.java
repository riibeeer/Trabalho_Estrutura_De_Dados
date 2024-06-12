package menu;

import DB.ClientesDB;
import DB.ProdutoDB;
import entities.Cliente;
import entities.Produto;
import entities.Vendedor;

import java.util.Scanner;

public class Menu {

    public static void menuPrincipal() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===================================");
        System.out.println("         MERCADO LIVRE             ");
        System.out.println("===================================");

        System.out.println("[1]- COMPRAR PRODUTOS");
        System.out.println("[2]- VENDER PRODUTOS");
        System.out.println("[3]- LISTAR PRODUTOS");
        System.out.println("[4]- CADASTRO USUARIO");
        System.out.println("[5]- CADASTRO VENDEDOR");
        System.out.println("[6]- FEEDBACK");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:

                Cliente usuario = menuLogin();
                if (usuario != null) {
                    System.out.println("Digite o ID do produto que você deseja comprar");
                    int id = Integer.parseInt(scanner.next());
                    Produto produto = ProdutoDB.procurarProduto(id);
                    System.out.println("=============================");
                    System.out.println(produto.toStringCompra());
                    System.out.println("Deseja comprar esse produto(S/N): ");
                    String comprar = scanner.next();
                    if (comprar.equalsIgnoreCase("s")) {
                        usuario.comprarProduto(produto);
                        produto.itemComprado();
                    } else {
                        menuPrincipal();
                    }

                }
                menuPrincipal();
                break;
            case 2:
                Vendedor vendedor = menuLoginVendedor();
                if (vendedor != null) {
                    cadastrarProduto(vendedor);
                    menuPrincipal();
                }
                menuPrincipal();
                break;
            case 3:
                ProdutoDB.mostrarProduto();
                menuPrincipal();
                break;
            case 4:
                menuCadastro();
                break;
            case 5:
                menuCadastroVendedor();
                break;
            case 6:
                menuFeedback();
            default:
                System.out.println("Nenhuma alternativa selecionada! Tente novamente!");
                menuPrincipal();

        }

    }

    public static Cliente menuLogin() {
        Scanner sc = new Scanner(System.in);

        System.out.println("==========================");
        System.out.println("       LOGIN USUARIO      ");
        System.out.println("==========================");

        System.out.println("Digite o email");
        String email = sc.nextLine();
        System.out.println("Digite o senha");
        String senha = sc.nextLine();
        Cliente cliente = ClientesDB.buscarPorEmailSenha(email, senha);
        if (cliente != null) {
            System.out.println("Login efetuado com sucesso");
            return cliente;
        } else {
            System.out.println("Usario nao encontrado");
            return null;
        }
    }

    public static Vendedor menuLoginVendedor() {
        Scanner sc = new Scanner(System.in);

        System.out.println("==========================");
        System.out.println("      LOGIN VENDEDOR      ");
        System.out.println("==========================");

        System.out.println("Digite o email");
        String email = sc.nextLine();
        System.out.println("Digite o senha");
        String senha = sc.nextLine();
        Vendedor vendedor = ClientesDB.buscarVendedorPorEmailSenha(email, senha);
        if (vendedor != null) {
            System.out.println("Login efetuado com sucesso");
            return vendedor;
        } else {
            System.out.println("Vendedor nao encontrado");
            return null;
        }

    }


    public static void menuCadastro() {
        Scanner sc = new Scanner(System.in);

        System.out.println("==========================");
        System.out.println("     CADASTRO USUARIO    ");
        System.out.println("==========================");

        System.out.println("Digite o nome: ");
        String nome = sc.nextLine();

        System.out.println("Digite o email: ");
        String email = sc.nextLine();

        System.out.println("Digite o senha: ");
        String senha = sc.nextLine();

        System.out.println("Digite o CPF: ");
        String cpf = sc.nextLine();

        ClientesDB.adicionarCliente(new Cliente(nome, email, senha, cpf));

        menuPrincipal();
    }

    public static void menuCadastroVendedor() {
        Scanner sc = new Scanner(System.in);

        System.out.println("==========================");
        System.out.println("     CADASTRO VENDEDOR     ");
        System.out.println("==========================");

        System.out.println("Digite o nome: ");
        String nome = sc.nextLine();

        System.out.println("Digite o email: ");
        String email = sc.nextLine();

        System.out.println("Digite o senha: ");
        String senha = sc.nextLine();

        System.out.println("Digite o CPF: ");
        String cpf = sc.nextLine();

        ClientesDB.adicionarCliente(new Vendedor(nome, email, senha, cpf));

        menuPrincipal();
    }

    public static void cadastrarProduto(Vendedor vendedor) {
        Scanner sc = new Scanner(System.in);
        System.out.println("==================================");
        System.out.println("         CADASTRAR PRODUTO        ");
        System.out.println("==================================");
        System.out.println("Digite o nome do produto: ");
        String nome = sc.nextLine();
        System.out.println("Digite a descricao do produto: ");
        String descricao = sc.nextLine();
        System.out.println("Digite o preco do produto: ");
        double preco = sc.nextDouble();
        System.out.println("Digite a quantidade do produto: ");
        int quantidade = sc.nextInt();

        ProdutoDB.addProduto(new Produto(nome, descricao, preco, quantidade, vendedor));
    }

    public static void menuFeedback() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("===================================");
        System.out.println("        FEEDBACK DO USUARIO        ");
        System.out.println("===================================");

        Cliente cliente = menuLogin();
        if (cliente.listaDeComprasEstaVazia()) {
            System.out.println("Voce nao realizou nenhuma compra!");
            menuPrincipal();
        }else {
            System.out.println("===================================");
            cliente.exibirListaDeCompras();
            System.out.println("===================================");
            System.out.println("Selecione o produto por ID que você deseja dar o feedback!");
            int id = Integer.parseInt(scanner.next());
            Produto produto = ProdutoDB.procurarProduto(id);
            System.out.println("Digite uma nota de 1 a 10");
            int nota = Integer.parseInt(scanner.next());
            produto.getProprietario().adicionarNota(nota);
            System.out.println("Nota do vendedor: " + produto.getProprietario().getMediaNotas());
            menuPrincipal();
        }

    }

}




