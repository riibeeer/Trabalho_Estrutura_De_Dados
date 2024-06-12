package DB;

import entities.Produto;

import java.util.Stack;

public class ProdutoDB {

    static final Stack<Produto> stack = new Stack<Produto>();

    public static void addProduto(Produto produto) {
        stack.push(produto);
    }

    public static void mostrarProduto(){
        Stack<Produto> tempStack = (Stack<Produto>) stack.clone();
        while (!tempStack.isEmpty()) {
            Produto produto = tempStack.pop();
            System.out.println("=====================");
            System.out.println(produto.toString());
            System.out.println("=====================");
        }
    }

    public static Produto procurarProduto(int id) {
        for (Produto produto : stack) {
            if (id == produto.getId()){
                return produto;
            }
        }
        return null;
    }
}
