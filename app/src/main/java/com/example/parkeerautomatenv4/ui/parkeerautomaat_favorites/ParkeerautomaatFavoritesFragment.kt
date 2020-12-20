package com.example.parkeerautomatenv4.ui.parkeerautomaat_favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.lifecycle.Observer
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.parkeerautomatenv4.data.local.ParkeerautomaatAndFields
import com.example.parkeerautomatenv4.data.local.entity.ParkeerautomaatfieldsEntity
import com.example.parkeerautomatenv4.data.repos.RepositoryUtils
import com.example.parkeerautomatenv4.databinding.FragmentFavoritesBinding
import com.example.parkeerautomatenv4.utils.LoadingFragment
import com.example.parkeerautomatenv4.utils.ParkeerautomaatAdaptor
import com.example.parkeerautomatenv4.utils.ParkeerautomaatClickListener
import com.example.parkeerautomatenv4.utils.Status

class ParkeerautomaatFavoritesFragment : Fragment() , ParkeerautomaatClickListener {
    private val loadingDialogFragment by lazy { LoadingFragment() }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentFavoritesBinding.inflate(inflater,container,false)
        val factory = ParkeerautomaatFavoritesViewModelFactory(requireNotNull(activity),RepositoryUtils.createParkeerautomaatRepository(requireContext()))
        val viewModel = ViewModelProvider(this,factory).get(ParkeerautomaatFavoritesViewModel::class.java)

        binding.lifecycleOwner = viewLifecycleOwner
        val adapter = ParkeerautomaatAdaptor(this)
        binding.adaptor = adapter

        viewModel.updateParkeerautomaten()
        viewModel.updateFavorit()
        
        viewModel.parkeerautomaten.observe(viewLifecycleOwner, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        showProgress(false)
                        if(viewModel.Favorit.value != null){
                            val templist = ArrayList<ParkeerautomaatAndFields>()
                            resource.data?.forEach { parkeerautomaatAndFields ->
                                viewModel.Favorit.value!!.forEach { favorit ->
                                    if(favorit.recordid == parkeerautomaatAndFields.records.recordid){
                                        templist.add(parkeerautomaatAndFields)
                                    }
                                }
                            }
                            adapter.submitList(templist)
                        }else{
                            adapter.submitList(resource.data)
                        }
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
        binding.zoekButton.setOnClickListener {
            ZoekenClicked()
        }

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
        val directions = ParkeerautomaatFavoritesFragmentDirections.actionParkeerautomaatFavoritesFragmentToDetailFragment(parkeerautomaatAndFields.records.recordid)
        findNavController().navigate(directions)
    }
    fun ZoekenClicked() {
        val directions = ParkeerautomaatFavoritesFragmentDirections.actionParkeerautomaatFavoritesFragmentToParkeerautomaatLijstFragment()
        findNavController().navigate(directions)
    }
}