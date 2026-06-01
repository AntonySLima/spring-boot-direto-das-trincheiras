package academy.devdojo.mapper;

import academy.devdojo.domain.Anime;
import academy.devdojo.request.AnimePostRequest;
import academy.devdojo.request.AnimePutRequest;
import academy.devdojo.response.AnimeGetResponse;
import academy.devdojo.response.AnimePostResponse;
import academy.devdojo.response.AnimePutResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AnimeMapper {
    AnimeMapper INSTANCE = Mappers.getMapper(AnimeMapper.class);

    // Request
    @Mapping(target = "id", expression = "java(java.util.concurrent.ThreadLocalRandom.current().nextLong(1, 1000))")
    Anime toAnime(AnimePostRequest animePostRequest);
    Anime toanime(AnimePutRequest animePutRequest);

    // Responses
    AnimePostResponse toAnimePostResponse(Anime anime);
    AnimeGetResponse toAnimeGetResponse(Anime anime);
    AnimePutResponse toAnimePutResponse(Anime anime);

    // Map to List<AnimeGetResponse>
    List<AnimeGetResponse> toListAnimeGetResponse(List<Anime> animes);
}
