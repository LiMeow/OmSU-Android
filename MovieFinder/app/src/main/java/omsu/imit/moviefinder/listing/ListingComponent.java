package omsu.imit.moviefinder.listing;


import dagger.Subcomponent;
import omsu.imit.moviefinder.listing.sorting.SortingDialogFragment;
import omsu.imit.moviefinder.listing.sorting.SortingModule;


@ListingScope
@Subcomponent(modules = {ListingModule.class, SortingModule.class})
public interface ListingComponent {
    MoviesListingFragment inject(MoviesListingFragment fragment);

    SortingDialogFragment inject(SortingDialogFragment fragment);
}
