package project.nutriscan.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import project.nutriscan.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(layoutInflater)

        binding.scanBarcode.setOnClickListener {
                Toast.makeText(activity, "Scan Button Tapped", Toast.LENGTH_SHORT).show()
        }

        binding.TypeBarcode.setOnClickListener {
            Toast.makeText(activity, "Type Button Tapped", Toast.LENGTH_SHORT).show()
        }


        return binding.root
    }


}