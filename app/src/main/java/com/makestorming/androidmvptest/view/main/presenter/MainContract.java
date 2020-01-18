package com.makestorming.androidmvptest.view.main.presenter;

import android.content.Context;

import com.makestorming.androidmvptest.adapter.contract.ImageAdapterContract;
import com.makestorming.androidmvptest.data.source.image.MainImageRepository;

public interface MainContract {

    interface View{
        void showToast(String title);
    }
    interface Presenter{
        void attachView(MainContract.View view);
        void loadItems(Context context, final boolean isClear);
        void setMainImageData(MainImageRepository mainImageRepository);
        void setImageAdapterModel(ImageAdapterContract.Model imageAdapterModel);
        void setImageAdapterView(ImageAdapterContract.View imageAdapterView);
        void detachView();
    }

}
