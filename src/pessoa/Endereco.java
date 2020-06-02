package pessoa;

public class Endereco {
    /*Atributos da classe*/
    /*Atributos que em tese deveriam ser INT foram trocados para String para facilitar
    a implementação no banco de dados*/
    private String numero;
    private String complemento;
    private String rua;
    private String cidade;
    private String estado;
    private String pais;
    
    /*Construtores*/
    public Endereco() {
    }
    public Endereco(String numero, String complemento, String rua, String cidade, String estado, String pais) {
        this.numero = numero;
        this.complemento = complemento;
        this.rua = rua;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
    }
    
    /*Getters/Setters*/
    public String getNumero() {
        return checkNull(numero);
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return checkNull(complemento);
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getRua() {
        return checkNull(rua);
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCidade() {
        return checkNull(cidade);
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return checkNull(estado);
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return checkNull(pais);
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    
    /*Método para toda vez que for recebido uma string em branco retornar um null,
    o .getText dos campos de texto não fazem isso de maneira adequada, resultando
    em diversos erros*/
    private String checkNull(String str) {
        if (str.equalsIgnoreCase("")) {
            return null;
        }
        return str;
    }
}
