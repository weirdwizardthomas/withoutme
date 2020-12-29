package com.weirdwizardtom.withoutme.ui.mywishlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.weirdwizardtom.withoutme.R;
import com.weirdwizardtom.withoutme.pojo.MyWish;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.List;

public class WishlistItemAdapter extends RecyclerView.Adapter<WishlistItemAdapter.ViewHolder> {

    public static final String DATE_PATTERN = "dd.MM.yyyy";

    private static Format formatter = new SimpleDateFormat(DATE_PATTERN);

    private List<MyWish> data;
    public static WishlistItemAdapter emptyInstance() {
        return new WishlistItemAdapter();
    }

    private WishlistItemAdapter() {
    }

    public void setData(List<MyWish> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public WishlistItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.wishlist_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WishlistItemAdapter.ViewHolder holder, int position) {
        MyWish item = data.get(position);
        holder.nameTextView.setText(item.getName());
        holder.descriptionTextView.setText(item.getDescription());
        holder.timestampTextView.setText(formatter.format(item.getTimeAdded()));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView pictureImageView;
        private TextView nameTextView;
        private TextView descriptionTextView;
        private TextView timestampTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            pictureImageView = itemView.findViewById(R.id.item_picture_imageview);
            nameTextView = itemView.findViewById(R.id.item_name_textview);
            descriptionTextView = itemView.findViewById(R.id.item_description_textview);
            timestampTextView = itemView.findViewById(R.id.item_timestamp_textview);
        }
    }
}
