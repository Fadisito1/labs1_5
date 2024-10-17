package artifactId.repository;

import artifactId.model.views;
import java.time.LocalDateTime;

public interface ViewsRepository {

    void addView(String usuario, LocalDateTime viewTime, int edad);
}

