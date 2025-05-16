package com.example.tugas2

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tugas2.databinding.ActivityMainBinding
import com.example.tugas2.databinding.ActivitySignupBinding
import com.google.firebase.auth.FirebaseAuth

class signup : AppCompatActivity() {
    private  lateinit var binding : ActivitySignupBinding
    private  lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()
        firebaseAuth = FirebaseAuth.getInstance()

        binding.createbtn.setOnClickListener {
            val email : String = binding.createuser.text.toString().trim()
            val password : String = binding.createpass.text.toString().trim()
            val confirmPassword : String = binding.confirmpass.text.toString().trim()

            if (email.isEmpty()){
                binding.createuser.error = "input email"
                binding.createuser.requestFocus()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                binding.createuser.error = "input email"
                binding.createuser.requestFocus()
                return@setOnClickListener
            }

            if (password.isEmpty() || password.length < 6){
                binding.createpass.error = "Password lebih dari 6 character"
                binding.createpass.requestFocus()
                return@setOnClickListener
            }

            if (password != confirmPassword){
                binding.confirmpass.error = "Password lebih dari 6 character"
                binding.confirmpass.requestFocus()
                return@setOnClickListener
            }
            registerUser(email, password)
        }

        binding.haveacc.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }

            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        }

    private fun registerUser(email: String, password: String){

        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener {
            if (it.isSuccessful){
                Intent(this, MainActivity::class.java).also {
                    it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(it)
                }
            }
            else {
                Toast.makeText(this, it.exception?.message, Toast.LENGTH_SHORT).show()
            }
        }
    }
}
