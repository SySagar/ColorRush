package com.example.colorrush

class player_details
{
    // created getter and setter methods
    // for all our variables.
    // string variable for
    // storing employee name.
    var playerName: String? = "baka"

    // string variable for storing
    // employee contact number
    var playerscore: Int? = 100

    fun setName(lastname: String) {
        this.playerName = playerName
    }

    fun setScore(lastname: String) {
        this.playerscore = playerscore
    }

    fun getScore(): Int? {
        return playerscore
    }

    fun getName(): String? {
        return playerName
    }
}