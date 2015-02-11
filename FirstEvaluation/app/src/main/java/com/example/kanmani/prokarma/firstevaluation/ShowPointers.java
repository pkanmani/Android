package com.example.kanmani.prokarma.firstevaluation;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;


public class ShowPointers extends ActionBarActivity implements View.OnTouchListener{

    private static final String TAG_POINTER_LOG = ShowPointers.class.getSimpleName();
    private ViewGroup mRootLayout;
    private View mTopLeftView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_pointers);
        mRootLayout = (ViewGroup) findViewById(R.id.FirstEvaluation_ViewHolder_RL_Id);
        mTopLeftView = (View) findViewById(R.id.FirstEvaluation_TopLeft_View_ID);
        mRootLayout.setOnTouchListener(this);

    }


    @Override
    public boolean onTouch(View view, MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()) {

            case MotionEvent.ACTION_MOVE:
                RelativeLayout.LayoutParams leftViewParams = (RelativeLayout.LayoutParams) mTopLeftView.getLayoutParams();
                leftViewParams.width = x;
                leftViewParams.height = y;
                mTopLeftView.setLayoutParams(leftViewParams);
                break;

        }
        mRootLayout.invalidate();
        return true;
    }
}
