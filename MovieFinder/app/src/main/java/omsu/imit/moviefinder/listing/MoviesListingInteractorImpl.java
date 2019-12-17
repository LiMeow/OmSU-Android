package omsu.imit.moviefinder.listing;

import androidx.annotation.NonNull;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import io.reactivex.Observable;
import omsu.imit.moviefinder.Movie;
import omsu.imit.moviefinder.MoviesWraper;
import omsu.imit.moviefinder.favorites.FavoritesInteractor;
import omsu.imit.moviefinder.listing.sorting.SortType;
import omsu.imit.moviefinder.listing.sorting.SortingOptionStore;
import omsu.imit.moviefinder.network.TmdbWebService;

class MoviesListingInteractorImpl implements MoviesListingInteractor {
    private FavoritesInteractor favoritesInteractor;
    private TmdbWebService tmdbWebService;
    private SortingOptionStore sortingOptionStore;
    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static final int LATEST_MIN_VOTE_COUNT = 50;

    MoviesListingInteractorImpl(FavoritesInteractor favoritesInteractor,
                                TmdbWebService tmdbWebService, SortingOptionStore store) {
        this.favoritesInteractor = favoritesInteractor;
        this.tmdbWebService = tmdbWebService;
        sortingOptionStore = store;
    }


    @Override
    public boolean isPaginationSupported() {
        int selectedOption = sortingOptionStore.getSelectedOption();
        return selectedOption != SortType.FAVORITES.getValue();
    }

    @Override
    public Observable<List<Movie>> fetchMovies(int page) {
        int selectedOption = sortingOptionStore.getSelectedOption();
        if (selectedOption == SortType.POPULAR.getValue()) {
            return tmdbWebService.popularMovies(page).map(MoviesWraper::getMovieList);
        } else if (selectedOption == SortType.TOP_RATED.getValue()) {
            return tmdbWebService.highestRatedMovies(page).map(MoviesWraper::getMovieList);
        } else if (selectedOption == SortType.LATEST.getValue()) {
            Calendar cal = Calendar.getInstance();
            String maxReleaseDate = dateFormat.format(cal.getTime());
            return tmdbWebService.newestMovies(maxReleaseDate, LATEST_MIN_VOTE_COUNT).map(MoviesWraper::getMovieList);
        } else {
            return Observable.just(favoritesInteractor.getFavorites());
        }
    }

    @Override
    public Observable<List<Movie>> searchMovie(@NonNull String searchQuery) {
        return tmdbWebService.searchMovies(searchQuery).map(MoviesWraper::getMovieList);
    }

}
