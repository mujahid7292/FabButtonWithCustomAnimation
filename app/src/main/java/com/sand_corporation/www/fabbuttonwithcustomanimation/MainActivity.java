package com.sand_corporation.www.fabbuttonwithcustomanimation;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton fab_main, fab_chat, fab_mail, fab_call;
    private Animation fab_open,fab_close,fab_rotate_clock_wise,
            fab_rotate_anti_clock_wise;

    private boolean is_open = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab_main = findViewById(R.id.fab_main);
        fab_chat = findViewById(R.id.fab_chat);
        fab_mail = findViewById(R.id.fab_mail);
        fab_call = findViewById(R.id.fab_call);

        fab_open = AnimationUtils.loadAnimation(getBaseContext(),R.anim.fab_open);
        fab_close = AnimationUtils.loadAnimation(getBaseContext(),R.anim.fab_close);
        fab_rotate_clock_wise = AnimationUtils.loadAnimation(getBaseContext()
                ,R.anim.fab_rotate_clock_wise);
        fab_rotate_anti_clock_wise = AnimationUtils.loadAnimation(getBaseContext()
                ,R.anim.fab_rotate_anti_clock_wise);

        fab_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (is_open){

                    fab_chat.startAnimation(fab_close);
                    fab_mail.startAnimation(fab_close);
                    fab_call.startAnimation(fab_close);
                    fab_main.startAnimation(fab_rotate_anti_clock_wise);

                    fab_chat.setClickable(false);
                    fab_mail.setClickable(false);
                    fab_call.setClickable(false);

                    is_open =false;

                }else {
                    fab_chat.startAnimation(fab_open);
                    fab_mail.startAnimation(fab_open);
                    fab_call.startAnimation(fab_open);
                    fab_main.startAnimation(fab_rotate_clock_wise);

                    fab_chat.setClickable(true);
                    fab_mail.setClickable(true);
                    fab_call.setClickable(true);

                    is_open =true;
                }
            }
        });
    }
}
