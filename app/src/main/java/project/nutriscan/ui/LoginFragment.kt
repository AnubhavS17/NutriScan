package project.nutriscan.ui

import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
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

        binding.loginUser.setOnClickListener {
            if (validateFields()){
                Toast.makeText(requireContext(),"Logged in Successfully",Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root
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