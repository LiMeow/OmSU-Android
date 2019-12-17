package omsu.imit.moviefinder.favorites;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import omsu.imit.moviefinder.Movie;


public class MovieRealmObject extends RealmObject {

    @PrimaryKey
    private String id;
    private String overview;
    private String releaseDate;
    private String posterPath;
    private String backdropPath;
    private String title;
    private double voteAverage;

    public MovieRealmObject() { }

    public MovieRealmObject(Movie movie) {
        id = movie.getId();
        overview = movie.getOverview();
        releaseDate = movie.getReleaseDate();
        posterPath = movie.getPosterPath();
        backdropPath = movie.getBackdropPath();
        title = movie.getTitle();
        voteAverage = movie.getVoteAverage();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOverview() {
        return overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public String getTitle() {
        return title;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

}
