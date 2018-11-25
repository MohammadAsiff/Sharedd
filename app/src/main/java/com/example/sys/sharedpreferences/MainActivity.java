package com.example.sys.sharedpreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
        public  static final String NAME="NAME";
        public  static final String COLLEGE="COLLEGE";
        public  static final String BRANCH="BRANCH";
        EditText et1,et2,et3;
        Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        et1=findViewById( R.id.e1 );
        et2=findViewById( R.id.e2 );
        et3=findViewById( R.id.e3 );
        b1=findViewById( R.id.b );
        b1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isValid =true;
                String s1=et1.getText().toString().trim();
                String s2=et2.getText().toString().trim();
                String s3=et3.getText().toString().trim();
                if (s1.isEmpty()){
                    isValid=false;
                    et1.setError( "Please enter Name" );
                }
                if (s2.isEmpty()){
                    isValid=false;
                    et2.setError( "Enter College Name" );
                }
                if (s3.isEmpty()){
                    isValid=false;
                    et3.setError( "Enter Branch Name" );
                }
                if(isValid){
                    SharedPreferences preferences=getSharedPreferences( "prefs",MODE_PRIVATE );
                    SharedPreferences.Editor editor=preferences.edit();
                    editor.putString( NAME,s1 );
                    editor.putString( COLLEGE,s2 );
                    editor.putString( BRANCH,s3 );
                    editor.apply();
                    ExampleDB db=new ExampleDB( MainActivity.this );
                    db.insert(s1,s2,s3);
                    Intent i=new Intent( MainActivity.this,IntentActivity.class );
                    startActivity( i );

                }
            }
        } );

    }
}
