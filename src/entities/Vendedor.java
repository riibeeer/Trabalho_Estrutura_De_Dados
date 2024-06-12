package entities;

import DB.ProdutoDB;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Vendedor extends Cliente{

    Queue<Double> notas = new LinkedList<>();
    double mediaNotas = 0;

    public Vendedor(String nome,  String email,  String senha, String cpf) {
        super(nome, email, senha, cpf);
    }

    ArrayList<Produto> produtos = new ArrayList<>();

    public void adicionarNota(double nota) {
        notas.add(nota);
        atualizarMediaNotas();
    }

    private void atualizarMediaNotas() {
        double soma = 0;
        for (double nota : notas) {
            soma += nota;
        }
        mediaNotas = soma / notas.size();
    }

    public double getMediaNotas() {
        return mediaNotas;
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
        ProdutoDB.addProduto(produto);
    }
}
