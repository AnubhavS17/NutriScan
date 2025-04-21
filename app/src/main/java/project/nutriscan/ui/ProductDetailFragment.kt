package project.nutriscan.ui

import android.annotation.SuppressLint
import android.graphics.Color
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
import project.nutriscan.R
import project.nutriscan.databinding.FragmentProductDetailBinding
import project.nutriscan.utils.UtilityFunctions.Companion.getAdditiveFullName
import project.nutriscan.viewmodel.NutritionViewModel

class ProductDetailFragment : Fragment() {
    private var _binding: FragmentProductDetailBinding? = null
    private val binding get() = _binding!!

    lateinit var viewmodel: NutritionViewModel

    private val args: ProductDetailFragmentArgs by navArgs()

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
        viewmodel.searchProduct(
            barcode,
            "nutriments,allergens,image_url," +
                    "additives_tags,ingredients_text_en,ingredients" +
                    "countries,ecoscore_grade,ecoscore_score," +
                    "nutrient_levels_tags,product_name,brands,manufacturing_places"
        )




        //Observing and Mapping Values.
        viewmodel.productDetails.observe(viewLifecycleOwner, Observer {

            //Product Info Card
            binding.productName.text =
                "Name: " + (it.product?.product_name?.toString() ?: "Not Found")

            binding.productBrands.text =
                "Brand: " + (it.product?.brands?.toString() ?: "Not Found")

            binding.productManufacturing.text =
                "Manufactured In: " + (it.product?.manufacturing_places?.toString() ?: "Not Found")


            //Nutriments Card
            binding.carbs.text =
                "Carbs: " + (it.product?.nutriments?.carbohydrates?.toString() ?: "Not Found") +
                        (it.product?.nutriments?.carbohydrates_unit ?: "")

            binding.sugar.text =
                "Sugar: " + (it.product?.nutriments?.sugars?.toString() ?: "Not Found") +
                        (it.product?.nutriments?.sugars_unit ?: "")

            binding.energy.text =
                "Energy: " + (it.product?.nutriments?.energy?.toString() ?: "Not Found") +
                        (it.product?.nutriments?.energy_unit ?: "")

            binding.fat.text = "Fat: " + (it.product?.nutriments?.fat?.toString() ?: "Not Found") +
                    (it.product?.nutriments?.fat_unit ?: "")

            binding.fatPer100g.text =
                "Fat per 100g: " + (it.product?.nutriments?.fat_100g?.toString() ?: "Not Found") +
                        (it.product?.nutriments?.fat_unit ?: "")

            binding.fiber.text =
                "Fiber: " + (it.product?.nutriments?.fiber?.toString() ?: "Not Found") +
                        (it.product?.nutriments?.fiber_unit ?: "")

            binding.nutritionalScore.text =
                "Nutritional Score: " + (it.product?.nutriments?.nutrition_score_fr?.toString()
                    ?: "Not Found")

            binding.proteins.text =
                "Protein: " + (it.product?.nutriments?.proteins?.toString() ?: "Not Found") +
                        (it.product?.nutriments?.proteins_unit ?: "")

            binding.salt.text =
                "Salt Content: " + (it.product?.nutriments?.salt?.toString() ?: "Not Found") +
                        (it.product?.nutriments?.salt_unit ?: "")

            binding.saturatedFat.text =
                "Saturated Fat: " + (it.product?.nutriments?.saturated_fat?.toString()
                    ?: "Not Found") +
                        (it.product?.nutriments?.saturated_fat_unit ?: "")

            binding.sodium.text =
                "Sodium: " + (it.product?.nutriments?.sodium?.toString() ?: "Not Found") +
                        (it.product?.nutriments?.sodium_unit ?: "")


            /*  //ProductName
              binding.productName.text = "Name: " + it.product?.product_name*/

            //Ingredients
            binding.ingredientsInfo.text =
                "Contains: ${it.product?.ingredients_text_en ?: "No ingredients available"}"

            //Nutrients_Level Summary
            val nutrientsTags = (it?.product?.nutrient_levels_tags)
            convertNutrientsSummary(nutrientsTags)

            //Allergens
            val formattedAllergens = formatAllergens(it.product?.allergens)
            binding.allergen.text = formattedAllergens
            //binding.allergen.setTextColor(Color.RED)


            //Product Image
            val imageUrl = it.product?.image_url
            binding.productImage.load(imageUrl)

            // Extract additives tags
            val additivesTags = (it?.product?.additives_tags)
            displayAdditivesTags(additivesTags)

            //Countries Found
            val formattedCountries = formatCountries(it.product?.countries)
            binding.countries.text = formattedCountries

            //Ecoscore
            binding.ecoscoreGrade.text =
                "Grade: ${it.product?.ecoscore_grade ?: "Not Found"}"
            binding.ecoscoreScore.text =
                "Score: ${it.product?.ecoscore_score ?: "Not Found"}"
        })



        return binding.root

    }

    private fun convertNutrientsSummary(nutrientsTags: List<String>?) {
        if (!nutrientsTags.isNullOrEmpty()) {
            val formattedTag = nutrientsTags.mapIndexed { index, tag ->
                val convertedTag = tag.removePrefix("en:") // Remove the "en:" prefix
                "${index + 1}. $convertedTag" // Format as "1. fat-in-high-quantity"
            }.joinToString("\n") // Join the list into a single string
            binding.nutrientsLevel.text = "List:\n$formattedTag"
        } else {
            binding.additives.text = "Cannot Generate Summary"
        }
    }

    @SuppressLint("ResourceAsColor")
    private fun displayAdditivesTags(additivesTags: List<String>?) {
        if (!additivesTags.isNullOrEmpty()) {
            val formattedAdditives = additivesTags.map { tag ->
                val convertedTag = convertTagFormat(tag) // Convert the tag format
                val fullName =
                    getAdditiveFullName(convertedTag) // Get the full name for the additive code
                "$convertedTag - $fullName" // Format as "E330 - Zeeshan"

            }.joinToString("\n") // Join the list into a single string
            binding.additives.text = "Additives:\n$formattedAdditives"
        } else {
            binding.additives.text = "Additives not found."
        }
    }

    fun convertTagFormat(tag: String): String {
        // Remove the "en:" prefix and convert to uppercase
        return tag.replace("en:", "").uppercase()
    }


    fun formatAllergens(allergens: String?): String {
        if (allergens.isNullOrEmpty()) {
            return "No allergens available"
        }

        val allergenList = allergens.split(",").map { it.trim() }
        return allergenList.mapIndexed { index, allergen ->
            "${index + 1}. ${
                allergen.replace(
                    "en:",
                    ""
                )
            }"
        }
            .joinToString("\n")
    }


    fun formatCountries(countries: String?): String {
        if (countries.isNullOrEmpty()) {
            return "No countries found"
        }

        val countriesList = countries.split(",").map { it.trim() }
        return countriesList.mapIndexed { index, countries ->
            "${index + 1}. ${countries}"
        }
            .joinToString("\n")
    }

}