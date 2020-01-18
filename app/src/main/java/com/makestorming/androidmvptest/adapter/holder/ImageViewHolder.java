package com.makestorming.androidmvptest.adapter.holder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.makestorming.androidmvptest.R;
import com.makestorming.androidmvptest.data.ImageItem;
import com.makestorming.androidmvptest.listener.OnItemClickListener;
import com.makestorming.androidmvptest.util.ImageAsync;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ImageViewHolder extends RecyclerView.ViewHolder {

    private Context context;
    private OnItemClickListener onItemClickListener;

    @BindView(R.id.img_view)
    ImageView imageView;

    public ImageViewHolder(Context context, ViewGroup parent, OnItemClickListener onItemClickListener) {
        super(LayoutInflater.from(context).inflate(R.layout.item_image, parent, false));

        this.context = context;
        this.onItemClickListener = onItemClickListener;
        ButterKnife.bind(this, itemView); //test ok;

    }


    public void onBind(ImageItem item, final int position) {
        itemView.setOnClickListener(view -> {
            if(onItemClickListener != null){
                onItemClickListener.onItemClick(position);
            }

        });

        new ImageAsync(context, imageView).execute(item.getImageRes());

    }
}
