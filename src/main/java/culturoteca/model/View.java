package culturoteca.model;

import java.time.LocalDateTime;

public record View(
        String usuario,
        LocalDateTime viewTime,
        int edad
) {

}