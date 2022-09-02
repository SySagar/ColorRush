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
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    var counter : Int =0
    var ball_code =0
    var bat_code =0
    var score : Int =0
    var rnds=0
    var lives=3;

    private lateinit var mAuth: FirebaseAuth
    lateinit private var userName : TextInputEditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //to make the app full screen
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)

        setContentView(R.layout.activity_main)

        val score_card=findViewById<TextView>(R.id.nos)
        val handler = Handler()
        val animationView : LottieAnimationView= findViewById(R.id.burst)
        val Ball=findViewById<ImageView>(R.id.ball)

        val game_over=findViewById<LottieAnimationView>(R.id.game_over)
        game_over.visibility=View.INVISIBLE


        //launches a separate coroutine for the ball drop animation
        GlobalScope.launch {
            while(true)
            {
                animationView.visibility=View.INVISIBLE
                rnds = (1..4).random()

                if (rnds == 1) {
                    ball_code = 1
                } else
                    if (rnds == 2) {
                        ball_code = 2
                    } else
                        if (rnds == 3) {
                            ball_code = 3
                        } else
                            if (rnds == 4) {
                                ball_code = 4
                            }

                val ball_animation: Animation =
                    AnimationUtils.loadAnimation(getApplicationContext(), R.anim.ball_down)
                handler.post { //updates the ui thread using handler


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
                {

                    //loses a life everytime the ball doesn't matches the bat color
                    handler.post {

                        val life1=findViewById<ImageView>(R.id.life1)
                        val life2=findViewById<ImageView>(R.id.life2)
                        val life3=findViewById<ImageView>(R.id.life3)
                        lives--;

                        if(lives==2)
                            life3.visibility=View.GONE

                        if(lives==1)
                            life2.visibility=View.GONE

                        if(lives==0)
                        {life1.visibility=View.GONE
                            val game_over=findViewById<LottieAnimationView>(R.id.game_over)
                            game_over.visibility=View.VISIBLE
                            game_over.playAnimation()

                            //delay the flow of apllication run by 3 seconds

                                val handler = Handler()
                                handler.postDelayed(
                                    {finish();},
                                    3000
                                )

                        }
                    }

                    }
                handler.post {
                    //updates the scoreboard textview from the existing coroutine
                    score_card.setText("" + score)

                }
            }

        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        player_score()
    }

    fun player_score()
    {
        // below line is used to get
        // reference for our database.
        val databaseReference = FirebaseDatabase.getInstance().getReference("score")


        val player =player_details()

        player.playerName="sagar"
        player.playerscore=score

        // we are use add value event listener method
        // which is called with database reference.
        val postListener = object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                // inside the method of on Data change we are setting
                // our object class to our database reference.
                // data base reference will sends data to firebase.
                databaseReference.push().setValue(player)

                // after adding this data we are showing toast message.
                Toast.makeText(this@MainActivity, "you scored something", Toast.LENGTH_SHORT).show()
            }

            override fun onCancelled(error: DatabaseError) {
                // if the data is not added or it is cancelled then
                // we are displaying a failure toast message.
                Toast.makeText(this@MainActivity, "Fail to add data $error", Toast.LENGTH_SHORT)
                    .show()
            }
        }
        databaseReference.addListenerForSingleValueEvent((postListener))
    }

    //the function is called to rotate the bat to left side
    fun leftRotate(view : View)
    {
        counter--
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


    //the function is called to rotate the bat to right side
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