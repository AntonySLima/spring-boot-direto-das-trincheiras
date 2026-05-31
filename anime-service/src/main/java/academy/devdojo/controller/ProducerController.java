package academy.devdojo.controller;

import academy.devdojo.domain.Producer;
import org.slf4j.Logger;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping("v1/producers")
public class ProducerController {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(ProducerController.class);

    @GetMapping()
    public List<Producer> listAll(@RequestParam(required = false) String name) {
        if (name == null) return Producer.getProducers();
        return Producer.getProducers().stream()
                .filter(a -> a.getName().equalsIgnoreCase(name))
                .toList();
    }

    @GetMapping("/{id}")
    public Producer findById(@PathVariable Long id) {
        return Producer.getProducers().stream()
                .filter(a -> a.getId().equals(id))
                .findFirst().orElse(null);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE,
            headers = "x-api-key")
    public ResponseEntity<Producer> save(@RequestBody Producer producer, @RequestHeader HttpHeaders headers) {
        log.info("header '{}'", headers);
        producer.setId(ThreadLocalRandom.current().nextLong(1, 1000));
        Producer.getProducers().add(producer);
        log.info("Saved Producer: '{}'", producer);
        var respondeHeaders = new HttpHeaders();
        respondeHeaders.add("Authorization", "My key");

        return ResponseEntity.status(HttpStatus.CREATED).headers(respondeHeaders).body(producer);
    }
}
