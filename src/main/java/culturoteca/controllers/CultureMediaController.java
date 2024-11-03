package culturoteca.controllers;

import java.util.List;
import culturoteca.exceptions.VideoNotFoundException;
import culturoteca.model.Video;
import culturoteca.service.CultureMediaService;

public class CultureMediaController {

    private final CultureMediaService cultureMediaService;

    public CultureMediaController(CultureMediaService cultureMediaService) {
        this.cultureMediaService = cultureMediaService;
    }

    public List<Video> findAllVideos() throws VideoNotFoundException {
        return cultureMediaService.findAll();
    }

    public List<Video> findVideosByTitle(String title) throws VideoNotFoundException {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty.");
        }

        List<Video> videos = cultureMediaService.findByTitle(title);
        if (videos.isEmpty()) {
            throw new VideoNotFoundException("No videos found with the title: " + title);
        }

        return videos;
    }
}