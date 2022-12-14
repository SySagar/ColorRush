package com.example.colorrush

//this is a basic splashscreen for ColorRush application
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity

class opening  : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.intro_screen)

        Handler().postDelayed({
            Intent(this, Login::class.java).also {
                startActivity(it)
                finish()

            }
        }, 3800)

    }
}