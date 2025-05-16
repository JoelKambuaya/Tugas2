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
import com.example.tugas2.databinding.ActivityForgotPassBinding
import com.google.firebase.auth.FirebaseAuth

class ForgotPass : AppCompatActivity() {

    private lateinit var binding: ActivityForgotPassBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityForgotPassBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.sendbtn.setOnClickListener {
            val email : String = binding.email.text.toString().trim()
            if (email.isEmpty()){
                binding.email.error = "input email"
                binding.email.requestFocus()
                return@setOnClickListener
           }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                binding.email.error = "invalid email"
                binding.email.requestFocus()
                return@setOnClickListener
            }

            FirebaseAuth.getInstance().sendPasswordResetEmail(email).addOnCompleteListener {
                if (it.isSuccessful){
                    Toast.makeText(this, "cek email untuk reset password",Toast.LENGTH_SHORT).show()
                    Intent(this, MainActivity::class.java).also {
                        it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(it)
                    }
                }
                else {
                    Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

           }
        }
    }
}