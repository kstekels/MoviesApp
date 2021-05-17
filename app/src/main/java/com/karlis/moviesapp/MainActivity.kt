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
            "31 March 2021 (USA)",
            "16 July 2010 (USA)",
            "2 May 2008 (USA)",
            "17 November 2017 (USA)",
            "15 December 2017 (USA)",
            "20 December 2019 (USA)",
            "10 August 2012 (USA)",
            "17 December 2003 (USA)",
            "10 June 2016 (USA)",
            "26 April 2019 (USA)"
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
            "Legends collide as Godzilla and Kong, the two most powerful forces of nature, clash in a spectacular battle for the ages. As Monarch embarks on a perilous mission into fantastic uncharted terrain, unearthing clues to the Titans’ very origins, a human conspiracy threatens to wipe the creatures, both good and bad, from the face of the earth forever.",
            "Your mind is the scene of the crime. Box-office superstar Leonardo DiCaprio stars in this contemporary science fiction action film set \"\"within the architecture of the mind.\"\" Written, directed and produced by Oscar® and Golden Globe nominee Christopher Nolan (The Dark Knight Trilogy, Interstellar, The Prestige), this eagerly awaited follow-up to 2008's billion-dollar blockbuster is yet another visionary tale from a startingly original filmmaker who continually raises the bar with every film he makes. Shooting in London, Paris, Tangiers, Calgary and Los Angeles, Nolan's mind-bending film also stars Academy Award® winners Michael Caine and Marion Cotillard, in addition to Juno's Elliot Page, Batman Begins' Cillian Murphy and Oscar® nominees Ken Watanabe (The Last Samurai) and Tom Berenger (Platoon).",
            "After surviving an unexpected attack in enemy territory, jet-setting industrialist Tony Stark builds a high-tech suit of armor and vows to protect the world as Iron Man. Straight from the pages of the legendary comic book, Iron Man is a hero who is built - not born - to be unlike any other.",
            "Fueled by his restored faith in humanity and inspired by Superman's selfless act, Bruce Wayne enlists the help of his new-found ally, Diana Prince, to face an even greater enemy.",
            "Rey develops her newly discovered abilities with the guidance of Luke Skywalker, who is unsettled by the strength of her powers. Meanwhile, the Resistance prepares for battle with the First Order. ",
            "The surviving members of the Resistance face the First Order once again, and the legendary conflict between the Jedi and the Sith reaches its peak, bringing the Skywalker saga to its end. ",
            "An expansion of the universe from Robert Ludlum's novels, centered on a new hero whose stakes have been triggered by the events of the previous three films.",
            "Gandalf and Aragorn lead the World of Men against Sauron's army to draw his gaze from Frodo and Sam as they approach Mount Doom with the One Ring.",
            "As an Orc horde invades the planet Azeroth using a magic portal, a few human heroes and dissenting Orcs must attempt to stop the true evil behind this war. ",
            "The fourth installment in the Avengers saga is the culmination of 22 interconnected Marvel films and the climax of an epic journey. The world's greatest heroes will finally understand just how fragile our reality is-and the sacrifices that must be made to uphold it-in a story of friendship, teamwork and setting aside differences to overcome an impossible obstacle."
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