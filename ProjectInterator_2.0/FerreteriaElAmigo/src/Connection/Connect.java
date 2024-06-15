package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {

    private static final String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    private static String url = "jdbc:sqlserver://localhost:1433;databaseName=db_FerrElAmigo;encrypt=true;trustServerCertificate=true";
    private static String user = "FerrElAmigoDB";
    private static String password = "#FerrElAmigo!2024.";

    public Connect() {
    }

    public Connection connection() {
        Connection cn = null;
        try {
            Class.forName(driver);
            cn = (DriverManager.getConnection(url, user, password));
            System.out.println("conectado");
        } catch (ClassNotFoundException | SQLException e) {

            System.out.println("error en la conexion");
            e.printStackTrace();
        }
        return cn;
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("cierre de conexion");
            } catch (SQLException e) {

                e.printStackTrace();
            }
        }
    }
}
