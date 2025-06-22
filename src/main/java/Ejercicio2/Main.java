package Ejercicio2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        var admin = new Usuario("Jefe", Arrays.asList(Permiso.ADMIN));
        var empleado = new Usuario("Empleado", Arrays.asList(Permiso.INTERMEDIO));
        var practicante = new Usuario("Practicante", Arrays.asList(Permiso.BASICO));

        probarAcceso(admin, "informe.txt");     // Solo admin
        probarAcceso(empleado, "manual.txt");   // Admin o intermedio
        probarAcceso(practicante, "datos.txt"); // Todos
    }

    static void probarAcceso(Usuario user, String archivo) {
        try {
            FileAcces proxy = new FileAccesProxy("c:/docs", archivo, user);
            System.out.println(user.miNombre() + " ACCEDE a " + archivo);
        } catch (Exception e) {
            System.out.println(user.miNombre() + " DENEGADO: " + e.getMessage());
        }
    }
}
