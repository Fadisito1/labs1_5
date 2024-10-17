package artifactId.repository;  // Usa el paquete correspondiente

import artifactId.model.Video;
import artifactId.model.views;
import java.util.List;
import java.util.Optional;

public interface CulturotecaService {

    void addVideo(Video video);

    Optional<Video> getVideoByCodigo(String codigo);

    Optional<Video> getVideoByTitulo(String titulo);

    void addView(views view);

    List<views> getAllViewsByVideo(String videoCodigo);
}