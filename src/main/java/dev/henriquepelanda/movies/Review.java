package dev.henriquepelanda.movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "reviews") // Representa o nome da colecao
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    @Id
    private ObjectId id; // Representa o id
    private String body; // Representa a sequencia do corpo

    public Review(String body) {
        this.body = body;
    }
}
