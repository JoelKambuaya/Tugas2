package com.example.tugas2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import android.widget.Toolbar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class RecyclerView1 : AppCompatActivity() {
    private lateinit var gameRecyclerView: RecyclerView
    private lateinit var gameAdapter: MyAdapter
    private lateinit var listgame: ArrayList<ItemData>

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycler_view1)
        gameRecyclerView = findViewById(R.id.gameRV)

        listgame = ArrayList()

        listgame.add(
            ItemData(
                R.drawable.danganropa, " Game: Danganronpa: Trigger Happy Havoc",
                "Developer: spike Chunsoft",
                "Investigate murders, search for clues and " +
                        "talk to your classmates to prepare for trial. There, you'll engage in " +
                        "deadly wordplay, going back and forth with suspects. Dissect their statements and fire their " +
                        "words back at them to expose their lies! There's only one way to" +
                        " survive—pull the trigger."
            )
        )

        listgame.add(
            ItemData(
                R.drawable.bully, "Game: Bully", "Developer: Rockstar New england",
                "Bully tells the story of mischievous 15-year-old Jimmy Hopkins as he goes through" +
                        " the hilarity and awkwardness of adolescence. " +
                        "Beat the jocks at dodge ball, play pranks on the preppies, " +
                        "save the nerds, kiss the girl and navigate the social hierarchy in the worst school around."
            )
        )

        listgame.add(
            ItemData(
                R.drawable.persona4, "Game: Persona 4", "Developer: Atlus",
                "Inaba—a quiet town in rural Japan sets the scene for budding adolescence in Persona 4 Golden." +
                        " A coming of age story that sets the protagonist and his friends on a journey" +
                        " kickstarted by a chain of serial murders. Explore meeting kindred spirits, " +
                        "feelings of belonging, and even confronting the darker sides of one’s self."
            )
        )

        listgame.add(
            ItemData(
                R.drawable.residentevil7, "Game: Resident evil 7", "Developer: Capcom",
                "Set in modern day rural America and taking place after the dramatic events of Resident Evil® 6, " +
                        "players experience the terror directly from the first person perspective." +
                        " Resident Evil 7 embodies the series’ signature gameplay elements of exploration and " +
                        "tense atmosphere that first coined “survival horror” some twenty years ago; " +
                        "meanwhile, a complete refresh of gameplay systems simultaneously propels the survival horror experience to the next level."
            )
        )

        listgame.add(
            ItemData(
                R.drawable.stardew, "Game: Stardew Valley", "Developer: ConcernedApe",
                "You've inherited your grandfather's old farm plot in Stardew Valley. " +
                        "Armed with hand-me-down tools and a few coins, you set out to begin your new life." +
                        " Can you learn to live off the land and turn these overgrown fields into a thriving home?"
            )
        )

        listgame.add(
            ItemData(
                R.drawable.tothemoon, "Game: To The Moon", "Developer: Freebird Games",
                "Dr. Rosalene and Dr. Watts have peculiar jobs: They give people another chance to " +
                        "live, all the way from the very beginning... but only in their patients' heads." +
                        "Due to the severity of the operation, the new life becomes the last thing the " +
                        "patients remember before drawing their last breath. Thus, the operation is only done" +
                        " to people on their deathbeds, to fulfill what they wish they had done with their lives, but didn’t." +
                        "This particular story follows their attempt to fulfill the dream of an elderly man, " +
                        "Johnny. With each step back in time, a new fragment of Johnny's past is revealed. As " +
                        "the two doctors piece together the puzzled events that spanned a life time, " +
                        "they seek to find out just why the frail old man chose his dying wish to be what it is." +
                        "And Johnny's last wish is, of course... to go to the moon."
            )
        )

        listgame.add(
            ItemData(
                R.drawable.findingparadise, "Game: Finding Paradise", "Developer: Freebird Games",
                "Finding Paradise is the 2nd full episode of To the Moon's series. It follows the life of the doctors' " +
                        "new patient, Colin, as they attempt to unravel a life that is split down the middle," +
                        " and fulfill a wish that appears to be self-contradictory by nature.\n"
            )
        )

        gameRecyclerView.layoutManager = LinearLayoutManager(this)
        gameRecyclerView.setHasFixedSize(true)
        gameAdapter = MyAdapter(listgame)
        gameRecyclerView.adapter = gameAdapter

        gameAdapter.onItemClick = {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("game", it)
            startActivity(intent)
        }

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigation.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navigation_home -> {
                    Toast.makeText(this, "Home click", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, Profile::class.java))
                    true
                }

                R.id.navigation_search -> {
                    Toast.makeText(this, "Search click", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.navigation_notifications -> {
                    Toast.makeText(this, "Notifications click", Toast.LENGTH_SHORT).show()
                    true
                }

                else -> false
            }
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_option, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.logout -> {
                Toast.makeText(this, "Logout clicked", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, MainActivity::class.java))
                return true
            }
            R.id.setting -> {
                Toast.makeText(this, "Setting clicked", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.profile -> {
                Toast.makeText(this, "Profile clicked", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, Profile::class.java))
                return true
            }
            else -> super.onOptionsItemSelected(item)


        }


    }
}

