package com.example.minapc.imdbapp;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.minapc.imdbapp.PojoModel.Movie;
import com.example.minapc.imdbapp.Retrofit.API;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieDetail extends AppCompatActivity {
    String TITLE;
    String  token = "b59333a1-84b2-468e-93c2-37c75b57e0ef";
    TextView title,simpleplot,urlimdb,year,rank;
    ImageView imgposter;
    public static ProgressDialog pDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        Bundle extras = getIntent().getExtras();

            TITLE = extras.getString("TITLE");
            init();
            getData();
    }

    private void init() {
        title=findViewById(R.id.title);
        simpleplot=findViewById(R.id.simpleplot);
        urlimdb=findViewById(R.id.urlimdb);
        rank=findViewById(R.id.rank);
        year=findViewById(R.id.year);
        imgposter=findViewById(R.id.movieposter);
        pDialog = new ProgressDialog(MovieDetail.this);
        pDialog.setMessage("Loading...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);

    }

    private void getData() {
        pDialog.show();
        API.getClient().create(BestFilmsInterface.class
        ).getMovieDetail(TITLE, token, "json").enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                if(response.isSuccessful()){
                   title.setText(response.body().getTitle().toString());
                    simpleplot.setText(response.body().getSimplePlot().toString());
                    urlimdb.setText(response.body().getUrlIMDB().toString());
                    rank.setText(response.body().getRanking().toString());
                    year.setText(response.body().getYear().toString());
                    Picasso.with(MovieDetail.this).load(response.body().getUrlPoster()).into(imgposter);
                }
                pDialog.dismiss();
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
                pDialog.dismiss();
            }
        });

    }
}
