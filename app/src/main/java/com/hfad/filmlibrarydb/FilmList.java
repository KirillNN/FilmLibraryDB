package com.hfad.filmlibrarydb;

import android.content.Context;
import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;

public class FilmList extends BaseActivity {

  protected String listFilmString01;
  protected String listFilmString02;
  private static FilmList ourInstance;
  private List<Film> films;
  private Context context;

  public static FilmList getInstance(Context context) {
//    this.context = context;
    if (ourInstance == null) {
      return ourInstance = new FilmList(context);
    } else {
      return ourInstance;
    }
  }

  public List<Film> getFilms() {
    return films;
  }

  private FilmList(Context context) {
    this.context = context;
    initItemList(context);
  }

  private void initItemList(Context context) {
    this.context = context;
    fillingFilmListFromDB(context);
  }

  private void fillingFilmListFromDB(Context context) {
    this.context = context;
    films = new ArrayList<>();
    connectDBRead(context);
    if (isConnectedRead) {
      Cursor cursor = db.query("GENRE",
          new String[]{"NAME", "DESCRIPTION"},
          null, null, null, null, null);

      if (cursor.moveToFirst()) {
        listFilmString01 = cursor.getString(0);
        listFilmString02 = cursor.getString(1);
        films.add(new Film(listFilmString01, listFilmString02));
      }
      while (cursor.moveToNext()) {
        listFilmString01 = cursor.getString(0);
        listFilmString02 = cursor.getString(1);
        films.add(new Film(listFilmString01, listFilmString02));
      }
      cursor.close();
    }
    db.close();
  }
  private void addFilm(Film film) {
    films.add(film);
  }
}
