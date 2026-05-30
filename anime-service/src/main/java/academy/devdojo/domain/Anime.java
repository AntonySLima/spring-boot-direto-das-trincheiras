package academy.devdojo.domain;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
public class Anime {
    private String name;
    private Long id;
    @Getter
    private static List<Anime> animes = new ArrayList<>();
    static {
        var attackOnTitan = new Anime("Attack on Titan", 1L);
        var kimetsuNoYaiba = new Anime("Kimetsu no Yaiba", 2L);
        var jujustuKaisen = new Anime("Jujustu Kaisen", 3L);

        animes.addAll(List.of(attackOnTitan,kimetsuNoYaiba,jujustuKaisen));
    }
}
