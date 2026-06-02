package academy.devdojo.service;

import academy.devdojo.domain.Anime;
import academy.devdojo.repository.AnimeHardCodedRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

public class AnimeService {
    private final AnimeHardCodedRepository repository;

    public AnimeService() {
        this.repository = new AnimeHardCodedRepository();
    }

    public List<Anime> listAll(String name) {
        return name == null ? repository.listAll() : repository.findByName(name);
    }

    public Anime findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Anime save(Anime animeToSave) {
        return repository.save(animeToSave);
    }

    public void deleteById(Long id) {
        Anime anime = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        repository.delete(anime);
    }

    public void update(Anime animeToUpdate) {
        repository.update(animeToUpdate);
    }
}
