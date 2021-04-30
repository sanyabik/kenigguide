package com.kenigguide

import android.view.View
import android.widget.Toast

class MyViewHolder(itemView: View, private val onClickTitleCard: OnClickTitleCard) : RecyclerView.ViewHolder(itemView) {

    private val imageTitle: ImageView = itemView.findViewById(R.id.imageView_title)

    fun bind(model: Model) {

        imageTitle.load(model.image)
        imageTitle.setImageResource(R.drawable.tilsit)

        imageTitle.setOnClickListener {
            onClickTitleCard.onClick(model)
            Toast.makeText(itemView.context,"Работает Клик", Toast.LENGTH_LONG).show()
        }
    }
}