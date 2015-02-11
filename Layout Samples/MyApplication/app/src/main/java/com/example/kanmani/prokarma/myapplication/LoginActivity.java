package com.example.kanmani.prokarma.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

/**
 * Created by Kanmani on 1/7/2015.
 */
public class LoginActivity extends Activity {
    public  static  final String TAG_LOGINACITIVITY=LoginActivity.class.getSimpleName();
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.v(TAG_LOGINACITIVITY, "LoginActivity -->onCreate()");
    }

public void callTermsAndCondition(View view)
{
    Intent termIntent = new Intent(this,TermsAndConditionActivity.class);
    startActivity(termIntent);
}


}
