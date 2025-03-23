package com.example.tugas2

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class home : AppCompatActivity() {
    @SuppressLint("QueryPermissionsNeeded")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)

        val sharebtn = findViewById<Button>(R.id.sharebtn)
        val textinput = findViewById<EditText>(R.id.textinput)

        // Set the WindowInsetsListener outside the OnClickListener
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        sharebtn.setOnClickListener {
            val message = textinput.text.toString()

            if (message.isNotEmpty()) {
                val intent = Intent(Intent.ACTION_SEND)
                intent.type = "text/plain"  // The MIME type for text
                intent.putExtra(Intent.EXTRA_TEXT, message)  // Add the message to the intent
                startActivity(Intent(Intent.createChooser(intent, "SHare To")))



                // Check if WhatsApp is installed
                if (intent.resolveActivity(packageManager) != null) {
                    // Start WhatsApp with the message
                    startActivity(intent)
                } else {
                    // WhatsApp is not installed, show a Toast message
                    Toast.makeText(
                        this,
                        "WhatsApp is not installed on your device",
                        Toast.LENGTH_SHORT
                    ).show()

                    // Optionally, redirect to the Play Store to install WhatsApp
                    val playStoreIntent = Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://play.google.com/store/apps/details?id=com.whatsapp")
                    )
                    startActivity(playStoreIntent)
                }
            } else {
                // If the EditText is empty, show a Toast message
                Toast.makeText(this, "Please enter a message to share", Toast.LENGTH_SHORT).show()
            }
        }
    }
}