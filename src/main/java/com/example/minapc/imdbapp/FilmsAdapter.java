package com.example.minapc.imdbapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.minapc.imdbapp.PojoModel.Data;
import com.example.minapc.imdbapp.PojoModel.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by MinaPC on 6/23/2018.
 */

public class FilmsAdapter extends RecyclerView.Adapter<FilmsAdapter.Holder> {
    Context mContext;
    List<Data.Movie> movies;


    public FilmsAdapter(Context mContext,   List<Data.Movie>  movies) {
        this.mContext = mContext;
        this.movies = movies;
    }



    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.movie_item, parent, false);
        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {

        holder.title.setText(movies.get(position).getTitle());
        holder.year.setText(movies.get(position).getYear());
       Picasso.with(mContext).load(movies.get(position).getUrlPoster()).into( holder.poster);

    }

    @Override
    public int getItemCount() {
 return movies.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView title, year;
        ImageView poster;

        public Holder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            year = itemView.findViewById(R.id.year);

        title.setOnClickListener(new View.OnClickListener() {
               @Override
                public void onClick(View view) {
                    onItemClick.onItemClick(movies.get(getAdapterPosition()  ));
                   Intent intent = new Intent(mContext, MovieDetail.class);

                   intent.putExtra("TITLE",movies.get(getAdapterPosition()).getTitle());
                  mContext.startActivity(intent);
                }
        });
   }
    }
    public void setOnItemClick(FilmsAdapter.onItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

    onItemClick onItemClick ;
    public interface onItemClick{
        void onItemClick(Movie movie) ;
    }
}

