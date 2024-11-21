package culturoteca.service.impl;

import org.springframework.stereotype.Service;
import java.util.List;
import culturoteca.model.Video;
import culturoteca.exceptions.VideoNotFoundException;
import culturoteca.repository.VideoRepository;
import culturoteca.service.CultureMediaService;

@Service
public class CultureMediaServiceImpl implements CultureMediaService {

    private final VideoRepository videoRepository;

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

        List<Video> videos = videoRepository.findByTitle(title);
        if (videos.isEmpty()) {
            throw new VideoNotFoundException("No videos found with the title: " + title);
        }
        return videos;
    }
}