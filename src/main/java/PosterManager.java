public class PosterManager {

    private PosterRepository repo;

    public PosterManager(PosterRepository repo) {
        this.repo = repo;
    }

    private String[] films = new String[0];
    private int limit;

    public PosterManager() {
        this.limit = 10;
    }
    public PosterManager(int limit) {
        this.limit = limit;
    }
    public void addFilm(String film) {
        String[] tmp = new String[films.length + 1];
        for (int i = 0; i < films.length; i++) {
            tmp[i] = films[i];
        }
        tmp[tmp.length - 1] = film;
        films = tmp;
    }
    public String[] findAll() {
        return films;
    }

    public String[] findLast() {
        int amount;
        if (films.length < limit) {
            amount = films.length;
        } else {
            amount = limit;
        }
        String[] tmp = new String[amount];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = films[films.length - 1 - i];
        }
        return tmp;
    }

}








