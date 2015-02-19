package com.example.kanmani.prokarma.firstsample;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.PopupWindow;
import android.graphics.drawable.ColorDrawable;


public class DynamicViewsActivity extends ActionBarActivity implements View.OnClickListener {

    int textview_Id = 1;
    PopupWindow popupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_views);
        LinearLayout rL = (LinearLayout) findViewById(R.id.FirstSample_Dynamic_Views_RL_Holder_Id);
        RelativeLayout layout = new RelativeLayout(this);
        TextView textView = new TextView(this);
        textView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        textView.setText("DynamicTextView");
        textView.setTextColor(Color.BLUE);
        rL.addView(textView);

        Button button = new Button(this);
        button.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        button.setText("Click Me");
        rL.addView(button);
        button.setOnClickListener(this);

    }




    @Override
    public void onClick(View v) {
      //  initiatePopupWindow();
        showAlertDialog();
    }

    public void initiatePopupWindow() {
        LayoutInflater inflater = (LayoutInflater) DynamicViewsActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.screen_popup, (ViewGroup) findViewById(R.id.popup_element));
        popupWindow = new PopupWindow(layout, 900, 300, true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.GRAY));
        popupWindow.showAtLocation(layout, Gravity.CENTER, 0, 0);
    }

    public void showAlertDialog()
    {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setMessage("****Alert Dialog****");
        alertDialog.show();
    }
}
