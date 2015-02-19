package com.example.kanmani.prokarma.firstsample;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;


public class GridSamples extends Activity {


    private GridView mGridView =null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_samples);

        mGridView = (GridView)findViewById(R.id.gridView_Holder_Id);
        mGridView.setAdapter(new ImageAdapter(this));

    }

public class ImageAdapter extends BaseAdapter
{
    Context mContext;
    public ImageAdapter(Context m) {
        mContext = m;
    }

    @Override
    public int getCount() {
        return mThumbIds.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if(convertView == null)
        {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(250,150));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8,8,8,8);
        }
        else
        {
            imageView =(ImageView)convertView;
        }

        imageView.setImageResource(mThumbIds[position]);

        return imageView;
    }
}

    private Integer[] mThumbIds = {
            R.drawable.sample_0,R.drawable.sample_1,
            R.drawable.sample_2,R.drawable.sample_3,
            R.drawable.sample_4,R.drawable.sample_5,
            R.drawable.sample_6,R.drawable.sample_7,
            R.drawable.sample_0,R.drawable.sample_1,
            R.drawable.sample_2,R.drawable.sample_3,
            R.drawable.sample_4,R.drawable.sample_5,
            R.drawable.sample_0,R.drawable.sample_1,
            R.drawable.sample_2,R.drawable.sample_3,
            R.drawable.sample_4,R.drawable.sample_5,
            R.drawable.sample_0,R.drawable.sample_1,
            R.drawable.sample_2,R.drawable.sample_3,
            R.drawable.sample_4,R.drawable.sample_5,
            R.drawable.sample_6,R.drawable.sample_7,
            R.drawable.sample_0,R.drawable.sample_1,
            R.drawable.sample_2,R.drawable.sample_3,
            R.drawable.sample_4,R.drawable.sample_5,
            R.drawable.sample_0,R.drawable.sample_1,
            R.drawable.sample_2,R.drawable.sample_3,
            R.drawable.sample_4,R.drawable.sample_5,
            R.drawable.sample_0,R.drawable.sample_1,
            R.drawable.sample_2,R.drawable.sample_3,
            R.drawable.sample_4,R.drawable.sample_5,
            R.drawable.sample_6,R.drawable.sample_7,
            R.drawable.sample_0,R.drawable.sample_1,
            R.drawable.sample_2,R.drawable.sample_3,
            R.drawable.sample_4,R.drawable.sample_5,
            R.drawable.sample_0,R.drawable.sample_1,
            R.drawable.sample_2,R.drawable.sample_3,
            R.drawable.sample_4,R.drawable.sample_5,
            R.drawable.sample_0,R.drawable.sample_1,
            R.drawable.sample_2,R.drawable.sample_3,
            R.drawable.sample_4,R.drawable.sample_5,
            R.drawable.sample_6,R.drawable.sample_7,
            R.drawable.sample_0,R.drawable.sample_1,
            R.drawable.sample_2,R.drawable.sample_3,
            R.drawable.sample_4,R.drawable.sample_5,
            R.drawable.sample_0,R.drawable.sample_1,
            R.drawable.sample_2,R.drawable.sample_3,
            R.drawable.sample_4,R.drawable.sample_5
    };

}
