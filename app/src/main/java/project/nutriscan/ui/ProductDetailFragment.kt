package project.nutriscan.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import coil.load
import project.nutriscan.MainActivity
import project.nutriscan.databinding.FragmentProductDetailBinding
import project.nutriscan.viewmodel.NutritionViewModel

class ProductDetailFragment : Fragment() {
    private var _binding : FragmentProductDetailBinding? = null
    private val binding get() = _binding!!

   lateinit var viewmodel : NutritionViewModel

   private val args : ProductDetailFragmentArgs by navArgs()

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewmodel = (activity as MainActivity).viewModel
        // Inflate the layout for this fragment
        _binding = FragmentProductDetailBinding.inflate(inflater)

        (requireActivity() as AppCompatActivity).supportActionBar?.title = "Product Details"

        //API Call to retrieve data.
        val barcode = args.barcode
        viewmodel.searchProduct(barcode,"nutriments,allergens,image_url")


        //Observing and Mapping Values.
        viewmodel.productDetails.observe(viewLifecycleOwner, Observer {
            binding.carbs.text = "Carbs: " + it.product?.nutriments?.carbohydrates.toString() + it.product?.nutriments?.carbohydrates_unit.toString()
            binding.sugar.text = "Sugar: " + it.product?.nutriments?.sugars.toString() + it.product?.nutriments?.sugars_unit.toString()
            binding.energy.text = "Energy: " + it.product?.nutriments?.energy.toString() + it.product?.nutriments?.energy_unit.toString()
            binding.fat.text = "Fat: " + it.product?.nutriments?.fat.toString() + it.product?.nutriments?.fat_unit.toString()
            binding.fatPer100g.text = "Fat per 100g: " + it.product?.nutriments?.fat_100g.toString() + it.product?.nutriments?.fat_unit.toString()
            binding.fiber.text = "Fiber: " + it.product?.nutriments?.fiber.toString() + it.product?.nutriments?.fiber_unit.toString()
            binding.nutritionalScore.text = "Nutritional Score: " + it.product?.nutriments?.nutrition_score_fr.toString()
            binding.proteins.text = "Protein: " + it.product?.nutriments?.proteins.toString() + it.product?.nutriments?.proteins_unit.toString()
            binding.salt.text = "Salt Content: " + it.product?.nutriments?.salt.toString() + it.product?.nutriments?.salt_unit.toString()
            binding.saturatedFat.text = "Saturated Fat: " + it.product?.nutriments?.saturated_fat.toString() + it.product?.nutriments?.saturated_fat_unit.toString()
            binding.sodium.text = "Sodium: " + it.product?.nutriments?.sodium.toString() + it.product?.nutriments?.sodium_unit.toString()

            //Allergens
            binding.allergen.text = "Allergen: " + it.product?.allergens?.toString()

            val imageUrl = it.product?.image_url
            binding.productImage.load(imageUrl)

        })





//        binding.CallAPI.setOnClickListener {
//            viewmodel.searchProduct("8901491101837","nutriments")
//            viewmodel.productDetails.observe(viewLifecycleOwner, Observer {
//              binding.carbs.text = it.product?.nutriments?.carbohydrates.toString()
//              binding.sugar.text = it.product?.nutriments?.sugars.toString()
//            })
//        }


        return binding.root

    }

}