package omsu.imit.moviefinder.favorites;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import omsu.imit.moviefinder.AppModule;

@Module(includes = AppModule.class)
public class FavoritesModule {
    @Provides
    @Singleton
    FavoritesInteractor provideFavouritesInteractor(FavoritesStore store) {
        return new FavoritesInteractorImpl(store);
    }
}
