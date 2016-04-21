package com.epicodus.airbnb;

/**
 * Created by Guest on 4/21/16.
 */

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomList extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] web;
    private final Integer[] imageId;
    private final Integer[] imageId2;
    public CustomList(Activity context,
                      String[] web, Integer[] imageId, Integer[] imageId2) {
        super(context, R.layout.list_single, web);
        this.context = context;
        this.web = web;
        this.imageId = imageId;
        this.imageId2 = imageId2;

    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.list_single, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.txt);

        ImageView imageView = (ImageView) rowView.findViewById(R.id.imageView);
        ImageView imageView2 = (ImageView) rowView.findViewById(R.id.imageView2);
        txtTitle.setText(web[position]);

        imageView.setImageResource(imageId[position]);
        imageView2.setImageResource(imageId2[position]);
        return rowView;
    }


}
