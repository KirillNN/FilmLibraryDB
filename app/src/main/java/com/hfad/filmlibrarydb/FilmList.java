package com.hfad.filmlibrarydb;

import android.content.Context;
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

}
