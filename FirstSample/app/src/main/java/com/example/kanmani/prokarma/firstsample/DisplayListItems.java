package com.example.kanmani.prokarma.firstsample;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;


public class DisplayListItems extends Activity {

    private static final String LOG_DISPLAY_LIST_ITEMS =DisplayListItems.class.getSimpleName();
    private TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_list_items);
        mTextView = (TextView)findViewById(R.id.FirstSample_displayListItems_TV_Id);
        displaySelectedMonthName();
    }

    private void displaySelectedMonthName() {

      /*  Intent intent = getIntent();
        StringBuffer responseText = new StringBuffer();
        if(intent!=null)
        {
            ArrayList sampleList = intent.getStringArrayListExtra("key1");
            Log.v("LOG_DISPLAY_LIST_ITEMS","List Size in second act--> "+sampleList.size());
            for(int i = 0 ;i<sampleList.size();i++)
            {
                Log.v(LOG_DISPLAY_LIST_ITEMS,"Selected Month Name : "+ sampleList.get(i));
                responseText.append("\n"+sampleList.get(i)).append(",");

            }*/

        Intent intent = getIntent();
        StringBuffer responseText = new StringBuffer();

        if(intent !=null)
        {
            ArrayList list = intent.getStringArrayListExtra("a");
            int listsize = list.size();
            for(int i = 0 ;i<listsize;i++)
            {
                Log.v(LOG_DISPLAY_LIST_ITEMS,"Selected Month Name : "+ list.get(i));
                responseText.append("\n"+list.get(i)).append(",");

            }
            mTextView.setText(responseText);

        }
    }
}
