package com.caiosilva.projetomarcel2tdsps

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.caiosilva.projetomarcel2tdsps.databinding.ActivitySecondBinding
import com.squareup.picasso.Picasso

class SecondActivity : ComponentActivity() {

    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getExtras()
        setupViews()
    }

    private fun setupViews() {
        val comicBookData =
            intent.getStringExtra("COMIC_BOOK_DATA").orEmpty().fromJson(ComicBookData::class.java)
        val url = comicBookData.imageUrl

        binding.textViewSecondActivity.setOnLongClickListener(object : View.OnLongClickListener {
            override fun onLongClick(v: View?): Boolean {
                openUrl(url)
                return true
            }
        })

        binding.imageViewFromUrl.setImageFromUrl(url)
    }

    private fun getExtras() {
        val comicBookData =
            intent.getStringExtra("COMIC_BOOK_DATA").orEmpty().fromJson(ComicBookData::class.java)
        val description = comicBookData.description

        binding.textViewSecondActivity.text = description
    }

    private fun openUrl(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }
}