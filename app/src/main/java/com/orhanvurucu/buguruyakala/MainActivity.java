package com.orhanvurucu.buguruyakala;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView zaman;
    TextView skor;
    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;
    ImageView imageView9;
    ImageView imageView10;
    ImageView imageView11;
    ImageView imageView12;
    ImageView[] imajDizisi;
    int sayac;
    Handler handler;
    Runnable runnable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imajGizle();
        sayac = 0;

        imageView1 = (ImageView) findViewById(R.id.imageView);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        imageView3 = (ImageView) findViewById(R.id.imageView3);
        imageView4 = (ImageView) findViewById(R.id.imageView4);
        imageView5 = (ImageView) findViewById(R.id.imageView5);
        imageView6 = (ImageView) findViewById(R.id.imageView6);
        imageView7 = (ImageView) findViewById(R.id.imageView7);
        imageView8 = (ImageView) findViewById(R.id.imageView8);
        imageView9 = (ImageView) findViewById(R.id.imageView9);
        imageView10 = (ImageView) findViewById(R.id.imageView10);
        imageView11 = (ImageView) findViewById(R.id.imageView11);
        imageView12 = (ImageView) findViewById(R.id.imageView12);

        imajDizisi = new ImageView[]{imageView1,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,imageView9,imageView10,imageView11,imageView12};

        new CountDownTimer(30000,1000){

            @Override
            public void onTick(long millisUntilFinished) {

                zaman = (TextView) findViewById(R.id.textTime);
                zaman.setText("Süre: " + millisUntilFinished / 1000);



            }

            @Override
            public void onFinish() {

                zaman = (TextView) findViewById(R.id.textTime);
                zaman.setText("Zamanın doldu bugur!");
                handler.removeCallbacks(runnable);
                for(ImageView image:imajDizisi){
                    image.setVisibility(View.INVISIBLE);
                }

            }
        }.start();

    }

    public void skoruYukselt(View view){

        skor = (TextView) findViewById(R.id.textScore);
        sayac++;
        skor.setText("Skor: " + sayac);



    }

    public void imajGizle(){

       handler = new Handler();
       runnable = new Runnable() {
           @Override
           public void run() {

               for(ImageView image:imajDizisi){
                   image.setVisibility(View.INVISIBLE);
               }
               Random rnd = new Random();
               int i = rnd.nextInt(11-0);
               imajDizisi[i].setVisibility(View.VISIBLE);
               handler.postDelayed(this,500);

           }
       };
       handler.post(runnable);
    }

}
