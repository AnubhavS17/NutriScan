package project.nutriscan.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import project.nutriscan.repository.Repository

class ViewModelFactory(private val repository: Repository, private val application: Application): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NutritionViewModel(repository,application) as T
    }
}