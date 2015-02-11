package com.example.kanmani.prokarma.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by Kanmani on 1/8/2015.
 */
public class TermsAndConditionActivity extends Activity {

    public static final String TAG_TERMS_LOGS=TermsAndConditionActivity.class.getSimpleName();
    private TextView mTermsText;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms);
        mTermsText = (TextView)findViewById(R.id.MyApp_Terms_TV_Id);
        mTermsText.setMovementMethod(new ScrollingMovementMethod());
        Log.v(TAG_TERMS_LOGS,"TermsAndCondition Logs on onCreate()");

    }
}
