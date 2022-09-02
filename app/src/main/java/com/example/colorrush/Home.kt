package com.example.colorrush

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create


class Home   : AppCompatActivity() {

    //holds the web view for an inbuilt browser
    lateinit var webview : WebView
    val clientId ="1ef39fdba83f178b02ed"
    val client_secret="f7676e6b377d89669d87bc791925b6d07619c1c8"
    val redirectUri="http://localhost:3000/callback"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        );

        setContentView(R.layout.home_screen)

    }

    //function responsible for executing intent to open game activity
    fun openGame(view : View)
    {
        val i = Intent(
                this@Home,
                MainActivity::class.java
            )
            //Intent is used to switch from one activity to another.
            startActivity(i)

    }

    //function to display leaderboard for the game
    fun leaderboard(view : View)
    {
        val leaderBoard_intent = Intent(
            this@Home,
            LeaderBoard::class.java
        )
        //Intent is used to switch from one activity to another.
        startActivity(leaderBoard_intent)

    }

    //function which calls github api to star project repo
    //uses retrofit to send http requests to the github server
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

        val intent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("https://github.com/login/oauth/authorize" + "?client_id=" + clientId + "&scope=repo&redirect_uri=" + redirectUri)
        )
        startActivity(intent)


//        val uri = intent.data
//        if (uri != null && uri.toString().startsWith(redirectUri)) {
//            // use the parameter your API exposes for the code (mostly it's "code")
//            val code = uri.getQueryParameter("code")
//            if (code != null) {
//                // get access token
//                // we'll do that in a minute
//            } else if (uri.getQueryParameter("error") != null) {
//                // show an error message here
//            }
//        }
//
        val retrofitBuilder= Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://github.com/")
            .build()
//
//        val client : Githubstar = retrofitBuilder.create(Githubstar::class.java)
//        val accessToken = client.getAccessToken(
//            clientId,
//            client_secret,
//            code
//        )

//        client.enqueue(new Callback<AccessToken>() {
//            @Override
//            public void onResponse(Call<User> call, Response<User> response) {
//
//            }
//
//            @Override
//            public void onFailure(Call<User> call, Throwable t) {
//
//            }
//        }
    }

    override fun onResume() {
        super.onResume()

        var code: String
        // the intent filter defined in AndroidManifest will handle the return from ACTION_VIEW intent
        val uri = intent.data
        if (uri != null && uri.toString().startsWith(redirectUri)) {
            // use the parameter your API exposes for the code (mostly it's "code")
            code = uri.getQueryParameter("code").toString()
            if (code != null) {
                // get access token
                // we'll do that in a minute
                Log.d("correct","this is good")
            } else if (uri.getQueryParameter("error") != null) {
                Log.d("error","this is error")
            }
        }

        Log.d("code",""+uri)
    }

    override fun onBackPressed() {
        if (webview.canGoBack()) {
            webview.goBack()
        } else {
            super.onBackPressed()
        }
    }

    //function which shows details about the developer
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