package conexaoBD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QuartoDAO extends ConexaoBD {

    private double precoFixo;

    public QuartoDAO() {
    }

    @Override/*método herdado da classe abstract*/
    public void inserir(Object o) throws SQLException {
    }

    /*método herdado da classe abstract sobrecarregado */
 /*método para inserir um quarto no BD*/
    public void inserir(String tipoQuarto, String qtdCrianca, String qtdAdulto) throws SQLException {
        /*Baseado no tipo de quarto retorna um valor*/
        precoFixo = consultarPreco(tipoQuarto);

        /*query para inserção*/
        query1 = "INSERT INTO quarto (tipo_quarto, qtd_adultos, qtd_criancas, valor) VALUES (?,?,?,?)";

        /*Estabelecendo conexão com o banco de dados*/
        super.connection = super.getConexaoMySQL();

        /*Executa a query no BD*/
        try (PreparedStatement query = connection.prepareStatement(query1)) {
            /*Seta os parametros*/
            query.setString(1, tipoQuarto);
            query.setString(2, qtdCrianca);
            query.setString(3, qtdAdulto);
            query.setString(4, Double.toString(precoFixo));

            query.execute(); //executa a query
        }
    }

    public double consultarPreco(String tipoQuarto) {
        if (tipoQuarto.equalsIgnoreCase("Standard")) {
            return 200.50;
        } else if (tipoQuarto.equalsIgnoreCase("Suíte")) {
            return 980;
        } else {
            return 1420;
        }
    }

    public ResultSet quartosDisponiveis(String tipoQuarto) throws SQLException {
        /*query com um select right join entre as tabelas reserva_quarto e quarto*/
        query1 = "SELECT \n"
                + "    rs.id_quarto AS id_quarto_res, q.id_quarto, tipo_quarto, qtd_adultos, qtd_criancas, valor\n"
                + "FROM\n"
                + "    reserva_quarto AS rs\n"
                + "        RIGHT JOIN\n"
                + "    quarto AS q ON rs.id_quarto = q.id_quarto\n"
                + "WHERE\n"
                + "    rs.id_quarto IS null AND q.tipo_quarto = ?;";

        /*Estabelecendo conexão com o banco de dados*/
        super.connection = super.getConexaoMySQL();

        /*Prepara a query para ser executada*/
        PreparedStatement query = connection.prepareStatement(query1);
        query.setString(1, tipoQuarto);

        /*Armazena o resultado da query*/
        ResultSet result = query.executeQuery();

        /*Retorna o resultado*/
        return result;
    }

    public ResultSet quartosHospedados() throws SQLException {
        /*query com um select inner join entre as tabelas reserva_quarto, hospede e quarto*/
        query1 = "SELECT \n"
                + "    rs.cpf,\n"
                + "    h.nome,\n"
                + "    q.id_quarto,\n"
                + "    q.tipo_quarto,\n"
                + "    q.qtd_adultos,\n"
                + "    q.qtd_criancas,\n"
                + "    q.valor\n"
                + "FROM\n"
                + "    reserva_quarto rs\n"
                + "        INNER JOIN\n"
                + "    hospede h ON rs.cpf = h.cpf\n"
                + "        INNER JOIN\n"
                + "    quarto q ON q.id_quarto = rs.id_quarto;";

        /*Estabelecendo conexão com o banco de dados*/
        super.connection = super.getConexaoMySQL();

        /*Prepara a query para ser executada*/
        PreparedStatement query = connection.prepareStatement(query1);

        /*Armazena o resultado da query*/
        ResultSet result = query.executeQuery();

        /*Retorna o resultado*/
        return result;
    }

}
