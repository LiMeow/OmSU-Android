package omsu.imit.moviefinder.listing.sorting;

public enum SortType {
    POPULAR(0), TOP_RATED(1), LATEST(2), FAVORITES(3);

    private final int value;

    SortType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
