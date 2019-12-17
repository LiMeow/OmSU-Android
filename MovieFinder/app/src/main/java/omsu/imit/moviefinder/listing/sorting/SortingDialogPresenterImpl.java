package omsu.imit.moviefinder.listing.sorting;

class SortingDialogPresenterImpl implements SortingDialogPresenter {
    private SortingDialogView view;
    private SortingDialogInteractor sortingDialogInteractor;

    SortingDialogPresenterImpl(SortingDialogInteractor interactor) {
        sortingDialogInteractor = interactor;
    }

    @Override
    public void setView(SortingDialogView view) {
        this.view = view;
    }

    @Override
    public void destroy() {
        view = null;
    }

    @Override
    public void setLastSavedOption() {
        if (isViewAttached()) {
            int selectedOption = sortingDialogInteractor.getSelectedSortingOption();

            if (selectedOption == SortType.POPULAR.getValue()) {
                view.setPopularChecked();
            } else if (selectedOption == SortType.TOP_RATED.getValue()) {
                view.setTopRatedChecked();
            } else if (selectedOption == SortType.LATEST.getValue()) {
                view.setLatestChecked();
            } else {
                view.setFavoritesChecked();
            }
        }
    }

    private boolean isViewAttached() {
        return view != null;
    }

    @Override
    public void onPopularMoviesSelected() {
        if (isViewAttached()) {
            sortingDialogInteractor.setSortingOption(SortType.POPULAR);
            view.dismissDialog();
        }
    }

    @Override
    public void onTopRatedMoviesSelected() {
        if (isViewAttached()) {
            sortingDialogInteractor.setSortingOption(SortType.TOP_RATED);
            view.dismissDialog();
        }
    }

    @Override
    public void onLatestMoviesSelected() {
        if (isViewAttached()) {
            sortingDialogInteractor.setSortingOption(SortType.LATEST);
            view.dismissDialog();
        }
    }

    @Override
    public void onFavoritesSelected() {
        if (isViewAttached()) {
            sortingDialogInteractor.setSortingOption(SortType.FAVORITES);
            view.dismissDialog();
        }
    }
}
