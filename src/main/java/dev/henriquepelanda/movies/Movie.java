package dev.henriquepelanda.movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

// Permite que a estrutura observe que a planilha
// representa cada documento da coleção de filmes
@Document(collection = "movies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    @Id // Faz com que o framework trate `id` como identificador único para cada filme no DB
    private ObjectId id; // Representa o ID do filme
    private String imdbId; // Representa o ID do imdb do filme
    private String title; // Representa o Titulo
    private String releaseDate; // Representa o ano de lançamento
    private String trailerLink; // Representa o Link do YT
    private String poster; // Representa a imagem do filme
    private List<String> genres; // Representa os gêneros de um único filme
    private List<String> backdrops; // Representa a imagem do filme
    @DocumentReference // Faz com que o DB armazene apenas os ID's da review
    private List<Review> reviewIds; // Representa os identificadores de review
}
