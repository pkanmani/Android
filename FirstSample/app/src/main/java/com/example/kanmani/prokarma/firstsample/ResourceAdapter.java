package com.example.kanmani.prokarma.firstsample;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Kanmani on 2/10/2015.
 */
public class ResourceAdapter extends BaseAdapter {

    private static final String LOG_ADAPTER = ResourceAdapter.class.getSimpleName();
    private ArrayList myList;
    private Context context;
    ICheckboxSelectedItems iCheckboxSelectedItems;
    ArrayList<String> selectedItemList = new ArrayList<String>();
    boolean[] checkBoxArray;

    public ResourceAdapter(Context context, ArrayList myList) {
        this.myList = myList;
        this.context = context;
        checkBoxArray = new boolean[myList.size()];

    }

    @Override
    public int getCount() {
        return myList.size();
    }

    @Override
    public Object getItem(int position) {
        return myList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        TextView mTextView = null;
        CheckBox mCheckBox = null;
        iCheckboxSelectedItems = (ICheckboxSelectedItems) context;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_layout__listview, parent, false);

        }
        mTextView = (TextView) convertView.findViewById(R.id.FirstSample_textView_Id);
        mCheckBox = (CheckBox) convertView.findViewById(R.id.FirstSample_checkBox_List_Id);
        mTextView.setText(getItem(position).toString());
        mCheckBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {


                if (isChecked) {
                    checkBoxArray[position] = true;
                    selectedItemList.add(myList.get(position).toString());
                    Toast.makeText(context, "List : " + selectedItemList.size() + " Item Checked " + isChecked, Toast.LENGTH_LONG).show();
                    Log.v("LOG_ADAPTER", "checked Item Name : " + myList.get(position).toString());

                } else {
                    checkBoxArray[position] = false;
                    selectedItemList.remove(myList.get(position).toString());
                    Toast.makeText(context, "List : " + selectedItemList.size() + " Item unChecked " + isChecked, Toast.LENGTH_LONG).show();
                    Log.v("LOG_ADAPTER", "Unchecked Item Name : " + myList.get(position).toString());

                }

                iCheckboxSelectedItems.getCheckedItems(context, selectedItemList);
              //  Log.v("LOG_ADAPTER", "checked Item Name : " + selectedItemList.size());

            }
        });
        mCheckBox.setChecked(checkBoxArray[position]);

        return convertView;
    }


}
