package academy.devdojo.controller;

import academy.devdojo.domain.Anime;
import academy.devdojo.mapper.AnimeMapper;
import academy.devdojo.request.AnimePostRequest;
import academy.devdojo.request.AnimePostResponse;
import academy.devdojo.response.AnimeGetResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("v1/animes")
@Slf4j
public class AnimeController {
    private static final AnimeMapper MAPPER = AnimeMapper.INSTANCE;

    @GetMapping()
    public ResponseEntity<List<AnimeGetResponse>> listAll(@RequestParam(required = false) String name) {
        log.debug("Request to list all animes, param name: '{}'", name);
        var animeGetResponses = MAPPER.toListAnimeGetResponse(Anime.getAnimes());
        if (name == null) return ResponseEntity.ok(animeGetResponses);

        var response = animeGetResponses.stream()
                .filter(a -> a.getName().equalsIgnoreCase(name))
                .toList();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnimeGetResponse> findById(@PathVariable Long id) {
        log.debug("Request to find anime by id: '{}'", id);

        var animeGetResponse = Anime.getAnimes().stream()
                .filter(a -> a.getId().equals(id))
                .findFirst()
                .map(MAPPER::toAnimeGetResponse)
                .orElse(null);

        return ResponseEntity.ok(animeGetResponse);
    }

    @PostMapping()
    public ResponseEntity<AnimePostResponse> save(@RequestBody AnimePostRequest animePostRequest) {
        log.debug("Request to save one anime: '{}'", animePostRequest);
        var anime = MAPPER.toAnime(animePostRequest);
        Anime.getAnimes().add(anime);

        var response = MAPPER.toAnimePostResponse(anime);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
