package com.makestorming.androidmvptest.view.main.presenter;

import android.content.Context;

import com.makestorming.androidmvptest.adapter.contract.ImageAdapterContract;
import com.makestorming.androidmvptest.data.ImageItem;
import com.makestorming.androidmvptest.data.source.image.MainImageRepository;
import com.makestorming.androidmvptest.listener.OnItemClickListener;

public class MainPresenter implements MainContract.Presenter, OnItemClickListener {

    private MainContract.View view;
    private ImageAdapterContract.Model adapterModel;
    private ImageAdapterContract.View adapterView;
    private MainImageRepository mainImageRepository;

    @Override
    public void attachView(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void loadItems(Context context, final boolean isClear) {
        mainImageRepository.getImages(context, 10, list -> {
            if(list != null){
                if(isClear){
                    adapterModel.clearItem();
                }
                adapterModel.addItems(list);
                adapterView.notifyAdapter();
            }
        });
    }

    @Override
    public void setMainImageData(MainImageRepository mainImageRepository) {
        this.mainImageRepository = mainImageRepository;
    }

    @Override
    public void setImageAdapterModel(ImageAdapterContract.Model adapterModel) {
        this.adapterModel = adapterModel;
    }

    @Override
    public void setImageAdapterView(ImageAdapterContract.View adapterView) {
        this.adapterView = adapterView;
        this.adapterView.setOnClickListener(this);
    }


    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public void onItemClick(int position) {
        ImageItem imageItem = adapterModel.getItem(position);
        view.showToast(imageItem.getTitle());
    }
}