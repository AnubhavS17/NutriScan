package project.nutriscan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import project.nutriscan.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.ScanButton.setOnClickListener {
            Toast.makeText(this,"Button is working",Toast.LENGTH_SHORT).show()
        }
    }
}