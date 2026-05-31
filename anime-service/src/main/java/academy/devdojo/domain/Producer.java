package academy.devdojo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class Producer {
    private String name;
    private Long id;
    private LocalDateTime createdAt;

    private static List<Producer> producers = new ArrayList<>();
    static {
        var mappa = Producer.builder().name("Mappa").id(1L).createdAt(LocalDateTime.now()).build();
        var bandaiNamco = Producer.builder().name("Bandai Namco").id(2L).createdAt(LocalDateTime.now()).build();
        var madhouse = Producer.builder().name("Madhouse").id(3L).createdAt(LocalDateTime.now()).build();

        producers.addAll(List.of(mappa,bandaiNamco,madhouse));
    }

    public static List<Producer> getProducers() {
        return producers;
    }
}
