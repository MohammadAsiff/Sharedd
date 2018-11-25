package com.example.sys.sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class IntentActivity extends AppCompatActivity {
      public TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_intent );
        t=findViewById( R.id.textView );
        SharedPreferences preferences=getSharedPreferences( "prefs",MODE_PRIVATE );
        String s1=preferences.getString( MainActivity.NAME," " );
        String s2=preferences.getString( MainActivity.COLLEGE," " );
        String s3=preferences.getString( MainActivity.BRANCH," " );
        t.setText( s1+"\n"+s2+"\n"+s3 );
    }
}
