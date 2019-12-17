package omsu.imit.moviefinder.details;

import java.util.List;

import io.reactivex.Observable;
import omsu.imit.moviefinder.Video;
import omsu.imit.moviefinder.VideoWrapper;
import omsu.imit.moviefinder.network.TmdbWebService;

class MovieDetailsInteractorImpl implements MovieDetailsInteractor {

    private TmdbWebService tmdbWebService;

    MovieDetailsInteractorImpl(TmdbWebService tmdbWebService) {
        this.tmdbWebService = tmdbWebService;
    }

    @Override
    public Observable<List<Video>> getTrailers(final String id) {
        return tmdbWebService.trailers(id).map(VideoWrapper::getVideos);
    }

}
