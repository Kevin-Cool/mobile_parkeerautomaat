package com.example.parkeerautomatenv4.ui.parkeerautomaat_lijst

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.findNavController
import com.example.parkeerautomatenv4.utils.parkeerautomaat_adaptor
import com.example.parkeerautomatenv4.domain.Parkeerautomaat
import com.example.parkeerautomatenv4.databinding.MainFragmentBinding
import com.example.parkeerautomatenv4.parkeerautomaat_clicklistener

class MainFragment : Fragment(), parkeerautomaat_clicklistener {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(

            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?): View? {
        val binding = MainFragmentBinding.inflate(inflater, container, false)
        context?: return  binding.root

        val adapter =
            parkeerautomaat_adaptor(this)
        binding.parkeerautomaatList.adapter = adapter

        viewModel.properties.observe(viewLifecycleOwner) {
            properties -> adapter.submitList(properties.parkeerautomatens)

        }

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onParkeerautomaatClicklistener(Parkeerautomaat: Parkeerautomaat) {
        val direction = MainFragmentDirections.actionHomeFragmentToDetailfragment(Parkeerautomaat)
        view?.findNavController()?.navigate(direction);

    }

}