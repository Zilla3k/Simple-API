package dev.henriquepelanda.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service // Declara que a classe é apenas um serviço
public class MovieService {
    @Autowired // Faz com que o framework saiba que queremos que ele instancie esta classe
    private MovieRepository movieRepository; // Faz referência ao repositório existente

    // Retorna toda a base de dados
    public List<Movie> allMovies(){
        return movieRepository.findAll();
    }

    //Retorna um dado da base de dados especificado pela ID
    public Optional<Movie> singleMovie(String imdbId){
        return movieRepository.findMovieByImdbId(imdbId);
    }
}
