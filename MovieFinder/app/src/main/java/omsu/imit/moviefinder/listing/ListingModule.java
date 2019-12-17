package omsu.imit.moviefinder.listing;


import dagger.Module;
import dagger.Provides;
import omsu.imit.moviefinder.favorites.FavoritesInteractor;
import omsu.imit.moviefinder.listing.sorting.SortingOptionStore;
import omsu.imit.moviefinder.network.TmdbWebService;

@Module
public class ListingModule {
    @Provides
    MoviesListingInteractor provideMovieListingInteractor(FavoritesInteractor favoritesInteractor,
                                                          TmdbWebService tmdbWebService,
                                                          SortingOptionStore sortingOptionStore) {
        return new MoviesListingInteractorImpl(favoritesInteractor, tmdbWebService, sortingOptionStore);
    }

    @Provides
    MoviesListingPresenter provideMovieListingPresenter(MoviesListingInteractor interactor) {
        return new MoviesListingPresenterImpl(interactor);
    }
}
