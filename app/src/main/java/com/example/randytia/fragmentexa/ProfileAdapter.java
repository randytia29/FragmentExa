package com.example.randytia.fragmentexa;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Randytia on 25/10/2017.
 */

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ViewHolder> {

    private String[] titles = {"synchronize",
            "activities",
            "my orders",
            "edit profile",
            "rate & review",
            "feedback",
            "share app",
            "about enr",
            "logout"};

    private int[] images = {R.drawable.ic_sync_black_24dp,
            R.drawable.ic_tablet_android_black_18dp,
            R.drawable.ic_local_activity_black_24dp,
            R.drawable.ic_border_color_black_24dp,
            R.drawable.ic_rate,
            R.drawable.ic_feedback_black_18dp,
            R.drawable.ic_share_black_18dp,
            R.drawable.ic_favorite_border_black_24dp,
            R.drawable.ic_all_out_black_18dp};

    class ViewHolder extends RecyclerView.ViewHolder {

        public TextView itemTitle;
        public ImageView itemImage;

        public ViewHolder(View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.imageView);
            itemTitle = itemView.findViewById(R.id.nameTextView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();

                    Snackbar.make(v, "Click detected on item " + position, Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            });
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_profile, viewGroup, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.itemTitle.setText(titles[i]);
        viewHolder.itemImage.setImageResource(images[i]);
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }
}
