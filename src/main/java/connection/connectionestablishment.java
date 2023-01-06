package connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectionestablishment {

    public static Connection connectionEstablishment() throws ClassNotFoundException, SQLException {
        Connection con= DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/jukebox","root","root");
        return con;
    }
}
