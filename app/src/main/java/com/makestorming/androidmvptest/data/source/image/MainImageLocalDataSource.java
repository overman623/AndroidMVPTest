package com.makestorming.androidmvptest.data.source.image;

import android.content.Context;
import android.util.Log;

import com.makestorming.androidmvptest.data.ImageItem;

import java.util.ArrayList;
import java.util.Locale;

class MainImageLocalDataSource implements MainImageSource {

    @Override
    public void getImages(Context context, int size, LoadImageCallback loadImageCallback) {

        ArrayList<ImageItem> items = new ArrayList<>();

        for(int i = 0; i < size; i++){
            final int random = (int)(Math.random() * 15);
            final String name = String.format(Locale.getDefault(),"sample_%02d", random);
            final int resource = context.getResources().getIdentifier(name, "drawable", context.getApplicationContext().getPackageName());
            items.add(new ImageItem(resource, name));
        }

        if(loadImageCallback != null){
            loadImageCallback.onImageLoaded(items);
        }

    }

}
