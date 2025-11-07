import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Libro> libros = new ArrayList<>();
    private ArrayList<Usuario> usuarios = new ArrayList<>();

    public void agregarLibro (Libro libro){
        libros.add(libro);
    }
    public void agregarUsuario (Usuario usuario){
        usuarios.add(usuario);
    }
    public void prestarLibro (Libro libro, Usuario usuario){
        System.out.println("El libro " + libro.getTitulo() + "ha sido prestado a: " + usuario.getNombre());
    }
}