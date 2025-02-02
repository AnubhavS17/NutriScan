package project.nutriscan.model

import com.google.gson.annotations.SerializedName

data class Nutriments(
    val carbohydrates: Double?,
    val carbohydrates_100g: Double?,
    val carbohydrates_serving: Double?,
    val carbohydrates_unit: String?,
    val carbohydrates_value: Double?,
    @SerializedName("carbon-footprint-from-known-ingredients_100g")
    val carbon_footprint_from_known_ingredients_100g: Double?,
    @SerializedName("carbon-footprint-from-known-ingredients_product")
    val carbon_footprint_from_known_ingredients_product: Double?,
    @SerializedName("carbon-footprint-from-known-ingredients_serving")
    val carbon_footprint_from_known_ingredients_serving: Double?,
    val energy: Double?,
    @SerializedName("energy-kcal")
    val energy_kcal: Double?,
    @SerializedName("energy-kcal_100g")
    val energy_kcal_100g: Double?,
    @SerializedName("energy-kcal_serving")
    val energy_kcal_serving: Double?,
    @SerializedName("energy-kcal_unit")
    val energy_kcal_unit: String?,
    @SerializedName("energy-kcal_value")
    val energy_kcal_value: Double?,
    @SerializedName("energy-kcal_value_computed")
    val energy_kcal_value_computed: Double?,
    val energy_kj: Double?,
    @SerializedName("energy-kj_100g")
    val energy_kj_100g: Double?,
    @SerializedName("energy-kj_serving")
    val energy_kj_serving: Double?,
    @SerializedName("energy-kj_unit")
    val energy_kj_unit: String?,
    @SerializedName("energy-kj_value")
    val energy_kj_value: Double?,
    @SerializedName("energy-kj_value_computed")
    val energy_kj_value_computed: Double?,
    val energy_100g: Double?,
    val energy_serving: Double?,
    val energy_unit: String?,
    val energy_value: Double?,
    val fat: Double?,
    val fat_100g: Double?,
    val fat_serving: Double?,
    val fat_unit: String?,
    val fat_value: Double?,
    val fiber: Double?,
    val fiber_100g: Double?,
    val fiber_serving: Double?,
    val fiber_unit: String?,
    val fiber_value: Double?,
    @SerializedName("fruits-vegetables-legumes-estimate-from-ingredients_100g")
    val fruits_vegetables_legumes_estimate_from_ingredients_100g: Double?,
    @SerializedName("fruits-vegetables-legumes-estimate-from-ingredients_serving")
    val fruits_vegetables_legumes_estimate_from_ingredients_serving: Double?,
    @SerializedName("fruits-vegetables-nuts-estimate-from-ingredients_100g")
    val fruits_vegetables_nuts_estimate_from_ingredients_100g: Double?,
    @SerializedName("fruits-vegetables-nuts-estimate-from-ingredients_serving")
    val fruits_vegetables_nuts_estimate_from_ingredients_serving: Double?,
    @SerializedName("nova-group")
    val nova_group: Double?,
    @SerializedName("nova-group_100g")
    val nova_group_100g: Double?,
    @SerializedName("nova-group_serving")
    val nova_group_serving: Double?,
    @SerializedName("nutrition-score-fr")
    val nutrition_score_fr: Double?,
    @SerializedName("nutrition-score-fr_100g")
    val nutrition_score_fr_100g: Double?,
    val proteins: Double?,
    val proteins_100g: Double?,
    val proteins_serving: Double?,
    val proteins_unit: String?,
    val proteins_value: Double?,
    val salt: Double?,
    val salt_100g: Double?,
    val salt_serving: Double?,
    val salt_unit: String?,
    val salt_value: Double?,
    @SerializedName("saturated-fat")
    val saturated_fat: Double?,
    @SerializedName("saturated-fat_100g")
    val saturated_fat_100g: Double?,
    @SerializedName("saturated-fat_serving")
    val saturated_fat_serving: Double?,
    @SerializedName("saturated-fat_unit")
    val saturated_fat_unit: String?,
    @SerializedName("saturated-fat_value")
    val saturated_fat_value: Double?,
    val sodium: Double?,
    val sodium_100g: Double?,
    val sodium_serving: Double?,
    val sodium_unit: String?,
    val sodium_value: Double?,
    val sugars: Double?,
    val sugars_100g: Double?,
    val sugars_serving: Double?,
    val sugars_unit: String?,
    val sugars_value: Double?
)
