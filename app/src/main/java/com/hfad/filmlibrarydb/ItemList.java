package com.hfad.filmlibrarydb;


import android.content.Context;
import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;

public class ItemList extends BaseActivity{

  protected String listString01;
  protected String listString02;
  private static ItemList ourInstance = null;
  private List<Item> items;
  private Context context;
  
  public static ItemList getInstance(Context context) {
    if (ourInstance == null) {
      return ourInstance = new ItemList(context);
    } else {
      return ourInstance;
    }
  }

  public List<Item> getItems() {
    return items;
  }
  
  private ItemList(Context context) {
    this.context = context;
    initItemList();
  }

  private void initItemList() {
    items = new ArrayList<>();
//    connectDBRead();
    if (isConnectedRead) {
      fillingItemList();
    } else {
      connectDBRead();
      fillingItemList();
    }
  }

  private void fillingItemList() {
    Cursor cursor = db.query("GENRE",
        new String[]{"NAME", "DESCRIPTION"},
        null, null, null, null, null);

    if (cursor.moveToFirst()) {
      listString01 = cursor.getString(0);
      listString02 = cursor.getString(1);
      items.add(new Item(listString01, listString02));
    }
    while (cursor.moveToNext()) {
      listString01 = cursor.getString(0);
      listString02 = cursor.getString(1);
      items.add(new Item(listString01, listString02));
    }
    cursor.close();
    db.close();
  }

  private void addItem(Item item) {
    items.add(item);
  }
}
