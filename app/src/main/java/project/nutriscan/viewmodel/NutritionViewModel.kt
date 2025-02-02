package project.nutriscan.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import project.nutriscan.model.NutritionResponse
import project.nutriscan.repository.Repository

class NutritionViewModel(private val repository: Repository,private val application: Application) : AndroidViewModel(application) {

  val productDetails : MutableLiveData<NutritionResponse> = MutableLiveData()

    fun searchProduct(barcode : String, fields : String) = viewModelScope.launch {
        val response = repository.searchProduct(barcode,fields)
        if (response.isSuccessful){
            response.body()?.let {
                productDetails.postValue(it)
            }
        }
    }
}