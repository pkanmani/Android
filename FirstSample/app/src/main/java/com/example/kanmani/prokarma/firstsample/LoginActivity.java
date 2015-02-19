package com.example.kanmani.prokarma.firstsample;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends ActionBarActivity{

    public  static  final String TAG_LOGIN =LoginActivity.class.getSimpleName();

    private Button mLogin_Btn;
    private Button mPassWord_Btn;
    private EditText mUserName_Et;
    private EditText mPass_Et;


    private SuccessStatusImplementable successStatusImplementable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.v(TAG_LOGIN,"onCreate() in LoginActivity");
         mLogin_Btn =(Button)findViewById(R.id.LoginButtonId);
         mPassWord_Btn = (Button)findViewById(R.id.CancelButtonId);
         mUserName_Et = (EditText)findViewById(R.id.userNameText);
         mPass_Et = (EditText)findViewById(R.id.passWordText);


/*
        FragmentManager manager = getFragmentManager();
        if(manager !=null)
        {
            FragmentTransaction ft =manager.beginTransaction();
            LogoFragment logoFragment = new LogoFragment();
            successStatusImplementable = logoFragment;
            Bundle bundle = new Bundle();
            bundle.putString("UserText","Hi");
            bundle.putParcelable();
            logoFragment.setArguments(bundle);
            ft.add(R.id.FirstSample_FL_Fragment_Id,logoFragment);
            ft.commit();
            successStatusImplementable.onSuccess(bundle);
        }
*/


            mLogin_Btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent loginIntent = new Intent(getApplicationContext(), SuccessActivity.class);
                    loginIntent.putExtra("UserName", mUserName_Et.getText().toString());
                    startActivityForResult(loginIntent, 1);
                }
            });


        mPassWord_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUserName_Et.setText("");
                mPass_Et.setText("");

            }
        });




    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK && requestCode==1)
        {
            if(data.hasExtra("Key1"))
            {
                Log.v(TAG_LOGIN,"Inside the TextView :: "+data.getExtras().getString("Key1"));
               Toast.makeText(getApplicationContext(),data.getExtras().getString("Key1"),Toast.LENGTH_LONG).show();
            }
        }

    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.v(TAG_LOGIN,"onStart() in LoginActivity");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG_LOGIN,"onResume() in LoginActivity");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TAG_LOGIN,"onPause() in LoginActivity");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(TAG_LOGIN,"onStop() in LoginActivity");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG_LOGIN,"onDestroy() in LoginActivity");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v(TAG_LOGIN,"onRestart() in LoginActivity");
    }


}
