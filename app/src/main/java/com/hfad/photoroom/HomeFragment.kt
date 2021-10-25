package com.hfad.photoroom

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContentProviderCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.hfad.photoroom.adapter.PhotoAdapter
import com.hfad.photoroom.database.PhotoRoomDatabase
import com.hfad.photoroom.databinding.FragmentHomeBinding
import com.hfad.photoroom.permission.RequestExternalPermission
import java.util.jar.Manifest


val TAG = "HomeFragment"

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val myAdapter: PhotoAdapter by lazy { PhotoAdapter() }

    private val viewModel: PhotoRoomViewModel by viewModels {
        PhotoRoomViewModelFactory((requireActivity().application as PhotoRoomApplication).repository)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        val requestExternalPermission = RequestExternalPermission(
            requireContext(),
            requireActivity() as AppCompatActivity
        )
        binding.fab.setOnClickListener {
//            requestExternalStoragePermission()
            requestExternalPermission.requestExternalStoragePermission()
        }
        recyclerView()
        return binding.root
    }

    private fun recyclerView() {
        binding.apply {
            rvPhotoList.apply {
                adapter = myAdapter
                layoutManager = GridLayoutManager(requireContext(), 3)
                setHasFixedSize(true)
            }
        }
    }

}