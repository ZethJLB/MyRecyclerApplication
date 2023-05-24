package com.example.myrecyclerapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends ArrayAdapter<Menu> {
    private List<Menu> menuList;
    private Bitmap bitmap;
    private Context mCtx;

    public MyAdapter(List<Menu> menuList, Context mCtx){
        super(mCtx, R.layout.list_item, menuList); //make sure the super() is called
        this.menuList=menuList;
        this.mCtx=mCtx;
    }

    static class ViewHolder{
        TextView textViewName;
        TextView textDescription;
        ImageView imageView;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder holder;
        LayoutInflater inflater= LayoutInflater.from(mCtx);
        convertView = inflater.inflate(R.layout.list_item, null, true);
        holder = new ViewHolder();
        holder.textViewName = convertView.findViewById(R.id.textViewName);
        holder.textDescription = convertView.findViewById(R.id.textViewMenuItemDescription);
        holder.imageView = convertView.findViewById(R.id.imageView);

        convertView.setTag(holder);

        Menu menu = menuList.get(position);

        String imageUrl = menu.getImageUrl();
        String menuItemDescription = menu.getDescription();
        String menuItemTitle = menu.getName();

        holder.textViewName.setText(menuItemTitle);
        holder.textDescription.setText(menuItemDescription);

        if(holder.imageView != null){
            new ImageDownloaderTask(holder.imageView).execute(imageUrl);
        }
        holder.imageView.setImageBitmap(bitmap);
        return convertView;
    }




}
