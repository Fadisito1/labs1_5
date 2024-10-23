package culturoteca.repository;

import culturoteca.model.View;
import java.time.LocalDateTime;
import java.util.List;

public interface ViewsRepository {

    void addView(String usuario, LocalDateTime viewTime, int edad);

    List<View> findByVideoCodigo(String videoCodigo);

    View save(View view);
}

