package com.example.kanmani.prokarma.firstsample;

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
public class SecondFragment extends Fragment {

    private static final String TAG_SECOND_FRAGMENT_LOG = SecondFragment.class.getSimpleName();

    private EditText mEditText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab2fragment,container,false);
        mEditText = (EditText)v.findViewById(R.id.FirstSample_Frament_Tab2_ET_ID_Id);
        return v;
    }

    public void setTextValue(Bundle bundle)
    {
      bundle = getArguments();
        if(bundle != null) {
           String textValueFragment2 = bundle.getString("FragmentOneText");
            mEditText.setText(textValueFragment2);
            Log.v(TAG_SECOND_FRAGMENT_LOG,"TextValue of Second Fragment : "+textValueFragment2);
        }
    }
}
