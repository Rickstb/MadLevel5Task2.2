package com.example.madlevel5task2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.madlevel5task2.R
import com.example.madlevel5task2.model.Game
import kotlinx.android.synthetic.main.item_list.view.*

class GameAdapter(private var listOfLocation: ArrayList<Game>) : RecyclerView.Adapter<GameAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun databinding(location: Game) {
            itemView.itemTitle.text = location.title
            itemView.itemNote.text = location.text
            itemView.itemRelease.text = itemView.resources.getString(R.string.tv_release, location.release.dayOfMonth.toString(),location.release.month.name, location.release.year.toString())




        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        )
    }
    override fun getItemCount(): Int {
        return listOfLocation.count()
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.databinding(listOfLocation[position])
    }
}