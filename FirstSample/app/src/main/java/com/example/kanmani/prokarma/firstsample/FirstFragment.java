package com.example.kanmani.prokarma.firstsample;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * Created by Kanmani on 1/31/2015.
 */
public class FirstFragment extends Fragment {
    public static final String TAG_FIRST_FRAGMENTS_LOGS = FirstFragment.class.getSimpleName();
    private EditText mEditText;
    ICallbackTabs iCallbackTabs;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.tab1fragment,container,false);
        mEditText = (EditText)v.findViewById(R.id.FirstSample_Frament_Tab1_ET_ID);
        return v;
    }

    @Override
    public void onStart() {
        super.onStart();
        Bundle bundle =getArguments();
        if(bundle !=null) {
            String defaulttext = bundle.get("Hi").toString();
            mEditText.setText(defaulttext);
            Log.v(TAG_FIRST_FRAGMENTS_LOGS, "FirstFragment logs" + defaulttext);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            iCallbackTabs =(ICallbackTabs)activity;
        }
        catch (ClassCastException e)
        {
            throw new ClassCastException(activity.toString()+ " Must implement TextClicked");
        }
    }

    public void sendDataToActivity()
    {
        Bundle bundle = new Bundle();
        String FragmentText = mEditText.getText().toString();
        bundle.putString("FragmentOneText",FragmentText);
        iCallbackTabs.getFragmentData(bundle);
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }


}
