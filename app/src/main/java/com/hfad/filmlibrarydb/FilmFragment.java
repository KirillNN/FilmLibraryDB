package com.hfad.filmlibrarydb;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

public class FilmFragment extends Fragment {

  private RecyclerView recyclerView;
  private List<Film> films;
//  private FilmAdapter filmAdapter;

  public FilmFragment() {
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_film, container, false);
  }

}
