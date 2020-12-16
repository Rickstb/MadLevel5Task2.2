package com.example.madlevel5task2.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.browser.customtabs.CustomTabsIntent
import androidx.recyclerview.widget.RecyclerView
import com.example.madlevel5task2.R
import com.example.madlevel5task2.model.Note
import kotlinx.android.synthetic.main.item_list.view.*

class StartAdapter(private var listOfLocation: ArrayList<Note>) : RecyclerView.Adapter<StartAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun databinding(location: Note) {
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