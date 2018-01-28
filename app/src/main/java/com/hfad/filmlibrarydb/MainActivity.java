package com.hfad.filmlibrarydb;

import android.os.Bundle;
import android.util.Log;
import java.util.List;


public class MainActivity extends BaseActivity {

  private static final String TAG = "MainActivity";
  private List<Item> items;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    items = ItemList.getInstance(this).getItems();

    Log.d(TAG, "onCreate");
  }

}
