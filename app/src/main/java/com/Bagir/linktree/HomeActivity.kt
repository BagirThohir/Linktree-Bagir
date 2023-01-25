package com.Bagir.linktree

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val image = findViewById<ImageView>(R.id.image)
        val title = findViewById<TextView>(R.id.title)
        val subtitle = findViewById<TextView>(R.id.subtitle)
        val list = findViewById<RecyclerView>(R.id.list)

        image.setImageResource(R.drawable.avatar)
        title.text = "Muhammad Bagir"
        subtitle.text = "Android Developer"
        list.adapter = linkAdapter
    }

    private val linkAdapter by lazy {
        val items = listOf<LinktreeModel>(
            LinktreeModel("WhatsApp", R.drawable.wa, "https://web.whatsapp.com/"),
            LinktreeModel("Instagram", R.drawable.ig, "https://www.instagram.com/bagirthohir//"),
            LinktreeModel("Facebook", R.drawable.fb, "https://www.facebook.com/muhammad.bagirbinthahir/"),
            LinktreeModel("YouTube", R.drawable.yt, "https://www.youtube.com/channel/UCtgNYy_nrdcJZ5m75blgEew"),
            LinktreeModel("Website", R.drawable.web, "http://bagirthohir.blogspot.com//"),
        )
        LinkAdapter(items, object : LinkAdapter.AdapterListener{
            override fun onClick(link: LinktreeModel) {
                openUrl( link.url )
            }
        })
    }

    private fun openUrl(url: String) {
        val openURL = Intent(Intent.ACTION_VIEW)
        openURL.data = Uri.parse( url )
        startActivity(openURL)
    }
}