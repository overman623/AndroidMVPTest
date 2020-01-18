package com.makestorming.androidmvptest.adapter.contract;

import com.makestorming.androidmvptest.data.ImageItem;
import com.makestorming.androidmvptest.listener.OnItemClickListener;

import java.util.ArrayList;

public interface ImageAdapterContract {

    interface View {
        void setOnClickListener(OnItemClickListener clickListener);
        void notifyAdapter();
    }

    interface Model {
        void clearItem();
        void addItems(ArrayList<ImageItem> list);
        ImageItem getItem(int position);
    }
}
