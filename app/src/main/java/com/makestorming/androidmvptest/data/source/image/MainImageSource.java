package com.makestorming.androidmvptest.data.source.image;

import android.content.Context;

import com.makestorming.androidmvptest.data.ImageItem;

import java.util.ArrayList;

public interface MainImageSource {
    interface LoadImageCallback{
        void onImageLoaded(ArrayList<ImageItem> list);
    }
    void getImages(Context context, int size, LoadImageCallback loadImageCallback);
}
