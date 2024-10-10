package artifactId.repository;
import artifactId.model.Video;
import java.util.List;

public interface VideoRepository {


    List<Video> listarVideos();

    void agregarVideo(String codigo, String titulo, String descripcion, double duracion);

    List<Video> buscarPorTitulo(String titulo);

    List<Video> buscarPorDuracion(double duracion);
}