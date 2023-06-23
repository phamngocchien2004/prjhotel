package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Connector {
    private static Connector instance;
    private final static String connection= "jdbc:mysql://localhost:3306/hotel_jp";
    private final static String user = "root";
    private final static String pwd = "";
    private Connection conn;
    public  Connector () throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        this.conn= (Connection) DriverManager.getConnection(connection,user,pwd);

    }
    public static Connector getInstance() throws Exception{
        if (instance == null) {
            instance = new Connector();
        }
        return instance;
    }

    public Connection getConn() {
        return conn;
    }

    public PreparedStatement getStatement(String sql) throws Exception{
        PreparedStatement statement = conn.prepareStatement(sql);
        return statement;
    }
}
