package omsu.imit.moviefinder;

import android.app.Application;
import android.os.StrictMode;

import io.realm.Realm;
import omsu.imit.moviefinder.details.DetailsComponent;
import omsu.imit.moviefinder.details.DetailsModule;
import omsu.imit.moviefinder.favorites.FavoritesModule;
import omsu.imit.moviefinder.listing.ListingComponent;
import omsu.imit.moviefinder.listing.ListingModule;
import omsu.imit.moviefinder.network.NetworkModule;

public class BaseApplication extends Application {
    private AppComponent appComponent;
    private DetailsComponent detailsComponent;
    private ListingComponent listingComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        StrictMode.enableDefaults();
        initRealm();
        appComponent = createAppComponent();
    }

    private AppComponent createAppComponent() {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule())
                .favoritesModule(new FavoritesModule())
                .build();
    }

    private void initRealm() {
        Realm.init(this);
    }

    public DetailsComponent createDetailsComponent() {
        detailsComponent = appComponent.plus(new DetailsModule());
        return detailsComponent;
    }

    public void releaseDetailsComponent() {
        detailsComponent = null;
    }

    public ListingComponent createListingComponent() {
        listingComponent = appComponent.plus(new ListingModule());
        return listingComponent;
    }

    public void releaseListingComponent() {
        listingComponent = null;
    }

    public ListingComponent getListingComponent() {
        return listingComponent;
    }
}
