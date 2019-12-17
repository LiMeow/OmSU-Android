package omsu.imit.moviefinder.details;

import java.util.List;

import omsu.imit.moviefinder.Movie;
import omsu.imit.moviefinder.Video;


interface MovieDetailsView {
    void showDetails(Movie movie);

    void showTrailers(List<Video> trailers);

    void showFavorited();

    void showUnFavorited();
}
