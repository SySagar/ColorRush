package com.example.colorrush

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.Gravity
import android.view.View
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Home   : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        );

        setContentView(R.layout.home_screen)

    }


    fun openGame(view : View)
    {
        val i = Intent(
                this@Home,
                MainActivity::class.java
            )
            //Intent is used to switch from one activity to another.
            startActivity(i)

    }

    fun thanks(view: View) {
        val thanks = findViewById<ImageView>(R.id.like)
        val animation: Animation = AnimationUtils.loadAnimation(this, R.anim.bounce);
        //starts the animation
        thanks.startAnimation(animation)

        //inflates the about section in form of a custom toast layout
        val layout = layoutInflater.inflate(R.layout.thanks, findViewById(R.id.root))

        val myToast = Toast(applicationContext)

        myToast.setGravity(Gravity.CENTER_VERTICAL, 0, 0)
        myToast.view = layout//setting the view of custom toast layout
        val countDownTimer = object : CountDownTimer(5000, 5000) {
            override fun onTick(millisUntilFinished: Long) {}
            override fun onFinish() {
                myToast.cancel()
            }
        }
        myToast.show()
        countDownTimer.start()

    }

    fun abt_author(view: View) {

        val developer = findViewById<ImageView>(R.id.developer)
        val animation: Animation = AnimationUtils.loadAnimation(this, R.anim.bounce);
        //starts the animation
        developer.startAnimation(animation)

        //inflates the about section in form of a custom toast layout
        val layout = layoutInflater.inflate(R.layout.about, findViewById(R.id.root))

        val myToast = Toast(applicationContext)

        myToast.setGravity(Gravity.CENTER_VERTICAL, 0, 0)
        myToast.view = layout//setting the view of custom toast layout
        val countDownTimer = object : CountDownTimer(5000, 5000) {
            override fun onTick(millisUntilFinished: Long) {}
            override fun onFinish() {
                myToast.cancel()
            }
        }
        myToast.show()
        countDownTimer.start()

    }

}