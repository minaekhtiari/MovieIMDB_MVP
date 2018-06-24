package com.example.minapc.imdbapp;

import com.example.minapc.imdbapp.PojoModel.BestMovies;
import com.example.minapc.imdbapp.PojoModel.Movie;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by MinaPC on 6/23/2018.
 */

public interface BestFilmsInterface {
//    @GET("top/")
//    Observable<Data> getFilms(@Query("token") String query, @Query("format") String format) ;

    @GET("top/")
    Call<BestMovies> getFilms(@Query("token") String token, @Query("format") String format) ;

    @GET("idIMDB/")
    Call<Movie> getMovieDetail(@Query("title") String title,@Query("token") String token, @Query("format") String format);
}
