package culturoteca.repository.impl;

import java.util.ArrayList;
import java.util.List;
import culturoteca.exceptions.VideoNotFoundException;
import culturoteca.model.Video;
import culturoteca.repository.VideoRepository;

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
        return new ArrayList<>(videos); // Devuelve una copia de la lista de videos
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
        return filteredVideos;
    }

    @Override
    public List<Video> findByTitle(String title) {
        List<Video> matchedVideos = new ArrayList<>();
        for (Video video : videos) {
            if (video.titulo().equalsIgnoreCase(title)) {
                matchedVideos.add(video);
            }
        }
        return matchedVideos;
    }
}