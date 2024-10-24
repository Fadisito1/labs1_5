package culturoteca.exceptions;

public class DurationNotFoundException extends RuntimeException {
    public DurationNotFoundException(String message) {
        super(message);
    }
}