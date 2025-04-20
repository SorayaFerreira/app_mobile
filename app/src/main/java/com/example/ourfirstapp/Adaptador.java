package com.example.ourfirstapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Adaptador extends BaseAdapter {

    private final Context context;
    private final List<Bird> birdList;

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

    // Aqui é onde ocorre o binding
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View iv;

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            iv = inflater.inflate(R.layout.i_bird, parent, false);
        } else {
            iv = convertView;
        }

        // Pega o objeto Bird e mostra sua foto

        ImageView imageView = iv.findViewById(R.id.bird_image);
        TextView textView = iv.findViewById(R.id.bird_name);
        Bird currentBird = birdList.get(position);
        imageView.setImageResource(currentBird.getImageResId());
        textView.setText(currentBird.getName());

        return iv;
    }

}
