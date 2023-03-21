
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Conexao {
    
    
    
    // Configurando o Driver JDBC driver
    public String DRIVER = "org.postgresql.Driver";
    public String BANCO = "jdbc:postgresql://localhost:5432/projeto";

    // Credenciais de acesso ao Mysql
    public String USUARIO = "postgres";
    public String SENHA = "c34601016";
    
    
    public Connection getConexao(){
        Connection conn = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(BANCO, USUARIO, SENHA);
        } catch (Exception e) {
            System.out.println("Ocorreu um erro: " + e.getMessage());
        }
        return conn;
    }
    
    

    public boolean executarSQL(String sql) {
        boolean sucesso = true;
        Connection conn = getConexao();
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            conn.close();
        } catch (Exception e) {
            System.out.println("Ocorreu um erro: " + e.getMessage());
            sucesso = false;
        }
        return sucesso;
    }
    
    
    
    public ResultSet executarSQLSelect(String sql){
        Connection conn = getConexao();
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            
            ResultSet rs = stmt.executeQuery(sql);
            return rs;
        } catch (Exception e) {
            System.out.println("Ocorreu um erro: " + e.getMessage());
        }
        return null;
    }
}
