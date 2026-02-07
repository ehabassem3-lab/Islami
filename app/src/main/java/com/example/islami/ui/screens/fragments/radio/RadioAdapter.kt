package com.example.islami.ui.screens.fragments.radio

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.R


class RadioAdapter(var radioDM: ArrayList<RadioDM> , var onClick : (positon : Int) -> Unit ) : RecyclerView.Adapter<RadioAdapter.viewHolder>() {
    lateinit var radioClick : RadioClick
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): viewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.radio_item,parent,false)
         return viewHolder(view)
    }

    override fun onBindViewHolder(
        holder: viewHolder,
        position: Int
    ) {
        var _radio = radioDM[position]
        holder.ShieckhName.text = _radio.sheickhName
        holder.Play_Button.setImageResource(_radio.play_status)
        holder.Bg_status.setImageResource(_radio.bg_status)
        holder.Volume_Button.setImageResource(_radio.audio_status)
        holder.itemView.setOnClickListener {
            onClick(position)
        }
    }

    override fun getItemCount(): Int {
         return  radioDM.size
    }


    class  viewHolder(view : View ) : RecyclerView.ViewHolder(view){
        var ShieckhName : TextView = itemView.findViewById(R.id.Shieckh_Name)
        var Bg_status : ImageView = itemView.findViewById(R.id.radio_footer)
        var Play_Button : ImageView = itemView.findViewById(R.id.Play_Button)
        var Volume_Button : ImageView = itemView.findViewById(R.id.Volume_Button)




    }
}