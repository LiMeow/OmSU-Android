package omsu.imit.moviefinder;

import com.squareup.moshi.Json;

import java.util.List;

public class MoviesWraper {

    @Json(name = "results")
    private List<Movie> movies;

    public List<Movie> getMovieList() {
        return movies;
    }

}
