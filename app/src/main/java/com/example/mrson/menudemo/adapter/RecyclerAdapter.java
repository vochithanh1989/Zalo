package com.example.mrson.menudemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mrson.menudemo.model.Myfeed;
import com.example.mrson.menudemo.R;
import com.example.mrson.menudemo.viewholder.RecyclerHeaderViewHolder;
import com.example.mrson.menudemo.viewholder.RecyclerItemViewHolder;

import java.util.ArrayList;
import java.util.List;


/*
* RecyclerView Adapter that allows to add a header view.
* */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_HEADER = 2;
    private static final int TYPE_ITEM = 1;
    private List<Myfeed> mItemList;
    ArrayList<Myfeed> mlist= new ArrayList<Myfeed>();
    Context mcontext;
    Myfeed myfeed;

    public RecyclerAdapter(List<Myfeed> mItemList) {
        this.mItemList = mItemList;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        if (viewType == TYPE_ITEM) {
            final View view = LayoutInflater.from(context).inflate(com.example.mrson.menudemo.R.layout.recycler_item, parent, false);
            return RecyclerItemViewHolder.newInstance(view);
        } else if (viewType == TYPE_HEADER) {
            final View view = LayoutInflater.from(context).inflate(R.layout.recycler_header, parent, false);
            return new RecyclerHeaderViewHolder(view);
        }
        throw new RuntimeException("There is no type that matches the type " + viewType + " + make sure your using types correctly");
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        if (!isPositionHeader(position)) {
            RecyclerItemViewHolder holder = (RecyclerItemViewHolder) viewHolder;
            Myfeed itemText = mItemList.get(position - 1); // header

            holder.setItemText((CharSequence) itemText);
            holder.setUsername(itemText.getName());
            holder.setavatar(itemText.getImage());



        }
    }

    public int getBasicItemCount() {
        return mItemList == null ? 0 : mItemList.size();
    }


    @Override
    public int getItemViewType(int position) {
        if (isPositionHeader(position)) {
            return TYPE_HEADER;
        }

        return TYPE_ITEM;
    }

    @Override
    public int getItemCount() {
        return getBasicItemCount() + 1; // header
    }

    private boolean isPositionHeader(int position) {
        return position == 0;
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

}
