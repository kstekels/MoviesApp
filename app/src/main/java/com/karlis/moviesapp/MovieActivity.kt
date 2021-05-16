package com.karlis.moviesapp

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.karlis.moviesapp.databinding.ActivityMainBinding
import com.karlis.moviesapp.databinding.ActivityMovieBinding

class MovieActivity: AppCompatActivity() {

    private lateinit var binding: ActivityMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val image = intent.getIntExtra("imageID", R.drawable.a)
        val titleMovie = intent.getStringExtra("title")
        val releaseDate = intent.getStringExtra("releaseDate")

        binding.thumbnailImage.setImageResource(image)
        binding.titleName.text = titleMovie
        binding.releaseDate.text = releaseDate
    }

}