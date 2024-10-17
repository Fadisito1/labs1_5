package artifactId.repository.impl;  // Asegúrate de que el paquete sea correcto

import artifactId.repository.CulturotecaService;
import artifactId.model.Video;
import artifactId.model.views;
import artifactId.repository.VideoRepository;
import artifactId.repository.ViewsRepository;

import java.util.List;
import java.util.Optional;

public class CulturotecaServiceImpl implements CulturotecaService {

    private final VideoRepository videoRepository;  // Repositorio para los videos
    private final ViewsRepository viewsRepository;  // Repositorio para las vistas


    public CulturotecaServiceImpl(VideoRepository videoRepository, ViewsRepository viewsRepository) {
        this.videoRepository = videoRepository;
        this.viewsRepository = viewsRepository;
    }

    @Override
    public void addVideo(Video video) {
        videoRepository.agregarVideo(video.codigo(), video.titulo(), video.descripcion(), video.duracion());
    }

    @Override
    public Optional<Video> getVideoByCodigo(String codigo) {
        List<Video> videos = videoRepository.listarVideos();
        return videos.stream().filter(video -> video.codigo().equals(codigo)).findFirst();
    }

    @Override
    public Optional<Video> getVideoByTitulo(String titulo) {
        List<Video> videos = videoRepository.buscarPorTitulo(titulo);
        return videos.isEmpty() ? Optional.empty() : Optional.of(videos.get(0)); // Devolver el primer video encontrado
    }

    @Override
    public void addView(views view) {
        // Usamos el repositorio de vistas para añadir una nueva vista
        viewsRepository.addView(view.usuario(), view.viewTime(), view.edad());
    }

    @Override
    public List<views> getAllViewsByVideo(String videoCodigo) {
        // Buscamos todas las vistas para un video específico en el repositorio
        return viewsRepository.findByVideoCodigo(videoCodigo);
    }
}