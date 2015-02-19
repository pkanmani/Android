package com.example.kanmani.prokarma.firstsample;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Kanmani on 2/16/2015.
 */
public class FragmentOne extends Fragment implements AdapterView.OnItemClickListener{

    private ListView mListView;
    String[] items = { "this", "is", "a", "really",
            "silly", "list" };
    TextView selection;
    OnItemSelectedListener OnItemSelectedListener;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragmentone,container,false);
        mListView = (ListView)v.findViewById(R.id.FirstSample_FragmentOne_listView_Id);
        ArrayAdapter adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_expandable_list_item_1, items);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(this);
        selection=(TextView)v.findViewById(R.id.selection);
        return v;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        int itemPosition = position;
        String itemValue = (String)mListView.getItemAtPosition(position);

        OnItemSelectedListener.onItemSelected(position);

/*        FragmentManager manager = getFragmentManager();

        if(manager !=null)
        {
            FragmentTransaction ft =manager.beginTransaction();
            FragmentTwo fragmentTwo = new FragmentTwo();
            ft.replace(R.id.FirstSample_FragmentSample_FrameLayout_ID,fragmentTwo);
            ft.commit();

        }*/

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try
        {
             OnItemSelectedListener=(OnItemSelectedListener)activity;
        }
        catch (Exception e)
        {

        }
    }

    interface OnItemSelectedListener
    {
        public void onItemSelected(int position);
    }
}
