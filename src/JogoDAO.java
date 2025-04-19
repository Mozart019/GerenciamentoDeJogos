import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JogoDAO {
    public void inserir(JogoDTO jogo) throws SQLException {
        String sql = "INSERT INTO jogo (titulo_do_jogo, plataforma_do_jogo, genero_jogo, data_lancamento) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, jogo.getTituloDoJogo());
            stmt.setString(2, jogo.getPlataformaDoJogo());
            stmt.setString(3, jogo.getGeneroJogo());
            stmt.setString(4, jogo.getDataLancamento());
            stmt.executeUpdate();
        }
    }

    public void atualizar(JogoDTO jogo) throws SQLException {
        String sql = "UPDATE jogo SET titulo_do_jogo = ?, plataforma_do_jogo = ?, genero_jogo = ?, data_lancamento = ? WHERE id_jogo = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, jogo.getTituloDoJogo());
            stmt.setString(2, jogo.getPlataformaDoJogo());
            stmt.setString(3, jogo.getGeneroJogo());
            stmt.setString(4, jogo.getDataLancamento());
            stmt.setInt(5, jogo.getIdJogo());
            stmt.executeUpdate();
        }
    }

    public void excluir(int idJogo) throws SQLException {
        String sql = "DELETE FROM jogo WHERE id_jogo = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idJogo);
            stmt.executeUpdate();
        }
    }

    public List<JogoDTO> listar() throws SQLException {
        List<JogoDTO> jogos = new ArrayList<>();
        String sql = "SELECT * FROM jogo";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                JogoDTO jogo = new JogoDTO();
                jogo.setIdJogo(rs.getInt("id_jogo"));
                jogo.setTituloDoJogo(rs.getString("titulo_do_jogo"));
                jogo.setPlataformaDoJogo(rs.getString("plataforma_do_jogo"));
                jogo.setGeneroJogo(rs.getString("genero_jogo"));
                jogo.setDataLancamento(rs.getString("data_lancamento"));
                jogos.add(jogo);
            }
        }
        return jogos;
    }

    public JogoDTO buscarPorId(int idJogo) throws SQLException {
        String sql = "SELECT * FROM jogo WHERE id_jogo = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idJogo);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    JogoDTO jogo = new JogoDTO();
                    jogo.setIdJogo(rs.getInt("id_jogo"));
                    jogo.setTituloDoJogo(rs.getString("titulo_do_jogo"));
                    jogo.setPlataformaDoJogo(rs.getString("plataforma_do_jogo"));
                    jogo.setGeneroJogo(rs.getString("genero_jogo"));
                    jogo.setDataLancamento(rs.getString("data_lancamento"));
                    return jogo;
                }
            }
        }
        return null;
    }
}