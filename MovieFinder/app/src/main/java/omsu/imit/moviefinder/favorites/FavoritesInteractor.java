package omsu.imit.moviefinder.favorites;

import java.util.List;

import omsu.imit.moviefinder.Movie;

public interface FavoritesInteractor {
    void setFavorite(Movie movie);

    boolean isFavorite(String id);

    List<Movie> getFavorites();

    void unFavorite(String id);
}
