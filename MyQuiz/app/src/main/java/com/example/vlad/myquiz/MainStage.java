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

/**
 * Created by Vlad on 20.12.2017.
 */

public class MainStage extends Activity {

    Cursor c = null;
    //FilmsDBHelper myDbHelper = new FilmsDBHelper(MainStage.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_stage);
       // getActionBar().setDisplayHomeAsUpEnabled(true);

       /* try {
            myDbHelper.openDataBase();
        } catch (SQLiteException sqle) {
            throw sqle;
        }*/
        ((Button) findViewById(R.id.button_stage_easy_1)).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                FilmsDBHelper myDbHelper = new FilmsDBHelper(MainStage.this);
                try {
                    myDbHelper.openDataBase();
                } catch (SQLiteException sqle) {
                    throw sqle;
                }
                c = myDbHelper.query("EZ_FILMS",null,null,null,null,null,null);
                c.moveToFirst();
                int item_id = c.getInt(0);
                String item_name = c.getString(1);
                String item_url = c.getString(2);
                c.moveToNext();
                Toast.makeText(MainStage.this,
                        "_id1: "+ item_id + "\n" +
                                "f_name1: " + item_name + "\n" +
                                "f_url1: " + item_url+ "\n" +"_id2: "+c.getString(0)+"\n"  + "f_name2: " + c.getString(1) + "\n" + "f_url2: " + c.getString(2),
                        Toast.LENGTH_LONG).show();
                String item_name2 = c.getString(1);
                c.moveToNext();
                String item_name3 = c.getString(1);
                c.moveToNext();
                String item_name4 = c.getString(1);
                c.close();
                Intent intent = new Intent(MainStage.this, MainAns.class);
                intent.putExtra("fname", item_name);
                intent.putExtra("fname2", item_name2);
                intent.putExtra("fname3", item_name3);
                intent.putExtra("fname4", item_name4);
                intent.putExtra("furl", item_url);
                startActivity(intent);
            }
        });
    }

    public void onClick(View view) {
        Intent intent = new Intent(MainStage.this, MainAns.class);
        startActivity(intent);
    }
}
