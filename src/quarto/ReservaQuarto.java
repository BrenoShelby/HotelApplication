package quarto;

public class ReservaQuarto {

    /*Atributos da classe*/
    /*Atributos que em tese deveriam ser INT foram trocados para String para facilitar
    a implementação no banco de dados*/
    private String cpf;
    private Quarto tipoQuarto;
    private String dataEntrada;
    private String dataSaida;
    
    /*Construtores*/
    public ReservaQuarto() {
    }
    public ReservaQuarto(String cpf, Quarto tipoQuarto, String dataEntrada, String dataSaida) {
        this.cpf = cpf;
        this.tipoQuarto = tipoQuarto;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
    }
    
    /*Getters/Setters*/
    public ReservaQuarto(Quarto tipoQuarto) {
        this.tipoQuarto = tipoQuarto;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Quarto getTipoQuarto() {
        return tipoQuarto;
    }

    public void setTipoQuarto(Quarto tipoQuarto) {
        this.tipoQuarto = tipoQuarto;
    }

    public String getDataEntrada() {
        return checkNull(dataEntrada);
    }

    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public String getDataSaida() {
        return checkNull(dataSaida);
    }

    public void setDataSaida(String dataSaida) {
        this.dataSaida = dataSaida;
    }
    
    /*Método para toda vez que for recebido uma string em branco retornar um null,
    o .getText dos campos de texto não fazem isso de maneira adequada, resultando
    em diversos erros*/
    private String checkNull(String str) {
        if (str.equalsIgnoreCase("     /        /       ")) {
            return null;
        }
        return str;
    }
    
    /*Método para imprimir os dados*/
    public String imprimir() {
        return "==========Descrição da reserva do Quarto=========="
                + "\nCPF: " + cpf
                + tipoQuarto.imprimir()
                + "\nData entrada: " + dataEntrada
                + "\nData saida: " + dataSaida;
    }
}
