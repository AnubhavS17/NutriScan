package project.nutriscan.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import project.nutriscan.R
import project.nutriscan.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(layoutInflater)

        binding.scanBarcode.setOnClickListener {
            findNavController().navigate(R.id.action_HomeScreen_to_scanBarcodeFragment)
            Toast.makeText(activity, "Scan Button Tapped", Toast.LENGTH_SHORT).show()
        }


        binding.SearchBarcode.setOnClickListener {
            if (binding.editTextBarcode.text.isNotEmpty()){
                if (binding.editTextBarcode.text.length == 16) {
                    var input: String = binding.editTextBarcode.text.toString()
                    Toast.makeText(activity, input, Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(activity, "Barcode must be 16 digit", Toast.LENGTH_SHORT).show()
                }
            } else{
                Toast.makeText(activity, "Please enter a barcode", Toast.LENGTH_SHORT).show()
            }

        }


        return binding.root
    }


}