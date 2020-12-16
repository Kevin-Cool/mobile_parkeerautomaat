package com.example.parkeerautomatenv4.ui.parkeerautomaat_detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

import androidx.navigation.fragment.navArgs
import com.example.parkeerautomatenv4.data.repos.RepositoryUtils
import com.example.parkeerautomatenv4.databinding.FragmentParkeerautomaatDetailBinding

class DetailFragment  : Fragment() {
    val arguments: DetailFragmentArgs by navArgs()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentParkeerautomaatDetailBinding.inflate(inflater, container, false)
        val factory = DetailViewModelFactory(RepositoryUtils.createParkeerautomaatRepository(requireContext()))
        val viewModel = ViewModelProvider(this,factory).get(DetailViewModel::class.java)


        viewModel.updateParkeerautomaat(arguments.ParkeerautomaatID)

        viewModel.parkeerautomaat.observe(viewLifecycleOwner,Observer {
            binding.parkeerautomaat = it
        })


        return binding.root
    }

}