package com.example.kanmani.prokarma.firstsample;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class FragmentSamples extends Activity implements FragmentOne.OnItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_samples);


       /* FragmentManager manager = getFragmentManager();
        if(manager !=null)
        {
            FragmentTransaction ft =manager.beginTransaction();
            FragmentOne fragmentOne = new FragmentOne();
            ft.add(R.id.FirstSample_FragmentSample_FrameLayout_ID,fragmentOne);
            ft.commit();

        }*/
    }


    @Override
    public void onItemSelected(int position) {
        FragmentTwo fragmentTwo = (FragmentTwo)getFragmentManager().findFragmentById(R.id.FirstSample_FragmentSample_FragmentB_ID);

        if(fragmentTwo == null)
        {
            Intent intent = new Intent(this,FragmentSampleB.class);
            intent.putExtra("position",position);
            startActivity(intent);
        }
        else
        {

        }
    }
}
