public class PosterRepository {
    private Poster[] films = new Poster[0];
    public void save(Poster film) {
        Poster[] tmp = new Poster[films.length + 1];
        for (int i = 0; i < films.length; i++) {
            tmp[i] = films[i];
        }
        tmp[tmp.length - 1] = film;
        films = tmp;
    }
    public Poster [] findAll() {
        return films;
    }

    public void findById(int id) {
        Poster[] tmp = new Poster[films.length];
        int copyToIndex = 0;
        for (Poster film : films) {
            if (film.getId() == id) {
                tmp[copyToIndex] = film;
                copyToIndex++;
            }
        }
        films = tmp;
    }
    public void removeById(int id) {
        Poster[] tmp = new Poster[films.length-1];
        int copyToIndex = 0;
        for (Poster film : films) {
            if (film.getId() != id) {
                tmp[copyToIndex] = film;
                copyToIndex++;
            }
        }
        films = tmp;
    }
    public void removeAll() {
        Poster[] tmp = new Poster[0];
    }



}

