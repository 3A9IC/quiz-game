package com.example.vlad.myquiz;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
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
        MakeLvls();
        getActionBar().setDisplayHomeAsUpEnabled(true);
        
    }

    public void MakeLvls(){
        ((Button) findViewById(R.id.button_stage_easy_1)).setOnClickListener(new OnClickListener(){
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
                /*Toast.makeText(MainStage.this,
                        "_id1: "+ item_id + "\n" +
                                "f_name1: " + item_name + "\n" +
                                "f_url1: " + item_url+ "\n" +"_id2: "+c.getString(0)+"\n"  + "f_name2: " + c.getString(1) + "\n" + "f_url2: " + c.getString(2),
                        Toast.LENGTH_LONG).show();*/
                String item_name2 = c.getString(1);
                c.moveToNext();
                String item_name3 = c.getString(1);
                c.moveToNext();
                String item_name4 = c.getString(1);

                c.moveToPosition(10);
                String item_name1_1 = c.getString(1);
                String item_url1_1 = c.getString(2);
                // String item_url1_1 = "https://lh6.googleusercontent.com/ygXBWfrwZbuTAXJSIXS8sJSJXvEuog6jekLXQl20p7GcWChTlXVkhqiLFOd84GC9Ym6CLLMzZb9CbW2p3mQt=w1920-h974-rw";
                c.moveToNext();
                String item_name1_2 = c.getString(1);
                c.moveToPosition(13);
                String item_name1_3 = c.getString(1);
                c.moveToPosition(5);
                String item_name1_4 = c.getString(1);

                c.moveToPosition(13);
                String item_name2_1 = c.getString(1);
                String item_url2_1 = c.getString(2);
                Toast.makeText(MainStage.this,
                        "f_name1: " + item_name2_1 + "\n" +
                                "f_url1: " + item_url2_1,
                        Toast.LENGTH_LONG).show();
                // String item_url1_1 = "https://lh6.googleusercontent.com/ygXBWfrwZbuTAXJSIXS8sJSJXvEuog6jekLXQl20p7GcWChTlXVkhqiLFOd84GC9Ym6CLLMzZb9CbW2p3mQt=w1920-h974-rw";
                c.moveToNext();
                String item_name2_2 = c.getString(1);
                c.moveToPosition(3);
                String item_name2_3 = c.getString(1);
                c.moveToPosition(9);
                String item_name2_4 = c.getString(1);

                c.close();
                Intent intent = new Intent(MainStage.this, MainAns.class);
                intent.putExtra("fname", item_name);
                intent.putExtra("fname2", item_name2);
                intent.putExtra("fname3", item_name3);
                intent.putExtra("fname4", item_name4);
                intent.putExtra("furl", item_url);

                intent.putExtra("fname1_1", item_name1_1);
                intent.putExtra("fname1_2", item_name1_2);
                intent.putExtra("fname1_3", item_name1_3);
                intent.putExtra("fname1_4", item_name1_4);
                intent.putExtra("furl1_1", item_url1_1);

                intent.putExtra("fname2_1", item_name2_1);
                intent.putExtra("fname2_2", item_name2_2);
                intent.putExtra("fname2_3", item_name2_3);
                intent.putExtra("fname2_4", item_name2_4);
                intent.putExtra("furl2_1", item_url2_1);

                //startActivity(intent);
                startActivityForResult(intent, 1);
            }
        }
        );


        ((Button) findViewById(R.id.button_stage_easy_2)).setOnClickListener(new OnClickListener(){


            @Override
            public void onClick(View view) {
                Toast.makeText(MainStage.this, "ВТОРОЙ ОБРАБОТЧИК", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainStage.this, MainAns.class);
                startActivity(intent);
            }
        });
    }



  /*  public void onClick(View view) {
        Intent intent = new Intent(MainStage.this, MainAns.class);
        startActivity(intent);
    }*/

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if (data == null) {return;}
       // String score = data.getStringExtra("score");
        int score = data.getIntExtra("score", 0);
        String str = Integer.toString(score);
        Toast.makeText(this, "Правильных ответов: "+str, Toast.LENGTH_SHORT).show();
        //Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
    }
    public void onClick2(View view) {
    }
}
