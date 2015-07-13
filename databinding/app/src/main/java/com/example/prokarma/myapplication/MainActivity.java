package com.example.prokarma.myapplication;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.prokarma.myapplication.databinding.ActivityMainBinding;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        User user = new User("Test", "User");
        binding.setUser(user);
    }

}
