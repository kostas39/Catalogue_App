package com.example.catalogue_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ViewPagerAdapter(
    private val titles: List<String>,
    private val descriptions: List<String>,
    private val images: List<Int>
) : RecyclerView.Adapter<ViewPagerAdapter.ViewHolder>() {

    // ViewHolder to hold the view references for each item
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.itemImage)
        val titleText: TextView = view.findViewById(R.id.itemTitle)
        val descriptionText: TextView = view.findViewById(R.id.itemDescription)
    }

    // Inflate the item layout (view_pager_item.xml)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_pager_item, parent, false)
        return ViewHolder(view)
    }

    // Bind data to the views in the ViewHolder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.imageView.setImageResource(images[position])
        holder.titleText.text = titles[position]
        holder.descriptionText.text = descriptions[position]
    }

    // Return the total number of items
    override fun getItemCount(): Int = titles.size
}