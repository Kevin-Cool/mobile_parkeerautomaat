package com.example.parkeerautomatenv4.ui.parkeerautomaat_lijst

import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.parkeerautomatenv4.data.local.ParkeerautomaatAndFieldsAndGeometry
import com.example.parkeerautomatenv4.data.remote.GhentApi
import com.example.parkeerautomatenv4.data.repos.RepositoryUtils
import com.example.parkeerautomatenv4.databinding.FragmentParkeerautomaatLijstBinding
import com.example.parkeerautomatenv4.domain.Parkeerautomaat
import com.example.parkeerautomatenv4.utils.ParkeerautomaatAdaptor
import com.example.parkeerautomatenv4.utils.ParkeerautomaatClickListener
import com.example.parkeerautomatenv4.utils.Status

class ParkeerautomaatLijstFragment : Fragment() , ParkeerautomaatClickListener {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View?{
        val binding = FragmentParkeerautomaatLijstBinding.inflate(inflater,container,false)
        val factory = ParkeerautomaatLijstViewModelFactory(RepositoryUtils.createParkeerautomaatRepository(requireContext()))
        val viewModel = ViewModelProvider(this,factory).get(ParkeerautomaatLijstViewModel::class.java)

        binding.lifecycleOwner = viewLifecycleOwner
        val adapter = ParkeerautomaatAdaptor(this)
        binding.adaptor = adapter

        val application = requireNotNull(this.activity).application


        viewModel.parkeerautomaten.observe(viewLifecycleOwner, Observer {
            it?.let { resource -> {
                when(resource.status){
                    Status.SUCCESS ->{
                        adapter.submitList(resource.data)
                    }
                    Status.LOADING ->{
                    }
                    Status.ERROR ->{
                    }
                }
            }}
        })
        return binding.root
    }

    override fun ParkeerautmaatClicked(parkeerautomaatAndFieldsAndGeometry: ParkeerautomaatAndFieldsAndGeometry) {
        val directions = ParkeerautomaatLijstFragmentDirections.actionParkeerautomaatLijstFragmentToDetailFragment(parkeerautomaatAndFieldsAndGeometry.parkeerautomaat.recordid)
        findNavController().navigate(directions)
    }


}