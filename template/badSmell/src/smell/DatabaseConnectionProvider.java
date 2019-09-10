package smell;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionProvider {
    private static final String dbUrl = "connectionURL";
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbUrl);
    }
}
