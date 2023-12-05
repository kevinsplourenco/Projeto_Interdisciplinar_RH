package projeto.interdisciplinar.rh;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TelaExibicaoDados extends javax.swing.JFrame {

    public TelaExibicaoDados() {
        exibirDados();
    }

    private void exibirDados() {
        try {
            Connection conexao = ConexaoBD.obterConexao();
            PreparedStatement pstmt = conexao.prepareStatement("SELECT * FROM dados_formulario");
            ResultSet rs = pstmt.executeQuery();

            DefaultTableModel model = new DefaultTableModel();
            JTable table = new JTable(model);
            model.addColumn("Nome");
            model.addColumn("Sobrenome");
            model.addColumn("Data de Nascimento");
            model.addColumn("Sexo");
            model.addColumn("Telefone");
            model.addColumn("Email");
            model.addColumn("Cidade");
            model.addColumn("Bairro");
            model.addColumn("Rua");
            model.addColumn("Número");
            model.addColumn("CEP");
            model.addColumn("Departamento");
            model.addColumn("Cargo");

            while (rs.next()) {
                Object[] row = {
                    rs.getString("nome"),
                    rs.getString("sobrenome"),
                    rs.getString("nsc_data"),
                    rs.getString("sexo"),
                    rs.getString("nmr_telefone"),
                    rs.getString("email"),
                    rs.getString("cidade"),
                    rs.getString("bairro"),
                    rs.getString("rua"),
                    rs.getInt("numero_casa"),
                    rs.getString("cep"),
                    rs.getString("departamento"),
                    rs.getString("cargo")
                };
                model.addRow(row);
            }

            rs.close();
            pstmt.close();
            conexao.close();

            JScrollPane scrollPane = new JScrollPane(table);
            this.add(scrollPane);
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            this.pack();
            this.setVisible(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}