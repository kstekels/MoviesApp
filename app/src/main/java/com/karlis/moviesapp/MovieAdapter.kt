package com.karlis.moviesapp

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class MovieAdapter(private val context: Activity, private val arrayList: ArrayList<Movie>): ArrayAdapter<Movie>(context, R.layout.movie_item, arrayList) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater : LayoutInflater = LayoutInflater.from(context)
        val view : View = inflater.inflate(R.layout.movie_item, null)

        val thumbnailView : ImageView = view.findViewById(R.id.thumbnail)
        val title: TextView = view.findViewById(R.id.titleText)
        val releaseDate: TextView = view.findViewById(R.id.releaseDateText)

        thumbnailView.setImageResource(arrayList[position].thumbnailID)
        title.text = arrayList[position].title
        releaseDate.text = arrayList[position].releaseDate

        return view
    }
}