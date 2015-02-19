package com.example.kanmani.prokarma.firstsample;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.provider.ContactsContract.Contacts;


public class SuccessActivity extends ActionBarActivity implements OnClickListener{

    public  static  final String TAG_LOG_SUCCESS=LoginActivity.class.getSimpleName();

    private EditText mUserName_ET;
    private EditText mDefaultUserNameText_ET;
    private TextView mLogoText_TV;
    private String mUserName;
    private String defaultUserName;
    private Button mShowContactBtn;
    private Button mNextBtn;
    private ImageView mCamera_IV;
    private Intent intent = new Intent();



    SuccessStatusImplementable successStatusImplementable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);
        Log.v(TAG_LOG_SUCCESS,"onCreate() in SuccessActivity");

        mDefaultUserNameText_ET =  (EditText)findViewById(R.id.FirstSample_UserName_ET_Id);
        defaultUserName = mDefaultUserNameText_ET.getText().toString();
        mLogoText_TV =(TextView)findViewById(R.id.logoMsg_TE_Id);

        Intent loginIntent=getIntent();
        if(loginIntent.getStringExtra("UserName")!=null) {
            mUserName = loginIntent.getStringExtra("UserName");
            mUserName_ET = (EditText) findViewById(R.id.FirstSample_UserName_ET_Id);
            mUserName_ET.setText(defaultUserName + "****" + mUserName);
        }


        mShowContactBtn =(Button)findViewById(R.id.FirstSample_ShowContacts_Button_Id);
        mCamera_IV =(ImageView)findViewById(R.id.FirstSample_Camera_IV_Id);
        mNextBtn = (Button)findViewById(R.id.FirstSample_Success_Next_Button_Id);
        mNextBtn.setOnClickListener(this);
        mCamera_IV.setOnClickListener(this);
        mShowContactBtn.setOnClickListener(this);


        FragmentManager manager = getFragmentManager();

        if(manager !=null)
        {
            FragmentTransaction ft =manager.beginTransaction();
            LogoFragment logoFragment = new LogoFragment();
            successStatusImplementable = logoFragment;
            Bundle bundle = new Bundle();
            bundle.putString("UserText", mUserName.toString());
            logoFragment.setArguments(bundle);
            ft.add(R.id.FirstSample_FL_Success_Fragment_Id,logoFragment);
            ft.commit();
            successStatusImplementable.onSuccess(bundle);
        }

    }




    @Override
    public void finish() {
        Log.v(TAG_LOG_SUCCESS,"finish() in SuccessActivity");
        Intent data = new Intent();
        data.putExtra("Key1",mUserName_ET.getText().toString());
        setResult(RESULT_OK,data);
        super.finish();
    }

    @Override
    protected void onDestroy() {
        Log.v(TAG_LOG_SUCCESS,"onDestroy() in SuccessActivity");
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.FirstSample_ShowContacts_Button_Id:
                showContacts();
                break;
            case R.id.FirstSample_Success_Next_Button_Id:
                editContacts();
                break;
            case R.id.FirstSample_Camera_IV_Id:
                showCamera();
                break;
            default:
                break;
        }

    }

    private void showCamera()
    {

        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(cameraIntent);
    }

    private void showContacts()
    {
        Intent intent= new Intent(Intent.ACTION_VIEW,Contacts.CONTENT_URI);
        startActivity(intent);
    }

    private void editContacts()
    {
     /*   Intent intentFilter = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.vogella.com"));
        startActivity(intentFilter);*/
        intent.setClass(this,LayoutSamples.class);
    //    Intent layoutIntent = new Intent(this,LayoutSamples.class);
        startActivity(intent);
    }
    @Override
    protected void onStart() {
        super.onStart();

        Log.v(TAG_LOG_SUCCESS,"onStart() in SuccessActivity");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG_LOG_SUCCESS,"onResume() in SuccessActivity");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TAG_LOG_SUCCESS,"onPause() in SuccessActivity");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(TAG_LOG_SUCCESS,"onStop() in SuccessActivity");
    }



    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v(TAG_LOG_SUCCESS,"onRestart() in SuccessActivity");
    }
}
