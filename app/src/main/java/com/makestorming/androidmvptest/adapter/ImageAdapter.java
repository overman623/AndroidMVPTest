package com.makestorming.androidmvptest.adapter;

import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.makestorming.androidmvptest.adapter.contract.ImageAdapterContract;
import com.makestorming.androidmvptest.adapter.holder.ImageViewHolder;
import com.makestorming.androidmvptest.data.ImageItem;
import com.makestorming.androidmvptest.listener.OnItemClickListener;

import java.util.ArrayList;

public class ImageAdapter extends RecyclerView.Adapter<ImageViewHolder> implements ImageAdapterContract.Model, ImageAdapterContract.View {

    private Context context;
    private OnItemClickListener onItemClickListener;

    private ArrayList<ImageItem> imageItems;

    public ImageAdapter(Context context) {
        this.context = context;
    }

    @Override
    public void addItems(ArrayList<ImageItem> imageItems) {
        this.imageItems = imageItems;
    }

    @Override
    public void clearItem() {
        if(imageItems != null){
            imageItems.clear();
        }
    }

    @Override
    public void notifyAdapter() {
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ImageViewHolder(context, parent, onItemClickListener);
    }


    @Override
    public int getItemCount() {
        return imageItems != null ? imageItems.size() : 0;
    }


    @Override
    public ImageItem getItem(int position) {
        return imageItems.get(position);
    }

    @Override
    public void setOnClickListener(OnItemClickListener clickListener) {
        this.onItemClickListener = clickListener;
    }

    @Override
    public void onBindViewHolder(final ImageViewHolder holder, int position) {
        if(holder == null) return;
        holder.onBind(getItem(position), position);
    }

}
