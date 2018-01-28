package com.hfad.filmlibrarydb;


import android.content.Context;
import java.util.ArrayList;
import java.util.List;

public class ItemList extends BaseActivity{
  private static ItemList ourInstrance = null;
  private List<Item> items;
  private Context context;
  
  public static ItemList getOurInstrance(Context context) {
    if (ourInstrance == null) {
      return ourInstrance = new ItemList(context);
    } else {
      return ourInstrance;
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
    connectDBRead();
    if (isConnectedRead) {
      fillingItemList();
    }
  }

  private void fillingItemList() {
  }

  private void addItem(Item item) {
    items.add(item);
  }
}
