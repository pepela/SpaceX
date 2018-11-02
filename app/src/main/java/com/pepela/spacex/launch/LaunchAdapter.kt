package com.pepela.spacex.launch

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pepela.data.launch.model.Launch
import com.pepela.spacex.R
import com.pepela.spacex.extensions.toReadableString
import java.util.*

class LaunchAdapter(var items: List<Launch> = Collections.emptyList())
    : RecyclerView.Adapter<LaunchAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_launch, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(items[position]) {
            holder.nameTv.text = name
            holder.dateTv.text = date.toReadableString()
            holder.launchSiteNameTv.text = launchSite.name
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTv = itemView.findViewById<TextView>(R.id.name_tv)
        val dateTv = itemView.findViewById<TextView>(R.id.date_tv)
        val launchSiteNameTv = itemView.findViewById<TextView>(R.id.site_name_tv)
    }
}
