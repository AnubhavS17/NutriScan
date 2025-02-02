package project.nutriscan.model

import com.google.gson.annotations.SerializedName

data class NutrientLevels(
    val fat: String?,
    val salt: String?,
    @SerializedName("saturated-fat")
    val saturatedFat: String?,
    val sugars: String?
)
