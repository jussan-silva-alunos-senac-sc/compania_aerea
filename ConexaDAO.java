package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConexaDAO {

    private Connection conexao;
    
    public ConexaDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://awsjussan.cbrcalzcoxol.us-east-1.rds.amazonaws.com:3306/aeroporto", "admin", "admin123");

   // private static final String URL = "jdbc:mysql://awsjussan.cbrcalzcoxol.us-east-1.rds.amazonaws.com:3306/aeroporto";
    private static final String URL = "jdbc:mysql://awsjussan.cbrcalzcoxol.us-east-1.rds.amazonaws.com/aeroporto";
    private static final String USER = "admin";
    private static final String PASS = "jussan123";

    private static final String SCHEMA = "aeroporto";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException ex) {
            throw new RuntimeException("Erro na conexão com o Banco de dados: ", ex);
        }
    }

    //Método para fechar a conexão com o banco de dados
    public static void closeConnection(Connection conexao) {
        if (conexao != null) {
            try {
                conexao.close();
            } catch (SQLException ex) {
                System.err.println("Erro: " + ex);
            }
        }
    }

    //Método para fechar a conexão com o banco de dados
    public static void closeConnection(Connection conexao, PreparedStatement declara) {
        closeConnection(conexao);
        if (declara != null) {
            try {
                declara.close();
            } catch (SQLException ex) {
                System.err.println("Erro: " + ex);
            }
        }
    }

    //Método para fechar a conexão com o banco de dados
    public static void closeConnection(Connection conexao, PreparedStatement declara, ResultSet retornoSet) {
        closeConnection(conexao, declara);
        if (retornoSet != null) {
            try {
                retornoSet.close();
            } catch (SQLException ex) {
                System.err.println("Erro: " + ex);
            }
        }
    }

}
