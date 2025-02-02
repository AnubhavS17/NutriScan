package project.nutriscan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import project.nutriscan.databinding.ActivityMainBinding
import project.nutriscan.repository.Repository
import project.nutriscan.viewmodel.NutritionViewModel
import project.nutriscan.viewmodel.ViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController : NavController
    lateinit var viewModel : NutritionViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment

        navController = navHostFragment.navController


        val repository = Repository()

        viewModel = ViewModelProvider(this, ViewModelFactory(repository,application)).get(NutritionViewModel::class.java)

        binding.bottomNavigation.setupWithNavController(navController)


    }
    fun showBottomNavigation()
    {
        binding.bottomNavigation.visibility = View.VISIBLE
    }
    fun hideBottomNavigation()
    {
        binding.bottomNavigation.visibility = View.GONE
    }
}