package project.nutriscan.repository

import project.nutriscan.api.RetrofitInstance

class Repository {

    suspend fun searchProduct(barcode: String, fields : String) = RetrofitInstance.api.searchProduct(barcode,fields)
}