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

    private Connection con;
    
    private static final String URL = "jdbc:mysql://awsjussan.cbrcalzcoxol.us-east-1.rds.amazonaws.com:3306/aeroporto";
    //private static final String URL = "jdbc:mysql://awsjussan.cbrcalzcoxol.us-east-1.rds.amazonaws.com/aeroporto";
    private static final String USER = "admin";
    private static final String PASS = "jussan123";

    public ConexaDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConexaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void close() {
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
