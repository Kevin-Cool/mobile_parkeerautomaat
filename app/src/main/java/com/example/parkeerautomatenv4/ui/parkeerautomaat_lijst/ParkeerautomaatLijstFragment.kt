package com.example.parkeerautomatenv4.ui.parkeerautomaat_lijst

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.parkeerautomatenv4.data.local.ParkeerautomaatAndFields
import com.example.parkeerautomatenv4.data.repos.RepositoryUtils
import com.example.parkeerautomatenv4.databinding.FragmentParkeerautomaatLijstBinding
import com.example.parkeerautomatenv4.utils.LoadingFragment
import com.example.parkeerautomatenv4.utils.ParkeerautomaatAdaptor
import com.example.parkeerautomatenv4.utils.ParkeerautomaatClickListener
import com.example.parkeerautomatenv4.utils.Status
import java.io.Console
import java.util.logging.Logger
import kotlin.math.log

class ParkeerautomaatLijstFragment : Fragment() , ParkeerautomaatClickListener {

    private val loadingDialogFragment by lazy { LoadingFragment() }


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

        viewModel.parkeerautomaten.observe(viewLifecycleOwner, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        showProgress(false)
                        adapter.submitList(resource.data)
                    }
                    Status.LOADING -> {
                        showProgress(true)
                    }
                    Status.ERROR -> {
                        showProgress(false)
                    }
                }
            }
        })
        return binding.root
    }
    private fun showProgress(b: Boolean) {
        if (b) {
            if (!loadingDialogFragment.isAdded) {
                loadingDialogFragment.show(requireActivity().supportFragmentManager, "loader")
            }
        } else {
            if (loadingDialogFragment.isAdded) {
                loadingDialogFragment.dismissAllowingStateLoss()
            }
        }
    }

    override fun ParkeerautmaatClicked(parkeerautomaatAndFields: ParkeerautomaatAndFields) {
        val directions = ParkeerautomaatLijstFragmentDirections.actionParkeerautomaatLijstFragmentToDetailFragment(parkeerautomaatAndFields.parkeerautomaat.recordid)
        findNavController().navigate(directions)
    }


}