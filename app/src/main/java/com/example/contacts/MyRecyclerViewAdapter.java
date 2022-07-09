package com.example.contacts;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    private List<String> mData; //

    public MyRecyclerViewAdapter(Context context, List<String> data) {
        this.mData = data;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void refreshEvents(List<String> newData) {
        mData = newData;
        notifyDataSetChanged();

    }

    //ye adapter in method niaz dare ke liste refresh shode contactaro begire
    //masalan ye tabe ke list string migire mizare tooye mData. faghat badesh notifyDataSetChanged faramoosh nashe

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_row, parent, false);
        return new ViewHolder(view);
        //ye view besazi
        //view ro bedi be viewholder
        //viewholder ro return koni
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //inja check vase position -1 bezar chun age ye moghe ba -1 ejra she, mData.get(-1) crash mikone
        String contact = mData.get(position);
        holder.nameTextView.setText(contact);
    }

    //inja check null vase mData faramoosh nashe
    @Override
    public int getItemCount() {
        return
                mData.size();
        if (mData!=null&& !mData.isEmpty()){
            else{
                return ;
            }
        }
    }


    //esme in class behtare viewholdere sade naabashe va ye esm bashe ke moshakhas kone karesh chie
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nameTextView;

        ViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextview);
        }
    }
}


