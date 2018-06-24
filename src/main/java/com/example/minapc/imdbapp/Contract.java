package com.example.minapc.imdbapp;


import com.example.minapc.imdbapp.PojoModel.Data;
import com.example.minapc.imdbapp.PojoModel.Movie;

import java.util.List;

public interface Contract {

    interface View{
        void showSuccessData(List<Data.Movie> data) ;
        void onFailure(String msg);
        void onDataLoading() ;
        void onDataLoadingFinished() ;

        void showFilmsData(Movie films) ;
    }
    interface Presenter{
        void attachView(View v)  ;
        // void searchByWord(String token) ;
        void receivedDataSuccess(List<Data.Movie> data) ;
        void onFailure(String msg);
        void onSelectFilms(Movie films) ;
    }
    interface Model{
        void attachPresenter(Presenter presenter) ;
       void search() ;
    }
}
