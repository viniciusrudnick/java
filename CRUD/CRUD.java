import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CRUD {
	public ResultSet Selecionar() {
		Connection conexao = null;
		Statement comando = null;
		ResultSet resultado = null;
		
		try {
			conexao =ClasseConexao.Conectar();
			String sql = "SELECT FROM * cadastro";
			comando = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			resultado = comando.executeQuery(sql);
			
			return resultado;
		}catch(SQLException e) {
			return null;
		}
	}

}
