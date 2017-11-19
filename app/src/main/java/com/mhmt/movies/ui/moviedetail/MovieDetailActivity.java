package com.mhmt.movies.ui.moviedetail;

import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;

import com.mhmt.movies.BR;
import com.mhmt.movies.Constant;
import com.mhmt.movies.R;
import com.mhmt.movies.databinding.ActivityMovieDetailBinding;
import com.mhmt.movies.domain.Movie;
import com.mhmt.movies.ui.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieDetailActivity extends BaseActivity {

  private ActivityMovieDetailBinding binding;

  @BindView(R.id.image_view_poster)
  protected ImageView imageView;

  MovieDetailViewModel movieDetailViewModel;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = DataBindingUtil.setContentView(this, R.layout.activity_movie_detail);
    ButterKnife.bind(this);

    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    getSupportActionBar().setDisplayShowHomeEnabled(true);

    movieDetailViewModel = new MovieDetailViewModel(getIntent().getStringExtra(Constant.Navigation.IMDB_ID));
    binding.setVariable(BR.viewModel, movieDetailViewModel);
    movieDetailViewModel.loadMovie();
  }

  @Override protected void onResume() {
    super.onResume();
  }

  @Override public boolean onOptionsItemSelected(final MenuItem item) {
    switch (item.getItemId()) {
      case android.R.id.home:
        onBackPressed();
        return true;
    }
    return super.onOptionsItemSelected(item);
  }

  @Override protected void onPause() {
    super.onPause();
  }

  @Override protected void onDestroy() {
    super.onDestroy();
  }

//  public void showPoster(final Bitmap posterBitmap) {
//    imageView.setImageBitmap(posterBitmap);
//  }
}
