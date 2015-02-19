package com.example.kanmani.prokarma.firstsample;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View.OnTouchListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;


public class FrameActivity extends ActionBarActivity implements OnTouchListener {

    private static final String TAG_FRAME_LOG = FrameActivity.class.getSimpleName();



    private Button mButton;
    private ViewGroup mRootLayout;
    private int _xDelta;
    private int _yDelta;
    private View mTopLeftView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame);
        mButton = (Button) findViewById(R.id.Center_View_Id);
        mRootLayout = (ViewGroup) findViewById(R.id.FirstSample_LayoutSamples_ViewHolder_RL_Id);
        mTopLeftView = (View) findViewById(R.id.FirstSample_LayoutSamples_TopLeft_View_ID);
       //mRootLayout.setOnTouchListener(this);
        mButton.setOnTouchListener(this);

    }


    @Override
    public boolean onTouch(View view, MotionEvent event) {
        int x = (int)event.getX();
        int y = (int)event.getY();
        int topMargin=0;
        int leftMargin=0;

        int boundary_x;
        int boundary_y;
        boolean buttonTouch = false;
        Log.v(TAG_FRAME_LOG,"x "+x+" y "+y);
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                RelativeLayout.LayoutParams buttonParams = (RelativeLayout.LayoutParams) mButton.getLayoutParams();
                int button_height = mButton.getHeight();
                int button_width = mButton.getWidth();
               topMargin = buttonParams.topMargin;
               leftMargin = buttonParams.leftMargin;

                boundary_x = leftMargin+button_width;
                boundary_y = topMargin+button_height;

                Log.v(TAG_FRAME_LOG, "\n" + "button_height : " + button_height + "\n" + " button_width : " + button_width
                                        +"\n"+"leftMargin : "+leftMargin+"\n" +"topMargin : "+"\n"+topMargin);
                if ((x < boundary_x && x > leftMargin) && ( y < boundary_y && y > topMargin))
                    buttonTouch = true;
                else
                    buttonTouch = false;
                break;
            case MotionEvent.ACTION_POINTER_DOWN:

                break;
            case MotionEvent.ACTION_UP:

                break;
            case MotionEvent.ACTION_POINTER_UP:

                break;
            case MotionEvent.ACTION_MOVE:

                    RelativeLayout.LayoutParams leftViewParams = (RelativeLayout.LayoutParams) mTopLeftView.getLayoutParams();
                    leftViewParams.width = x+leftMargin;
                    leftViewParams.height = y+topMargin;
                    mTopLeftView.setLayoutParams(leftViewParams);

                break;

        }
        Log.v(TAG_FRAME_LOG, "OnTouch() in FrameActivity");
        mRootLayout.invalidate();
        return true;
    }
}
