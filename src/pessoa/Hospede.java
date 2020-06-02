package pessoa;

public class Hospede {

    /*Atributos da classe*/
     /*Atributos que em tese deveriam ser INT foram trocados para String para facilitar
    a implementação no banco de dados*/
    private String nomeCompleto;
    private String cpf;
    private String rg;
    private String dataNasc;
    private String email;
    private Endereco endereco;
    private String telefoneResidencial;
    private String telefoneCelular;

    /*Construtores*/
    public Hospede() {
    }

    public Hospede(String nomeCompleto, String cpf, String rg, String dataNasc, String email, Endereco endereco, String telefoneResidencial, String telefoneCelular) {
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.rg = rg;
        this.dataNasc = dataNasc;
        this.email = email;
        this.endereco = endereco;
        this.telefoneResidencial = telefoneResidencial;
        this.telefoneCelular = telefoneCelular;
    }

    /*Getters/Setters*/
    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return checkNull(rg);
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEmail() {
        return checkNull(email);
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getDataNasc() {
        /*Caso particular*/
        if (dataNasc.equalsIgnoreCase("     /        /       ")) {
            return null;
        }
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getTelefoneResidencial() {
        return checkNull(telefoneResidencial);
    }

    public void setTelefoneResidencial(String telefoneResidencial) {
        this.telefoneResidencial = telefoneResidencial;
    }

    public String getTelefoneCelular() {
        return checkNull(telefoneCelular);
    }

    public void setTelefoneCelular(String telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
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
