package academy.devdojo.domain;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
public class Anime {
    private String name;
    private Long id;
    private static List<Anime> animes = new ArrayList<>();
    static {
        var attackOnTitan = new Anime("Attack on Titan", 1L);
        var kimetsuNoYaiba = new Anime("Kimetsu no Yaiba", 2L);
        var jujustuKaisen = new Anime("Jujustu Kaisen", 3L);

        animes.addAll(List.of(attackOnTitan,kimetsuNoYaiba,jujustuKaisen));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static List<Anime> getAnimes() {
        return animes;
    }

    public static void setAnimes(List<Anime> animes) {
        Anime.animes = animes;
    }
}
