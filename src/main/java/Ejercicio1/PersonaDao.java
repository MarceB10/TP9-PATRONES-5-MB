package Ejercicio1;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class PersonaDao {

    public Persona personaPorId(int id) {
        String sql = "SELECT nombre FROM personas WHERE id = ?";
        Connection conn = null;
        try {
            conn = obtenerConexion();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                String nombre = result.getString("nombre");
                Set<Telefono> telefonosProxy = new TelefonoSetProxy(id, conn);
                return new Persona(id, nombre, telefonosProxy);
            } else {
                if (conn != null) conn.close();
                return null;
            }

        } catch (SQLException e) {
            try { if (conn != null) conn.close(); } catch (SQLException ex) {}
            throw new RuntimeException(e);
        }
    }

    private Connection obtenerConexion() throws SQLException {
        return ConnectionManager.getConnection();
    }
}