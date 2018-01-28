package com.hfad.filmlibrarydb;

import android.os.Bundle;
import android.util.Log;



public class MainActivity extends BaseActivity {

  private static final String TAG = "MainActivity";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Log.d(TAG, "onCreate");
  }

}
