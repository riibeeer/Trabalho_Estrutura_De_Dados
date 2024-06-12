package DB;

import entities.Produto;

public class NoArvore {
    Produto produto;
    NoArvore esquerda, direita;

    public NoArvore(Produto produto) {
        this.produto = produto;
        esquerda = direita = null;
    }
}
