package project.nutriscan.model

data class NutriscoreData(
    val components: ComponentsX?,
    val count_proteins: Int?,
    val count_proteins_reason: String?,
    val grade: String?,
    val is_beverage: Int?,
    val is_cheese: Int?,
    val is_fat_oil_nuts_seeds: Int?,
    val is_red_meat_product: Int?,
    val is_water: Int?,
    val negative_points: Int?,
    val negative_points_max: Int?,
    val positive_nutrients: List<String>?,
    val positive_points: Int?,
    val positive_points_max: Int?,
    val score: Int?
)