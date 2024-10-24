package culturoteca.repository;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import culturoteca.model.Video;
import culturoteca.repository.impl.VideoRepositoryImpl;
import culturoteca.exceptions.VideoNotFoundException;
import static org.junit.jupiter.api.Assertions.assertEquals;

class VideoRepositoryTest {

    private VideoRepository videoRepository;

    @BeforeEach
    void init(){

        videoRepository = new VideoRepositoryImpl();

        List<Video> videos = List.of(new Video("01", "Título 1", "----", 4.5),
                new Video("02", "Título 2", "----", 5.5),
                new Video("03", "Título 3", "----", 4.4),
                new Video("04", "Título 4", "----", 3.5),
                new Video("05", "Clic 5", "----", 5.7),
                new Video("06", "Clic 6", "----", 5.1));


        for ( Video video : videos ) {
            videoRepository.save( video );
        }

    }

    @Test
    void when_FindAll_all_videos_should_be_returned_successfully() {
        List<Video> videos = videoRepository.findAll( );
        assertEquals(6, videos.size());
    }

    @Test
    void when_FindByTitle_only_videos_which_contains_the_word_in_the_title_should_be_returned_successfully() {
        List<Video> videos = videoRepository.find( "Clic" );
        assertEquals(2, videos.size());
    }

    @Test
    void when_FindByDuration_only_videos_between_the_range_should_be_returned_successfully() {
        List<Video> videos = videoRepository.find( 4.5, 5.5 );
        assertEquals(3, videos.size());
    }

    @Test
    void when_FindByTitle_does_not_match_any_video_an_empty_list_should_be_returned_successfully() {
        List<Video> videos = videoRepository.findByTitle("Título Inexistente");
        assertTrue(videos.isEmpty(), "La lista de videos debe estar vacía.");
    }

    @Test
    void when_FindByDuration_does_not_match_any_video_an_empty_list_should_be_returned_successfully() {
        List<Video> videos = videoRepository.find(10.0, 12.0);
        assertTrue(videos.isEmpty(), "La lista de videos debe estar vacía.");
    }

    @Test
    void when_FindAll_with_added_videos_should_return_all_successfully() {
        List<Video> newVideos = List.of(
                new Video("01", "Título 1", "----", 4.5),
                new Video("02", "Título 2", "----", 5.5)
        );

        for (Video video : newVideos) {
            videoRepository.save(video);
        }

        List<Video> returnedVideos = videoRepository.findAll();
        assertEquals(8, returnedVideos.size());
        assertTrue(returnedVideos.containsAll(newVideos));
    }
    @Test
    void when_FindAll_does_not_find_any_video_an_VideoNotFoundException_should_be_thrown_successfully() {
        VideoRepository emptyRepository = new VideoRepositoryImpl();
        assertThrows(VideoNotFoundException.class, emptyRepository::findAll);
    }
}
