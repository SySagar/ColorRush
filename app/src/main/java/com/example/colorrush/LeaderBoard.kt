package com.example.colorrush
import android.os.Bundle
import android.view.WindowManager
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import java.util.ArrayList


class LeaderBoard  : AppCompatActivity(){

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

        recyclerview.bringToFront()

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this)

        // ArrayList of class ItemsViewModel
        val data = ArrayList<ItemsViewModel>()

        for (i in 1..20) {
            data.add(ItemsViewModel("Item "+i))

        }


        // This will pass the ArrayList to our Adapter
        val adapter = CustomAdapter(data)

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter

    }
}