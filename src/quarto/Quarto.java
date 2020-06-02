package quarto;

public class Quarto {

    /*Atributos da classe*/
 /*Atributos que em tese deveriam ser INT foram trocados para String para facilitar
    a implementação no banco de dados*/
    private String tipo_quarto;
    private String qtd_adultos;
    private String qtd_crianca;
    private double valor;
    
    /*Construtores*/
    public Quarto() {
    }
    public Quarto(String tipo_quarto, String qtd_adultos, String qtd_crianca, double valor) {
        this.tipo_quarto = tipo_quarto;
        this.qtd_adultos = qtd_adultos;
        this.qtd_crianca = qtd_crianca;
        this.valor = valor;
    }
    
    /*Getters/Setters*/
    public String getTipo_quarto() {
        return tipo_quarto;
    }

    public void setTipo_quarto(String tipo_quarto) {
        this.tipo_quarto = tipo_quarto;
    }

    public String getQtd_adultos() {
        return qtd_adultos;
    }

    public void setQtd_adultos(String qtd_adultos) {
        this.qtd_adultos = qtd_adultos;
    }

    public String getQtd_crianca() {
        return qtd_crianca;
    }

    public void setQtd_crianca(String qtd_crianca) {
        this.qtd_crianca = qtd_crianca;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    /*Método para imprimir os dados*/
    public String imprimir() {
        return "\nTipo de quarto: " + tipo_quarto
                + "\nQuantidade de adultos: " + qtd_adultos + "\nQuantidade de crianças: " + qtd_crianca;
    }

}
