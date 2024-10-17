package artifactId.exceptions;


public class DuracionNotValidException extends viewsExceptions {

    public DuracionNotValidException(String titulo, double duracion) {
        super("La duración del video '" + titulo + "' no es válida. Duración: " + duracion + " minutos.");
    }
}