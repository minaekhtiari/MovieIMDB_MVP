package com.example.minapc.imdbapp;

import android.util.Log;

import com.example.minapc.imdbapp.PojoModel.BestMovies;
import com.example.minapc.imdbapp.Retrofit.API;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by MinaPC on 6/23/2018.
 */

public class Model implements Contract.Model {
    private Contract.Presenter presenter;
    public static BestMovies movielist;

    @Override
    public void attachPresenter(Contract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void search() {
      String  token = "b59333a1-84b2-468e-93c2-37c75b57e0ef";
//        API.getClient().create(BestFilmsInterface.class).getFilms(token, "json")
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<Data>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(Data data) {
//                        presenter.receivedDataSuccess(data);
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        presenter.onFailure(e.toString());
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
//
//
//        Log.d("w_y", token);


                API.getClient().create(BestFilmsInterface.class).getFilms(token , "json")
                .enqueue(new Callback<BestMovies>() {
                    @Override
                    public void onResponse(Call<BestMovies> call, Response<BestMovies> response) {
                        if (response.isSuccessful()) {

                     movielist=response.body();


                   //  movielist.getMovies().size();
                            //       Log.d("w_y", "onResponse: " + response.body().getMovies().size());
                            // Log.d("w_y", "onResponse: " + response.body().getMovies().get(2).getTitle());
                          presenter.receivedDataSuccess( movielist.getData().getMovies());
                        }
                    }

                    @Override
                    public void onFailure(Call<BestMovies> call, Throwable t) {
                        Log.d("w_y", "onFailure: " + t);
                        presenter.onFailure(t.toString());
                    }
                });
   }
}
