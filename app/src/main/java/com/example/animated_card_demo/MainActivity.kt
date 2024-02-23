package com.example.animated_card_demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cardList = ArrayList<CardItem>()
        for (i in 1..10) {
            cardList.add(CardItem("Title $i", "Description $i"))
        }

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = CardAdapter(cardList)
    }
}