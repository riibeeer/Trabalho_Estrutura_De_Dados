package entities;

import DB.ArvoreDB;
import DB.NoArvore;

public class Cliente {

    private String nome;
    private String cpf;
    private String email;
    private String senha;
    private ArvoreDB listaDeCompras;

    public Cliente(String nome, String email, String senha, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.listaDeCompras = new ArvoreDB();
    }

    public String getNome() { return nome;}
    public void setNome(String nome) { this.nome = nome;}

    public String getCpf() { return cpf;}
    public void setCpf(String cpf) { this.cpf = cpf;}

    public String getEmail() { return email;}
    public void setEmail(String email) { this.email = email;}

    public String getSenha() { return senha;}
    public void setSenha(String senha) { this.senha = senha;}

    // Método para adicionar um produto à lista de compras
    public void comprarProduto(Produto produto) {
        listaDeCompras.adicionarProduto(produto);
    }

    // Método para exibir a lista de compras
    public void exibirListaDeCompras() {
        listaDeCompras.imprimirEmOrdem();
    }

    public boolean listaDeComprasEstaVazia() {
        return listaDeCompras.estaVazia();
    }

    public String toString(){
        return String.format("Nome: %s \n" +
                "CPF: %s\n" +
                "Email: %s\n" +
                "Senha: %s", nome, cpf, email, senha);
    }
}
