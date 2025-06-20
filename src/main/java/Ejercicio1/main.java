package Ejercicio1;

public class main {
    public static void main(String[] args) {

        Persona p = new Persona(1, "María", new TelefonoSetProxy("María"));

        System.out.println("🚀 Programa arrancó");

        // No se cargan aún
        System.out.println("📦 Teléfonos aún no accedidos");

        // Primer acceso → se cargan
        System.out.println("📱 Teléfonos: " + p.getTelefonos());

        // Segundo acceso → ya están cargados
        System.out.println("✅ Total: " + p.getTelefonos().size());
    }
}
