package omsu.imit.moviefinder.listing.sorting;

interface SortingDialogView {
    void setPopularChecked();

    void setLatestChecked();

    void setTopRatedChecked();

    void setFavoritesChecked();

    void dismissDialog();

}
