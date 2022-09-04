package com.example.colorrush

import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.*


class LeaderBoard  : AppCompatActivity(){

    private lateinit var  adapter: personAdapter


    // creating a variable for
    // our Firebase Database.
    var firebaseDatabase: FirebaseDatabase? = null

    // creating a variable for our
    // Database Reference for Firebase.
    var databaseReference: DatabaseReference? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.leaderboard)

        setContentView(R.layout.item)
        val profile_pic : ImageView = findViewById(R.id.profile_pic);
//        Picasso.get()
//            .load("https://media.geeksforgeeks.org/wp-content/cdn-uploads/logo-new-2.svg")
//            .resize(30,30)
//            .into(profile_pic);


        setContentView(R.layout.leaderboard)

        // getting the recyclerview by its id
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this)



        firebaseDatabase = FirebaseDatabase.getInstance();

        // below line is used to get
        // reference for our database.
        databaseReference = firebaseDatabase!!.getReference()
        val query1 = FirebaseDatabase.getInstance().getReference().child("score");

        val options: FirebaseRecyclerOptions<player_details> = FirebaseRecyclerOptions.Builder<player_details>()
            .setQuery(query1, player_details::class.java)
            .build()

//        Glide.with(this)
//            .load("https://media.geeksforgeeks.org/wp-content/cdn-uploads/logo-new-2.svg")
//            .override(30, 20)
//            .placeholder(R.drawable.red)
//            .dontAnimate()
//            .into(profile_pic)

        // This will pass the ArrayList to our Adapter
        adapter = personAdapter(options)

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter

    }

    override fun onStart() {
        super.onStart()

        adapter.startListening()
    }

    // Function to tell the app to stop getting
    // data from database on stopping of the activity
    override fun onStop() {
        super.onStop()
        adapter.stopListening()
    }

}