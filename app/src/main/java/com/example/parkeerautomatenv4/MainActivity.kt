package com.example.parkeerautomatenv4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import com.example.parkeerautomatenv4.ui.parkeerautomaat_favorites.ParkeerautomaatFavoritesFragment

class MainActivity : AppCompatActivity() {

    private  lateinit var navController : NavController
    lateinit var fragment: ParkeerautomaatFavoritesFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



    }
}