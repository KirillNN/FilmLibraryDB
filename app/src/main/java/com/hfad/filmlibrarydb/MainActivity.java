package com.hfad.filmlibrarydb;

import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;

public class MainActivity extends BaseActivity {

  private static final String TAG = "MainActivity";
  ArrayList genre;

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

    }
  }
}
