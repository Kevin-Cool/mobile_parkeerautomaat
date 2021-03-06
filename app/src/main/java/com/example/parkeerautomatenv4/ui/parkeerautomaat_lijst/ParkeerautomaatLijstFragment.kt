package com.example.parkeerautomatenv4.ui.parkeerautomaat_lijst

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.parkeerautomatenv4.data.local.ParkeerautomaatAndFields
import com.example.parkeerautomatenv4.data.repos.RepositoryUtils
import com.example.parkeerautomatenv4.databinding.FragmentParkeerautomaatLijstBinding
import com.example.parkeerautomatenv4.utils.ParkeerautomaatAdaptor
import com.example.parkeerautomatenv4.utils.ParkeerautomaatClickListener

class ParkeerautomaatLijstFragment : Fragment(), ParkeerautomaatClickListener {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentParkeerautomaatLijstBinding.inflate(inflater, container, false)
        val factory = ParkeerautomaatLijstViewModelFactory(requireNotNull(activity), RepositoryUtils.createParkeerautomaatRepository(requireContext()))
        val viewModel = ViewModelProvider(this, factory).get(ParkeerautomaatLijstViewModel::class.java)

        binding.lifecycleOwner = viewLifecycleOwner
        val adapter = ParkeerautomaatAdaptor(this)
        binding.adaptor = adapter

        viewModel.updateParkeerautomaten()

        viewModel.parkeerautomaten.observe(
            viewLifecycleOwner,
            Observer {
                it?.let { resource -> adapter.submitList(resource.data) }
            }
        )

        return binding.root
    }

    override fun ParkeerautmaatClicked(parkeerautomaatAndFields: ParkeerautomaatAndFields) {
        val directions = parkeerautomaatAndFields.records?.recordid?.let { ParkeerautomaatLijstFragmentDirections.actionParkeerautomaatLijstFragmentToDetailFragment(it) }
        if (directions != null) {
            findNavController().navigate(directions)
        }
    }
}
