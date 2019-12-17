package omsu.imit.moviefinder.listing.sorting;

public interface SortingDialogPresenter {
    void setLastSavedOption();

    void onPopularMoviesSelected();

    void onTopRatedMoviesSelected();

    void onFavoritesSelected();

    void onLatestMoviesSelected();

    void setView(SortingDialogView view);

    void destroy();
}
