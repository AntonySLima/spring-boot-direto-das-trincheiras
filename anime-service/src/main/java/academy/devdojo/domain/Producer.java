package academy.devdojo.domain;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Producer {
    private String name;
    @EqualsAndHashCode.Include
    private Long id;
    private LocalDateTime createdAt;

    private static List<Producer> producers = new ArrayList<>();

    static {
        var mappa = Producer.builder().name("Mappa").id(1L).createdAt(LocalDateTime.now()).build();
        var bandaiNamco = Producer.builder().name("Bandai Namco").id(2L).createdAt(LocalDateTime.now()).build();
        var madhouse = Producer.builder().name("Madhouse").id(3L).createdAt(LocalDateTime.now()).build();

        producers.addAll(List.of(mappa, bandaiNamco, madhouse));
    }

    public static List<Producer> getProducers() {
        return producers;
    }
}
