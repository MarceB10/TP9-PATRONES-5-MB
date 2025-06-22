package Ejercicio1;

import java.sql.*;
import java.util.*;

public class TelefonoSetProxy implements Set<Telefono> {
    private final int idPersona;
    private final Connection conn;
    private Set<Telefono> telefonosReales;
    private boolean cargado = false;

    public TelefonoSetProxy(int idPersona, Connection conn) {
        this.idPersona = idPersona;
        this.conn = conn;
    }

    private void cargarTelefonos() {
        if (!cargado) {
            telefonosReales = new HashSet<>();
            String sql = "SELECT numero FROM telefonos WHERE idpersona = ?";

            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, idPersona);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    telefonosReales.add(new Telefono(rs.getString("numero")));
                }
                cargado = true;
            } catch (SQLException e) {
                throw new RuntimeException("Error al cargar teléfonos para persona " + idPersona, e);
            } finally {
                try {
                    if (conn != null) conn.close();
                } catch (SQLException e) {
                    System.err.println("Error al cerrar conexión: " + e.getMessage());
                }
            }
        }
    }

    // Implementación completa de los métodos de Set
    @Override
    public int size() {
        cargarTelefonos();
        return telefonosReales.size();
    }

    @Override
    public boolean isEmpty() {
        cargarTelefonos();
        return telefonosReales.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        cargarTelefonos();
        return telefonosReales.contains(o);
    }

    @Override
    public Iterator<Telefono> iterator() {
        cargarTelefonos();
        return telefonosReales.iterator();
    }

    @Override
    public Object[] toArray() {
        cargarTelefonos();
        return telefonosReales.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        cargarTelefonos();
        return telefonosReales.toArray(a);
    }

    @Override
    public boolean add(Telefono telefono) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        cargarTelefonos();
        return telefonosReales.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends Telefono> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }
}
