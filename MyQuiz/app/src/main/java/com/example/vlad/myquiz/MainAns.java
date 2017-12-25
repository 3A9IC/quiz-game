package com.example.vlad.myquiz;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class MainAns extends Activity {
    public int Score = 0;
    //public  Button p1_button = (Button)findViewById(R.id.button_ans1);
    public ImageView mPhotoImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ans);
        getActionBar().setDisplayHomeAsUpEnabled(true);


        Button p1_button = (Button)findViewById(R.id.button_ans1);
        Button p2_button = (Button)findViewById(R.id.button_ans2);
        Button p3_button = (Button)findViewById(R.id.button_ans3);
        Button p4_button = (Button)findViewById(R.id.button_ans4);

        MakeText(p1_button,p2_button,p3_button,p4_button);
       /* Intent intent = getIntent();

        String fname = intent.getStringExtra("fname");
        String fname2 = intent.getStringExtra("fname2");
        String fname3 = intent.getStringExtra("fname3");
        String fname4 = intent.getStringExtra("fname4");
        String furl = intent.getStringExtra("furl");
        p1_button.setText(fname);
        p2_button.setText(fname2);
        p3_button.setText(fname3);
        p4_button.setText(fname4);

        mPhotoImage = (ImageView)findViewById(R.id.iv_photo);
       Glide.with(getApplicationContext())
                .load(furl)
               //.load("https://avatars2.githubusercontent.com/u/26170743?s=400&u=e32627dab80811b09f4da54d82392f98a0c72c15&v=4")
              // .load("https://lh3.googleusercontent.com/ZoQUaXY7gD1EK7sKiXbrvBObZGjeK7gzpdvETSs91BiZjsQMsNYvZOs2v84ctaEPboEVLV0mG_BYsP6Xfw3d=w1920-h925")
               .placeholder(R.drawable.def)
                .into(mPhotoImage);

       p1_button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Score=+1;
               SecStage();
           }
       });
        p2_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SecStage();
            }
        });
        p3_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SecStage();
            }
        });
        p4_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SecStage();
            }
        });*/



    }
    private void MakeText(Button p1_button,Button p2_button,Button p3_button,Button p4_button){


        Intent intent = getIntent();

        String fname = intent.getStringExtra("fname");
        String fname2 = intent.getStringExtra("fname2");
        String fname3 = intent.getStringExtra("fname3");
        String fname4 = intent.getStringExtra("fname4");
        String furl = intent.getStringExtra("furl");
        p1_button.setText(fname);
        p2_button.setText(fname2);
        p3_button.setText(fname3);
        p4_button.setText(fname4);

        mPhotoImage = (ImageView)findViewById(R.id.iv_photo);
        Glide.with(getApplicationContext())
                .load(furl)
                //.load("https://avatars2.githubusercontent.com/u/26170743?s=400&u=e32627dab80811b09f4da54d82392f98a0c72c15&v=4")
                // .load("https://lh3.googleusercontent.com/ZoQUaXY7gD1EK7sKiXbrvBObZGjeK7gzpdvETSs91BiZjsQMsNYvZOs2v84ctaEPboEVLV0mG_BYsP6Xfw3d=w1920-h925")
                .placeholder(R.drawable.def)
                .into(mPhotoImage);

        p1_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Score++;
                SecStage();
            }
        });
        p2_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SecStage();
            }
        });
        p3_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SecStage();
            }
        });
        p4_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SecStage();
            }
        });
    }
    private void SecStage(){
        Toast.makeText(this, "НИЧОСИ", Toast.LENGTH_SHORT).show();
        Button p1_button = (Button)findViewById(R.id.button_ans1);
        Button p2_button = (Button)findViewById(R.id.button_ans2);
        Button p3_button = (Button)findViewById(R.id.button_ans3);
        Button p4_button = (Button)findViewById(R.id.button_ans4);

        Intent intent = getIntent();

        String fname = intent.getStringExtra("fname1_1");
        String fname2 = intent.getStringExtra("fname1_2");
        String fname3 = intent.getStringExtra("fname1_3");
        String fname4 = intent.getStringExtra("fname1_4");
        String furl = intent.getStringExtra("furl1_1");
        p1_button.setText(fname2);
        p2_button.setText(fname3);
        p3_button.setText(fname);
        p4_button.setText(fname4);

        mPhotoImage = (ImageView)findViewById(R.id.iv_photo);
        Glide.with(getApplicationContext())
                .load(furl)
                //.load("https://avatars2.githubusercontent.com/u/26170743?s=400&u=e32627dab80811b09f4da54d82392f98a0c72c15&v=4")
                // .load("https://lh3.googleusercontent.com/ZoQUaXY7gD1EK7sKiXbrvBObZGjeK7gzpdvETSs91BiZjsQMsNYvZOs2v84ctaEPboEVLV0mG_BYsP6Xfw3d=w1920-h925")
                .placeholder(R.drawable.def)
                .into(mPhotoImage);

        p1_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ThirdStage();
            }
        });
        p2_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ThirdStage();
            }
        });
        p3_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Score++;
                ThirdStage();
            }
        });
        p4_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ThirdStage();
            }
        });
        //p1_button.setText("НУ ЧЕ ЕПТА");

    }

    private void ThirdStage(){
        Toast.makeText(this, "THIRD obrab ", Toast.LENGTH_SHORT).show();
        Button p1_button = (Button)findViewById(R.id.button_ans1);
        Button p2_button = (Button)findViewById(R.id.button_ans2);
        Button p3_button = (Button)findViewById(R.id.button_ans3);
        Button p4_button = (Button)findViewById(R.id.button_ans4);

        Intent intent = getIntent();

        String fname = intent.getStringExtra("fname2_1");
        String fname2 = intent.getStringExtra("fname2_2");
        String fname3 = intent.getStringExtra("fname2_3");
        String fname4 = intent.getStringExtra("fname2_4");
        String furl = intent.getStringExtra("furl2_1");
        p1_button.setText(fname2);
        p2_button.setText(fname);
        p3_button.setText(fname4);
        p4_button.setText(fname3);

        mPhotoImage = (ImageView)findViewById(R.id.iv_photo);
        Glide.with(getApplicationContext())
                .load(furl)
                //.load("https://avatars2.githubusercontent.com/u/26170743?s=400&u=e32627dab80811b09f4da54d82392f98a0c72c15&v=4")
                // .load("https://lh3.googleusercontent.com/ZoQUaXY7gD1EK7sKiXbrvBObZGjeK7gzpdvETSs91BiZjsQMsNYvZOs2v84ctaEPboEVLV0mG_BYsP6Xfw3d=w1920-h925")
                .placeholder(R.drawable.def)
                .into(mPhotoImage);

        p1_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("score", Score);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
        p2_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Score++;
                Intent intent = new Intent();
                intent.putExtra("score", Score);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
        p3_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("score", Score);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
        p4_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("score", Score);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
