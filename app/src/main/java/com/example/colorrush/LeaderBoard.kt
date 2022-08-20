package com.example.colorrush

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity

class LeaderBoard  : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.leaderboard)

    }
}