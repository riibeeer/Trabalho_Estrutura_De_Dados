package entities;


public class Produto {

    private int id = 0;
    static int proximoId;

    private String nome;
    private String descricao;
    private double preco;
    private int quantidade;
    private Vendedor proprietario = null;

    public Produto(String nome, String descricao, double preco, int quantidade, Vendedor proprietario) {
        this.id = proximoId; // Atribui o valor de proximoId ao id do funcionário
        proximoId++; // Incrementa proximoId para o próximo funcionário
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
        this.proprietario = proprietario;
    }

    public int getId(){ return id;}

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public String getDescricao() {return descricao;}
    public void setDescricao(String descricao) {this.descricao = descricao;}

    public double getPreco() {return preco;}
    public void setPreco(double preco) {this.preco = preco;}

    public int getQuantidade() {return quantidade;}
    public void setQuantidade(int quantidade) {this.quantidade = quantidade;}

    public Vendedor getProprietario() {return proprietario;}
    public void setProprietario(Vendedor proprietario) {}

    public void itemComprado(){
        this.quantidade = this.quantidade - 1;
    }

    public String toString(){
        return String.format("ID: %d \n" +
                "Produto: %s \n" +
                "Descrição: %s \n" +
                "Preço %.2f \n" +
                "Quantidade: %d", id, nome, descricao, preco, quantidade);
    }

    public String toStringCompra(){
        return String.format("Produto: %s \n" +
                "Descrição: %s \n" +
                "Preço %.2f \n" +
                "Quantidade: %d", nome, descricao, preco, quantidade);
    }

}
