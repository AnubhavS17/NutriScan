package project.nutriscan.model

data class NutritionResponse(
    val code: String?,
    val errors: List<Any>?,
    val product: Product?,
    val result: Result?,
    val status: String?,
    val warnings: List<Any>?
)