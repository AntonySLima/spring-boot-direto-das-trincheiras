package academy.devdojo.controller;

import academy.devdojo.domain.Producer;
import academy.devdojo.mapper.ProducerMapper;
import academy.devdojo.request.ProducerPutRequest;
import academy.devdojo.request.ProducerPostRequest;
import academy.devdojo.response.ProducerPutResponse;
import academy.devdojo.response.ProducerGetResponse;
import academy.devdojo.response.ProducerPostResponse;
import academy.devdojo.service.ProducerService;
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
    private ProducerService service;

    public ProducerController() {
        this.service = new ProducerService();
    }

    @GetMapping()
    public ResponseEntity<List<ProducerGetResponse>> listAll(@RequestParam(required = false) String name) {
        log.debug("Request to returning all Producers, param name '{}'", name);
        var producers = service.findAll(name);

        var producerGetResponses = MAPPER.toProducerGetResponseList(producers);

        return ResponseEntity.ok(producerGetResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProducerGetResponse> findById(@PathVariable Long id) {
        log.debug("Requesting to return Producer by id, param id '{}'", id);
        var producer = service.findByIdOrThrowNotFound(id);

        var producerGetResponse = MAPPER.toProducerGetResponse(producer);

        return ResponseEntity.ok(producerGetResponse);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, headers = "x-api-key")
    public ResponseEntity<ProducerPostResponse> save(@RequestBody ProducerPostRequest producerPostRequest, @RequestHeader HttpHeaders headers) {
        log.debug("Requesting to save Producer: '{}'", producerPostRequest);

        var producer = MAPPER.toProducer(producerPostRequest);

        Producer producerSaved = service.save(producer);

        var producerPostResponse = MAPPER.toProducerPostResponse(producerSaved);

        return ResponseEntity.status(HttpStatus.CREATED).body(producerPostResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        log.debug("Requesting to delete Producer with id: '{}'", id);

        service.deleteById(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping()
    public ResponseEntity<Void> update(@RequestBody ProducerPutRequest request) {
        log.debug("Requesting to update Producer: '{}'", request);

        var producerToUpdate = MAPPER.toProducer(request);

        service.update(producerToUpdate);

        return ResponseEntity.noContent().build();
    }
}
