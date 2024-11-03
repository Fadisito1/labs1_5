package culturoteca.service;

import java.util.List;
import culturoteca.model.Video;
import culturoteca.exceptions.VideoNotFoundException;

public interface CultureMediaService {
    List<Video> findAll() throws VideoNotFoundException;

    List<Video> findByTitle(String title);
}