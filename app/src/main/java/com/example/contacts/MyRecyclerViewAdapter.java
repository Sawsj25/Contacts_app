package com.example.contacts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    private List<String> mData;

    public MyRecyclerViewAdapter(Context context, List<String> data) {
        this.mData = data;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //        View view = (View) mData;
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_row , parent ,false);
        return new ViewHolder(view);
        //ye view besazi
        //view ro bedi be viewholder
        //viewholder ro return koni
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String contact = mData.get(position);
        holder.myTextView.setText(contact);
    }


    @Override
    public int getItemCount() {
        return
                mData.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {// implements View.OnClickListener {
        TextView myTextView;

        ViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.nameTextview);
        }
    }
}


