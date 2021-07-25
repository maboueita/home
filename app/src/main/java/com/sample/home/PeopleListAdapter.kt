package com.sample.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


data class PeopleItem(
    val interest: String,
    val position: String,
    val location: String
)

class PeopleListAdapter(val dataSet: ArrayList<PeopleItem>) :
    RecyclerView.Adapter<PeopleListAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val interest: TextView
        val position: TextView
        val location: TextView

        init {
            // Define click listener for the ViewHolder's View.
            interest = view.findViewById(R.id.interest)
            position = view.findViewById(R.id.position)
            location = view.findViewById(R.id.location)
        }
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {

        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.text_row_item, parent, false)

        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.interest.text = dataSet[position].interest
        holder.location.text = dataSet[position].location
        holder.position.text = dataSet[position].position
    }

    override fun getItemCount(): Int =
        dataSet.size
}
