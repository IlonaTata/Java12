import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Poster {
    private int id;
    private String film;
    public int getId() {
        return id;
    }

    public Poster(String film) {
        this.film = film;
    }

    public Poster(int id) {
        this.id = id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFilmName() {
        return film;
    }

    public void setFilmName(String film) {
        this.film = film;
    }
}
