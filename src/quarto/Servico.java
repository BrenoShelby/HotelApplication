package quarto;


public class Servico {
    /*Atributos*/
    private String nome;
    private double preco;
    
    /*Construtores*/
    public Servico(){}
    public Servico(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }
    
    /*Getters/Setters*/
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    /*Método para imprimir os dados*/
    public String imprimir(){
        return "\nNome: " + nome + "\nPreço: " + preco;
    }
}
