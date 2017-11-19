package com.mhmt.movies.ui.moviedetail;

import android.databinding.ObservableField;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.mhmt.movies.BuildConfig;
import com.mhmt.movies.domain.Movie;
import com.mhmt.movies.helper.JsonObjectMapper;
import com.mhmt.movies.jobs.Api;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class MovieDetailViewModel {

  public final ObservableField<Movie> movie = new ObservableField<>();

  private final String movieId;
  private final Api api;

  public MovieDetailViewModel(final String movieId) {
    this.movieId = movieId;

    final Retrofit retrofit = new Retrofit.Builder()
                                  .baseUrl("http://www.omdbapi.com")
                                  .addConverterFactory(JacksonConverterFactory.create(new JsonObjectMapper()))
                                  .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                                  .build();

    api = retrofit.create(Api.class);

  }

  public void loadMovie() {
    api.getMovie(movieId, BuildConfig.API_KEY)
       .subscribeOn(Schedulers.io())
       .observeOn(AndroidSchedulers.mainThread())
       .subscribe(m -> {
         movie.set(m);
         loadPoster(m.getPoster());
       }, throwable -> {
         // handle error event
       });

  }

  private void loadPoster(String posterUrl) {
    api.getPoster(posterUrl);
  }
}