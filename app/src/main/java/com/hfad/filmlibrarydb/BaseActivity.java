package com.hfad.filmlibrarydb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.widget.Toast;

public class BaseActivity extends AppCompatActivity {

  protected SQLiteOpenHelper filmsDB;
  protected SQLiteDatabase db;
  protected boolean isConnectedRead;

  protected void toastCenterLong(String message) {
    Toast toastCenter = Toast.makeText(this, message, Toast.LENGTH_LONG);
    toastCenter.setGravity(Gravity.CENTER, 0, 0);
    toastCenter.show();
  }

  protected void toastCenterShort(String message) {
    Toast toastCenter = Toast.makeText(this, message, Toast.LENGTH_SHORT);
    toastCenter.setGravity(Gravity.CENTER, 0, 0);
    toastCenter.show();
  }

  protected void connectDBRead(Context context) {
    try {
      filmsDB = new FilmLibraryDatabaseHelper(context);
      db = filmsDB.getReadableDatabase();
      isConnectedRead = true;
    } catch (SQLiteException e) {
      toastCenterLong(getString(R.string.db_error));
      isConnectedRead = false;
    }
  }

}
