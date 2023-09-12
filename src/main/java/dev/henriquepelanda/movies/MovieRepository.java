package dev.henriquepelanda.movies;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository // informa ao framework que a classe é um repositório
// extende classe do MongoRepositoty existente,
// e entre '<>' informamos com quais tipos de dados estamos trabalhando,
// neste caso 'Movie' e 'ObjectId'
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {
    Optional<Movie> findMovieByImdbId(String imdbId);
}
