package com.example.colorrush

import android.R.anim
import android.graphics.Point
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.view.animation.AccelerateInterpolator
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlin.properties.Delegates


class MainActivity : AppCompatActivity() {
    val location = IntArray(2)
    var counter : Int =3
    var ball_code by Delegates.notNull<Int>()
    var bat_code by Delegates.notNull<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val redBox=findViewById<ImageView>(R.id.redBox)
        val blueBox=findViewById<ImageView>(R.id.blueBox)
        val greenBox=findViewById<ImageView>(R.id.greenBox)
        val yellowBox=findViewById<ImageView>(R.id.yellowBox)

        val rnds = (1..4).random()

        if(rnds==1){ball_code=1;}
        else
        if(rnds==2){ball_code=2;}
        else
        if(rnds==3){ball_code=3;}
        else
        if(rnds==4){ball_code=4;}


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
                   Log.d("msge","end")
            }, animation_ur.getDuration())



            bat_code=1;

            //redBox.animate().translationX(200f).translationY(200f)
//            animation_ur.setFillAfter(true)
//
//            animation_ur.setInterpolator(AccelerateInterpolator())
//
//            animation_ur.setFillAfter(true)
//            Handler().postDelayed(Runnable {
//                redBox.x = 922f
//                redBox.y = 1302f
//                   Log.d("msge","end")
//            }, animation_ur.getDuration())
//
//
//            animation_rd.setInterpolator(AccelerateInterpolator())
//
//            animation_rd.setFillAfter(true)
//            Handler().postDelayed(Runnable {
//                greenBox.x = 622f
//                greenBox.y = 1611f
//                Log.d("msge","end")
//            }, animation_rd.getDuration())
//
//            animation_dl.setInterpolator(AccelerateInterpolator())
//
//            animation_dl.setFillAfter(true)
//            Handler().postDelayed(Runnable {
//                blueBox.x = 338f
//                blueBox.y = 1302f
//                Log.d("msge","end")
//            }, animation_dl.getDuration())
//
//            animation_lu.setInterpolator(AccelerateInterpolator())
//
//            animation_lu.setFillAfter(true)
//            Handler().postDelayed(Runnable {
//                yellowBox.x = 608f
//                yellowBox.y = 1002f
//                Log.d("msge","end")
//            }, animation_lu.getDuration())
//
//

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