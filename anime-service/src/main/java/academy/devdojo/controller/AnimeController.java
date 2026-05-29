package academy.devdojo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AnimeController {

    @GetMapping("v1/animes")
    public List<String> listAll() {
        return List.of("Attack on titan", "Berserk", "Jujutsu Kaisen");
    }
}
