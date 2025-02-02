package project.nutriscan.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RetrofitInstance {

    companion object{
        private val retrofit by lazy {
            Retrofit.Builder().baseUrl("https://world.openfoodfacts.org/api/v3/")
                .addConverterFactory(GsonConverterFactory.create()).build()
        }

        val api by lazy {
            retrofit.create(NutritionAPI::class.java)
        }
    }
}