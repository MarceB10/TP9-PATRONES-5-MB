package Ejercicio1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;

public class ConnectionManager {
    private static final String URL = "jdbc:derby:miBD;create=true";

    public static Connection getConnection() throws SQLException {
        Locale.setDefault(new Locale("es", "ES"));
        try {
            return DriverManager.getConnection(URL);
        } catch (SQLException e) {
            throw new RuntimeException("Error al conectar a la base de datos",e);
        }
    }
    // de esta forma no me tira errores con el Locale

}
