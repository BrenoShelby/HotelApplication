package conexaoBD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import quarto.ReservaQuarto;

public class ReservaDAO extends ConexaoBD{
    /*Construtor*/
    public ReservaDAO() {
        super();
    }
    
    @Override/*Método para inserir uma reserva no BD*/
    public void inserir(Object o) throws SQLException {
        /*Convertando o Object para objeto ReservaQuarto*/
        ReservaQuarto reservaquarto = (ReservaQuarto) o;
        /*Referencia da clsse ResultSet*/
        ResultSet result;
        
        /*Capturando os atributos do objeto Reserva*/
        String cpf = reservaquarto.getCpf();
        String tipoQuarto = reservaquarto.getTipoQuarto().getTipo_quarto();
        String data_entrada = reservaquarto.getDataEntrada();
        String data_saida = reservaquarto.getDataSaida();
        
        /*Query de inserção da reserva*/
        super.query1 = "INSERT INTO reserva_quarto(cpf,id_quarto,data_entrada,data_saida) "
                + "VALUES(?,?,STR_TO_DATE(?,'%d/%m/%Y/'),STR_TO_DATE(?,'%d/%m/%Y/'))";
        /*Query de select right join entre as tabelas reserva_quarto e quarto*/
        super.query2 = "SELECT \n"
                + "    rs.id_quarto AS id_quarto_reserva, q.id_quarto AS id_quarto\n"
                + "FROM\n"
                + "    reserva_quarto AS rs\n"
                + "        RIGHT JOIN\n"
                + "    quarto AS q ON rs.id_quarto = q.id_quarto\n"
                + "WHERE\n"
                + "    rs.id_quarto IS null AND q.tipo_quarto = ?";

        /*Estabelecendo conexão com o banco de dados*/
        super.connection = super.getConexaoMySQL();
        
        /*Inicializando a string*/
        String id_quarto = "";
        
        /*Prepara a query para ser executada*/
        PreparedStatement queryIdQuarto = connection.prepareStatement(query2);
        queryIdQuarto.setString(1, tipoQuarto);
        
        /*Executa a query e pega o valor da coluna id_quarto*/
        result = queryIdQuarto.executeQuery();
        if (result != null && result.next()) {
            id_quarto = result.getString("id_quarto");
        }
        
        /*Executa a query no BD*/
        try (PreparedStatement stmtInsert = connection.prepareStatement(query1)) {
            stmtInsert.setString(1, cpf);
            stmtInsert.setString(2, id_quarto);
            stmtInsert.setString(3, data_entrada);
            stmtInsert.setString(4, data_saida);

            stmtInsert.execute();
        }
        
        /*Mensagem para o Hospede de detalhes de sua reserva*/
        JOptionPane.showMessageDialog(null, "=======Reserva efetuada com sucesso=======\nCPF: " + reservaquarto.getCpf()
                + "\nNúmero do quarto reservado: " + id_quarto
                + "\nDe:    " + data_entrada + "\nAté:    " + data_saida);
    }

}
