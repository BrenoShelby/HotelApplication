package conexaoBD;

import java.sql.PreparedStatement;
import pessoa.Hospede;
import java.sql.ResultSet;
import java.sql.SQLException;
import pessoa.Endereco;

public class HospedeDAO extends ConexaoBD{
    /*Construtor*/
    public HospedeDAO() {
        super();
    }
    
    @Override/*Método para inserir um Hospéde no BD*/
    public void inserir(Object o) throws SQLException {
        /*Converte o Object para o objeto Hospede*/
        Hospede hospede = (Hospede) o;
        
        /*Query's de inserção dos dados no BD*/
        super.query1 = "INSERT INTO hospede(cpf,nome,rg,email,data_nascimento,telefone_residencial,telefone_celular) "
                + "VALUES(?,?,?,?,STR_TO_DATE(?,'%d/%m/%Y/'),?,?)";
        super.query2 = "INSERT INTO endereco(cpf,numero,complemento,rua,cidade,estado,pais) VALUES (?,?,?,?,?,?,?)";
        
        /*Estabelecendo conexão com o banco de dados*/
        super.connection = super.getConexaoMySQL();
        
        /*Pegando os atributos do objeto Hospede*/
        String cpf = hospede.getCpf();
        String rg = hospede.getRg();
        String nome = hospede.getNomeCompleto();
        String email = hospede.getEmail();
        String data = hospede.getDataNasc();
        String telefoneRes = hospede.getTelefoneResidencial();
        String telefoneCel = hospede.getTelefoneCelular();
        
        /*Pegando o endereco do Hospede*/
        Endereco hospedeEndereco = hospede.getEndereco();
        String numero = hospedeEndereco.getNumero();
        String complemento = hospedeEndereco.getComplemento();
        String rua = hospedeEndereco.getRua();
        String cidade = hospedeEndereco.getCidade();
        String estado = hospedeEndereco.getEstado();
        String pais = hospedeEndereco.getPais();
        
        /*Executa a query no BD*/
        try (PreparedStatement stmtHospede = connection.prepareStatement(query1)) {
            /*Seta os parametros*/
            stmtHospede.setString(1, cpf);
            stmtHospede.setString(2, nome);
            stmtHospede.setString(3, rg);
            stmtHospede.setString(4, email);
            stmtHospede.setString(5, data);
            stmtHospede.setString(6, telefoneRes);
            stmtHospede.setString(7, telefoneCel);
            
            stmtHospede.execute(); //executa comando para o Hospede
        }
        /*Executa a query no BD*/
        try (PreparedStatement stmtHospedeEndereco = connection.prepareStatement(query2)) {
            /*Seta os parametros*/
            stmtHospedeEndereco.setString(1, cpf);
            stmtHospedeEndereco.setString(2, numero);
            stmtHospedeEndereco.setString(3, complemento);
            stmtHospedeEndereco.setString(4, rua);
            stmtHospedeEndereco.setString(5, cidade);
            stmtHospedeEndereco.setString(6, estado);
            stmtHospedeEndereco.setString(7, pais);
            
            stmtHospedeEndereco.execute(); //executa comando para o Endereco do Hospede
        }
    }
    
    /*Método que retorna uma busca do hospéde no BD*/
    public ResultSet hospedesCadastrados(String cpf) throws SQLException {
        /*query para pegar hospede baseado no cpf*/
        super.query1 = "SELECT * FROM hospede WHERE cpf = ?";
        
        /*Estabelecendo conexão com o banco de dados*/
        super.connection = super.getConexaoMySQL();
        
        /*Prepara a query para ser executada*/
        PreparedStatement consulta = connection.prepareStatement(query1);
        consulta.setString(1, cpf);
        
        /*Armazena o resultado da query*/
        ResultSet result = consulta.executeQuery();
        
        /*Retorna o resultado*/
        return result;
    }
    
    /*Método que retorna todos os hospédes do BD*/
    public ResultSet hospedesCadastrados() throws SQLException {
        /*query para visualizar os hospedes do BD*/
        super.query1 = "SELECT * FROM hospede";
        
        /*Estabelecendo conexão com o banco de dados*/
        super.connection = super.getConexaoMySQL();
        
        /*Prepara a query para ser executada*/
        PreparedStatement consulta = connection.prepareStatement(query1);
        
        /*Armazena o resultado da query*/
        ResultSet result = consulta.executeQuery();
        
        /*Retorna o resultado*/
        return result;
    }
}
