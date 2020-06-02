package conexaoBD;

//Classes necessárias para uso de Banco de dados
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class ConexaoBD {
    /*Atributos que serão herdados*/
    protected Connection connection;
    protected String query1;
    protected String query2;
    
    public ConexaoBD(){}
    /*método abstrato que será herdado por outras classes*/
    public abstract void inserir(Object o) throws SQLException;
    
    //Método de Conexão
    public java.sql.Connection getConexaoMySQL() {
        //atributo do tipo Connection     

        try { 
            // Carregando o JDBC Driver padrão
            String driverName = "com.mysql.jdbc.Driver";

            Class.forName(driverName);

            // Configurando a nossa conexão com um banco de dados//
            String url = "jdbc:mysql://localhost:3306/hotel"; //caminho para conexao
            
            String username = "root";        //nome de usuário do BD     

            String password = "365Pass";      //senha de acesso

            connection = DriverManager.getConnection(url, username, password);

            //Testa sua conexão//  
            if (connection != null) {
                System.out.println("STATUS--->Conectado com sucesso!");
            } else {
                System.out.println("STATUS--->Não foi possivel realizar conexão");
            }

            return connection;
        } catch (ClassNotFoundException e) {  
            //Driver não encontrado
            System.out.println("O driver expecificado nao foi encontrado!");
            System.out.println(e.getMessage());
            return null;

        } catch (SQLException e) {
            //Não conseguindo se conectar ao banco
            System.out.println("Nao foi possivel conectar ao Banco de Dados!");
            System.out.println(e.getMessage());
            return null;
        }

    }
}
