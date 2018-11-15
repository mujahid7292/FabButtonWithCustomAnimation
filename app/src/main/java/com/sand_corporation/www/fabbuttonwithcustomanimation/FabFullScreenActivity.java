package com.sand_corporation.www.fabbuttonwithcustomanimation;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class FabFullScreenActivity extends AppCompatActivity {

    private FloatingActionButton fab_Main;
    private LinearLayout fab_chat, fab_mail, fab_call;
    private CoordinatorLayout coordinatorLayOut;
    private Animation fab_open,fab_close,fab_rotate_clock_wise,
            fab_rotate_anti_clock_wise;
    private boolean is_open = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fab_full_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        coordinatorLayOut = findViewById(R.id.coordinatorLayOut);

        fab_Main = findViewById(R.id.fab_Main);
        fab_chat = findViewById(R.id.fab_chat);
        fab_mail = findViewById(R.id.fab_mail);
        fab_call = findViewById(R.id.fab_call);

        fab_open = AnimationUtils.loadAnimation(getBaseContext(),R.anim.fab_open);
        fab_close = AnimationUtils.loadAnimation(getBaseContext(),R.anim.fab_close);
        fab_rotate_clock_wise = AnimationUtils.loadAnimation(getBaseContext()
                ,R.anim.fab_rotate_clock_wise);
        fab_rotate_anti_clock_wise = AnimationUtils.loadAnimation(getBaseContext()
                ,R.anim.fab_rotate_anti_clock_wise);

        fab_Main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (is_open){
                    fab_chat.startAnimation(fab_close);
                    fab_mail.startAnimation(fab_close);
                    fab_call.startAnimation(fab_close);
                    fab_Main.startAnimation(fab_rotate_anti_clock_wise);

                    fab_chat.setClickable(false);
                    fab_mail.setClickable(false);
                    fab_call.setClickable(false);
                    coordinatorLayOut.setBackgroundColor(0x00000000);

                    is_open =false;

                }else {
                    coordinatorLayOut.setBackgroundColor(getResources()
                            .getColor(R.color.fab_full_screen));
                    fab_chat.startAnimation(fab_open);
                    fab_mail.startAnimation(fab_open);
                    fab_call.startAnimation(fab_open);
                    fab_Main.startAnimation(fab_rotate_clock_wise);

                    fab_chat.setClickable(true);
                    fab_mail.setClickable(true);
                    fab_call.setClickable(true);

                    is_open =true;
                }
            }
        });

        fab_chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FabFullScreenActivity.this, "Chat Button Clicked",
                        Toast.LENGTH_LONG).show();
            }
        });

        fab_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FabFullScreenActivity.this, "Call Button Clicked",
                        Toast.LENGTH_LONG).show();
            }
        });

        fab_mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FabFullScreenActivity.this, "Mail Button Clicked",
                        Toast.LENGTH_LONG).show();
            }
        });


    }

}
