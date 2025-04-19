package com.example.ourfirstapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.content.Context;
import android.widget.ImageView;

import java.util.List;

public class Adaptador extends BaseAdapter {

    private Context context;
    private List<Bird> birdList;

    public Adaptador(Context context, List<Bird> birdList) {
        this.context = context;
        this.birdList = birdList;
    }

    @Override
    public int getCount() {
        return birdList.size();
    }

    @Override
    public Object getItem(int position) {
        return birdList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    // This is where the binding happens
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView iv;

        if (convertView == null) {
            iv = new ImageView(context);
            iv.setLayoutParams(new ViewGroup.LayoutParams(250, 250));
            iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
            iv.setPadding(5, 5, 5, 5);
        } else {
            iv = (ImageView) convertView;
        }

        // Get the Bird object and set its image
        Bird currentBird = birdList.get(position);
        iv.setImageResource(currentBird.getImageResId());

        return iv;
    }

}
