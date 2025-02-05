package project.nutriscan.ui

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.budiyev.android.codescanner.CodeScanner
import com.budiyev.android.codescanner.CodeScannerView
import com.budiyev.android.codescanner.DecodeCallback
import project.nutriscan.MainActivity
import project.nutriscan.R
import project.nutriscan.databinding.FragmentScanBarcodeBinding

class ScanBarcodeFragment : Fragment() {
    private var _binding: FragmentScanBarcodeBinding? = null
    private val binding get() = _binding!!
    lateinit var barcode : String

    private lateinit var codeScanner: CodeScanner

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity() as AppCompatActivity).supportActionBar?.hide()
        (activity as MainActivity).hideBottomNavigation()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentScanBarcodeBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val scannerView = binding.scannerView
        val activity = requireActivity()
        codeScanner = CodeScanner(activity, scannerView)

        codeScanner.decodeCallback = DecodeCallback {
            activity.runOnUiThread {
                barcode = it.text.toString()
                Toast.makeText(activity, barcode, Toast.LENGTH_LONG).show()
                binding.currentScannedBarcode.text = barcode

                binding.ScanForProduct.setOnClickListener {
                    /* findNavController().navigate(R.id.action_scanBarcodeFragment_to_productDetailFragment)*/
                    if (!barcode.isNullOrEmpty()){
                        if(isValidEan(barcode)){
                            val action = ScanBarcodeFragmentDirections.actionScanBarcodeFragmentToProductDetailFragment(barcode)
                            findNavController().navigate(action)
                        } else {
                            Toast.makeText(requireActivity(),"Found Invalid Barcode Type",Toast.LENGTH_SHORT).show()
                        }
                        /*val action = ScanBarcodeFragmentDirections.actionScanBarcodeFragmentToProductDetailFragment(barcode)
                        findNavController().navigate(action)*/
                    } else {
                        Toast.makeText(requireActivity(),"No Barcode Detected",Toast.LENGTH_SHORT).show()
                    }
                }

            }
        }
        scannerView.setOnClickListener {
            codeScanner.startPreview()
        }

    }

    private fun isValidEan(barcode: String): Boolean {
        if (barcode.length != 13) return false
        val allDigits = barcode.map { it.toString().toInt() }
        val s = if (barcode.length % 2 == 0) 3 else 1
        val s2 = if (s == 3) 1 else 3
        return allDigits.last() == (10 - (allDigits.take(barcode.length - 1).mapIndexed { ci, c -> c * (if (ci % 2 == 0) s else s2) }.sum() % 10)) % 10
    }



    override fun onResume() {
        super.onResume()
        codeScanner.startPreview()
    }

    override fun onPause() {
        codeScanner.releaseResources()
        super.onPause()
    }

    override fun onDetach() {
        super.onDetach()
        (requireActivity() as AppCompatActivity).supportActionBar?.show()
        (activity as MainActivity).showBottomNavigation()
    }

}