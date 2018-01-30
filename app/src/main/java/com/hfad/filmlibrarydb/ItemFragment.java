package com.hfad.filmlibrarydb;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

public class ItemFragment extends Fragment {

  private RecyclerView recyclerView;
  private List<Item> items;
  private ItemAdapter itemAdapter;

  public ItemFragment() {
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View root = inflater.inflate(R.layout.fragment_item, container, false);
    items = ItemList.getInstance(getContext()).getItems();
    itemAdapter = new ItemAdapter(getContext(), items);
    recyclerView = root.findViewById(R.id.itemListRW);

    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());

    recyclerView.setLayoutManager(linearLayoutManager);
    recyclerView.setAdapter(itemAdapter);
    return root;
  }

  private class ItemAdapter extends RecyclerView.Adapter<ItemViewHolder> {

    private Context context;
    private List<Item> items;

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
    public void onBindViewHolder(ItemViewHolder holder, int position) {
      holder.itemNameView.setText(items.get(position).getName());
      holder.itemDescView.setText(items.get(position).getDescription());
      holder.cardView.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View v) {

        }
      });
    }

    @Override
    public int getItemCount() {
      return items.size();
    }
  }

  private class ItemViewHolder extends RecyclerView.ViewHolder {

    private CardView cardView;
    private TextView itemNameView;
    private TextView itemDescView;

    public ItemViewHolder(View itemView) {
      super(itemView);
      cardView = itemView.findViewById(R.id.genreCardView);
      itemNameView = itemView.findViewById(R.id.genreNameView);
      itemDescView = itemView.findViewById(R.id.genreDescView);
    }
  }

}
