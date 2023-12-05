package projeto.interdisciplinar.rh;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

 public class ConexaoBD {
    private static final String URL = "jdbc:mysql://localhost:3306/dados_rh?user=root&password=lowshutdown\"";
    private static final String USUARIO = "root";
    private static final String SENHA = "lowshutdown";

    public static Connection obterConexao() {
        Connection conexao = null;
        try {
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            System.out.println("Conexão estabelecida com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados:");
            e.printStackTrace();
        }
        return conexao;
    }
}