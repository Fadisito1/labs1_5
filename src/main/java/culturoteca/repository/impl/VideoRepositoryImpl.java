package culturoteca.repository.impl;
import java.util.ArrayList;
import java.util.List;

import culturoteca.model.Video;
import culturoteca.repository.VideoRepository;

public class VideoRepositoryImpl implements VideoRepository {

    private final List<Video> videos;

    public VideoRepositoryImpl() {
        videos = new ArrayList<>();
    }

    @Override
    public List<Video> findAll() {
        return videos;
    }

    @Override
    public Video save(Video video) {
        this.videos.add( video );
        return video;
    }

    @Override
    public List<Video> find(String title) {
        List<Video> filteredVideos = null;
        for ( Video video : videos ) {
            if(title.equals( video.titulo() )){
                if(filteredVideos == null){
                    filteredVideos = new ArrayList<Video>();
                }
                filteredVideos.add(video);
            }
        }
        return filteredVideos;
    }

    @Override
    public List<Video> find(Double fromDuration, Double toDuration) {
        List<Video> filteredVideos = new ArrayList<Video>();
        for ( Video video : videos ) {
            if(video.duracion()> fromDuration && video.duracion()< toDuration){
                filteredVideos.add(video);
            }
        }
        return filteredVideos;
    }

    @Override
    public List<Video> listarVideos() {
        return List.of();
    }

    @Override
    public void agregarVideo(String codigo, String titulo, String descripcion, double duracion) {

    }

    @Override
    public List<Video> buscarPorTitulo(String titulo) {
        return List.of();
    }

    @Override
    public List<Video> buscarPorDuracion(double duracion) {
        return List.of();
    }


}