package com.example.colorrush

import android.graphics.Point
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
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


class MainActivity : AppCompatActivity() {
    var counter : Int =3
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

        val blueBall=findViewById<ImageView>(R.id.blueball)
        val greenBall=findViewById<ImageView>(R.id.greenball)
        val yellowBall=findViewById<ImageView>(R.id.yellowball)
        val redBall=findViewById<ImageView>(R.id.redball)


        GlobalScope.launch {
            while(true)
            {val job = GlobalScope.launch {
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

            }

            runBlocking {

                job.join()
                Log.d("msge",""+rnds)
                val ball_animation: Animation =
                    AnimationUtils.loadAnimation(getApplicationContext(), R.anim.ball_down);
                if (ball_code == 3) {
                    blueBall.startAnimation(ball_animation)
                    redBall.visibility = View.INVISIBLE
                    greenBall.visibility = View.INVISIBLE
                    yellowBall.visibility = View.INVISIBLE
                }
                if (ball_code == 2) {
                    greenBall.startAnimation(ball_animation)
                    redBall.visibility = View.INVISIBLE
                    blueBall.visibility = View.INVISIBLE
                    yellowBall.visibility = View.INVISIBLE
                }
                if (ball_code == 1) {
                    redBall.startAnimation(ball_animation)
                    blueBall.visibility = View.INVISIBLE
                    greenBall.visibility = View.INVISIBLE
                    yellowBall.visibility = View.INVISIBLE
                }
                if (ball_code == 4) {
                    yellowBall.startAnimation(ball_animation)
                    redBall.visibility = View.INVISIBLE
                    greenBall.visibility = View.INVISIBLE
                    blueBall.visibility = View.INVISIBLE
                }

                if (ball_code == bat_code)
                    score++;
                else
                    score--;

            }

                delay(3000)
                job.cancel()


                handler.post({ //Do something after delay
                    score_card.setText(""+score)
                })
        }


        }

    }

    fun leftRotate(view : View)
    {
        counter++;
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

        if (counter%4==0)
        {}


    }

    fun View.getLocationOnScreen(view: View): Point
    {
        val location = IntArray(2)
        view.getLocationOnScreen(location)
        return Point(location[0],location[1])
    }

    fun rightRotate(view : View)
    {




        counter++;
        val redBox=findViewById<ImageView>(R.id.redBox)
        val blueBox=findViewById<ImageView>(R.id.blueBox)
        val greenBox=findViewById<ImageView>(R.id.greenBox)
        val yellowBox=findViewById<ImageView>(R.id.yellowBox)
        //val ball=findViewById<ImageView>(R.id.ball)

//
//        var run = Runnable{
//            val ball_animation: Animation =
//                AnimationUtils.loadAnimation(getApplicationContext(), R.anim.ball_down);
//            ball.startAnimation(ball_animation);
//        }


        if(counter%4==0) {
            val animation_ur: Animation =
                AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right_rotate_ur);
            redBox.startAnimation(animation_ur);
            val animation_rd: Animation =
                AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right_rotate_rd);
            greenBox.startAnimation(animation_rd);
            val animation_dl: Animation =
                AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right_rotate_dl);
            blueBox.startAnimation(animation_dl);
            val animation_lu: Animation =
                AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right_rotate_lu);
            yellowBox.startAnimation(animation_lu);

            Handler().postDelayed(Runnable {
                greenBox.setImageResource(R.drawable.red);
                blueBox.setImageResource(R.drawable.green);
                yellowBox.setImageResource(R.drawable.blue);
                redBox.setImageResource(R.drawable.yellow);
            }, animation_ur.getDuration())


            bat_code=1;

        }


        else
        if(counter%4==1)
        {
            val animation_ur : Animation =AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right_rotate_ur);
            yellowBox.startAnimation(animation_ur);
            val animation_rd : Animation =AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right_rotate_rd);
            redBox.startAnimation(animation_rd);
            val animation_dl : Animation =AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right_rotate_dl);
            greenBox.startAnimation(animation_dl);
            val animation_lu : Animation =AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right_rotate_lu);
            blueBox.startAnimation(animation_lu);

            bat_code=2

            Handler().postDelayed(Runnable {
                greenBox.setImageResource(R.drawable.yellow);
                blueBox.setImageResource(R.drawable.red);
                yellowBox.setImageResource(R.drawable.green);
                redBox.setImageResource(R.drawable.blue);
                Log.d("msge","end")
            }, animation_ur.getDuration())
        }
        else
        if(counter%4==2)
        {
            val animation_ur : Animation =AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right_rotate_ur);
            blueBox.startAnimation(animation_ur);
            val animation_rd : Animation =AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right_rotate_rd);
            yellowBox.startAnimation(animation_rd);
            val animation_dl : Animation =AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right_rotate_dl);
            redBox.startAnimation(animation_dl);
            val animation_lu : Animation =AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right_rotate_lu);
            greenBox.startAnimation(animation_lu);

            bat_code=3

            Handler().postDelayed(Runnable {
                greenBox.setImageResource(R.drawable.blue);
                blueBox.setImageResource(R.drawable.yellow);
                yellowBox.setImageResource(R.drawable.red);
                redBox.setImageResource(R.drawable.green);
                Log.d("msge","end")
            }, animation_ur.getDuration())
        }
        else
        if(counter%4==3)
        {
            val animation_ur : Animation =AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right_rotate_ur);
            greenBox.startAnimation(animation_ur);
            val animation_rd : Animation =AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right_rotate_rd);
            blueBox.startAnimation(animation_rd);
            val animation_dl : Animation =AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right_rotate_dl);
            yellowBox.startAnimation(animation_dl);
            val animation_lu : Animation =AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right_rotate_lu);
            redBox.startAnimation(animation_lu);

            bat_code=4

            Handler().postDelayed(Runnable {
                greenBox.setImageResource(R.drawable.green);
                blueBox.setImageResource(R.drawable.blue);
                yellowBox.setImageResource(R.drawable.yellow);
                redBox.setImageResource(R.drawable.red);
                Log.d("msge","end")
            }, animation_ur.getDuration())
        }

        val animation_ur : Animation =AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right_rotate_ur);
        redBox.startAnimation(animation_ur);
        val animation_rd : Animation =AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right_rotate_rd);
        greenBox.startAnimation(animation_rd);
        val animation_dl : Animation =AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right_rotate_dl);
        blueBox.startAnimation(animation_dl);
        val animation_lu : Animation =AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right_rotate_lu);
        yellowBox.startAnimation(animation_lu);

    }
}