package com.example.minapc.imdbapp;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.minapc.imdbapp.PojoModel.Data;
import com.example.minapc.imdbapp.PojoModel.Movie;

import java.util.List;

public class MainActivity extends BaseActivity implements Contract.View,FilmsAdapter.onItemClick {
    Contract.Presenter presenter = new Presenter();
    RecyclerView bestsList;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bind();
        presenter.attachView(this);


    }

    private void bind() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");

        GridLayoutManager lLayout = new GridLayoutManager(MainActivity.this, 2);
        bestsList=findViewById(R.id.bestslist);
        bestsList.setHasFixedSize(true);
        bestsList.setLayoutManager(lLayout);
      //  presenter.searchByWord(token);
    }

    @Override
    public void showSuccessData(List<Data.Movie> data) {

        FilmsAdapter adapter =
                new FilmsAdapter(mContext,data);
        bestsList.setAdapter(adapter);
       adapter.setOnItemClick(this);
    }

    @Override
    public void onFailure(String msg) {
        PublicMethods.showToast(mContext, msg);
    }

    @Override
    public void onDataLoading() {

progressDialog.show();
    }

    @Override
    public void onDataLoadingFinished() {
progressDialog.dismiss();
    }

    @Override
    public void showFilmsData(Movie films) {
        PublicMethods.showToast(mContext , films.getTitle()+ " " + films.getRating());
    }

    @Override
    public void onItemClick(Movie films) {
        presenter.onSelectFilms( films);
    }
}
