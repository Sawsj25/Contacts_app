package com.example.contacts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.collection.ArraySet;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

//age file import ezafe dare pak she
public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    private final List<String> mData; //vaghti yeja matn mesle mData inja zard mishe roosh mouse ro negah dar bebin irad chie. masalan inja mige moteghayeret chun yebar faghat tarif mishe bayad final bashe
    private List<String> customListviewList;

    //context che estefadei mishe inja ke pass dadim? age lazem nis pak she
    public MyRecyclerViewAdapter(Context context, List<String> data) {
        this.mData = data;
    }

    public void refreshEvents(List<String> mData)
    {
        this.customListviewList.clear();
        this.customListviewList.addAll(mData);
        notifyDataSetChanged();
    }
    //ye adapter in method niaz dare ke liste refresh shode contactaro begire
    //masalan ye tabe ke list string migire mizare tooye mData. faghat badesh notifyDataSetChanged faramoosh nashe

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_row , parent ,false);
        return new ViewHolder(view);
        //ye view besazi
        //view ro bedi be viewholder
        //viewholder ro return koni
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //inja check vase position -1 bezar chun age ye moghe ba -1 ejra she, mData.get(-1) crash mikone
        String contact = mData.get(position);
        holder.myTextView.setText(contact);
    }

//inja check null vase mData faramoosh nashe
    @Override
    public int getItemCount() {
        return
                mData.size();
    }


//esme in class behtare viewholdere sade naabashe va ye esm bashe ke moshakhas kone karesh chie
    //commentaye ezafi ke male man nist pak kon lotfan
    public static class ViewHolder extends RecyclerView.ViewHolder {// implements View.OnClickListener {
        //public private yadet nare
        TextView myTextView;

        ViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.nameTextview);
        }
    }
}


