package com.example.kanmani.prokarma.myapplication;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    public static final String TAG_MAINACTIVITY = MainActivity.class.getSimpleName();
    ListView m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(TAG_MAINACTIVITY, "MainActivity -->onCreate()");
    }

    public void callLoginActivity(View view) {
        Intent loginIntent = new Intent(this, LoginActivity.class);
        startActivity(loginIntent);
    }

    public void callRegisterActivity(View v) {
        Intent registerIntent = new Intent(this, SampleRegister.class);
        startActivity(registerIntent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v(TAG_MAINACTIVITY, "MainActivity -->onStart()");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG_MAINACTIVITY, "MainActivity -->onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
/*
        Intent sampleIntent = new Intent(this,TermsAndConditionActivity.class);
        startActivity(sampleIntent);*/
        Log.v(TAG_MAINACTIVITY, "MainActivity -->onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.v(TAG_MAINACTIVITY, "MainActivity -->onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.v(TAG_MAINACTIVITY, "MainActivity -->onDestroy()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v(TAG_MAINACTIVITY, "MainActivity -->onRestart()");
    }

}
