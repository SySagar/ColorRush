package com.example.colorrush

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    var counter : Int =0
    var ball_code =0
    var bat_code =0
    var score : Int =0;
    var rnds=0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main)

        val score_card=findViewById<TextView>(R.id.nos)
        val handler = Handler()
        val animationView : LottieAnimationView= findViewById(R.id.burst);
        val Ball=findViewById<ImageView>(R.id.ball)



        GlobalScope.launch {
            while(true)
            {
                animationView.visibility=View.INVISIBLE
                rnds = (1..4).random()

                if (rnds == 1) {
                    ball_code = 1;
                } else
                    if (rnds == 2) {
                        ball_code = 2;
                    } else
                        if (rnds == 3) {
                            ball_code = 3;
                        } else
                            if (rnds == 4) {
                                ball_code = 4;
                            }

                Log.d("msge",""+rnds)
                val ball_animation: Animation =
                    AnimationUtils.loadAnimation(getApplicationContext(), R.anim.ball_down);
                handler.post { //Do something after delay


                    if (ball_code == 3) {

                        Ball.setImageResource(R.drawable.green_ball)

                    }
                    if (ball_code == 2) {

                        Ball.setImageResource(R.drawable.blue_ball)
                    }
                    if (ball_code == 1) {
                        Ball.setImageResource(R.drawable.yellow_ball)
                    }
                    if (ball_code == 4) {
                        Ball.setImageResource(R.drawable.red_ball)
                    }


                }
                Ball.startAnimation(ball_animation)
                delay(3000)
                if (ball_code == bat_code)
                {score++

                    handler.post {
                        animationView.visibility=View.VISIBLE
                        animationView.playAnimation()}
                }
                else
                    score--
                handler.post {

                    score_card.setText("" + score)

                }
            }

        }
    }


    fun leftRotate(view : View)
    {
        counter--;
        val redBox=findViewById<ImageView>(R.id.redBox)
        val blueBox=findViewById<ImageView>(R.id.blueBox)
        val greenBox=findViewById<ImageView>(R.id.greenBox)
        val yellowBox=findViewById<ImageView>(R.id.yellowBox)

        val animation_ul : Animation =AnimationUtils.loadAnimation(getApplicationContext(), R.anim.left_rotate_ul);
        redBox.startAnimation(animation_ul);
        val animation_ld : Animation =AnimationUtils.loadAnimation(getApplicationContext(), R.anim.left_rotate_ld);
        yellowBox.startAnimation(animation_ld);
        val animation_dr : Animation =AnimationUtils.loadAnimation(getApplicationContext(), R.anim.left_rotate_dr);
        blueBox.startAnimation(animation_dr);
        val animation_ru : Animation =AnimationUtils.loadAnimation(getApplicationContext(), R.anim.left_rotate_ru);
        greenBox.startAnimation(animation_ru);

        Log.d("out",""+counter)


        if((counter%4)==-1) {
            Handler().postDelayed(Runnable {
                greenBox.setImageResource(R.drawable.blue);
                blueBox.setImageResource(R.drawable.yellow);
                yellowBox.setImageResource(R.drawable.red);
                redBox.setImageResource(R.drawable.green);
            }, 500)


            bat_code=3;

        }
        else
            if((counter%4)==-2)
            {
                Handler().postDelayed(Runnable {
                    greenBox.setImageResource(R.drawable.yellow);
                    blueBox.setImageResource(R.drawable.red);
                    yellowBox.setImageResource(R.drawable.green);
                    redBox.setImageResource(R.drawable.blue);
                }, 500)


                bat_code=2;

            }
            else
                if((counter%4)==-3)
                {
                    Handler().postDelayed(Runnable {
                        greenBox.setImageResource(R.drawable.red);
                        blueBox.setImageResource(R.drawable.green);
                        yellowBox.setImageResource(R.drawable.blue);
                        redBox.setImageResource(R.drawable.yellow);
                    }, 500)

                    bat_code=1;

                }
                else
                    if(counter%4==0)
                    {

                        Handler().postDelayed(Runnable {
                            greenBox.setImageResource(R.drawable.green);
                            blueBox.setImageResource(R.drawable.blue);
                            yellowBox.setImageResource(R.drawable.yellow);
                            redBox.setImageResource(R.drawable.red);
                        }, 500)

                        bat_code=3;

                    }
                    else
                        if(counter%4==1) {

                            Handler().postDelayed(Runnable {
                                greenBox.setImageResource(R.drawable.red);
                                blueBox.setImageResource(R.drawable.green);
                                yellowBox.setImageResource(R.drawable.blue);
                                redBox.setImageResource(R.drawable.yellow);
                            }, 500)


                            bat_code=1;

                        }
                        else
                            if(counter%4==2)
                            {
                                bat_code=2

                                Handler().postDelayed(Runnable {
                                    greenBox.setImageResource(R.drawable.yellow);
                                    blueBox.setImageResource(R.drawable.red);
                                    yellowBox.setImageResource(R.drawable.green);
                                    redBox.setImageResource(R.drawable.blue);
                                    Log.d("msge","end")
                                }, 500)
                            }
                            else
                                if(counter%4==3)
                                {
                                    bat_code=3

                                    Handler().postDelayed(Runnable {
                                        greenBox.setImageResource(R.drawable.blue);
                                        blueBox.setImageResource(R.drawable.yellow);
                                        yellowBox.setImageResource(R.drawable.red);
                                        redBox.setImageResource(R.drawable.green);
                                        Log.d("msge","end")
                                    }, 500)
                                }

    }

    fun rightRotate(view : View)
    {

        counter++;
        val redBox=findViewById<ImageView>(R.id.redBox)
        val blueBox=findViewById<ImageView>(R.id.blueBox)
        val greenBox=findViewById<ImageView>(R.id.greenBox)
        val yellowBox=findViewById<ImageView>(R.id.yellowBox)

        val animation_ur : Animation =AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right_rotate_ur);
        redBox.startAnimation(animation_ur);
        val animation_rd : Animation =AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right_rotate_rd);
        greenBox.startAnimation(animation_rd);
        val animation_dl : Animation =AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right_rotate_dl);
        blueBox.startAnimation(animation_dl);
        val animation_lu : Animation =AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right_rotate_lu);
        yellowBox.startAnimation(animation_lu);

        Log.d("out",""+counter)


        if(counter%4==1) {

            Handler().postDelayed(Runnable {
                greenBox.setImageResource(R.drawable.red);
                blueBox.setImageResource(R.drawable.green);
                yellowBox.setImageResource(R.drawable.blue);
                redBox.setImageResource(R.drawable.yellow);
            }, 500)


            bat_code=1;

        }
        else
            if(counter%4==2)
            {
                bat_code=2

                Handler().postDelayed(Runnable {
                    greenBox.setImageResource(R.drawable.yellow);
                    blueBox.setImageResource(R.drawable.red);
                    yellowBox.setImageResource(R.drawable.green);
                    redBox.setImageResource(R.drawable.blue);
                    Log.d("msge","end")
                }, 500)
            }
            else
                if(counter%4==3)
                {
                    bat_code=3

                    Handler().postDelayed(Runnable {
                        greenBox.setImageResource(R.drawable.blue);
                        blueBox.setImageResource(R.drawable.yellow);
                        yellowBox.setImageResource(R.drawable.red);
                        redBox.setImageResource(R.drawable.green);
                        Log.d("msge","end")
                    }, 500)
                }
                else
                    if(counter%4==0)
                    {
                        bat_code=4

                        Handler().postDelayed(Runnable {
                            greenBox.setImageResource(R.drawable.green);
                            blueBox.setImageResource(R.drawable.blue);
                            yellowBox.setImageResource(R.drawable.yellow);
                            redBox.setImageResource(R.drawable.red);
                            Log.d("msge","end")
                        }, 500)
                    }
                    else
                        if((counter%4)==-1) {
                            Handler().postDelayed(Runnable {
                                greenBox.setImageResource(R.drawable.blue);
                                blueBox.setImageResource(R.drawable.yellow);
                                yellowBox.setImageResource(R.drawable.red);
                                redBox.setImageResource(R.drawable.green);
                            }, 500)


                            bat_code=3;

                        }
                        else
                            if((counter%4)==-2)
                            {
                                Handler().postDelayed(Runnable {
                                    greenBox.setImageResource(R.drawable.yellow);
                                    blueBox.setImageResource(R.drawable.red);
                                    yellowBox.setImageResource(R.drawable.green);
                                    redBox.setImageResource(R.drawable.blue);
                                }, 500)


                                bat_code=2;

                            }
                            else
                                if((counter%4)==-3)
                                {
                                    Handler().postDelayed(Runnable {
                                        greenBox.setImageResource(R.drawable.red);
                                        blueBox.setImageResource(R.drawable.green);
                                        yellowBox.setImageResource(R.drawable.blue);
                                        redBox.setImageResource(R.drawable.yellow);
                                    }, 500)

                                    bat_code=1;

                                }

    }
}