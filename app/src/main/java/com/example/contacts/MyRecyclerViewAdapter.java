package com.example.contacts;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Objects;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    private final List<String> mData; //

    public MyRecyclerViewAdapter(Context context, List<String> data) {
        this.mData = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_row, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //inja check vase position -1 bezar chun age ye moghe ba -1 ejra she, mData.get(-1) crash mikone
        String contact = mData.get(position);
        holder.nameTextView.setText(contact);
        if(position<getItemCount()){
            onBindViewHolder(holder, position);
        }
    }

    @Override
    public int getItemCount() {
        if (Objects.isNull(mData))
            return 0;
        return mData.size();
    }

    //esme in class behtare viewholdere sade naabashe va ye esm bashe ke moshakhas kone karesh chie
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView nameTextView;

        ViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextview);
        }
    }
}


