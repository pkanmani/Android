package com.example.kanmani.prokarma.firstsample;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;


public class ListActivity extends ActionBarActivity implements ICheckboxSelectedItems {

    public static final String TAG_LOGLIST = ListActivity.class.getSimpleName();

    private String[] mMonthArray = {"Jan", "Feb", "Mar", "April", "May", "June", "July", "Aug", "Sep", "Oct", "Nov", "Dec"};
    private ListView mMonth_LV;
    private Button mButton;
    private ArrayList<String> selectedMonthList;
  //  Bundle listbundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v(TAG_LOGLIST, "onCreate() in the ListActivity");
        setContentView(R.layout.activity_list);
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < mMonthArray.length; i++) {
            list.add(mMonthArray[i]);
        }
        mMonth_LV = (ListView) findViewById(R.id.FirstSample_listView_Id);
        mButton = (Button) findViewById(R.id.FirstSample_Submit_Button_Id);
        ResourceAdapter adapter = new ResourceAdapter(this, list);
        mMonth_LV.setAdapter(adapter);


        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TAG_LOGLIST, "Size of the Selected Month List" + selectedMonthList.size());
                Intent intent = new Intent(getApplicationContext(), DisplayListItems.class);
                /* Sending List via bundle from Activity to Activity*/
                /*   listbundle = new Bundle();
                     listbundle.putStringArrayList("a", selectedMonthList);
                     intent.putExtras(listbundle);*/

                /* Sending List via Intent from Activity to Activity*/
                  intent.putStringArrayListExtra("key1",selectedMonthList);
                  startActivity(intent);
         }
        });
    }


    @Override
    public void getCheckedItems(Context context, ArrayList itemName) {
        selectedMonthList = itemName;
    }
}
