package com.kanmani.prokarma.samplecontentprovider;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Kanmani on 4/9/2015.
 */
public class ContactAdaptor extends BaseAdapter {

    private static final String  TAG = ContactAdaptor.class.getSimpleName();

    private List<People> peopleList;
    private Context context;
    private LayoutInflater inflater;
    private TextView mTextView;

    public ContactAdaptor(Context context,List<People> peopleList) {
        this.peopleList = peopleList;
        this.context = context;
        inflater = LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        Log.v(TAG,"Contact Name Map Size :"+peopleList.size());
        return peopleList.size();


    }

    @Override
    public People getItem(int position) {
        return peopleList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null)
        {
            convertView = inflater.inflate(R.layout.contact_list_item,parent,false);
        }

        People ppl = getItem(position);
        mTextView = (TextView) convertView.findViewById(R.id.TextViewId);
        mTextView.setText(ppl.displayName);

        if (ppl.notes != null && ppl.notes.length() > 0) {
            mTextView.setTextColor(Color.BLUE);
        } else {
            mTextView.setTextColor(Color.GRAY);
        }
        return convertView;
    }
}
