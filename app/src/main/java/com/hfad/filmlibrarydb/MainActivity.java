package com.hfad.filmlibrarydb;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;


public class MainActivity extends BaseActivity {

  private static final String TAG = "MainActivity";
  Genre[] genres;
  String genreString01;
  String genreString02;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Log.d(TAG, "onCreate");
  }

  @Override
  protected void onStart() {
    super.onStart();
    connectDBRead();
    if (isConnectedRead) {
      Cursor cursor = db.query("GENRE",
          new String[]{"NAME", "DESCRIPTION"},
          null, null, null, null, null);
      if (cursor.moveToFirst()) {
        genreString01 = cursor.getString(0);
        genreString02 = cursor.getString(1);
        new Genre(genreString01, genreString01);
//        genre.add((cursor.getString(0)),(cursor.getString(1));
      }
      while (cursor.moveToNext()) {
        genreString01 = cursor.getString(0);
        genreString02 = cursor.getString(1);
        new Genre(genreString01, genreString01);
      }
      cursor.close();
    }
    db.close();
  }
}
