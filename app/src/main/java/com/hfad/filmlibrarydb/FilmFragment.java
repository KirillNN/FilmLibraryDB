package com.hfad.filmlibrarydb;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

public class FilmFragment extends Fragment {

  private RecyclerView recyclerView;
  private List<Film> films;
  private FilmAdapter filmAdapter;

  public FilmFragment() {
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View root = inflater.inflate(R.layout.fragment_film, container, false);
    films = FilmList.getInstance(getContext()).getFilms();
    filmAdapter = new FilmAdapter(getContext(), films);
    recyclerView = root.findViewById(R.id.filmListRW);

    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());

    recyclerView.setLayoutManager(linearLayoutManager);
    recyclerView.setAdapter(filmAdapter);
    return root;
  }

  private class FilmAdapter extends RecyclerView.Adapter<FilmViewHolder> {

    private Context context;
    private List<Film> films;

    public FilmAdapter(Context context, List<Film> films) {
      this.context = context;
      this.films = films;
    }

    @Override
    public FilmViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      View itemView = LayoutInflater.from(context).inflate(R.layout.film_item,
          parent, false);
      return new FilmViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(FilmViewHolder holder, int position) {
      holder.filmsNameView.setText(films.get(position).getName());
      holder.filmsDescView.setText(films.get(position).getDescription());
      holder.cardViewFilms.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View v) {

        }
      });
    }

    @Override
    public int getItemCount() {
      return films.size();
    }
  }

  private class FilmViewHolder extends RecyclerView.ViewHolder {

    private CardView cardViewFilms;
    private TextView filmsNameView;
    private TextView filmsDescView;

    public FilmViewHolder(View itemView) {
      super(itemView);
      cardViewFilms = itemView.findViewById(R.id.filmCardView);
      filmsNameView = itemView.findViewById(R.id.filmNameView);
      filmsDescView = itemView.findViewById(R.id.filmDescView);
    }
  }

}
