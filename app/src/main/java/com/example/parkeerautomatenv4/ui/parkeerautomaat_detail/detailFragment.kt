package com.example.parkeerautomatenv4.ui.parkeerautomaat_detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

import androidx.navigation.fragment.navArgs
import com.example.parkeerautomatenv4.databinding.FragmentParkeerautomaatDetailBinding
import com.example.parkeerautomatenv4.databinding.FragmentParkeerautomaatDetailBinding.inflate
import com.example.parkeerautomatenv4.utils.ParkeerautomaatAdaptor

class DetailFragment  : Fragment() {
    private val argument: DetailFragmentArgs by navArgs()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentParkeerautomaatDetailBinding.inflate(inflater, container, false)
        val viewModel = ViewModelProvider(this).get(DetailViewmodel::class.java)

        viewModel.parkeerautomaat.observe(viewLifecycleOwner,Observer {
            binding.parkeerautomaat = it
        })
        viewModel.updateParkeerautomaat(argument.parkeerautomaat)

        return binding.root
    }

}