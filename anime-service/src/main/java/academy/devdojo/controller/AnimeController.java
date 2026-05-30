package academy.devdojo.controller;

import academy.devdojo.domain.Anime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/animes")
@Slf4j
public class AnimeController {

    @GetMapping()
    public List<Anime> listAll(@RequestParam(required = false) String name) {
        if (name == null) return Anime.getAnimes();
        return Anime.getAnimes().stream()
                .filter(a -> a.getName().equalsIgnoreCase(name))
                .toList();
    }

    @GetMapping("/{id}")
    public Anime findById(@PathVariable Long id) {
        return Anime.getAnimes().stream()
                .filter(a -> a.getId().equals(id))
                .findFirst().orElse(null);
    }
}
