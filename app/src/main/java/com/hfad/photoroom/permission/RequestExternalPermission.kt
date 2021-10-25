package com.hfad.photoroom.permission

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat
import com.hfad.photoroom.TAG
import java.security.AccessController.getContext

class RequestExternalPermission(val context: Context, private val activity: AppCompatActivity) {

    private fun onPermissionGranted() {
        Log.d(TAG, "Permission granted")
    }

    private val requestPermissionLauncher = activity.registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
        if (isGranted) {
            onPermissionGranted()
        } else {
// Toast
        }
    }

     fun requestExternalStoragePermission() {
        val permission = android.Manifest.permission.READ_EXTERNAL_STORAGE
        when {
            ContextCompat.checkSelfPermission(
                context,
                permission
            ) == PackageManager.PERMISSION_GRANTED -> {
//                permission is granted
                onPermissionGranted()
            }
            ActivityCompat.shouldShowRequestPermissionRationale(
                activity,
                permission
            ) -> {
//                Additinal rationale should be displayed
//               Toast message
                requestPermissionLauncher.launch(
                    permission
                )

            }
            else -> {
//                permission has not been asked - Toast message
                requestPermissionLauncher.launch(
                    permission
                )
            }
        }
    }



}