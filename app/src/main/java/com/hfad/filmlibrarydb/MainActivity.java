package com.hfad.filmlibrarydb;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;


public class MainActivity extends BaseActivity {

  private static final String TAG = "MainActivity";
  private RecyclerView recyclerView;
  private List<Item> items;
  private ItemAdapter itemAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
//    connectDBRead();
    items = ItemList.getInstance(this).getItems();
    itemAdapter = new ItemAdapter(this, items);
    recyclerView = findViewById(R.id.itemListRW);

    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

    recyclerView.setLayoutManager(linearLayoutManager);
    recyclerView.setAdapter(itemAdapter);

    Log.d(TAG, "onCreate");
  }

  private class ItemAdapter extends RecyclerView.Adapter<ItemViewHolder> {

    Context context;
    List<Item> items;

    public ItemAdapter(Context context, List<Item> items) {
      this.context = context;
      this.items = items;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      View itemView = LayoutInflater.from(context).inflate(R.layout.genre_item,
          parent, false);
      return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ItemViewHolder holder, int position) {
      holder.itemNameView.setText(items.get(position).getName());
      holder.itemDescView.setText(items.get(position).getDescription());
      holder.cardView.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View v) {
          toastCenterShort(Integer.toString(holder.getAdapterPosition()));
        }
      });
    }

    @Override
    public int getItemCount() {
      return items.size();
    }
  }

  private class ItemViewHolder extends RecyclerView.ViewHolder {

    CardView cardView;
    TextView itemNameView;
    TextView itemDescView;

    public ItemViewHolder(View itemView) {
      super(itemView);
      cardView = itemView.findViewById(R.id.genreCardView);
      itemNameView = itemView.findViewById(R.id.genreNameView);
      itemDescView = itemView.findViewById(R.id.genreDescView);
    }
  }

}
