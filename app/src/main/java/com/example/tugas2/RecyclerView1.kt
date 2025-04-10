package com.example.tugas2

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerView1 : AppCompatActivity() {
    private lateinit var gameRecyclerView: RecyclerView
    private lateinit var gameAdapter: MyAdapter
    private lateinit var listgame : ArrayList<ItemData>

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycler_view1)

        gameRecyclerView = findViewById(R.id.gameRV)
        listgame = ArrayList()

        listgame.add(ItemData(R.drawable.danganropa, "Danganronpa","SpikeSoft"))
        listgame.add(ItemData(R.drawable.findingparadise, "finding paradise","Freebird"))
        listgame.add(ItemData(R.drawable.tothemoon, "To The Moon","Freebird"))
        listgame.add(ItemData(R.drawable.stardew, "Stardew Valley","ConcradeApe"))
        listgame.add(ItemData(R.drawable.bully, "Bully","RockStar"))
        listgame.add(ItemData(R.drawable.persona4, "Persona 4 ","Atlus"))
        listgame.add(ItemData(R.drawable.residentevil7, "Resident Evil & ","CapCom"))

        gameRecyclerView.layoutManager = LinearLayoutManager(this)
        gameRecyclerView.setHasFixedSize(true)
        gameAdapter = MyAdapter(listgame)
        gameRecyclerView.adapter = gameAdapter

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}