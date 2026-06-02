package academy.devdojo.domain;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Producer {
    private String name;
    @EqualsAndHashCode.Include
    private Long id;
    private LocalDateTime createdAt;
}
