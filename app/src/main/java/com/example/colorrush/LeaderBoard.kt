package com.example.colorrush

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import com.squareup.picasso.Picasso


class LeaderBoard  : AppCompatActivity(){

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
        val imageView : ImageView = findViewById(R.id.profile_pic);
        Picasso.with(this)
            .load("https://media.geeksforgeeks.org/wp-content/cdn-uploads/logo-new-2.svg")
            .resize(30, 30)
            .placeholder(R.mipmap.ic_launcher)
            .into(imageView);


        setContentView(R.layout.leaderboard)

        // getting the recyclerview by its id
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this)

        // ArrayList of class ItemsViewModel
        val data = ArrayList<ItemsViewModel>()



        firebaseDatabase = FirebaseDatabase.getInstance();

        // below line is used to get
        // reference for our database.
        databaseReference = firebaseDatabase!!.getReference("Score");

        setContentView(R.layout.leaderboard)

        // This will pass the ArrayList to our Adapter
        val adapter = CustomAdapter(data)

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter


        databaseReference!!.addValueEventListener(object : ValueEventListener {
            @SuppressLint("NotifyDataSetChanged")
            override fun onDataChange(snapshot: DataSnapshot) {
                 val dp : DataSnapshot
                for(dp in snapshot.getChildren())run {
                    data.add(ItemsViewModel(dp.child("playerName").getValue().toString()))
                    Log.d("kata", "" + snapshot.child("playerName").getValue().toString())
                }

                adapter.notifyDataSetChanged()

            }

            override fun onCancelled(error: DatabaseError) {
                // calling on cancelled method when we receive
                // any error or we are not able to get the data.
                Toast.makeText(this@LeaderBoard, "Fail to get data.", Toast.LENGTH_SHORT).show()
            }
        })

    }
}