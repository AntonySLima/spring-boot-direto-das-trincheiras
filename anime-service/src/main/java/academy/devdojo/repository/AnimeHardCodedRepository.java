package academy.devdojo.repository;

import academy.devdojo.domain.Anime;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AnimeHardCodedRepository {
    private static final List<Anime> ANIMES = new ArrayList<>();

    static {
        var ninjaKamui = new Anime(1L, "Ninja Kamui");
        var kaijuu = new Anime(2L, "Kaijuu-8gou");
        var kimetsuNoYaiba = new Anime(3L, "Kimetsu No Yaiba");
        ANIMES.addAll(List.of(ninjaKamui, kaijuu, kimetsuNoYaiba));
    }

    public static List<Anime> getAnimes() {
        return ANIMES;
    }

    public List<Anime> listAll() {
        return ANIMES;
    }

    public List<Anime> findByName(String name) {
        return ANIMES.stream()
                .filter(anime -> anime.getName().equalsIgnoreCase(name))
                .toList();
    }

    public Optional<Anime> findById(Long id) {
        return ANIMES.stream()
                .filter(anime -> anime.getId().equals(id))
                .findFirst();
    }

    public Anime save(Anime anime) {
        ANIMES.add(anime);
        return anime;
    }

    public void delete(Anime anime) {
        ANIMES.remove(anime);
    }

    public void update(Anime animeToUpdate) {
        ANIMES.remove(animeToUpdate);
        ANIMES.add(animeToUpdate);
    }

}
