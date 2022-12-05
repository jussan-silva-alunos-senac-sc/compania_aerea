import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.mariadb.jdbc.*;

public class  DAO {
    public static Connection con = null;
    // URL de conexão com o banco de dados AWS
    public static final String URL = "jdbc:mariadb://awsjussan.cbrcalzcoxol.us-east-1.rds.amazonaws.com:3306/aeroporto";
    //private static final String URL = "jdbc:mysql://awsjussan.cbrcalzcoxol.us-east-1.rds.amazonaws.com/aeroporto";
    public static final String USER = "admin";
    public static final String PASS = "jussan123";

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
