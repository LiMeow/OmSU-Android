package omsu.imit.moviefinder.listing.sorting;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import omsu.imit.moviefinder.BaseApplication;
import omsu.imit.moviefinder.R;
import omsu.imit.moviefinder.listing.MoviesListingPresenter;

public class SortingDialogFragment extends DialogFragment implements SortingDialogView, RadioGroup.OnCheckedChangeListener {
    @Inject
    SortingDialogPresenter sortingDialogPresenter;

    @BindView(R.id.popular)
    RadioButton popular;
    @BindView(R.id.top_rated)
    RadioButton topRated;
    @BindView(R.id.favorites)
    RadioButton favorites;
    @BindView(R.id.latest)
    RadioButton latest;
    @BindView(R.id.sorting_group)
    RadioGroup sortingOptionsGroup;

    private static MoviesListingPresenter moviesListingPresenter;
    private Unbinder unbinder;

    public static SortingDialogFragment newInstance(MoviesListingPresenter moviesListingPresenter) {
        SortingDialogFragment.moviesListingPresenter = moviesListingPresenter;
        return new SortingDialogFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        ((BaseApplication) getActivity().getApplication()).getListingComponent().inject(this);
        sortingDialogPresenter.setView(this);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View dialogView = inflater.inflate(R.layout.sorting_options, null);
        unbinder = ButterKnife.bind(this, dialogView);
        initViews();

        Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(dialogView);
        dialog.setTitle(R.string.sort_by);
        dialog.show();
        return dialog;
    }

    private void initViews() {
        sortingDialogPresenter.setLastSavedOption();
        sortingOptionsGroup.setOnCheckedChangeListener(this);
    }

    @Override
    public void setPopularChecked() {
        popular.setChecked(true);
    }


    @Override
    public void setLatestChecked() {
        latest.setChecked(true);
    }

    @Override
    public void setTopRatedChecked() {
        topRated.setChecked(true);
    }

    @Override
    public void setFavoritesChecked() {
        favorites.setChecked(true);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
        switch (checkedId) {
            case R.id.popular:
                sortingDialogPresenter.onPopularMoviesSelected();
                moviesListingPresenter.firstPage();
                break;

            case R.id.top_rated:
                sortingDialogPresenter.onTopRatedMoviesSelected();
                moviesListingPresenter.firstPage();
                break;

            case R.id.favorites:
                sortingDialogPresenter.onFavoritesSelected();
                moviesListingPresenter.firstPage();
                break;
            case R.id.latest:
                sortingDialogPresenter.onLatestMoviesSelected();
                moviesListingPresenter.firstPage();
                break;
        }
    }

    @Override
    public void dismissDialog() {
        dismiss();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        sortingDialogPresenter.destroy();
        unbinder.unbind();
    }
}
