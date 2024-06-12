package DB;

import entities.Cliente;

public class No {
    Cliente cliente;
    No proximo, anterior;

    // Construtor para criar um novo nó
    public No(Cliente cliente) {
        this.cliente = cliente;
    }
}
