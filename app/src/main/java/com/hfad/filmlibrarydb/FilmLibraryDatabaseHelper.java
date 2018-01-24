package com.hfad.filmlibrarydb;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class FilmLibraryDatabaseHelper extends SQLiteOpenHelper {

  private static final String DB_NAME = "film_library";
  private static final int DB_VERSION = 1;
  private Context context;

  public FilmLibraryDatabaseHelper(Context context) {
    super(context, DB_NAME, null, DB_VERSION);
  }

  @Override
  public void onCreate(SQLiteDatabase db) {

  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

  }

  @Override
  public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    super.onDowngrade(db, oldVersion, newVersion);
  }

  private void createMyDatabase(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("CREATE TABLE GENRE ("
        + "_ID INTEGER PRIMARY KEY AUTOINCREMENT, "
        + "NAME TEXT, "
        + "DESCRIPTION TEXT);");
  }

  private static void insertGenre(SQLiteDatabase db, String name, String description) {
    ContentValues genreValues = new ContentValues();
    genreValues.put("NAME", name);
    genreValues.put("DESCRIPTION", description);
    db.insert("GENRE", null, genreValues);
  }

}
