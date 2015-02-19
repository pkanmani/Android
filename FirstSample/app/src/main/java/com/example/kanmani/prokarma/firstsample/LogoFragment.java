package com.example.kanmani.prokarma.firstsample;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * Created by Kanmani on 1/21/2015.
 */
public class LogoFragment extends Fragment implements SuccessStatusImplementable{

    public static final String TAG_FRAGMENTS_LOGS = LogoFragment.class.getSimpleName();

    private TextView mLogoText;
    private String mdefaultText;
    String logo_text;
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.v(TAG_FRAGMENTS_LOGS,"onAttach() in the LogoFragment");

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.v(TAG_FRAGMENTS_LOGS,"onCreate() in the LogoFragment");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        Log.v(TAG_FRAGMENTS_LOGS,"onCreateView() in the LogoFragment");
        View v = inflater.inflate(R.layout.logo,container,false);
        mLogoText =(TextView)v.findViewById(R.id.logoMsg_TE_Id);
        return v;

    }

    @Override
    public void onSuccess(Bundle message) {
        Log.d(TAG_FRAGMENTS_LOGS,"onSuccess message is "+message);
        message = getArguments();
        if(message!=null) {
             logo_text = getArguments().get("UserText").toString();
        }

    }



    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.v(TAG_FRAGMENTS_LOGS,"onActivityCreated() in the LogoFragment");
    }

    @Override
    public void onStart() {
        super.onStart();
        mdefaultText = mLogoText.getText().toString();
        if(logo_text!=null) {
            mLogoText.setText(mdefaultText + "***" + logo_text);
        }
        else {
            logo_text = " ";
            mLogoText.setText(mdefaultText + "***" + logo_text);
        }
        Log.v(TAG_FRAGMENTS_LOGS, "onStart() in the LogoFragment");
    }




    @Override
    public void onResume() {
        super.onResume();
        Log.v(TAG_FRAGMENTS_LOGS,"onResume() in the LogoFragment");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.v(TAG_FRAGMENTS_LOGS,"onPause() in the LogoFragment");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.v(TAG_FRAGMENTS_LOGS,"onStop() in the LogoFragment");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.v(TAG_FRAGMENTS_LOGS,"onDestroyView() in the LogoFragment");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.v(TAG_FRAGMENTS_LOGS,"onDestroy() in the LogoFragment");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.v(TAG_FRAGMENTS_LOGS,"onDetach() in the LogoFragment");
    }
}
