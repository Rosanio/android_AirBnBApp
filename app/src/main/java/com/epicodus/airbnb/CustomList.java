package com.epicodus.airbnb;

/**
 * Created by Guest on 4/21/16.
 */

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomList extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] web;
    private final Integer[] imageId;
    private final Integer[] imageId2;
    private final Integer[] imageId3;

    public CustomList(Activity context,
                      String[] web, Integer[] imageId, Integer[] imageId2, Integer[] imageId3) {
        super(context, R.layout.list_single, web);
        this.context = context;
        this.web = web;
        this.imageId = imageId;
        this.imageId2 = imageId2;
        this.imageId3 = imageId3;
    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        final View rowView= inflater.inflate(R.layout.list_single, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.txt);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.imageView);
        ImageView imageView2 = (ImageView) rowView.findViewById(R.id.imageView2);
        ImageView imageView3 = (ImageView) rowView.findViewById(R.id.imageView3);
        LinearLayout imageLinearLayout = (LinearLayout) rowView.findViewById(R.id.imageLinearLayout);


        txtTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer realPosition = (Integer) v.getId();
                TextView clickedTextView = (TextView) rowView.findViewById(realPosition);
                Toast.makeText(context, "You clicked on " + clickedTextView.getText().toString(), Toast.LENGTH_LONG).show();
            }
        });

        txtTitle.setText(web[position]);

        imageView.setImageResource(imageId[position]);
        imageView2.setImageResource(imageId2[position]);
        imageView3.setImageResource(imageId3[position]);
        return rowView;
    }



}
