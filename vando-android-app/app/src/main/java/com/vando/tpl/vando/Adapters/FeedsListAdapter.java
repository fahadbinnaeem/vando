package com.vando.tpl.vando.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import com.squareup.picasso.Picasso;
import com.vando.tpl.vando.Activities.ItemDetailsActivity;
import com.vando.tpl.vando.Activities.MainActivity;
import com.vando.tpl.vando.R;
import com.vando.tpl.vando.Models.FeedItem;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Faraz on 26-Nov-16.
 */
public class FeedsListAdapter extends RecyclerView.Adapter<FeedsListAdapter.FeedItemHolder> {


    List<FeedItem> feedItems = new ArrayList<>();
    Context context;

    public FeedsListAdapter(Context context) {
        this.context = context;
    }

    @Override
    public FeedItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.feed_list_item, parent,false);
        FeedItemHolder feedItemHolder = new FeedItemHolder(v);
        return feedItemHolder;
    }

    @Override
    public void onBindViewHolder(FeedItemHolder holder, int position) {
        final FeedItem feedItem = feedItems.get(position);


        Glide.with(context).load(feedItem.getImgUrl()).placeholder(R.drawable.dish).dontAnimate().fitCenter().into(holder.FeedImg);
        holder.itemName.setText(feedItem.getItemName());
        holder.feedDateTime.setText(feedItem.getDateTime());
        holder.quantity.setText(feedItem.getQuantity());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,ItemDetailsActivity.class);
                intent.putExtra("item_name",feedItem.getItemName());
                intent.putExtra("manufecture_date",feedItem.getDateTime());
                intent.putExtra("distance",feedItem.getDistance());
                intent.putExtra("quantity",feedItem.getQuantity());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return feedItems.size();
    }

    public class FeedItemHolder extends RecyclerView.ViewHolder{

        ImageView FeedImg;
        TextView itemName;
        TextView feedDateTime;
        TextView quantity;


        public FeedItemHolder(View itemView) {
            super(itemView);
            FeedImg = (ImageView) itemView.findViewById(R.id.ivFeedImg);
            itemName = (TextView) itemView.findViewById(R.id.tvItemName);
            feedDateTime = (TextView) itemView.findViewById(R.id.tvFeedDateTime);
            quantity = (TextView) itemView.findViewById(R.id.tvQuantity);
        }

    }

    public void setFeedItems(List<FeedItem> feedItems) {
        this.feedItems = feedItems;
    }

    public void addFeedItems(List<FeedItem> feedItems){
        this.feedItems.addAll(feedItems);
    }
}
