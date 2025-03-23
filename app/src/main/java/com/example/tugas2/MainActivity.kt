package com.example.tugas2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {

    private val correctUsername = "user"
    private val correctPassword = "123"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        val usernameEditText = findViewById<EditText>(R.id.username)
        val passwordEditText = findViewById<EditText>(R.id.password)
        val forgotPass = findViewById<TextView>(R.id.forgotpass)
        val signup1 = findViewById<TextView>(R.id.signup1)
        val loginbtn = findViewById<Button>(R.id.loginbtn)


        loginbtn.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()
            if (username == correctUsername && password == correctPassword) {
                val intent = Intent(this, home::class.java)
                startActivity(intent)
                finish()
            } else {

                Toast.makeText(this, "Username atau password salah", Toast.LENGTH_SHORT).show()
            }
        }


        forgotPass.setOnClickListener {
            val intent = Intent(this, Forgot_pass::class.java)
            startActivity(intent)
        }


        signup1.setOnClickListener {
            val intent = Intent(this, signup::class.java)
            startActivity(intent)
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets  // Return insets for proper layout handling
        }
    }
}