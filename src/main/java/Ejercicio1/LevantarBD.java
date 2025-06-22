package Ejercicio1;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class LevantarBD {
    public static void inicializar() {
        try (Connection conn = ConnectionManager.getConnection();
             Statement stmt = conn.createStatement()) {

            try {
                stmt.executeQuery("SELECT 1 FROM personas FETCH FIRST 1 ROWS ONLY");
                System.out.println("⚠️ Las tablas ya existen, no se recrean");
                return;
            } catch (SQLException e) {
            }

            stmt.executeUpdate("CREATE TABLE personas (id INT PRIMARY KEY, nombre VARCHAR(100))");
            stmt.executeUpdate("CREATE TABLE telefonos (id INT PRIMARY KEY, numero VARCHAR(20), idpersona INT, " +
                    "FOREIGN KEY (idpersona) REFERENCES personas(id))");

            stmt.executeUpdate("INSERT INTO personas VALUES (1, 'María')");
            stmt.executeUpdate("INSERT INTO telefonos VALUES (1, '2984123456', 1)");
            stmt.executeUpdate("INSERT INTO telefonos VALUES (2, '2984123457', 1)");

            //ya agregamos a maria de prueba
        } catch (SQLException e) {
            System.out.println("⚠️ Error al inicializar BD: " + e.getMessage());
        }
    }
}