package omsu.imit.moviefinder.details;

import omsu.imit.moviefinder.Movie;

public interface MovieDetailsPresenter {
    void showDetails(Movie movie);

    void showTrailers(Movie movie);

    void showFavoriteButton(Movie movie);

    void onFavoriteClick(Movie movie);

    void setView(MovieDetailsView view);

    void destroy();
}
