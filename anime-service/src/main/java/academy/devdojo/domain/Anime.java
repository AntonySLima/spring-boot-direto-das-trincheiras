package academy.devdojo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@AllArgsConstructor
@Value
public class Anime {
    String name;
    Long id;

    public static List<Anime> getAnimes() {
        return List.of(
                new Anime("Attack on Titan", 1L),
                new Anime("Kimetsu no Yaiba", 2L),
                new Anime("Jujustu Kaisen", 3L));
    }
}
