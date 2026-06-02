package academy.devdojo.mapper;

import academy.devdojo.domain.Producer;
import academy.devdojo.request.ProducerPostRequest;
import academy.devdojo.request.ProducerPutRequest;
import academy.devdojo.response.ProducerGetResponse;
import academy.devdojo.response.ProducerPostResponse;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-06-02T13:24:19-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 26.0.1 (Oracle Corporation)"
)
public class ProducerMapperImpl implements ProducerMapper {

    @Override
    public Producer toProducer(ProducerPostRequest postRequest) {
        if ( postRequest == null ) {
            return null;
        }

        Producer.ProducerBuilder producer = Producer.builder();

        producer.name( postRequest.getName() );

        producer.createdAt( java.time.LocalDateTime.now() );
        producer.id( java.util.concurrent.ThreadLocalRandom.current().nextLong(1, 1000) );

        return producer.build();
    }

    @Override
    public Producer toProducer(ProducerPutRequest putRequest) {
        if ( putRequest == null ) {
            return null;
        }

        Producer.ProducerBuilder producer = Producer.builder();

        producer.name( putRequest.getName() );
        producer.id( putRequest.getId() );

        return producer.build();
    }

    @Override
    public ProducerGetResponse toProducerGetResponse(Producer producer) {
        if ( producer == null ) {
            return null;
        }

        ProducerGetResponse.ProducerGetResponseBuilder producerGetResponse = ProducerGetResponse.builder();

        producerGetResponse.id( producer.getId() );
        producerGetResponse.name( producer.getName() );
        producerGetResponse.createdAt( producer.getCreatedAt() );

        return producerGetResponse.build();
    }

    @Override
    public List<ProducerGetResponse> toProducerGetResponseList(List<Producer> producers) {
        if ( producers == null ) {
            return null;
        }

        List<ProducerGetResponse> list = new ArrayList<ProducerGetResponse>( producers.size() );
        for ( Producer producer : producers ) {
            list.add( toProducerGetResponse( producer ) );
        }

        return list;
    }

    @Override
    public ProducerPostResponse toProducerPostResponse(Producer producer) {
        if ( producer == null ) {
            return null;
        }

        ProducerPostResponse producerPostResponse = new ProducerPostResponse();

        producerPostResponse.setId( producer.getId() );
        producerPostResponse.setName( producer.getName() );

        return producerPostResponse;
    }
}
