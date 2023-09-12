package dev.henriquepelanda.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController // Define como um Rest
@RequestMapping("/api/v1/movies") // Define a solicitação para o endpoint definido, ao inves de localhost:8080/
public class MovieController {


    @Autowired // Faz com que o framework saiba que queremos que ele instancie esta classe
    private MovieService movieService;

    // Retorna toda a base de dados dos filmes
    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(){
        return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);
    }

    // Retorna apenas um filme especificado pela ID
    @GetMapping("/{imdbId}") // Pesquisa um filme pela ID
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbId){ // Retorna um filme especifico
        return new ResponseEntity<Optional<Movie>>(movieService.singleMovie(imdbId), HttpStatus.OK);
    }
}
