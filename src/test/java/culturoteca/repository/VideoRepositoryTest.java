package culturoteca.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import culturoteca.exceptions.DurationNotFoundException;
import culturoteca.exceptions.TitleNotFoundException;
import culturoteca.model.Video;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class VideoRepositoryTest {

    private VideoRepository videoRepository;
    private Video video2;

    @BeforeEach
    void init() {
        videoRepository = mock(VideoRepository.class);
        Video video1 = new Video("01", "Título 1", "----", 4.5);
        video2 = new Video("02", "Título 2", "----", 5.5);
        Video video3 = new Video("03", "Clic 3", "----", 4.4);

        List<Video> videos = new ArrayList<>();
        videos.add(video1);
        videos.add(video2);
        videos.add(video3);

        when(videoRepository.findAll()).thenReturn(videos);
        when(videoRepository.find("Clic")).thenReturn(List.of(video3));
        when(videoRepository.find(4.0, 5.5)).thenReturn(List.of(video1, video2));
        when(videoRepository.find("Título Inexistente")).thenThrow(new TitleNotFoundException("Título no encontrado"));
        when(videoRepository.find(10.0, 12.0)).thenThrow(new DurationNotFoundException("Duración no encontrada"));
    }

    @Test
    void when_FindAll_all_videos_should_be_returned_successfully() {
        List<Video> videos = videoRepository.findAll();
        assertEquals(3, videos.size());
    }

    @Test
    void when_FindByTitle_only_videos_which_contains_the_word_in_the_title_should_be_returned_successfully() {
        List<Video> videos = videoRepository.find("Clic");
        assertEquals(1, videos.size());
        assertEquals("Clic 3", videos.get(0).titulo());
    }

    @Test
    void when_FindByDuration_only_videos_between_the_range_should_be_returned_successfully() {
        List<Video> videos = videoRepository.find(4.0, 5.5);
        assertEquals(2, videos.size());
    }

    @Test
    void when_FindByTitle_does_not_match_any_video_TitleNotFoundException_should_be_thrown() {
        assertThrows(TitleNotFoundException.class, () -> videoRepository.find("Título Inexistente"));
    }

    @Test
    void when_FindByDuration_does_not_find_any_video_DurationNotFoundException_should_be_thrown() {
        assertThrows(DurationNotFoundException.class, () -> videoRepository.find(10.0, 12.0));
    }
}