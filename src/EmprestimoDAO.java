import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmprestimoDAO {
    public void inserir(EmprestimoDTO emprestimo) throws SQLException {
        String sql = "INSERT INTO emprestimo (id_jogo, data_emprestimo, data_devolucao, id_usuario, nome_amigo, data_devolucao_prevista) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, emprestimo.getIdJogo());
            stmt.setString(2, emprestimo.getDataEmprestimo());
            if (emprestimo.getDataDevolucao() != null && !emprestimo.getDataDevolucao().isEmpty()) {
                stmt.setString(3, emprestimo.getDataDevolucao());
            } else {
                stmt.setNull(3, java.sql.Types.DATE);
            }
            stmt.setInt(4, 1); // id_usuario fixo (usuário padrão, já que não gerenciamos usuários)
            stmt.setString(5, "Amigo Padrão"); // nome_amigo fixo
            stmt.setNull(6, java.sql.Types.DATE); // data_devolucao_prevista como NULL
            stmt.executeUpdate();
        }
    }

    public void atualizar(EmprestimoDTO emprestimo) throws SQLException {
        String sql = "UPDATE emprestimo SET data_devolucao = ? WHERE id_emprestimo = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, emprestimo.getDataDevolucao());
            stmt.setInt(2, emprestimo.getIdEmprestimo());
            stmt.executeUpdate();
        }
    }

    public List<EmprestimoDTO> listar() throws SQLException {
        List<EmprestimoDTO> emprestimos = new ArrayList<>();
        String sql = "SELECT * FROM emprestimo";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                EmprestimoDTO emprestimo = new EmprestimoDTO();
                emprestimo.setIdEmprestimo(rs.getInt("id_emprestimo"));
                emprestimo.setIdJogo(rs.getInt("id_jogo"));
                emprestimo.setDataEmprestimo(rs.getString("data_emprestimo"));
                emprestimo.setDataDevolucao(rs.getString("data_devolucao"));
                emprestimos.add(emprestimo);
            }
        }
        return emprestimos;
    }
}