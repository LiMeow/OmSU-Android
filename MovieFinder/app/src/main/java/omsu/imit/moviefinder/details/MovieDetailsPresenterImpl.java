package omsu.imit.moviefinder.details;


import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import omsu.imit.moviefinder.Movie;
import omsu.imit.moviefinder.Video;
import omsu.imit.moviefinder.favorites.FavoritesInteractor;
import omsu.imit.moviefinder.util.RxUtils;

class MovieDetailsPresenterImpl implements MovieDetailsPresenter {
    private MovieDetailsView view;
    private MovieDetailsInteractor movieDetailsInteractor;
    private FavoritesInteractor favoritesInteractor;
    private Disposable trailersSubscription;

    MovieDetailsPresenterImpl(MovieDetailsInteractor movieDetailsInteractor, FavoritesInteractor favoritesInteractor) {
        this.movieDetailsInteractor = movieDetailsInteractor;
        this.favoritesInteractor = favoritesInteractor;
    }

    @Override
    public void setView(MovieDetailsView view) {
        this.view = view;
    }

    @Override
    public void destroy() {
        view = null;
        RxUtils.unsubscribe(trailersSubscription);
    }

    @Override
    public void showDetails(Movie movie) {
        if (isViewAttached()) {
            view.showDetails(movie);
        }
    }

    private boolean isViewAttached() {
        return view != null;
    }

    @Override
    public void showTrailers(Movie movie) {
        trailersSubscription = movieDetailsInteractor.getTrailers(movie.getId())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onGetTrailersSuccess, t -> onGetTrailersFailure());
    }

    private void onGetTrailersSuccess(List<Video> videos) {
        if (isViewAttached()) {
            view.showTrailers(videos);
        }
    }

    private void onGetTrailersFailure() { }


    @Override
    public void showFavoriteButton(Movie movie) {
        boolean isFavorite = favoritesInteractor.isFavorite(movie.getId());
        if (isViewAttached()) {
            if (isFavorite) {
                view.showFavorited();
            } else {
                view.showUnFavorited();
            }
        }
    }

    @Override
    public void onFavoriteClick(Movie movie) {
        if (isViewAttached()) {
            boolean isFavorite = favoritesInteractor.isFavorite(movie.getId());
            if (isFavorite) {
                favoritesInteractor.unFavorite(movie.getId());
                view.showUnFavorited();
            } else {
                favoritesInteractor.setFavorite(movie);
                view.showFavorited();
            }
        }
    }
}
