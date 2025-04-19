import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String URL = "jdbc:mysql://localhost:3306/gerenciamento_de_jogos?useSSL=false";
    private static final String USUARIO = "root"; // Ajuste para seu usuário
    private static final String SENHA = "bidu";   // Ajuste para sua senha

    public static Connection getConnection() throws SQLException {
        try {
            Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA);
            System.out.println("Conexão com o banco estabelecida com sucesso!");
            return conn;
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco: " + e.getMessage());
            throw e;
        }
    }
}