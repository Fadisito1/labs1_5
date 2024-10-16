package artifactId.model;

import java.time.LocalDateTime;

public record views(
        String usuario,
        LocalDateTime viewTime,
        int edad
) {

}