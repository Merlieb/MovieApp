package com.example.movieapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.movieapp.models.Movie;

import java.util.ArrayList;
import static com.example.movieapp.R.layout.item_movie;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    //list of movies
    ArrayList<Movie> movies;
    ViewGroup parent;
    ViewHolder holder;
    int position;


    public MovieAdapter(ArrayList<Movie> movies) {
        this.movies = movies;

    }
    //create inflates a new view
    @Override
    public ViewHolder onCreateViewHolder ( ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View movieView = inflater.inflate(item_movie, parent, false);
        return new ViewHolder(movieView);
    }
    //binds an inflated view to a new item
    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {
        Movie movie = movies.get(position);
        holder.tvTitle.setText(movie.getTitle());
        holder.tvOverview.setText(movie.getOverview());
    }
    //returns the total number of item in the list
    @Override
    public int getItemCount() {
        return movies.size() ;
    }

    // create the view holder as a static inner class
    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivPosterImage;
        TextView tvTitle;
        TextView tvOverview;

        public ViewHolder(View itemView) {
            super(itemView);
            ivPosterImage =(ImageView) itemView.findViewById(R.id.ivPosterImage);
            tvOverview  =  (TextView) itemView.findViewById(R.id.tvOverview);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
        }
    }
}
