package omsu.imit.moviefinder.details;;

import dagger.Module;
import dagger.Provides;
import omsu.imit.moviefinder.favorites.FavoritesInteractor;
import omsu.imit.moviefinder.network.TmdbWebService;


@Module
public class DetailsModule {
    @Provides
    @DetailsScope
    MovieDetailsInteractor provideInteractor(TmdbWebService tmdbWebService) {
        return new MovieDetailsInteractorImpl(tmdbWebService);
    }

    @Provides
    @DetailsScope
    MovieDetailsPresenter providePresenter(MovieDetailsInteractor detailsInteractor,
                                           FavoritesInteractor favoritesInteractor) {
        return new MovieDetailsPresenterImpl(detailsInteractor, favoritesInteractor);
    }
}
