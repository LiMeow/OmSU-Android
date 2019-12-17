package omsu.imit.moviefinder;

import javax.inject.Singleton;

import dagger.Component;
import omsu.imit.moviefinder.details.DetailsComponent;
import omsu.imit.moviefinder.details.DetailsModule;
import omsu.imit.moviefinder.favorites.FavoritesModule;
import omsu.imit.moviefinder.listing.ListingComponent;
import omsu.imit.moviefinder.listing.ListingModule;
import omsu.imit.moviefinder.network.NetworkModule;

@Singleton
@Component(modules = {
        AppModule.class,
        NetworkModule.class,
        FavoritesModule.class})
public interface AppComponent {
    DetailsComponent plus(DetailsModule detailsModule);

    ListingComponent plus(ListingModule listingModule);
}
