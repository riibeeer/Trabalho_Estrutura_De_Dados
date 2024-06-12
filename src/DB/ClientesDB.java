package DB;

import entities.Cliente;
import entities.Vendedor;

public class ClientesDB {

    static No inicio;
    static No fim = null;

    // Adiciona um cliente à lista
    public static void adicionarCliente(Cliente cliente) {
        No novoNo = new No(cliente);

        // Se a lista estiver vazia
        if (inicio == null) {
            inicio = fim = novoNo;
            inicio.anterior = null;
            fim.proximo = null;
        } else {
            fim.proximo = novoNo;
            novoNo.anterior = fim;
            fim = novoNo;
            fim.proximo = null;
        }
    }

    public static void exibirClientes() {
        No atual = inicio;
        if (inicio == null) {
            System.out.println("A lista está vazia.");
            return;
        }
        while (atual != null) {
            System.out.println("\n===============================");
            System.out.print(atual.cliente.toString());
            System.out.println("\n===============================");
            atual = atual.proximo;
        }
        System.out.println();
    }

    // Método para buscar cliente por email e senha
    public static Cliente buscarPorEmailSenha(String email, String senha) {
        No atual = inicio;
        while (atual != null) {
            if (atual.cliente.getEmail().equalsIgnoreCase(email) && atual.cliente.getSenha().equalsIgnoreCase(senha)) {
                return atual.cliente;
            }
            atual = atual.proximo;
        }
        return null;  // Retorna null se não encontrar cliente com o email e senha fornecidos
    }

    public static Vendedor buscarVendedorPorEmailSenha(String email, String senha) {
        No atual = inicio;
        while (atual != null) {
            if (atual.cliente instanceof Vendedor && atual.cliente.getEmail().equalsIgnoreCase(email) && atual.cliente.getSenha().equalsIgnoreCase(senha)) {
                return (Vendedor) atual.cliente;
            }
            atual = atual.proximo;
        }
        return null;  // Retorna null se não encontrar um vendedor com o email e senha fornecidos
    }

}
