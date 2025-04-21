package project.nutriscan.api

import project.nutriscan.model.NutritionResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NutritionAPI {
    //"https://world.openfoodfacts.org/api/v3/product/3175681257511"
    //nutriments

    @GET("product/{barcode}")
    suspend fun searchProduct(@Path("barcode") barcode : String,
                              @Query("fields") fields : String = "filters")
    : Response<NutritionResponse>

}