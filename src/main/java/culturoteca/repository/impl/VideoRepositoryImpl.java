package culturoteca.repository.impl;

import java.util.ArrayList;
import java.util.List;

import culturoteca.exceptions.DurationNotFoundException;
import culturoteca.exceptions.TitleNotFoundException;
import culturoteca.exceptions.VideoNotFoundException;
import culturoteca.model.Video;
import culturoteca.repository.VideoRepository;
import org.springframework.stereotype.Component;

@Component
public class VideoRepositoryImpl implements VideoRepository {

    private final List<Video> videos;

    public VideoRepositoryImpl() {
        videos = new ArrayList<>();
    }

    @Override
    public List<Video> findAll() {
        if (videos.isEmpty()) {
            throw new VideoNotFoundException("No videos found.");
        }
        return new ArrayList<>(videos);
    }
    @Override
    public Video save(Video video) {
        this.videos.add(video);
        return video;
    }
    @Override
    public List<Video> find(String title) {
        List<Video> filteredVideos = new ArrayList<>();
        for (Video video : videos) {
            if (video.titulo().contains(title)) {
                filteredVideos.add(video);
            }
        }
        if (filteredVideos.isEmpty()) {
            throw new TitleNotFoundException("No videos found with title: " + title);
        }
        return filteredVideos;
    }

    @Override
    public List<Video> find(Double fromDuration, Double toDuration) {
        List<Video> filteredVideos = new ArrayList<>();
        for (Video video : videos) {
            if (video.duracion() >= fromDuration && video.duracion() <= toDuration) {
                filteredVideos.add(video);
            }
        }
        if (filteredVideos.isEmpty()) {
            throw new DurationNotFoundException("No videos found with duration between " + fromDuration + " and " + toDuration);
        }
        return filteredVideos;
    }

    @Override
    public List<Video> findByTitle(String title) {
        return List.of();
    }
}