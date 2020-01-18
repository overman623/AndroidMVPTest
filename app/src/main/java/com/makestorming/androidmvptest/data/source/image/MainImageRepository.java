package com.makestorming.androidmvptest.data.source.image;

import android.content.Context;

public class MainImageRepository implements MainImageSource {

    private static MainImageRepository mainImageRepository;

    public static MainImageRepository getInstance(){
        if(mainImageRepository == null){
            mainImageRepository = new MainImageRepository();
        }
        return mainImageRepository;
    }

    private MainImageLocalDataSource mainImageLocalDataSource;

    private MainImageRepository(){
        mainImageLocalDataSource = new MainImageLocalDataSource();
    }

    @Override
    public void getImages(Context context, int size, final LoadImageCallback loadImageCallback) {
        mainImageLocalDataSource.getImages(context, size, list -> {
            if(loadImageCallback != null){
                loadImageCallback.onImageLoaded(list);
            }
        });
    }

}
