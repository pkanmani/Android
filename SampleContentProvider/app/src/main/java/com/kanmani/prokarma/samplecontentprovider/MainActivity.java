package com.kanmani.prokarma.samplecontentprovider;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.ContentResolver;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity implements View.OnClickListener{

    private static final String TAG = MainActivity.class.getSimpleName();

    private Button mButton,mImageButtom,mPeople;
    private  FragmentManager manager;
    private  FragmentTransaction fT;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mButton = (Button)findViewById(R.id.Contacts_Btn);
        mImageButtom = (Button)findViewById(R.id.images_id);
        mPeople = (Button)findViewById(R.id.people);
        mButton.setOnClickListener(this);
        mImageButtom.setOnClickListener(this);
        mPeople.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        manager = getFragmentManager();
        fT = manager.beginTransaction();
        switch (v.getId()) {
            case R.id.Contacts_Btn:
                callContactFragments();
                break;

            case R.id.images_id:
                callImageFragments();
                break;

            case R.id.people:
                callPeopleFragment();
                break;
            default:

        }
    }

    private void callPeopleFragment() {
        if (manager!=null) {
            PeopleFragment peopleFragment = new PeopleFragment();
            fT.replace(R.id.FrameLayoutID,peopleFragment);
            fT.commit();
        }

    }

    private void callImageFragments() {
        if(manager!=null)
        {
            ImageFragment imageFragment = new ImageFragment();
            fT.replace(R.id.FrameLayoutID,imageFragment);
            fT.commit();
        }
    }

    private void callContactFragments() {
        if(manager!=null) {
            ContactFragment fragment = new ContactFragment();
            fT.replace(R.id.FrameLayoutID, fragment);
            fT.commit();
        }
    }


}
