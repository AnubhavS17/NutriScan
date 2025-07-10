package project.nutriscan.ui

import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import project.nutriscan.MainActivity
import project.nutriscan.R
import project.nutriscan.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(layoutInflater)

        (activity as? AppCompatActivity)?.supportActionBar?.hide()
        (activity as MainActivity).hideBottomNavigation()

        binding.loginUser.setOnClickListener {
            if (validateFields()){
                Toast.makeText(requireContext(),"Logged in Successfully",Toast.LENGTH_SHORT).show()
            }
        }

        binding.register.setOnClickListener {
          navigateToRegister()
        }


        return binding.root
    }

    private fun navigateToRegister(){
        findNavController().navigate(R.id.action_login_to_register)
    }

    private fun navigateToHome(){
        findNavController().navigate(R.id.action_login_to_HomeScreen)
    }

    private fun validateFields(): Boolean {
        // Accessing the text from EditText using View Binding
        val email = binding.emailLogin.text.toString().trim()
        val password = binding.passwordLogin.text.toString().trim()

        // Validate email
        if (email.isEmpty()) {
            binding.emailLogin.error = "Email is required" // Use binding to set error
            binding.emailLogin.requestFocus() // Use binding to request focus
            return false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.emailLogin.error = "Please enter a valid email" // Use binding to set error
            binding.emailLogin.requestFocus() // Use binding to request focus
            return false
        }
        // Validate password
        if (password.isEmpty()) {
            binding.passwordLogin.error = "Password is required" // Use binding to set error
            binding.passwordLogin.requestFocus() // Use binding to request focus
            return false
        } else if (password.length < 8) {
            binding.passwordLogin.error =
                "Password must be at least 8 characters" // Use binding to set error
            binding.passwordLogin.requestFocus() // Use binding to request focus
            return false
        }
        return true // All validations passed
    }
}