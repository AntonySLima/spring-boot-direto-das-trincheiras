package academy.devdojo.controller;

import academy.devdojo.domain.Producer;
import academy.devdojo.mapper.ProducerMapper;
import academy.devdojo.request.ProducerPostRequest;
import academy.devdojo.response.ProducerGetResponse;
import academy.devdojo.response.ProducerPostResponse;
import org.slf4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("v1/producers")
public class ProducerController {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(ProducerController.class);
    private static final ProducerMapper MAPPER = ProducerMapper.INSTANCE;

    @GetMapping()
    public ResponseEntity<List<ProducerGetResponse>> listAll(@RequestParam(required = false) String name) {
        log.debug("Request to returning all Producers, param name '{}'", name);
        List<ProducerGetResponse> producerGetResponseList = MAPPER.toProducerGetResponseList(Producer.getProducers());
        if (name == null) return ResponseEntity.ok(producerGetResponseList);

        List<ProducerGetResponse> producerGetResponses = producerGetResponseList.stream()
                .filter(a -> a.getName().equalsIgnoreCase(name))
                .toList();
        return ResponseEntity.ok(producerGetResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProducerGetResponse> findById(@PathVariable Long id) {
        log.debug("Requesting to return Producer by id, param id '{}'", id);
        ProducerGetResponse producerGetResponse = MAPPER.toProducerGetResponseList(Producer.getProducers())
                .stream()
                .filter(a -> a.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Producer not found"));
        return ResponseEntity.ok(producerGetResponse);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, headers = "x-api-key")
    public ResponseEntity<ProducerPostResponse> save(@RequestBody ProducerPostRequest producerPostRequest, @RequestHeader HttpHeaders headers) {
        log.debug("Requesting to save Producer: '{}'", producerPostRequest);
        var producer = MAPPER.toProducer(producerPostRequest);
        Producer.getProducers().add(producer);

        var response = MAPPER.toProducerPostResponse(producer);


        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        log.debug("Requesting to delete Producer with id: '{}'", id);

        boolean removedIf = Producer.getProducers()
                .removeIf(p -> p.getId().equals(id));

        if (!removedIf) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Producer not found");
        }

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
