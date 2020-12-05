package com.example.parkeerautomatenv4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import com.example.parkeerautomatenv4.ui.parkeerautomaat_lijst.MainFragment

class MainActivity : AppCompatActivity() {

    private  lateinit var navController : NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
    }
}