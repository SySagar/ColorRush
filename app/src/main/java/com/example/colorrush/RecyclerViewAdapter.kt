package com.example.colorrush

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

// FirebaseRecyclerAdapter is a class provided by
// FirebaseUI. it provides functions to bind, adapt and show
// database contents in a Recycler View
internal class
personAdapter(
    options: FirebaseRecyclerOptions<player_details>
) : FirebaseRecyclerAdapter<player_details, personAdapter.personsViewholder>(options) {
    // Function to bind the view in Card view(here
    // "person.xml") with data in
    // model class(here "person.class")
    override fun onBindViewHolder(
        holder: personsViewholder,
        position: Int, model: player_details
    ) {

        // Add firstname from model class (here
        // "person.class")to appropriate view in Card
        // view (here "person.xml")
        holder.playerName.text = model.getName()

        holder.playerScore.text= model.getScore().toString()

    }

    // Function to tell the class about the Card view (here
    // "person.xml")in
    // which the data will be shown
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): personsViewholder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item, parent, false)
        return personsViewholder(view)
    }


    internal inner class personsViewholder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var playerName: TextView
        var playerScore: TextView


        init {
            playerName = itemView.findViewById(R.id.name)
            playerScore = itemView.findViewById(R.id.player_score)

        }
    }
}