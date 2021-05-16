package com.karlis.moviesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.karlis.moviesapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var moviesList: ArrayList<Movie>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val thumbnailID = intArrayOf(
            R.drawable.i,
            R.drawable.j,
            R.drawable.h,
            R.drawable.g,
            R.drawable.f,
            R.drawable.e,
            R.drawable.d,
            R.drawable.c,
            R.drawable.b,
            R.drawable.a
        )

        val title = arrayOf(
            "Godzilla vs. Kong",
            "Inception",
            "Iron Man",
            "Justice League",
            "Star Wars: Episode VIII - The Last Jedi",
            "Star Wars: Episode IX - The Rise of Skywalker",
            "The Bourne Legacy",
            "The Lord of the Rings: The Return of the King",
            "Warcraft",
            "Avengers: Endgame"
        )

        val releaseDate = arrayOf(
            "2021",
            "2010",
            "2008",
            "2017",
            "2017",
            "2019",
            "2012",
            "2003",
            "2016",
            "2019"
        )

        val genre = arrayOf(
            "Action, Sci-Fi, Thriller",
            "Action, Adventure, Sci-Fi",
            "Action, Adventure, Sci-Fi",
            "Action, Adventure, Fantasy",
            "Action, Adventure, Fantasy",
            "Action, Adventure, Fantasy",
            "Action, Adventure, Thriller",
            "Action, Adventure, Drama",
            "Action, Adventure, Fantasy",
            "Action, Adventure, Drama"
        )

        val details = arrayOf(
            "The epic next chapter in the cinematic Monsterverse pits two of the greatest icons in motion picture history against one another - the fearsome Godzilla and the mighty Kong - with humanity caught in the balance.",
            "A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O.",
            "After being held captive in an Afghan cave, billionaire engineer Tony Stark creates a unique weaponized suit of armor to fight evil. ",
            "Fueled by his restored faith in humanity and inspired by Superman's selfless act, Bruce Wayne enlists the help of his new-found ally, Diana Prince, to face an even greater enemy.",
            "Rey develops her newly discovered abilities with the guidance of Luke Skywalker, who is unsettled by the strength of her powers. Meanwhile, the Resistance prepares for battle with the First Order. ",
            "The surviving members of the Resistance face the First Order once again, and the legendary conflict between the Jedi and the Sith reaches its peak, bringing the Skywalker saga to its end. ",
            "An expansion of the universe from Robert Ludlum's novels, centered on a new hero whose stakes have been triggered by the events of the previous three films.",
            "Gandalf and Aragorn lead the World of Men against Sauron's army to draw his gaze from Frodo and Sam as they approach Mount Doom with the One Ring.",
            "As an Orc horde invades the planet Azeroth using a magic portal, a few human heroes and dissenting Orcs must attempt to stop the true evil behind this war. ",
            "After the devastating events of Avengers: Infinity War (2018), the universe is in ruins. With the help of remaining allies, the Avengers assemble once more in order to reverse Thanos' actions and restore balance to the universe."
        )

        moviesList = ArrayList()
        for (i in title.indices){
            val movie = Movie(
                thumbnailID[i],
                title[i],
                releaseDate[i],
                genre[i],
                details[i]
            )
            moviesList.add(movie)
        }
        binding.moviesListView.isClickable = true
        binding.moviesListView.adapter = MovieAdapter(this, moviesList)

        binding.moviesListView.setOnItemClickListener { parent, view, position, id ->
            val imageID = thumbnailID[position]
            val titleMovie = title[position]
            val releaseDateText = releaseDate[position]
            val movieGenre = genre[position]
            val movieDetails = details[position]


            val i = Intent(this, MovieActivity::class.java)
            i.putExtra("imageID", imageID)
            i.putExtra("title", titleMovie)
            i.putExtra("releaseDate", releaseDateText)
            i.putExtra("genre", movieGenre)
            i.putExtra("details", movieDetails)

            startActivity(i)

        }

    }
}