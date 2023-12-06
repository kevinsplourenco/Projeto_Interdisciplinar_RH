package projeto.interdisciplinar.rh.conexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

 public class ConexaoBD {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/sistema_recursos_humanos?user=root";
    private static final String USUARIO = "root";
    private static final String SENHA = "";

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