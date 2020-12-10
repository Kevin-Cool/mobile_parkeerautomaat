package com.example.parkeerautomatenv4.ui.parkeerautomaat_lijst

import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.parkeerautomatenv4.data.remote.GhentApi
import com.example.parkeerautomatenv4.databinding.FragmentParkeerautomaatLijstBinding
import com.example.parkeerautomatenv4.utils.ParkeerautomaatAdaptor

class ParkeerautomaatLijstFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View?{
        val binding = FragmentParkeerautomaatLijstBinding.inflate(inflater,container,false)
        val factory = ParkeerautomaatLijstViewModelFactory(GhentApi.apiService)
        val viewModel = ViewModelProvider(this,factory).get(ParkeerautomaatLijstViewModel::class.java)

        binding.lifecycleOwner = viewLifecycleOwner
        val adapter = ParkeerautomaatAdaptor()
        binding.adaptor = adapter

        val application = requireNotNull(this.activity).application


        viewModel.parkeerautomaten.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
            Toast.makeText(application, "Kill me "+ it.get(0).recordid, Toast.LENGTH_SHORT).show()
        })
        return binding.root
    }


}