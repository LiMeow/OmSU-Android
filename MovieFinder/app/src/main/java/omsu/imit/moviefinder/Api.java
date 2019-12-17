package omsu.imit.moviefinder;

public class Api {
    private static final String BASE_POSTER_PATH = "https://image.tmdb.org/t/p/w342";
    private static final String BASE_BACKDROP_PATH = "https://image.tmdb.org/t/p/w780";
    static final String YOUTUBE_VIDEO_URL = "https://www.youtube.com/watch?v=%1$s";
    static final String YOUTUBE_THUMBNAIL_URL = "https://img.youtube.com/vi/%1$s/0.jpg";

    private Api() { }

    public static String getPosterPath(String posterPath) {
        return BASE_POSTER_PATH + posterPath;
    }

    public static String getBackdropPath(String backdropPath) {
        return BASE_BACKDROP_PATH + backdropPath;
    }
}
