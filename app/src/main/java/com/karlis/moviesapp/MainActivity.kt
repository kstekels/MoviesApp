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

        moviesList = ArrayList()
        for (i in title.indices){
            val movie = Movie(
                thumbnailID[i],
                title[i],
                releaseDate[i]
            )
            moviesList.add(movie)
        }
        binding.moviesListView.isClickable = true
        binding.moviesListView.adapter = MovieAdapter(this, moviesList)

        binding.moviesListView.setOnItemClickListener { parent, view, position, id ->
            val imageID = thumbnailID[position]
            val titleMovie = title[position]
            val releaseDateText = releaseDate[position]

            val i = Intent(this, MovieActivity::class.java)
            i.putExtra("imageID", imageID)
            i.putExtra("title", titleMovie)
            i.putExtra("releaseDate", releaseDateText)
            startActivity(i)

        }

    }
}