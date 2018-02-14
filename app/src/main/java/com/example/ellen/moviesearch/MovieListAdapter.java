/*
 * Copyright(C) 2015 Verizon. All rights reserved.
 */
package com.example.ellen.moviesearch;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.ViewHolder> {

    private List<MovieData> mMoviesList;

    public void setDataList(List<MovieData> movieDataList) {
        if (movieDataList != null && !movieDataList.isEmpty()) {
            mMoviesList = movieDataList;
            notifyDataSetChanged();
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view;
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.movie_list_item,
                viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.update(mMoviesList.get(position));
    }

    @Override
    public int getItemCount() {
        return (mMoviesList != null) ? mMoviesList.size() : 0;
    }

    private void getImage(MovieData movieData, ImageView imageView) {
            GetImageRequest request;
            String poster = movieData.getPoster();
            if (!(URLUtil.isHttpUrl(poster) || URLUtil.isHttpsUrl(poster))) {
                return;
            }
            request = new GetImageRequest(imageView, poster);

            RequestQueue queue = RequestQueue.getInstance(imageView.getContext());
            request.addToQueue(queue);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView mImageView;
        private final TextView mNameTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.movie_picture);
            mNameTextView = itemView.findViewById(R.id.movie_title);
        }

        void update(MovieData movieData) {
            getImage(movieData, mImageView);
            mNameTextView.setText(movieData.getTitle());
        }
    }
}
