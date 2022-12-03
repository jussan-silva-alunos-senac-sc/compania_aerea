import java.util.List;

public interface dataBase {
    public void connect();
    public void disconnect();
    public static void insert(Object obj) {
        // TODO Auto-generated method stub
        
    }
    public static void update(Object obj) {
        // TODO Auto-generated method stub
        
    }
    public static void delete(Object obj) {
        // TODO Auto-generated method stub
        
    }
    public Object select(Object obj);
    public List<Object> selectAll(Object obj);

    public void create(T obj) throws SQLException {
        String sql = "INSERT INTO " + obj.getTableName() + " (" + obj.getColumns() + ") VALUES (" + obj.getValues() + ");";
        con.createStatement().executeUpdate(sql);
    }

    public void update(T obj) throws SQLException {
        String sql = "UPDATE " + obj.getTableName() + " SET " + obj.getColumns() + " WHERE " + obj.getPrimaryKey() + " = " + obj.getPrimaryKeyValue() + ";";
        con.createStatement().executeUpdate(sql);
    }

    public void delete(T obj) throws SQLException {
        String sql = "DELETE FROM " + obj.getTableName() + " WHERE " + obj.getPrimaryKey() + " = " + obj.getPrimaryKeyValue() + ";";
        con.createStatement().executeUpdate(sql);
    }

    public ResultSet select(T obj) throws SQLException {
        String sql = "SELECT * FROM " + obj.getTableName() + ";";
        return con.createStatement().executeQuery(sql);
    }

    public ResultSet select(T obj, String where) throws SQLException {
        String sql = "SELECT * FROM " + obj.getTableName() + " WHERE " + where + ";";
        return con.createStatement().executeQuery(sql);
    }
    public static List<Companhia> listar() {
        return null;
    }

    public static Companhia buscar(int id) {
        return null;
    }
    public static List<Hangar> list() {
        return null;
    }



}
