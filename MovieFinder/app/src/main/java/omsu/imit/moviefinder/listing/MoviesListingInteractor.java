package omsu.imit.moviefinder.listing;

import java.util.List;

import io.reactivex.Observable;
import omsu.imit.moviefinder.Movie;

public interface MoviesListingInteractor {
    boolean isPaginationSupported();

    Observable<List<Movie>> fetchMovies(int page);

    Observable<List<Movie>> searchMovie(String searchQuery);
}
