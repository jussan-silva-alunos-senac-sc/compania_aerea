import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
    private static Connection con;
    private static final String URL = "jdbc:mysql://awsjussan.cbrcalzcoxol.us-east-1.rds.amazonaws.com:3306/aeroporto";
    //private static final String URL = "jdbc:mysql://awsjussan.cbrcalzcoxol.us-east-1.rds.amazonaws.com/aeroporto";
    private static final String USER = "admin";
    private static final String PASS = "jussan123";

    // método para obter a conexão
    public static Connection getConnect() throws SQLException {
        if(con == null || con.isClosed()) {
            con = DriverManager.getConnection(URL, USER, PASS);
        }
        return con;
    }
    
    // método para fechar a conexão
    public static void deleteConnect() throws SQLException {
        getConnect().close();
        
    }

}
