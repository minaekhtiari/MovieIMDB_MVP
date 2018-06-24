package com.example.minapc.imdbapp;

import com.example.minapc.imdbapp.PojoModel.Data;
import com.example.minapc.imdbapp.PojoModel.Movie;

import java.util.List;

/**
 * Created by MinaPC on 6/23/2018.
 */

public class Presenter implements Contract.Presenter {
    private Contract.View view;
    Model model = new Model() ;

    @Override
    public void attachView(Contract.View view) {
        this.view = view;
        model.attachPresenter(this);
        model.search();
        view.onDataLoading();
    }

//    @Override
//    public void searchByWord(String token) {
//        model.search(token);
//        view.onDataLoading();
//    }

    @Override
    public void receivedDataSuccess(List<Data.Movie> data) {
        view.showSuccessData(data);
        view.onDataLoadingFinished();
    }

    @Override
    public void onFailure(String msg) {
        view.onFailure(msg);
        view.onDataLoadingFinished();
    }

    @Override
    public void onSelectFilms(Movie films) {
        view.showFilmsData(films);
    }
}
