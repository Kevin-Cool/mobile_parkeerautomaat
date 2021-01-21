package com.example.parkeerautomatenv4.ui.parkeerautomaat_detail

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context.CLIPBOARD_SERVICE
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.parkeerautomatenv4.data.repos.RepositoryUtils
import com.example.parkeerautomatenv4.databinding.FragmentParkeerautomaatDetailBinding

class DetailFragment : Fragment() {
    val arguments: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentParkeerautomaatDetailBinding.inflate(inflater, container, false)
        val factory = DetailViewModelFactory(requireNotNull(activity), RepositoryUtils.createParkeerautomaatRepository(requireContext()))
        val viewModel = ViewModelProvider(this, factory).get(DetailViewModel::class.java)

        viewModel.updateParkeerautomaat(arguments.ParkeerautomaatID)
        viewModel.updateFavorit(arguments.ParkeerautomaatID)

        viewModel.parkeerautomaat.observe(
            viewLifecycleOwner,
            Observer {
                binding.parkeerautomaat = it
            }
        )

        viewModel.isFavorit.observe(
            viewLifecycleOwner,
            Observer {
                // Toast.makeText(activity , "Favorit status changed", Toast.LENGTH_LONG).show()
            }
        )

        binding.coppyButton.setOnClickListener {
            val myClipboard: ClipboardManager = requireActivity().getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
            val myClip: ClipData = ClipData.newPlainText("text", binding.parkeerautomaat?.fields?.locatieomschrijving)

            myClipboard.setPrimaryClip(myClip)

            Toast.makeText(activity, "Copied: " + binding.parkeerautomaat?.fields?.locatieomschrijving, Toast.LENGTH_LONG).show()
        }
        binding.favButton.setOnClickListener {
            viewModel.update()
        }

        return binding.root
    }
}
