package Ejercicio2;

public class FileAccesProxy extends FileAcces{
    private Usuario usuario;

    public FileAccesProxy(String ruta, String nombre, Usuario usuario) {
        super(ruta, nombre);
        this.usuario = usuario;
    }

    @Override
    public String readFile() throws IOException {
        if (usuario.poseePermiso(Permiso.ADMIN) || usuario.poseePermiso(Permiso.INTERMEDIO)) {
            return super.readFile();
        } else {
            throw new IOException("Acceso denegado: Usuario no tiene permisos suficientes.");
        }
    }


}
