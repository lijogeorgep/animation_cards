package com.example.animated_card_demo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView

class CardAdapter(private val cardList: MutableList<CardItem>) :
    RecyclerView.Adapter<CardAdapter.CardViewHolder>() {

    private var selectedItemPosition = -1

    inner class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardView: MaterialCardView = itemView.findViewById(R.id.cardView)
        val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        val descriptionTextView: TextView = itemView.findViewById(R.id.descriptionTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_card, parent, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val currentItem = cardList[position]
        holder.titleTextView.text = currentItem.title
        holder.descriptionTextView.text = currentItem.description

        // Handle card click event
        holder.cardView.setOnClickListener {
            val tappedPosition = holder.adapterPosition
            if (selectedItemPosition != tappedPosition) {
                // Move the tapped card to the zeroth position
                cardList.add(0, cardList.removeAt(tappedPosition))
                notifyItemMoved(tappedPosition, 0)

                // If there was a previously selected card, move it back to its original position
                if (selectedItemPosition != -1) {
                    val previousPosition = selectedItemPosition
                    notifyItemMoved(0, previousPosition)
                    selectedItemPosition = previousPosition
                } else {
                    selectedItemPosition = 0
                }
            }
        }
    }


    override fun getItemCount(): Int {
        return cardList.size
    }
}
