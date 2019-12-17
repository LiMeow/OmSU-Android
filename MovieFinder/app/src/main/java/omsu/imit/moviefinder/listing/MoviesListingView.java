package omsu.imit.moviefinder.listing;


import java.util.List;

import omsu.imit.moviefinder.Movie;

interface MoviesListingView {
    void showMovies(List<Movie> movies);

    void loadingStarted();

    void loadingFailed(String errorMessage);

    void onMovieClicked(Movie movie);
}
