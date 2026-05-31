package academy.devdojo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
public class Producer {
    private String name;
    private Long id;

    private static List<Producer> producers = new ArrayList<>();
    static {
        var mappa = new Producer("Mappa", 1L);
        var bandaiNamco = new Producer("Bandai Namco", 2L);
        var madhouse = new Producer("Madhouse", 3L);

        producers.addAll(List.of(mappa,bandaiNamco,madhouse));
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public static List<Producer> getProducers() {
        return producers;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static void setProducers(List<Producer> producers) {
        Producer.producers = producers;
    }
}
