package conexaoBD;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ServicoDAO extends ConexaoBD{
    /*Atributo da classe*/
    private double preco;
    
    /*Construtor*/
    public ServicoDAO(){
        super();
    }
    
    /*Método para consultar o preço do serviço especifico*/
    public double consultaPreco(String nome) throws SQLException{
        /*query de busca*/
        super.query1 = "SELECT * FROM servico WHERE nome = ?";
        
        /*Estabelece conexão com o banco de dados*/
        super.connection = super.getConexaoMySQL();
        
        /*Prepara a query para ser executada*/
        PreparedStatement query = connection.prepareStatement(query1);
        query.setString(1, nome);
        
        /*Executa a query e pega o valor da coluna preco*/
        ResultSet result = query.executeQuery();
        while(result != null && result.next()){
            preco = result.getDouble("preco");
        }
        
        /*retorna o preço*/
        return preco;
    }

    @Override/*Método herdado a classe abstrata mas não utilizado*/
    public void inserir(Object o) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
