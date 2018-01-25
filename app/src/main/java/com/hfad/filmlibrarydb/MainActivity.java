package com.hfad.filmlibrarydb;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;


public class MainActivity extends BaseActivity {

  private static final String TAG = "MainActivity";
//  static ArrayList genres = new ArrayList();
  static ArrayList<Item> genres = new ArrayList<>();
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
    Log.d(TAG, "onStart");
    connectDBRead();
    if (isConnectedRead) {
      fillingGenreList();
    }
    genres.size();
    db.close();
  }
  protected void fillingGenreList() {
    Cursor cursor = db.query("GENRE",
        new String[]{"NAME", "DESCRIPTION"},
        null, null, null, null, null);

    if (cursor.moveToFirst()) {
      genreString01 = cursor.getString(0);
      genreString02 = cursor.getString(1);
//        genres.add(genreString01);
      genres.add(new Item(genreString01, genreString02));

//        genre.add((cursor.getString(0)),(cursor.getString(1));
    }
    while (cursor.moveToNext()) {
      genreString01 = cursor.getString(0);
      genreString02 = cursor.getString(1);
//        genres.add(genreString01);
      genres.add(new Item(genreString01, genreString02));
    }
    cursor.close();
  }
}
