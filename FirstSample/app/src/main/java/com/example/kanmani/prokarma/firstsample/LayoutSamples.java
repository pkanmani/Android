package com.example.kanmani.prokarma.firstsample;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.view.View.OnClickListener;


public class LayoutSamples extends ActionBarActivity implements OnClickListener{

    public static final String TAG_LAYOUT_SAMPLES = LayoutSamples.class.getSimpleName();
    private TextView mListView;
    private TextView mFrameLayout;
    private TextView mDynamicViews;
    private TextView mTabViews;
    private TextView mFragmentViews;
    private  View mView;
    private Intent intent = new Intent();


        
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v(TAG_LAYOUT_SAMPLES, "onCreate() in LayoutSamples");
        setContentView(R.layout.activity_layout_samples);
        mListView = (TextView)findViewById(R.id.FirstSample_LayoutSamples_List_TV_Id);
        mFrameLayout = (TextView)findViewById(R.id.FirstSample_LayoutSamples_Frame_TV_Id);
        mDynamicViews = (TextView)findViewById(R.id.FirstSample_LayoutSamples_DynamicViews_TV_ID);
        mTabViews = (TextView)findViewById(R.id.FirstSample_LayoutSamples_TabSamples_TV_ID);
        mFragmentViews = (TextView)findViewById(R.id.FirstSample_LayoutSamples_FragmentSample_TV_Id);

        mFrameLayout.setOnClickListener(this);
        mListView.setOnClickListener(this);
        mDynamicViews.setOnClickListener(this);
        mTabViews.setOnClickListener(this);
        mFragmentViews.setOnClickListener(this);

    }




    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.FirstSample_LayoutSamples_List_TV_Id:
                showListView();
                break;
            case R.id.FirstSample_LayoutSamples_Frame_TV_Id:
                showFrameLayout();
                break;
            case R.id.FirstSample_LayoutSamples_DynamicViews_TV_ID:
                showDynamicViews();
                break;
            case R.id.FirstSample_LayoutSamples_TabSamples_TV_ID:
                showTab();
                break;
            case R.id.FirstSample_LayoutSamples_FragmentSample_TV_Id:
                showFragmentLayout();
                break;
            default:
                break;
        }



    }

    private void showFragmentLayout() {
        intent.setClass(this,FragmentSamples.class);
        startActivity(intent);
    }

    public void showTab()
    {
        //intent.setClass(this,TabBarActivity.class);
        intent.setClass(this,GridSamples.class);
        startActivity(intent);
    }

    public void showDynamicViews()
    {
        intent.setClass(this,DynamicViewsActivity.class);
        startActivity(intent);
    }

    public void showFrameLayout()
    {
        intent.setClass(this,FrameActivity.class);
        startActivity(intent);

    }

    public void showListView()
    {
        intent.setClass(this,ListActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v(TAG_LAYOUT_SAMPLES, "onStart() in LayoutSamples");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG_LAYOUT_SAMPLES,"onResume() in LayoutSamples");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TAG_LAYOUT_SAMPLES, "onPause() in LayoutSamples");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(TAG_LAYOUT_SAMPLES,"onStop() in LayoutSamples");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG_LAYOUT_SAMPLES, "onDestroy() in LayoutSamples");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v(TAG_LAYOUT_SAMPLES, "onRestart() in LayoutSamples");
    }



}
