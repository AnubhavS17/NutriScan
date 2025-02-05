package project.nutriscan.ui

import android.Manifest
import android.Manifest.permission.CAMERA
import android.content.pm.PackageManager
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.PermissionRequest
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import project.nutriscan.R
import project.nutriscan.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {


    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    // Declare a launcher for the camera permission request, handling the permission result
    private val cameraPermissionRequestLauncher: ActivityResultLauncher<String> =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted: Boolean ->
            if (isGranted) {
                // Permission granted: proceed with opening the camera
                navigate()
            } else {
                // Permission denied: inform the user to enable it through settings
                Toast.makeText(
                    requireActivity(),
                    "Go to settings and enable camera permission to use this feature",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(layoutInflater)

        (requireActivity() as AppCompatActivity).supportActionBar?.title = "Home"

        binding.scanBarcode.setOnClickListener {
            handleCameraPermission()
            //findNavController().navigate(R.id.action_HomeScreen_to_scanBarcodeFragment)
            //Toast.makeText(activity, "Scan Button Tapped", Toast.LENGTH_SHORT).show()
        }


        binding.SearchBarcode.setOnClickListener {
            val barcode = binding.editTextBarcode.text.toString()
            if (barcode.isNotEmpty()) {
                if (isValidEANBarcode(barcode)) {
                    val action = HomeFragmentDirections.actionHomeScreenToProductDetailFragment(barcode)
                    findNavController().navigate(action)
                } else {
                    Toast.makeText(activity, "Barcode must be 13 digit EAN", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(activity, "Please enter a barcode", Toast.LENGTH_SHORT).show()
            }
        }


        return binding.root
    }

    private fun navigate() {
        findNavController().navigate(R.id.action_HomeScreen_to_scanBarcodeFragment)
    }

    fun isValidEANBarcode(barcode: String): Boolean {
        // Check if the string contains only digits and has a length of 8 or 13
        return barcode.matches("\\d+".toRegex()) && (barcode.length == 13)
    }

   private fun handleCameraPermission() {
        when {
            ContextCompat.checkSelfPermission(
                requireActivity(),
                Manifest.permission.CAMERA
            ) == PackageManager.PERMISSION_GRANTED -> {
                // Permission is already granted: start the camera
                navigate()
            }
            else -> {
                // Permission is not granted: request it
                cameraPermissionRequestLauncher.launch(Manifest.permission.CAMERA)
            }
        }
    }

}