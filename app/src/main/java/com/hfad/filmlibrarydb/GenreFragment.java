package com.hfad.filmlibrarydb;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class GenreFragment extends Fragment {

  public GenreFragment() {
  }

  @Override
  public void onStart() {
    super.onStart();

  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.genre_fragment, container, false);
  }

  private class GenreAdapter extends RecyclerView.Adapter<GenreViewHolder> {

    @Override
    public GenreViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      return null;
    }

    @Override
    public void onBindViewHolder(GenreViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
      return 0;
    }
  }

  private static class GenreViewHolder extends RecyclerView.ViewHolder {

    CardView genreCardViewList;
    TextView genreViewList;
    TextView genreDescViewList;

    public GenreViewHolder(View itemView) {
      super(itemView);
      genreCardViewList = itemView.findViewById(R.id.genreCardView);
      genreViewList = itemView.findViewById(R.id.genreView);
      genreDescViewList = itemView.findViewById(R.id.genreDescView);
    }
  }

}
