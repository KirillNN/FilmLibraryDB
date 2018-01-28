package com.hfad.filmlibrarydb;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class FilmLibraryDatabaseHelper extends SQLiteOpenHelper {

  private static final String DB_NAME = "film_library";
  private static final int DB_VERSION = 2;
  private Context contextDB;

  public FilmLibraryDatabaseHelper(Context context) {
    super(context, DB_NAME, null, DB_VERSION);
    contextDB = context;
  }

  @Override
  public void onCreate(SQLiteDatabase db) {
    createMyDatabase(db, 0, DB_VERSION);
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    updateMyDatabase(db, oldVersion, newVersion);
  }

  @Override
  public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    updateMyDatabase(db, oldVersion, newVersion);
  }

  private void createMyDatabase(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("CREATE TABLE GENRE ("
        + "_ID INTEGER PRIMARY KEY AUTOINCREMENT, "
        + "NAME TEXT, "
        + "DESCRIPTION TEXT);");

    createGenreTable(db);
  }

  private void createGenreTable(SQLiteDatabase db) {
    insertGenre(db, contextDB.getString(R.string.action),
        contextDB.getString(R.string.action_desc));

    insertGenre(db, contextDB.getString(R.string.adventure),
        contextDB.getString(R.string.adventure_desc));

    insertGenre(db, contextDB.getString(R.string.children),
        contextDB.getString(R.string.children_desc));

    insertGenre(db, contextDB.getString(R.string.comedy),
        contextDB.getString(R.string.comedy_desc));

    insertGenre(db, contextDB.getString(R.string.detective),
        contextDB.getString(R.string.detective_desc));

    insertGenre(db, contextDB.getString(R.string.doc),
        contextDB.getString(R.string.doc_desc));

    insertGenre(db, contextDB.getString(R.string.drama),
        contextDB.getString(R.string.drama_desc));

    insertGenre(db, contextDB.getString(R.string.family),
        contextDB.getString(R.string.family_desc));

    insertGenre(db, contextDB.getString(R.string.fantastic),
        contextDB.getString(R.string.fantastic_desc));

    insertGenre(db, contextDB.getString(R.string.horror),
        contextDB.getString(R.string.horror_desc));

    insertGenre(db, contextDB.getString(R.string.thriller),
        contextDB.getString(R.string.thriller_desc));

    insertGenre(db, contextDB.getString(R.string.western),
        contextDB.getString(R.string.western_desc));
  }

  private static void insertGenre(SQLiteDatabase db, String name, String description) {
    ContentValues genreValues = new ContentValues();
    genreValues.put("NAME", name);
    genreValues.put("DESCRIPTION", description);
    db.insert("GENRE", null, genreValues);
  }

  private void updateMyDatabase(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE GENRE");
    createMyDatabase(db, oldVersion, newVersion);
  }

}
