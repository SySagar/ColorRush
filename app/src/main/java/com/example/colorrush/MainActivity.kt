package com.example.colorrush

import android.animation.ValueAnimator
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    val location = IntArray(2)
    var counter : Int =-1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val redBox=findViewById<ImageView>(R.id.redBox)
        val blueBox=findViewById<ImageView>(R.id.blueBox)
        val greenBox=findViewById<ImageView>(R.id.greenBox)
        val yellowBox=findViewById<ImageView>(R.id.yellowBox)


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

//        redBox.animate().translationX(-185f).translationY(85f)



//        redBox.getLocationOnScreen(location)
//        Log.d("hel",""+location[0]+" "+location[1])
//        redBox.x = (location[0]-290).toFloat();
//        redBox.y = (location[1]+105).toFloat();

    }

    fun rightRotate(view : View)
    {
        counter++;
        val redBox=findViewById<ImageView>(R.id.redBox)
        val blueBox=findViewById<ImageView>(R.id.blueBox)
        val greenBox=findViewById<ImageView>(R.id.greenBox)
        val yellowBox=findViewById<ImageView>(R.id.yellowBox)



//            val animation_ur : Animation =AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right_rotate_ur);
//            redBox.startAnimation(animation_ur);
//            val animation_rd : Animation =AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right_rotate_rd);
//            greenBox.startAnimation(animation_rd);
//            val animation_dl : Animation =AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right_rotate_dl);
//            blueBox.startAnimation(animation_dl);
//            val animation_lu : Animation =AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right_rotate_lu);
//            yellowBox.startAnimation(animation_lu);



            val animator = ValueAnimator.ofFloat(0f, 1f) // values from 0 to 1
            animator.duration = 2000 // 5 seconds duration from 0 to 1
            animator.addUpdateListener { animation ->
                val value = (animation.animatedValue as Float)
                    .toFloat()
                // Set translation of your view here. Position can be calculated
                // out of value. This code should move the view in a half circle.
                redBox.setTranslationX((250.0 * Math.sin(value * Math.PI)).toFloat())
                redBox.setTranslationY((-250.0 * Math.cos(value * Math.PI)).toFloat())

            }

            animator.start()



//        else
//        if(counter%4==1)
//        {
//            val animation_ur : Animation =AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right_rotate_ur);
//            yellowBox.startAnimation(animation_ur);
//            val animation_rd : Animation =AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right_rotate_rd);
//            redBox.startAnimation(animation_rd);
//            val animation_dl : Animation =AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right_rotate_dl);
//            greenBox.startAnimation(animation_dl);
//            val animation_lu : Animation =AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right_rotate_lu);
//            blueBox.startAnimation(animation_lu);
//
//
//        }
//        else
//        if(counter%4==2)
//        {
//            val animation_ur : Animation =AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right_rotate_ur);
//            blueBox.startAnimation(animation_ur);
//            val animation_rd : Animation =AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right_rotate_rd);
//            yellowBox.startAnimation(animation_rd);
//            val animation_dl : Animation =AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right_rotate_dl);
//            redBox.startAnimation(animation_dl);
//            val animation_lu : Animation =AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right_rotate_lu);
//            greenBox.startAnimation(animation_lu);
//
//
//        }
//        else
//        if(counter%4==3)
//        {
//            val animation_ur : Animation =AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right_rotate_ur);
//            greenBox.startAnimation(animation_ur);
//            val animation_rd : Animation =AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right_rotate_rd);
//            blueBox.startAnimation(animation_rd);
//            val animation_dl : Animation =AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right_rotate_dl);
//            yellowBox.startAnimation(animation_dl);
//            val animation_lu : Animation =AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right_rotate_lu);
//            redBox.startAnimation(animation_lu);
//
//
//        }

//        val animation_ur : Animation =AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right_rotate_ur);
//        redBox.startAnimation(animation_ur);
//        val animation_rd : Animation =AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right_rotate_rd);
//        greenBox.startAnimation(animation_rd);
//        val animation_dl : Animation =AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right_rotate_dl);
//        blueBox.startAnimation(animation_dl);
//        val animation_lu : Animation =AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right_rotate_lu);
//        yellowBox.startAnimation(animation_lu);

    }
}