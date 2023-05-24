package com.example.myrecyclerapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import org.apache.http.HttpStatus;

import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;

public class ImageDownloaderTask extends AsyncTask<String, Void, Bitmap> {

    private final WeakReference<ImageView> imageViewReference;
    private static final String TAG = ImageDownloaderTask.class.getSimpleName();
    public ImageDownloaderTask(ImageView imageView){
        imageViewReference = new WeakReference<ImageView>(imageView);
    }

    @Override
    protected Bitmap doInBackground(String...params){
        return downloadBitmap(params[0]);
    }
    @Override
    protected void onPostExecute(Bitmap bitmap){
        if (isCancelled()){
            bitmap = null;
        }
        if (imageViewReference != null){
            ImageView imageView = imageViewReference.get();
            if (imageView != null){
                imageView.setImageBitmap(bitmap);
            } else{
                Drawable placeholder = imageView.getContext().getDrawable(R.drawable.food);
                imageView.setImageDrawable(placeholder);
            }
        }
    }
    private Bitmap downloadBitmap(String imageUrl){
        HttpURLConnection urlConnection = null;
        try{
            URL uri = new URL(imageUrl);
            //opening the connection
            urlConnection = (HttpURLConnection) uri.openConnection();

            //get status
            int statusCode = urlConnection.getResponseCode();

            //check if things worked properly
            if(statusCode!= HttpStatus.SC_OK){
                return null;
            }
            InputStream inputStream = urlConnection.getInputStream();
            if (inputStream !=null){
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                return bitmap;
            }
        } catch(Exception e){
            urlConnection.disconnect();
            Log.d(TAG, "url exception occurred" + imageUrl);
        } finally {
            if(urlConnection !=null){
                urlConnection.disconnect();
            }
        }
        return null;
    }


}
