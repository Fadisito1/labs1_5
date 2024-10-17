package artifactId.repository;

import artifactId.model.views;
import java.time.LocalDateTime;
import java.util.List;

public interface ViewsRepository {

    void addView(String usuario, LocalDateTime viewTime, int edad);

    List<views> findByVideoCodigo(String videoCodigo);
}

