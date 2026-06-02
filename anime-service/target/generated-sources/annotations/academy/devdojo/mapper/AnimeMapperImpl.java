package academy.devdojo.mapper;

import academy.devdojo.domain.Anime;
import academy.devdojo.request.AnimePostRequest;
import academy.devdojo.request.AnimePutRequest;
import academy.devdojo.response.AnimeGetResponse;
import academy.devdojo.response.AnimePostResponse;
import academy.devdojo.response.AnimePutResponse;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-06-02T13:18:00-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 26.0.1 (Oracle Corporation)"
)
public class AnimeMapperImpl implements AnimeMapper {

    @Override
    public Anime toAnime(AnimePostRequest animePostRequest) {
        if ( animePostRequest == null ) {
            return null;
        }

        String name = null;

        name = animePostRequest.getName();

        Long id = java.util.concurrent.ThreadLocalRandom.current().nextLong(1, 1000);

        Anime anime = new Anime( id, name );

        return anime;
    }

    @Override
    public Anime toanime(AnimePutRequest animePutRequest) {
        if ( animePutRequest == null ) {
            return null;
        }

        Long id = null;
        String name = null;

        id = animePutRequest.getId();
        name = animePutRequest.getName();

        Anime anime = new Anime( id, name );

        return anime;
    }

    @Override
    public AnimePostResponse toAnimePostResponse(Anime anime) {
        if ( anime == null ) {
            return null;
        }

        AnimePostResponse animePostResponse = new AnimePostResponse();

        animePostResponse.setName( anime.getName() );
        animePostResponse.setId( anime.getId() );

        return animePostResponse;
    }

    @Override
    public AnimeGetResponse toAnimeGetResponse(Anime anime) {
        if ( anime == null ) {
            return null;
        }

        AnimeGetResponse animeGetResponse = new AnimeGetResponse();

        animeGetResponse.setName( anime.getName() );
        animeGetResponse.setId( anime.getId() );

        return animeGetResponse;
    }

    @Override
    public AnimePutResponse toAnimePutResponse(Anime anime) {
        if ( anime == null ) {
            return null;
        }

        AnimePutResponse animePutResponse = new AnimePutResponse();

        animePutResponse.setName( anime.getName() );
        animePutResponse.setId( anime.getId() );

        return animePutResponse;
    }

    @Override
    public List<AnimeGetResponse> toListAnimeGetResponse(List<Anime> animes) {
        if ( animes == null ) {
            return null;
        }

        List<AnimeGetResponse> list = new ArrayList<AnimeGetResponse>( animes.size() );
        for ( Anime anime : animes ) {
            list.add( toAnimeGetResponse( anime ) );
        }

        return list;
    }
}
