package Ejercicio1;

public class Main {
    public static void main(String[] args) {
        // inicializar la base de datos
        LevantarBD.inicializar();

        // obtenemos persona
        var dao = new PersonaDao();
        var p = dao.personaPorId(1);

        System.out.println("Nombre: " + p.nombre());

        for (Telefono telefono : p.telefonos()) {
            System.out.println(telefono);
        }
    }
}