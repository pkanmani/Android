package com.example.kanmani.prokarma.firstsample;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.util.Log;
import android.widget.TabHost;
import android.widget.Toast;


public class TabBarActivity extends FragmentActivity implements TabHost.OnTabChangeListener,ICallbackTabs {

    private static final String TAG_TAB_ACITIVITY = TabBarActivity.class.getSimpleName();
    private final String  TAB_1_TAG = "tab1";
    private final String  TAB_2_TAG = "tab2";
    private FragmentTabHost mTabHost;
    ICallbackTabs iCallbackTabs;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);
        mTabHost.addTab(mTabHost.newTabSpec(TAB_1_TAG).setIndicator("Tab1"), FirstFragment.class, null);
        mTabHost.addTab(mTabHost.newTabSpec(TAB_2_TAG).setIndicator("Tab2"), SecondFragment.class, null);

      /*  Bundle bundle = new Bundle();
        bundle.putString("Hi", "From Tab Activity");
        FirstFragment firstFragment = new FirstFragment();
        firstFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().add(android.R.id.tabcontent, firstFragment).commit();
        iCallbackTabs.getFragmentData(bundle);*/
        mTabHost.setOnTabChangedListener(this);
    }
    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
    }

    @Override
    public void getFragmentData(Bundle bundle) {
       SecondFragment sF = (SecondFragment)getSupportFragmentManager().findFragmentById(R.id.ta2_holder_Id);
        sF.setTextValue(bundle);
    }

    @Override
    public void onTabChanged(String tabId) {

        Log.v(TAG_TAB_ACITIVITY,tabId);
        if(TAB_1_TAG.equals("tab1"))
        {
            Toast.makeText(getApplicationContext(), "Selected Tab " + tabId, Toast.LENGTH_LONG).show();
        }
        else if(TAB_2_TAG.equals("tab2"))
        {
            Toast.makeText(getApplicationContext(), "Selected Tab " + tabId, Toast.LENGTH_LONG).show();
        }
    }
}
