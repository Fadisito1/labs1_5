package culturoteca.service.impl;

import java.util.List;
import culturoteca.model.Video;
import culturoteca.exceptions.VideoNotFoundException;
import culturoteca.repository.VideoRepository; // Asegúrate de importar el repositorio correcto
import culturoteca.service.CultureMediaService;

public class CultureMediaServiceImpl implements CultureMediaService {

    private final VideoRepository videoRepository; // Dependencia del repositorio

    public CultureMediaServiceImpl(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    @Override
    public List<Video> findAll() throws VideoNotFoundException {
        List<Video> videos = videoRepository.findAll();
        if (videos.isEmpty()) {
            throw new VideoNotFoundException("No videos found.");
        }
        return videos;
    }

    @Override
    public List<Video> findByTitle(String title) {
        return List.of();
    }
}