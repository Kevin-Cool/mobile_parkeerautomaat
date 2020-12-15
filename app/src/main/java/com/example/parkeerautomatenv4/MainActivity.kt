package com.example.parkeerautomatenv4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.parkeerautomatenv4.ui.parkeerautomaat_lijst.ParkeerautomaatLijstFragment

class MainActivity : AppCompatActivity() {

    private  lateinit var navController : NavController
    lateinit var fragment: ParkeerautomaatLijstFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



    }
}