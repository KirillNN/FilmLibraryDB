package com.hfad.filmlibrarydb;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;


public class MainActivity extends BaseActivity {

  private static final String TAG = "MainActivity";
  protected static ArrayList<Item> genres = new ArrayList<>();

  protected String listString01;
  protected String listString02;

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
  }

  @Override
  protected void onStop() {
    super.onStop();
    db.close();
  }

  protected void fillingGenreList() {
    Cursor cursor = db.query("GENRE",
        new String[]{"NAME", "DESCRIPTION"},
        null, null, null, null, null);

    if (cursor.moveToFirst()) {
      listString01 = cursor.getString(0);
      listString02 = cursor.getString(1);
      genres.add(new Item(listString01, listString02));
    }
    while (cursor.moveToNext()) {
      listString01 = cursor.getString(0);
      listString02 = cursor.getString(1);
      genres.add(new Item(listString01, listString02));
    }
    cursor.close();
  }
}
