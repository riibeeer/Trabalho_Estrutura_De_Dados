import DB.ClientesDB;
import DB.ProdutoDB;
import entities.Cliente;
import entities.Produto;
import entities.Vendedor;
import menu.Menu;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Cadastro previo produto
        Vendedor mercadoLivre = new Vendedor("Mercado Livre", "000000", "mercadolivre@gmail.com", "mercado");
        ProdutoDB.addProduto(new Produto("Caneca do batman", "Uma caneca ilustrada com o batman", 12.90, 20, mercadoLivre));
        ProdutoDB.addProduto(new Produto("Chinelo", "Um chinelo tamanho M", 5, 50, mercadoLivre));

        //Cadastro Usuario
        ClientesDB.adicionarCliente(new Cliente("riber", "riber2", "123", "12345"));

        //Cadastrar Vendedor
        ClientesDB.adicionarCliente(new Vendedor("Paty", "paty@", "paty2", "1234"));

        Menu.menuPrincipal();

    }
}