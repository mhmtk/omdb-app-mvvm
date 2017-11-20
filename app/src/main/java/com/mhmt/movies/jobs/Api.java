package com.mhmt.movies.jobs;

import com.mhmt.movies.domain.DownloadPosterData;
import com.mhmt.movies.domain.Movie;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface Api {

  @GET(".") Single<Movie> getMovie(@Query("i") String movieId, @Query("apiKey") String apiKey);

}
