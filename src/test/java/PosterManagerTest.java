import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class PosterManagerTest {
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
