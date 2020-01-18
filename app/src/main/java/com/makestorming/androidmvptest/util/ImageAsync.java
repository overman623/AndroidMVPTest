package com.makestorming.androidmvptest.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.lang.ref.WeakReference;

public class ImageAsync extends AsyncTask<Integer, Void, Bitmap> {

    private Context context;

    private final WeakReference<ImageView> imageViewWeakReference;

    public ImageAsync(Context context, ImageView imageView) {
        this.context = context;
        imageViewWeakReference = new WeakReference<>(imageView);
    }

    @Override
    protected Bitmap doInBackground(Integer... params) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 2;
        return BitmapFactory.decodeResource(context.getResources(), params[0], options);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        imageViewWeakReference.get().setImageResource(0);
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        imageViewWeakReference.get().setImageBitmap(bitmap);
    }
}