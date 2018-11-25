package com.example.sys.sharedpreferences;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ExampleDB extends SQLiteOpenHelper {
    private static final  String DATABASE_NAME ="sample_db";
    private static final  String TABLE_NAME ="Student";
    private static final  String NAME ="USER_NAME";
    private static final  String COLLEGE ="COLLEGE_NAME";
    private static final  String BRANCH ="BRANCH_NAME";

    public ExampleDB(Context context) {
        super( context, DATABASE_NAME,null, 1 );
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL( "Create table "+TABLE_NAME +"("+NAME+" TEXT,"+COLLEGE+" TEXT,"
                +BRANCH+" TEXT"+")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
       sqLiteDatabase.execSQL( "DROP TABLE IF EXISTS"+TABLE_NAME );
       onCreate( sqLiteDatabase );
    }
    public void insert(String s1,String s2,String s3)
    {
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        ContentValues contentValues=new ContentValues(  );
        contentValues.put( NAME,s1 );
        contentValues.put( COLLEGE,s2 );
        contentValues.put( BRANCH,s3 );
        sqLiteDatabase.insert( TABLE_NAME,null,contentValues );
    }
}
