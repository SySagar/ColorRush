package com.example.colorrush

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class Login : AppCompatActivity(){


    private lateinit var mAuth: FirebaseAuth
    lateinit private var userName : TextInputEditText
    lateinit private var userPassword : TextInputEditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.login_page)

        //mAuth= FirebaseAuth.getInstance()
        mAuth = Firebase.auth
        userName = findViewById(R.id.name)
        userPassword = findViewById(R.id.password)

        val loginButton=findViewById<Button>(R.id.LoginButton)

        loginButton.setOnClickListener(View.OnClickListener { registerNewUser() })

        val new_signup=findViewById<TextView>(R.id.newUser)

        new_signup.setOnClickListener(View.OnClickListener {

            val signUpIntent=Intent(this, SignUp::class.java)
            startActivity(signUpIntent)
        })



    }

    fun login(view : View)
    {
            val homeActivityIntent=Intent(this, Home::class.java)
            startActivity(homeActivityIntent)
    }

//    public override fun onStart() {
//        super.onStart()
//        // Check if user is signed in (non-null) and update UI accordingly.
//        val currentUser = mAuth?.currentUser
//        if(currentUser != null){
//            Toast.makeText(applicationContext,"you are not a member",Toast.LENGTH_LONG).show()
//        }
//    }

    private fun previousUser()
    {
        val name: String
        val password: String
        name = userName.text.toString()
        password = userPassword.text.toString()


        if (TextUtils.isEmpty(name)) {
            Toast.makeText(
                applicationContext,
                "Please enter your name!!",
                Toast.LENGTH_LONG
            )
                .show()
            return
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(
                applicationContext,
                "Please enter password!!",
                Toast.LENGTH_LONG
            )
                .show()
            return
        }

        Log.d("this",""+name+"\n"+password)

        mAuth.signInWithEmailAndPassword(name, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "signInWithEmail:success")
                    val user = mAuth.currentUser
                    //updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                   // updateUI(null)
                }
            }
    }


    private fun registerNewUser() {


        val name: String
        val password: String
        name = userName.text.toString()
        password = userPassword.text.toString()


        if (TextUtils.isEmpty(name)) {
            Toast.makeText(
                applicationContext,
                "Please enter your name!!",
                Toast.LENGTH_LONG
            )
                .show()
            return
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(
                applicationContext,
                "Please enter password!!",
                Toast.LENGTH_LONG
            )
                .show()
            return
        }

        Log.d("this",""+name+"\n"+password)

        // create new user or register new user
        mAuth.createUserWithEmailAndPassword(name, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(
                        applicationContext,
                        "Registration successful!",
                        Toast.LENGTH_LONG
                    )
                        .show()


                    // if the user created intent to login activity
                    val intent = Intent(
                        this@Login,
                        Home::class.java
                    )
                    startActivity(intent)
                } else {

                    // Registration failed
                    Toast.makeText(
                        applicationContext, "Registration failed!!"
                                + " Please try again later",
                        Toast.LENGTH_LONG
                    )
                        .show()

                }
            }
    }



}

