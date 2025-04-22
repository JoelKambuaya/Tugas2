package com.example.tugas2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class menutgs : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menutgs)

        val btntgs2 = findViewById<Button>(R.id.btntgs2)
        val btntgs3 = findViewById<Button>(R.id.btntgs3)
        val btntgs4 = findViewById<Button>(R.id.btntgs4)

        btntgs2.setOnClickListener {
            val intent = Intent (this ,home::class.java)
            startActivity(intent)
        }

        btntgs3.setOnClickListener {
            val intent = Intent (this, RecyclerView1::class.java)
            startActivity(intent)
        }

        btntgs4.setOnClickListener {
            val intent = Intent (this, Profile::class.java)
            startActivity(intent)
        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}