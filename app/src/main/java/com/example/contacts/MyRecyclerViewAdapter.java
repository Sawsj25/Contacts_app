package com.example.contacts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Objects;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolderShowItem> {

    private final List<String> mData; //

    public MyRecyclerViewAdapter(Context context, List<String> data) {
        this.mData = data;
    }

    @NonNull
    @Override
    public ViewHolderShowItem onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_row, parent, false);
        return new ViewHolderShowItem(view);

    }

    @Override
    public void onBindViewHolder(ViewHolderShowItem holder, int position) {
        if(position == -1) return;
        String contact = mData.get(position);
        holder.nameTextView.setText(contact);
    }

    @Override
    public int getItemCount() {
        if (mData == null)
            return 0;
        return mData.size();
    }
    public static class ViewHolderShowItem extends RecyclerView.ViewHolder {
        private final TextView nameTextView;
        ViewHolderShowItem(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextview);
        }
    }
}


