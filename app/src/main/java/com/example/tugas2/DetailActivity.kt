package com.example.tugas2

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)

        val game = intent.getParcelableExtra<ItemData>("game")
        if (game !=null){
            val imageView: ImageView =findViewById(R.id._gambar)
            val textViewTitle : TextView =findViewById(R.id._gamenama)
            val textViewDesc : TextView =findViewById(R.id._desgame)

            imageView.setImageResource(game.gambar)
            textViewTitle.text = game.nama
            textViewDesc.text = game.deskripsi

        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}