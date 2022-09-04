package com.example.colorrush

class player_details
{
    // created getter and setter methods
    // for all our variables.
    // string variable for
    // storing employee name.
    private var playerName: String? = "baka"

    // string variable for storing
    // employee contact number
    private var playerscore: Int? = 100

    fun setName(name: String) {
        this.playerName = name
    }

    fun setScore(score: Int) {
        this.playerscore = score
    }

    fun getScore(): Int? {
        return playerscore
    }

    fun getName(): String? {
        return playerName
    }
}