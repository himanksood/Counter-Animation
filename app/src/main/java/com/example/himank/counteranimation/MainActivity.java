package com.example.himank.counteranimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Animation.AnimationListener
{
    private TextView t1;
    AlphaAnimation fadeIn, fadeOut;

    private static int count = 0, finalValue = 20;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




                t1 = (TextView) findViewById(R.id.t1);

                fadeIn = new AlphaAnimation(0.0f, 1.0f);
                fadeOut = new AlphaAnimation(1.0f, 0.0f);

                fadeIn.setDuration(1000);
                fadeIn.setFillAfter(true);
                fadeOut.setDuration(1000);
                fadeOut.setFillAfter(true);

                fadeIn.setAnimationListener(this);
                fadeOut.setAnimationListener(this);
                t1.startAnimation(fadeIn);
                t1.startAnimation(fadeOut);

            }

            @Override
            public void onAnimationEnd(Animation arg0) {
                //  Auto-generated method

                Log.i("mini", "Count:" + count);

                runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        //  Auto-generated method
                        t1.setText("" + count );
                    }
                });

                if (count == finalValue)
                {

                    t1.setText(""+ finalValue);

                }
                else
                {
                    ++count;
                    t1.startAnimation(fadeIn);
                    t1.startAnimation(fadeOut);
                }

            }


            @Override
            public void onAnimationRepeat(Animation arg0) {
                // Auto generated method
            }

            @Override
            public void onAnimationStart(Animation arg0) {
                // Auto generated Method

            }

        }

