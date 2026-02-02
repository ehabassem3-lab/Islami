package com.example.islami.ui.screens.fragments.hadeth

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.R
import org.w3c.dom.Text

class HadethAdapter(val hadethList : ArrayList<HadethDM> , var onClick : (HadethDM) -> Unit )
    : RecyclerView.Adapter<HadethAdapter.ViewHolder>()
{
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.hadeth_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        val hadeth = hadethList[position]
        holder.hadethTitle.text = hadeth.title
        holder.hadethContent.text = hadeth.content
        holder.itemView.setOnClickListener {
            onClick(hadeth)
        }
    }

    override fun getItemCount(): Int {
       return  hadethList.size
    }


    class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val hadethTitle : TextView = view.findViewById(R.id.hadeth_title)
        val hadethContent: TextView = view.findViewById(R.id.hadeth_content)

    }
}