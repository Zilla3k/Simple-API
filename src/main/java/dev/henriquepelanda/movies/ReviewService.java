package dev.henriquepelanda.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public Review createReview(String reviewBody, String imdbId){
        Review review = reviewRepository.insert(new Review(reviewBody)); // Insere a review no DB

        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId") // Vai no DB e procura o imdbId
                        .is(imdbId)) // passado pelo usuario
                .apply(new Update().push("reviewIds") // E realiza o update na area `reviewIds`
                        .value(review))// com o conteudo passado pelo usuario
                .first(); // Para ter certeza que teremos um unico filme a ser atualizado

        return review;
    }
}
