package com.vando.tpl.vando.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.vando.tpl.vando.Activities.MainActivity;
import com.vando.tpl.vando.Models.SearchSuggestiontem;
import com.vando.tpl.vando.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Faraz on 07-Nov-16.
 */
public class SearchListAdapter extends RecyclerView.Adapter<SearchListAdapter.ItemHolder> {


    List<SearchSuggestiontem> list = new ArrayList<>();
    Context context;


    public SearchListAdapter(Context context) {
        this.context = context;
    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_list_items, parent,false);
        ItemHolder itemHolder = new ItemHolder(v);
        return itemHolder;
    }

    @Override
    public void onBindViewHolder(ItemHolder holder, int position) {
        final SearchSuggestiontem item = list.get(position);
        //holder.userImg.setImageResource(item.getImgId());

        holder.suggestionText.setText(item.getSearchSuggestion());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context,MainActivity.class);
                intent.putExtra("chosen_search",item.getSearchSuggestion());
                context.startActivity(intent);

                //overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);


            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setList(List<SearchSuggestiontem> list) {
        this.list = list;
    }

    public class ItemHolder extends RecyclerView.ViewHolder{


        TextView suggestionText;

        public ItemHolder(View itemView) {
            super(itemView);

            suggestionText = (TextView) itemView.findViewById(R.id.tvUserName);

        }

    }
}
