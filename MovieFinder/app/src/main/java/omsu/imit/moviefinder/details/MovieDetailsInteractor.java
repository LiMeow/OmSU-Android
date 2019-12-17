package omsu.imit.moviefinder.details;


import java.util.List;

import io.reactivex.Observable;
import omsu.imit.moviefinder.Video;

public interface MovieDetailsInteractor {
    Observable<List<Video>> getTrailers(String id);
}
