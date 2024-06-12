package DB;

import entities.Produto;

public class ArvoreDB {
    NoArvore raiz;

    // Método para adicionar um produto à árvore
    public void adicionarProduto(Produto produto) {
        raiz = adicionarRecursivo(raiz, produto);
    }

    private NoArvore adicionarRecursivo(NoArvore atual, Produto produto) {
        if (atual == null) {
            return new NoArvore(produto);
        }

        // Altere esta condição para determinar onde o produto deve ser adicionado
        if (produto.getNome().compareTo(atual.produto.getNome()) < 0) {
            atual.esquerda = adicionarRecursivo(atual.esquerda, produto);
        } else if (produto.getNome().compareTo(atual.produto.getNome()) > 0) {
            atual.direita = adicionarRecursivo(atual.direita, produto);
        } else {
            // valor já existe
            return atual;
        }

        return atual;
    }

    // Método para imprimir os produtos na árvore em ordem
    public void imprimirEmOrdem() {
        imprimirEmOrdemRecursivo(raiz);
    }

    private void imprimirEmOrdemRecursivo(NoArvore atual) {
        if (atual != null) {
            imprimirEmOrdemRecursivo(atual.esquerda);
            System.out.println(atual.produto.toString());
            imprimirEmOrdemRecursivo(atual.direita);
        }
    }

    public boolean estaVazia() {
        return raiz == null;
    }

}
