package com.example.vlad.myquiz;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.vlad.myquiz.data.FilmsDBHelper;

import java.io.IOException;

public class MainActivity extends Activity {

    Cursor c = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((Button) findViewById(R.id.buttonStart)).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                FilmsDBHelper myDbHelper = new FilmsDBHelper(MainActivity.this);
                try {
                    myDbHelper.createDataBase();
                } catch (IOException ioe){
                    throw new Error("Unable to create database");
                }
                try {
                    myDbHelper.openDataBase();
                } catch (SQLiteException sqle){
                    throw  sqle;
                }
                Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
                //c.close();
                Intent intent = new Intent(MainActivity.this, MainStage.class);
                startActivity(intent);
                /*
                c = myDbHelper.query("EZ_FILMS",null,null,null,null,null,null);
                if (c.moveToFirst()){
                    do {
                        Toast.makeText(MainActivity.this,
                                "_id: "+ c.getString(0) + "\n" +
                        "f_name: " + c.getString(1) + "\n" +
                        "f_url: " + c.getString(2),
                                Toast.LENGTH_LONG).show();
                    } while (c.moveToNext());
                }*/
            }
            //Intent intent = new Intent(MainActivity.this, MainStage.class);
           // startActivity(intent);
        });
    }

   /* public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this, MainStage.class);
        startActivity(intent);
    }*/
}
