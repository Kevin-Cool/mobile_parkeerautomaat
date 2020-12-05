package com.example.parkeerautomatenv4.ui.parkeerautomaat_detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels

import androidx.navigation.fragment.navArgs
import com.example.parkeerautomatenv4.databinding.ParkeerautomaatDetailFragmentBinding

class detailFragment  : Fragment() {
    private val viewModel: DetailViewmodel by viewModels()
    private val arg: detailFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = ParkeerautomaatDetailFragmentBinding.inflate(inflater, container, false)

        binding.viewModel = this.viewModel;
        binding.lifecycleOwner = viewLifecycleOwner
        viewModel.set(arg.parkeerautomaat);
        binding.parkeerautomaat = viewModel.Parkeerautomaat
        return binding.root
    }

}