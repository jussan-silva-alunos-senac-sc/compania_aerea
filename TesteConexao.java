import java.sql.Connection;
import java.sql.ResultSet;

/**
 * TODO: REMOVE THIS CLASS
 * */        

public class TesteConexao {
    public static void main(String[] args) {
        try {
            Connection con = DAO.getConnect();
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM aviao;");
            while(rs.next()) {
                System.out.println(rs.getString("id"));
                System.out.println(rs.getString("marca"));
                System.out.println(rs.getString("modelo"));
            }
            System.out.println("Sucesso na conexão");
        } catch (Exception e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
        }

    }    
}
