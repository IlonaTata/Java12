import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.mockito.Mockito.*;

public class PosterManagerTest {

    PosterRepository repo = Mockito.mock(PosterRepository.class);
    PosterManager manager = new PosterManager(repo);
    Poster film1 = new Poster(1,"Номер 1");
    Poster film2 = new Poster(2,"Номер 2");
    Poster film3 = new Poster(3,"Номер 3");
    @Test
    public void addFilmWithMockito() {
        Poster[] films = {film1, film2, film3};
        doReturn(films).when(repo).findAll();
        String[] expected = {"Номер 1", "Номер 2", "Номер 3"};
        manager.addFilm("Номер 1");
        manager.addFilm("Номер 2");
        manager.addFilm("Номер 3");
        String[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void addFilmWithMockito1() {
        Poster[] films = {film1, film2,film3};
        doReturn(films).when(repo).findAll();
        String[] expected = {"Номер 1", "Номер 2"};
        manager.addFilm("Номер 1");
        manager.addFilm("Номер 2");
        String[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void addFilm() {
        PosterManager manager = new PosterManager();
        manager.addFilm("Номер 1");
        manager.addFilm("Номер 2");
        manager.addFilm("Номер 3");
        manager.addFilm("Номер 4");
        manager.addFilm("Номер 5");
        String[] expected = {"Номер 1", "Номер 2", "Номер 3", "Номер 4", "Номер 5"};
        String[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void addLastFilm() {
        PosterManager manager = new PosterManager();
        manager.addFilm("Номер 1");
        manager.addFilm("Номер 2");
        manager.addFilm("Номер 3");
        manager.addFilm("Номер 4");
        manager.addFilm("Номер 5");
        String[] expected = {"Номер 5", "Номер 4", "Номер 3", "Номер 2", "Номер 1"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void addFilmWithLimit() {
        PosterManager manager = new PosterManager(5);
        manager.addFilm("Номер 1");
        manager.addFilm("Номер 2");
        manager.addFilm("Номер 3");
        manager.addFilm("Номер 4");
        manager.addFilm("Номер 5");
        String[] expected = {"Номер 1", "Номер 2", "Номер 3", "Номер 4","Номер 5"};
        String[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void addFilmOverLimit() {
        PosterManager manager = new PosterManager(5);
        manager.addFilm("Номер 1");
        manager.addFilm("Номер 2");
        manager.addFilm("Номер 3");
        manager.addFilm("Номер 4");
        manager.addFilm("Номер 5");
        manager.addFilm("Номер 6");
        String[] expected = {"Номер 6", "Номер 5", "Номер 4", "Номер 3", "Номер 2"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void addFilmLessLimit() {
        PosterManager manager = new PosterManager(5);
        manager.addFilm("Номер 1");
        manager.addFilm("Номер 2");
        manager.addFilm("Номер 3");
        manager.addFilm("Номер 4");
        String[] expected = {"Номер 4", "Номер 3", "Номер 2", "Номер 1"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

}
