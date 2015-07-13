package com.kanmani.prokarma.samplecontentprovider;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by Kanmani on 5/14/2015.
 */
public class ImageAdaptor extends BaseAdapter {

    private Context context;
    private ArrayList imageList;
    private LayoutInflater inflater;
    private ImageView mImage;


    public ImageAdaptor(Context context,ArrayList imageList) {

        this.context = context;
        this.imageList = imageList;
    }

    @Override
    public int getCount() {
        return imageList.size();
    }

    @Override
    public Object getItem(int position) {
        return imageList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView== null)
        {
        convertView = inflater.inflate(R.layout.image_list_item,parent,false);

        }
        mImage = (ImageView)convertView.findViewById(R.id.GImage);
      //  mImage.setImageResource(getItem(position));
        return convertView;
    }
}
