package culturoteca.repository;
import culturoteca.model.Video;
import java.util.List;

public interface VideoRepository {


    List<Video> findAll();

    Video save(Video video);

    List<Video> find(String title);

    List<Video> find(Double fromDuration, Double toDuration);

    List<Video> listarVideos();

    void agregarVideo(String codigo, String titulo, String descripcion, double duracion);

    List<Video> buscarPorTitulo(String titulo);

    List<Video> buscarPorDuracion(double duracion);
}