public class Moduralidad {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Libro libro1 = new Libro("Los 3 cochinitos", "Joseph Jacob");
        Usuario usuario1 = new Usuario("Hugo Sanchez", 01);
        Libro libro2 = new Libro("La Cenicienta", "Rosa");
        Usuario usuario2 = new Usuario("Jaqueline Guadalupe", 02);
        Libro libro3 = new Libro("La Bella y La Bestia", "Feilpe");
        Usuario usuario3 = new Usuario("Ariday Hernandez", 03);
        Libro libro4 = new Libro("El principito", "Pepe");
        Usuario usuario4 = new Usuario("Brandom Villanueva", 04);
        Libro libro5 = new Libro("La Caperucita Roja", "Jeffrey Esptein");
        Usuario usuario5 = new Usuario("Juan Jose", 05);


        biblioteca.agregarLibro(libro1);
        biblioteca.agregarUsuario(usuario1);
        biblioteca.prestarLibro(libro1, usuario1);
        biblioteca.agregarLibro(libro2);
        biblioteca.agregarUsuario(usuario2);
        biblioteca.prestarLibro(libro2, usuario2);
        biblioteca.agregarLibro(libro3);
        biblioteca.agregarUsuario(usuario3);
        biblioteca.prestarLibro(libro3, usuario3);
        biblioteca.agregarLibro(libro4);
        biblioteca.agregarUsuario(usuario4);
        biblioteca.prestarLibro(libro4, usuario4);
        biblioteca.agregarLibro(libro5);
        biblioteca.agregarUsuario(usuario5);
        biblioteca.prestarLibro(libro5, usuario5);
    }
}